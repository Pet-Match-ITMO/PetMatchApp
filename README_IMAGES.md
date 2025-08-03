# Pet Images for PetMatch App

This document describes how to generate placeholder images for the PetMatch application.

## Image Generation

The application uses SVG placeholder images for pets. These images are generated using the `scripts/create_placeholder_images.sh` script.

### Running the Script

```bash
./scripts/create_placeholder_images.sh
```

This script creates:
- 5 cat placeholder images (cat_1.xml to cat_5.xml)
- 5 dog placeholder images (dog_1.xml to dog_5.xml)

### Image Format

The images are created as Android Vector Drawable (XML) files, which are scalable and lightweight. Each image is 200x200 dp.

### Usage in the App

The images are automatically used in the PetCard components throughout the application:
- HomeScreen
- SearchScreen
- FavoritesScreen

Each pet card displays an appropriate image based on the pet type (cat or dog).

### Customization

To customize the placeholder images, modify the `scripts/create_placeholder_images.sh` script. The current implementation creates simple circular shapes with face features to represent cats and dogs.