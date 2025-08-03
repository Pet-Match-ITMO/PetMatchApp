import os
import requests
from PIL import Image
from io import BytesIO

def download_image(url, save_path):
    """Download an image from URL and save it to the specified path."""
    try:
        response = requests.get(url, timeout=10)
        response.raise_for_status()
        
        # Create directory if it doesn't exist
        os.makedirs(os.path.dirname(save_path), exist_ok=True)
        
        # Save image
        with open(save_path, 'wb') as f:
            f.write(response.content)
        print(f"Downloaded: {save_path}")
        return True
    except Exception as e:
        print(f"Failed to download {url}: {e}")
        return False

def main():
    # Define the project resources directory
    project_res_dir = "app/src/main/res"
    
    # Create drawable directories
    drawable_dirs = [
        f"{project_res_dir}/drawable",
        f"{project_res_dir}/drawable-hdpi",
        f"{project_res_dir}/drawable-mdpi",
        f"{project_res_dir}/drawable-xhdpi",
        f"{project_res_dir}/drawable-xxhdpi",
        f"{project_res_dir}/drawable-xxxhdpi"
    ]
    
    for dir_path in drawable_dirs:
        os.makedirs(dir_path, exist_ok=True)
    
    # Define pet images to download (using placekitten and placedog)
    pet_images = [
        # Cats
        ("https://placekitten.com/200/200", f"{project_res_dir}/drawable/cat_1.png"),
        ("https://placekitten.com/201/201", f"{project_res_dir}/drawable/cat_2.png"),
        ("https://placekitten.com/202/202", f"{project_res_dir}/drawable/cat_3.png"),
        ("https://placekitten.com/203/203", f"{project_res_dir}/drawable/cat_4.png"),
        ("https://placekitten.com/204/204", f"{project_res_dir}/drawable/cat_5.png"),
        
        # Dogs
        ("https://placedog.net/200/200", f"{project_res_dir}/drawable/dog_1.png"),
        ("https://placedog.net/201/201", f"{project_res_dir}/drawable/dog_2.png"),
        ("https://placedog.net/202/202", f"{project_res_dir}/drawable/dog_3.png"),
        ("https://placedog.net/203/203", f"{project_res_dir}/drawable/dog_4.png"),
        ("https://placedog.net/204/204", f"{project_res_dir}/drawable/dog_5.png"),
    ]
    
    # Download all images
    print("Downloading pet images...")
    successful_downloads = 0
    
    for url, save_path in pet_images:
        if download_image(url, save_path):
            successful_downloads += 1
    
    print(f"\nDownload complete! Successfully downloaded {successful_downloads}/{len(pet_images)} images.")
    print("Images saved to app/src/main/res/drawable/ directory.")

if __name__ == "__main__":
    main()