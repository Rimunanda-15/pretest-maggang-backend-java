![image](https://github.com/Rimunanda-15/pretest-maggang-backend-java/blob/main/asset/Model%20Database.png?raw=true)

Desain database ini dibuat berdasarkan prinsip normalisasi, yang betujuan untuk memudahkan dalam pengemabangan
  

pada rancangan ini memiliki 6 tabel diantaranya sebagai berikut :
1. Users, pengguna aplikasi.
2. kategori, kategori barang pada aplikasi.
3. Produk, produk yang dijual oleh produsen.
4. Transaksi, transaksi pengguna dan produk yang dibeli.
5. Transaksi Detail, detail transaksi pengguna.
6. pesanan log sebagai penyimanan log 

untuk entitas kelas sangat terhubung dimana tabel produk sangat terhubung dengan transaksi yang memiliki sifat many to many 

