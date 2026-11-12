# Java Socket ile Basit Web Sunucusu

Üçüncü parti bileşen kullanmadan, yalnızca Java ve socket programlama ile yazılmış basit bir web sunucusudur. Sunucu **1989. portu** dinler. Tarayıcı bağlandığında şunları gösterir:

- **H1:** Ad Soyad
- **H2:** Öğrenci No
- Renk ve font ile biçimlendirilmiş kısa bir biyografi

**Hazırlayan:** İsmail Gürbüz
**Öğrenci No:** 1250505033

## Gereksinimler

- Java JDK 11 veya üzeri (`java -version` ile kontrol edin)
- Visual Studio Code ve "Extension Pack for Java" eklentisi (isteğe bağlı)

macOS'ta Java yüklü değilse:

```bash
brew install openjdk
```

## Proje Yapısı

| Dosya | Görevi |
|---|---|
| `Main.java` | Giriş noktası; nesneleri oluşturur ve sunucuyu başlatır |
| `WebServer.java` | `ServerSocket` ile portu dinler, bağlantıları thread havuzuna devreder |
| `ClientHandler.java` | Tek bir istemcinin isteğini okur ve yanıt gönderir |
| `HttpResponseBuilder.java` | HTTP durum satırı ve başlıklarını hazırlar |
| `PageProvider.java` | Sayfa içeriği üreten sınıflar için arayüz |
| `BiographyPage.java` | Ad Soyad, Öğrenci No ve biyografi HTML'ini üretir |

> **Not:** Java'da `public` sınıf adı ile dosya adı birebir (büyük/küçük harf dahil) aynı olmalıdır.

## Çalıştırma

### Terminalden

Proje klasöründe:

```bash
javac *.java
java Main
```

### VS Code ile

1. Klasörü VS Code'da açın (File → Open Folder).
2. `Main.java` dosyasını açın.
3. Sağ üstteki **Run** (▶) düğmesine basın.

Konsolda şu çıktıyı görmelisiniz:

```
Sunucu başlatıldı: http://localhost:1989
```

Ardından tarayıcıda şu adresi açın:

```
http://localhost:1989
```

Durdurmak için terminalde `Ctrl + C` tuşlarına basın.

## Bilgileri Değiştirme

`BiographyPage.java` içindeki alanları düzenleyin:

```java
private static final String AD_SOYAD   = "Ad Soyad";
private static final String OGRENCI_NO = "123456789";
```

Biyografi metni ve CSS stilleri aynı dosyadaki `getHtml()` metodunda bulunur.

## Sık Karşılaşılan Hatalar

| Hata | Çözüm |
|---|---|
| `The public type X must be defined in its own file` | Dosya adını sınıf adıyla aynı yapın (örn. `main.java` → `Main.java`) |
| `Address already in use` | Sunucu zaten çalışıyor. Önceki çalışmayı durdurun veya portu değiştirin |
| Türkçe karakterler bozuk görünüyor | Dosyaları UTF-8 kodlamasıyla kaydedin |

## SOLID İlkeleri

- **S (Tek Sorumluluk):** Her sınıfın tek bir görevi vardır.
- **O (Açık/Kapalı):** Yeni sayfa için yeni bir `PageProvider` yazmak yeterlidir, sunucu kodu değişmez.
- **L (Liskov):** Her `PageProvider` gerçeklemesi, birbirinin yerine kullanılabilir.
- **I (Arayüz Ayrımı):** `PageProvider` yalnızca tek metot içerir.
- **D (Bağımlılığın Tersine Çevrilmesi):** `WebServer` ve `ClientHandler` somut sınıfa değil `PageProvider` arayüzüne bağımlıdır.

## Kullanılan Teknolojiler

`java.net.ServerSocket`, `java.net.Socket`, `java.io.BufferedReader`, `java.io.OutputStream`, `java.util.concurrent.ExecutorService`
