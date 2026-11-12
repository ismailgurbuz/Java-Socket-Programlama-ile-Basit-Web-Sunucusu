import java.nio.charset.StandardCharsets;

/**
 * HTTP yanıtının başlık (header) ve gövde (body) kısmını oluşturur.
 * Tek sorumluluğu: HTTP formatını hazırlamak (SOLID - S).
 */
public class HttpResponseBuilder {

    public byte[] build(int statusCode, String statusText, String html) {
        byte[] body = html.getBytes(StandardCharsets.UTF_8);
        String header = "HTTP/1.1 " + statusCode + " " + statusText + "\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "Content-Length: " + body.length + "\r\n"
                + "Connection: close\r\n"
                + "\r\n";
        byte[] head = header.getBytes(StandardCharsets.UTF_8);
        byte[] all = new byte[head.length + body.length];
        System.arraycopy(head, 0, all, 0, head.length);
        System.arraycopy(body, 0, all, head.length, body.length);
        return all;
    }
}