#!/bin/bash

# Create drawable directories
mkdir -p app/src/main/res/drawable
mkdir -p app/src/main/res/drawable-hdpi
mkdir -p app/src/main/res/drawable-mdpi
mkdir -p app/src/main/res/drawable-xhdpi
mkdir -p app/src/main/res/drawable-xxhdpi
mkdir -p app/src/main/res/drawable-xxxhdpi

# Download sample images from a reliable source
# Using Picsum Photos which provides placeholder images
curl -s -o app/src/main/res/drawable/cat_1.png https://picsum.photos/200/200?random=1
curl -s -o app/src/main/res/drawable/cat_2.png https://picsum.photos/200/200?random=2
curl -s -o app/src/main/res/drawable/cat_3.png https://picsum.photos/200/200?random=3
curl -s -o app/src/main/res/drawable/cat_4.png https://picsum.photos/200/200?random=4
curl -s -o app/src/main/res/drawable/cat_5.png https://picsum.photos/200/200?random=5

curl -s -o app/src/main/res/drawable/dog_1.png https://picsum.photos/200/200?random=6
curl -s -o app/src/main/res/drawable/dog_2.png https://picsum.photos/200/200?random=7
curl -s -o app/src/main/res/drawable/dog_3.png https://picsum.photos/200/200?random=8
curl -s -o app/src/main/res/drawable/dog_4.png https://picsum.photos/200/200?random=9
curl -s -o app/src/main/res/drawable/dog_5.png https://picsum.photos/200/200?random=10

echo "Pet images downloaded successfully!"
echo "Images saved to app/src/main/res/drawable/ directory."