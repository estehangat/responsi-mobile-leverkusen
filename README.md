# Responsi 1 Pemrograman Mobile

```json
Nama       :  Daiva Paundra Gevano
NIM        :  H1D023075
Shift Baru :  A
Shift KRS  :  F
Team       :  Bayer 04 Leverkusen
```

## Video Demo Aplikasi
https://github.com/user-attachments/assets/416521ad-c194-4001-963b-e091c096266a

## Penjelasan Alur Data
Aplikasi ini memakai Retrofit untuk mengambil data dari API Football Data. Prosesnya dimulai dari `RetrofitClient.kt` yang bertugas menyambungkan ke endpoint `https://api.football-data.org/v4/` dan mengubah respons JSON menjadi objek Kotlin memakai `GsonConverterFactory`. Lalu ada `FootballApiService.kt` yang mendefine fungsi `getTeamDetails()` untuk mengirim request HTTP GET dengan parameter `id` tim dan header autentikasi `X-Auth-Token`. Saat user membuka halaman "Squad", `SquadActivity.kt` langsung memanggil fungsi `loadSquadData()` supaya mengambil datanya tidak membuat UI freeze. Data yang sudah didapat lalu dikirim ke `SquadAdapter.kt` untuk ditampilkan di setiap item `RecyclerView`. Adapter ini menampilkan nama pemain, kewarganegaraan, dan posisinya dengan warna background yang berbeda-beda sesuai posisi di lapangan. Jika user klik salah satu pemain, detailnya akan muncul melalui `PlayerDetailFragment`. Jadi secara keseluruhan, alurnya adalah: Ambil data dari API → parse JSON → menampilkan list pemain ke UI secara dinamis.
