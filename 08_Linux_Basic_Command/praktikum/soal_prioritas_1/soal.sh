#!/bin/sh

echo 'Welcome to Learning Management System!'
echo '--------------------------------------'
echo 'Silahkan login untuk melanjutkan'
echo 'Masukan username: '
	read username
echo 'Masukan password: '
	read password
echo 'Selamat Datang ' $username '!'
echo 'Masukan judul catatan Anda: '
	read catatan
echo 'Masukan isi catatan Anda:'
	read isi
echo '-------------------------------------'
echo 'Catatan Anda'
echo $catatan
echo $isi

