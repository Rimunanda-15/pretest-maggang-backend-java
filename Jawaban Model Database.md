Desain database ini dibuat berdasarkan prinsip normalisasi, yang bertujuan untuk mengurangi duplikasi data dan meningkatkan integritas data. 
Setiap tabel mewakili bagian yang berbeda dari sistem e-commerce dan hubungan dibuat di mana perlu untuk menghubungkan tabel-tabel ini.
  
Misalnya, tabel 'Cart' memiliki hubungan dengan tabel 'Product' dan 'Customer', yang menunjukkan bahwa sebuah keranjang belanja 
milik seorang pelanggan dan dapat berisi beberapa produk. Ini membantu dalam melacak produk apa saja yang ada dalam keranjang belanja setiap pelanggan.

Demikian pula, tabel 'OrderBuy' dan 'OrderItem' membantu dalam melacak detail pesanan seperti produk apa yang dipesan, 
berapa jumlahnya, dan siapa pelanggannya. Tabel 'OrderLog' membantu dalam melacak aktivitas pelanggan.
Desain ini juga memungkinkan skalabilitas dan fleksibilitas. Misalnya, jika kita ingin menambahkan lebih banyak detail 
tentang produk atau pelanggan di masa mendatang, kita bisa melakukannya dengan menambahkan lebih banyak atribut ke tabel 'Product' atau 'Customer'.
Jadi, desain ini dipilih karena efisiensinya dalam mengelola dan melacak data dalam sistem e-commerce.