# SmartLibrary - Akıllı Kütüphane Yönetim Sistemi

**SmartLibrary**, Piri Reis Üniversitesi Nesneye Dayalı Programlama-II dersi kapsamında geliştirilmiş; Java SE, JDBC ve SQLite teknolojilerini kullanan masaüstü tabanlı bir kütüphane otomasyon sistemidir.

Proje, **Nesneye Yönelik Programlama (OOP)** prensiplerine sadık kalınarak ve **Katmanlı Mimari (Repository Pattern)** kullanılarak tasarlanmıştır.

## 🚀 Proje Özellikleri

Bu sistem aşağıdaki temel işlevleri yerine getirmektedir:

* **Kitap Yönetimi:** Kitap ekleme, listeleme, güncelleme ve silme (CRUD).
* **Öğrenci Yönetimi:** Öğrenci kaydı, listeleme, bilgi güncelleme ve silme.
* **Ödünç (Loan) Sistemi:**
    * Kitap ödünç verme (Stok ve müsaitlik kontrolü yapılır).
    * Kitap iade alma (Teslim tarihi işlenir).
    * Aktif ve geçmiş ödünç işlemlerini listeleme.
* **Veri Tabanı:** Tüm veriler **SQLite** veritabanında kalıcı olarak saklanır. Program her açıldığında veriler korunur.

## 🛠️ Kullanılan Teknolojiler ve Mimari

* **Dil:** Java (JDK 17+)
* **Veri Tabanı:** SQLite
* **Veri Erişim:** JDBC (Java Database Connectivity)
* **Mimari:** Layered Architecture (Model - Repository - Database)
* **IDE:** Visual Studio Code

## ⚙️ Kurulum ve Çalıştırma

Proje Visual Studio Code ortamında geliştirilmiştir.

Projeyi bilgisayarınıza indirin (Clone/Download).

Klasörü VS Code ile açın.

lib klasöründeki kütüphaneyi tanıtıp Main.java dosyasını çalıştırın.
