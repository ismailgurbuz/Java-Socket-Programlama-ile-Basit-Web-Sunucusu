/**
 * Ad Soyad (H1), Öğrenci No (H2) ve kısa biyografiyi üretir.
 * Tek sorumluluğu: HTML içeriği oluşturmak (SOLID - S).
 */
public class BiographyPage implements PageProvider {

   
    private static final String AD_SOYAD   = "İsmail Gürbüz";
    private static final String OGRENCI_NO = "1250505033";

    @Override
    public String getHtml() {
        return "<!DOCTYPE html>\n"
            + "<html lang=\"tr\">\n<head>\n"
            + "<meta charset=\"UTF-8\">\n"
            + "<title>" + AD_SOYAD + "</title>\n"
            + "<style>\n"
            + "  body { background-color:#f0f4f8; font-family:Georgia, serif; margin:40px; }\n"
            + "  h1 { color:#1a237e; font-family:Verdana, sans-serif; }\n"
            + "  h2 { color:#c62828; font-family:'Courier New', monospace; }\n"
            + "  .bio { background:#ffffff; border-left:6px solid #1a237e; padding:20px;\n"
            + "         font-size:18px; color:#333; line-height:1.6; }\n"
            + "  .bio b { color:#2e7d32; }\n"
            + "  .bio i { color:#6a1b9a; }\n"
            + "</style>\n</head>\n<body>\n"
            + "<h1>" + AD_SOYAD + "</h1>\n"
            + "<h2>Öğrenci No: " + OGRENCI_NO + "</h2>\n"
            + "<div class=\"bio\">\n"
            + "  <p><b>Merhaba!</b> Ben <i>Yazılım Mühendisliği</i> öğrencisiyim.</p>\n"
            + "  <p>Yazılım geliştirme, ağ programlama ve nesne yönelimli tasarıma ilgi duyuyorum. "
            + "Boş zamanlarımda mobil oyunlar oynamayı ve yeni şeyler öğrenmeyi severim.</p>\n"
            + "  <p>Bu sayfa, <b>Java Socket</b> kullanılarak yazılmış basit bir web sunucusu tarafından sunulmaktadır.</p>\n"
            + "</div>\n</body>\n</html>";
    }
}