# Figma Export Script

This script exports assets from a Figma file, preserving the folder structure.

## Prerequisites

- Python 3.x
- `requests` library
- `python-dotenv` library

## Installation

1.  Clone the repository.
2.  Install the required Python packages:
    ```bash
    pip install -r requirements.txt
    ```
3.  Create a `.env` file in the root directory of the project and add your Figma personal access token:
    ```
    FIGMA_TOKEN="your_figma_token_here"
    ```

## Usage

To run the script, use the following command:

```bash
python scripts/figma_export.py <file_key> --node <root_node_id> [ --out <output_directory>]
```

### Arguments

-   `file_key`: **(Required)** The key of the Figma file you want to export from. You can find this in the URL of your Figma file (e.g., `https://www.figma.com/file/asmASXsyOgsxjaoz4FUt23/My-Design`).
-   `--node`: **(Required)** The ID of the root node from which to start the export. All children of this node will be exported.
-   `--out`: (Optional) The directory where the exported assets will be saved. Defaults to `"figma_export"`.

### Example

```bash
python scripts/figma_export.py asmASXsyOgsxjaoz4FUt23 --node 385:15971 --out figma_assets
```

This command will export all assets from the node `385:15971` in the file with key `asmASXsyOgsxjaoz4FUt23` and save them to the `figma_assets` directory.
