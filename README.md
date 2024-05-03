Nama Kelompok:
1.Ni Nengah Senja Sri Pratiwi     (2305551014)
2.Kadek Dwi Cahyadi               (2305551022)


Online Food Ordering System

Deskripsi
Program ini adalah sistem pemesanan makanan online berbasis command line yang dibangun dengan bahasa Java.
Program ini memungkinkan pengguna untuk login sebagai admin atau pelanggan, melihat daftar restoran, menambahkan
atau menghapus restoran (untuk admin), melihat menu restoran, membuat pesanan, melihat pesanan (untuk customer)

Cara Menjalankan Program
1.Pastikan Anda memiliki Java JDK terinstal di komputer Anda.
2.Unduh atau salin kode program dari repositori ini.
3.Buka aplikasi IntelIj.
4.Navigasi ke direktori tempat Anda menyimpan kode program.
5.Compile program dengan perintah: OnlineFoodOrderingSystem.java
6.Jalankan program dengan perintah: java Main

Petunjuk Penggunaan
1.Pada menu awal, pilih opsi 1 untuk login sebagai admin atau opsi 2 untuk login sebagai pelanggan.
2.Jika login sebagai admin, Anda dapat melihat, menambahkan, atau menghapus restoran.
3.Jika login sebagai pelanggan, Anda dapat melihat daftar restoran, melihat menu restoran, membuat pesanan, dan melihat pesanan yang sudah dibuat.
4.Untuk keluar dari program, pilih opsi "Keluar" dari menu.

Catatan Penting
Login credential untuk admin adalah sebagai berikut:
Username: admin
Password: admin123
Login credential untuk customer adalah sebagai berikut:
Username: customer
Password: customer123

Diagram UML

![PBO](https://github.com/Senjasripratiwi/Tugas_1_Pemrograman_Berorientasi_Objek/assets/147185666/2994cc21-5d3c-4f06-b4aa-58a159a62c67)

Penjelasan Diagram UML
Kelas OnlineFoodOrderingSystem:
Deskripsi: Kelas utama yang merepresentasikan sistem pemesanan makanan online.
Atribut:
adminCredentials: Map yang menyimpan kredensial admin.
customerCredentials: Map yang menyimpan kredensial pelanggan.
orderList: List yang menyimpan daftar pesanan.
restaurantAddressMap: Map yang menyimpan alamat restoran.
restaurantFoodMenuMap: Map yang menyimpan menu makanan untuk setiap restoran.
restaurantDrinkMenuMap: Map yang menyimpan menu minuman untuk setiap restoran.
scanner: Objek Scanner untuk input pengguna.
Metode:
main(String[]): Metode utama yang memulai aplikasi.
adminLogin(): Metode untuk login sebagai admin.
customerLogin(): Metode untuk login sebagai pelanggan.
displayAdminMenu(): Metode untuk menampilkan menu admin.
displayCustomerMenu(): Metode untuk menampilkan menu pelanggan.
showRestaurantMenu(): Metode untuk menampilkan daftar restoran dan menu.
addRestaurant(): Metode untuk menambahkan restoran dan menu.
deleteRestaurant(): Metode untuk menghapus restoran dan menu.
createOrder(): Metode untuk membuat pesanan.
showOrder(): Metode untuk menampilkan pesanan.
Hubungan dengan Kelas Lain:
Admin: Sistem menggunakan fungsionalitas dari kelas Admin untuk login admin dan menampilkan menu admin.
Customer: Sistem menggunakan fungsionalitas dari kelas Customer untuk login pelanggan dan menampilkan menu pelanggan.
Restaurant: Sistem menggunakan fungsionalitas dari kelas Restaurant untuk menampilkan daftar restoran dan menu.
Kardinalitas:
Setiap instance dari OnlineFoodOrderingSystem dapat berinteraksi dengan satu instance admin atau satu instance pelanggan.
OnlineFoodOrderingSystem dapat menampilkan daftar nol atau lebih instance restoran dan menu.
Dengan diagram ini, struktur sistem dan interaksi antar kelas dapat lebih mudah dipahami, membantu dalam pengembangan dan pemeliharaan sistem pemesanan makanan online.


