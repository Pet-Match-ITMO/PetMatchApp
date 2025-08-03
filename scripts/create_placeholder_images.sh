#!/bin/bash

# Create drawable directories
mkdir -p app/src/main/res/drawable

# Create simple SVG placeholder images for cats
for i in {1..5}; do
  cat > app/src/main/res/drawable/cat_$i.xml << EOF
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="200dp"
    android:height="200dp"
    android:viewportWidth="200"
    android:viewportHeight="200">
  <path
      android:fillColor="#FFBB86FC"
      android:pathData="M100,100m-80,0a80,80 0,1 1,160 0a80,80 0,1 1,-160 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M70,70m-15,0a15,15 0,1 1,30 0a15,15 0,1 1,-30 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M130,70m-15,0a15,15 0,1 1,30 0a15,15 0,1 1,-30 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M100,130m-20,0a20,20 0,1 1,40 0a20,20 0,1 1,-40 0"/>
</vector>
EOF
done

# Create simple SVG placeholder images for dogs
for i in {1..5}; do
  cat > app/src/main/res/drawable/dog_$i.xml << EOF
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="200dp"
    android:height="200dp"
    android:viewportWidth="200"
    android:viewportHeight="200">
  <path
      android:fillColor="#FF6200EE"
      android:pathData="M100,100m-80,0a80,80 0,1 1,160 0a80,80 0,1 1,-160 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M70,80m-10,0a10,10 0,1 1,20 0a10,10 0,1 1,-20 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M130,80m-10,0a10,10 0,1 1,20 0a10,10 0,1 1,-20 0"/>
  <path
      android:fillColor="#FFFFFF"
      android:pathData="M100,140m-25,0a25,25 0,1 1,50 0a25,25 0,1 1,-50 0"/>
</vector>
EOF
done

echo "Placeholder SVG images created successfully!"
echo "Images saved to app/src/main/res/drawable/ directory."