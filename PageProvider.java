/**
 * Sunucunun döndüreceği sayfa içeriğini üreten sözleşme (arayüz).
 * SOLID - O (Open/Closed) ve D (Dependency Inversion) burada uygulanır.
 */
public interface PageProvider {
    String getHtml();
}