#!/bin/bash

# Endpoint REST API
url="https://jsonplaceholder.typicode.com/posts"

# Meminta input dari pengguna
echo "Enter post title:"
	read title
echo "Enter post body:"
	read body
echo "Enter user ID:"
	read userId

# Membuat request body dalam format JSON
jsonBody="{\"title\":\"$title\", \"body\":\"$body\", \"userId\":$userId}"

echo "Sending request..."
# Mengirim POST request ke API
response=$( curl -s -X POST -H "Content-Type: application/json" -d "$jsonBody" $url )

# Menampilkan respon
echo "$response"
echo "done"