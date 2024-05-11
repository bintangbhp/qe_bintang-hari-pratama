#!/bin/bash

# Membuat direktori 'about_me' dan 'favorites'
mkdir about_me favorites

# Membuat dan mengisi file 'about_me.txt' dengan nama lengkap
echo "Bintang Hari Pratama" > about_me/about_me.txt

# Membuat file 'foods.txt' dan 'drinks.txt' di dalam direktori 'favorites'
touch favorites/foods.txt favorites/drinks.txt

# Mengisi file 'foods.txt' dengan makanan favorit
echo "Makanan favorit: Nasi goreng, Ayam goreng" > favorites/foods.txt

# Mengisi file 'drinks.txt' dengan minuman favorit
echo "Minuman favorit: Es teh" > favorites/drinks.txt

# Menampilkan struktur direktori dan file yang telah dibuat
echo "Tree direktori:"
tree