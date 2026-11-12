/**
 * Uygulamanın giriş noktası. Nesneleri oluşturup birbirine bağlar.
 */
public class Main {
    public static void main(String[] args) {
        try {
            WebServer server = new WebServer(1989, new BiographyPage(), new HttpResponseBuilder());
            server.start();
        } catch (Exception e) {
            System.err.println("Sunucu başlatılamadı: " + e.getMessage());
        }
    }
}