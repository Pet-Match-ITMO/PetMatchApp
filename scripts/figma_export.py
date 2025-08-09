import requests
import os
import re
import argparse
import logging
from dotenv import load_dotenv

load_dotenv()

TOKEN = os.getenv("FIGMA_TOKEN")
MAX_BATCH_SIZE = 100  # Ограничение Figma API

# Очистка имени для использования в пути
def clean_name(name):
    return re.sub(r'[^\w\-_\. ]', '', name).strip().replace(' ', '_')

# Рекурсивный сбор информации о нодах с сохранением структуры
def collect_nodes(node, parent_path="", nodes_info=None):
    if nodes_info is None:
        nodes_info = []
    
    node_id = node["id"]
    node_name = clean_name(node.get("name", f"node_{node_id}"))
    node_type = node.get("type", "UNKNOWN")
    
    # Определяем формат экспорта
    export_format = "png"  # По умолчанию
    if node_type in ["VECTOR", "BOOLEAN_OPERATION", "STAR", "LINE", "ELLIPSE"]:
        export_format = "svg"
    
    # Сохраняем информацию о ноде
    node_path = os.path.join(parent_path, node_name)
    nodes_info.append({
        "id": node_id,
        "name": node_name,
        "type": node_type,
        "format": export_format,
        "path": node_path
    })
    
    # Обрабатываем детей
    if "children" in node:
        for child in node["children"]:
            collect_nodes(child, node_path, nodes_info)
    
    return nodes_info

# Экспорт нод с созданием структуры папок
def export_nodes(nodes_info, file_key, token, output_dir):
    # Группировка по формату для пакетной обработки
    format_groups = {}
    for node in nodes_info:
        if node["format"] not in format_groups:
            format_groups[node["format"]] = []
        format_groups[node["format"]].append(node["id"])
    
    # Экспорт по группам форматов
    for fmt, node_ids in format_groups.items():
        for i in range(0, len(node_ids), MAX_BATCH_SIZE):
            batch_ids = node_ids[i:i+MAX_BATCH_SIZE]
            
            # Запрос на экспорт
            url = f"https://api.figma.com/v1/images/{file_key}?ids={','.join(batch_ids)}&format={fmt}"
            headers = {"X-Figma-Token": token}
            response = requests.get(url, headers=headers)
            
            if response.status_code != 200:
                logging.error(f"Ошибка экспорта: {response.text}")
                continue
            
            data = response.json()
            images = data.get("images", {})
            
            # Сохранение файлов
            for node_id, image_url in images.items():
                if not image_url:
                    continue
                
                # Находим информацию о ноде
                node_info = next((n for n in nodes_info if n["id"] == node_id), None)
                if not node_info:
                    continue
                
                # Создаем папки
                os.makedirs(os.path.join(output_dir, node_info["path"]), exist_ok=True)
                
                # Скачиваем и сохраняем файл
                response = requests.get(image_url)
                file_path = os.path.join(output_dir, node_info["path"], f"{node_info['name']}.{fmt}")
                
                with open(file_path, "wb") as f:
                    f.write(response.content)
                
                logging.info(f"Сохранено: {file_path}")

# Основной процесс
def main():
    logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

    parser = argparse.ArgumentParser(description="Export assets from Figma.")
    parser.add_argument("file_key", help="Figma file key")
    parser.add_argument("--node", required=True, help="Root node ID to export")
    parser.add_argument("--out", default="figma_export", help="Output directory")
    args = parser.parse_args()

    file_key = args.file_key
    root_node_id = args.node
    output_dir = args.out

    if not TOKEN:
        logging.error("Figma token not found. Please set FIGMA_TOKEN in your .env file.")
        return

    # Получаем структуру файла
    headers = {"X-Figma-Token": TOKEN}
    response = requests.get(f"https://api.figma.com/v1/files/{file_key}", headers=headers)
    
    if response.status_code != 200:
        logging.error(f"Error fetching file structure: {response.text}")
        return

    file_data = response.json()
    
    # Находим корневую ноду
    root_node = None
    def find_node(node, target_id):
        if node["id"] == target_id:
            return node
        if "children" in node:
            for child in node["children"]:
                found = find_node(child, target_id)
                if found:
                    return found
        return None
    
    root_node = find_node(file_data["document"], root_node_id)
    
    if not root_node:
        logging.error(f"Корневая нода {root_node_id} не найдена!")
        return
    
    # Собираем информацию о всех нодах
    logging.info("Сбор информации о нодах...")
    nodes_info = collect_nodes(root_node)
    
    logging.info(f"Найдено {len(nodes_info)} нод для экспорта")
    
    # Экспортируем ноды
    logging.info("Начало экспорта...")
    export_nodes(nodes_info, file_key, TOKEN, output_dir)
    logging.info("Экспорт завершен!")

if __name__ == "__main__":
    main()