import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Bağlanan tek bir istemciyi (tarayıcıyı) işler.
 * Somut sınıfa değil, PageProvider arayüzüne bağımlıdır (SOLID - D).
 */
public class ClientHandler implements Runnable {

    private final Socket socket;
    private final PageProvider pageProvider;
    private final HttpResponseBuilder responseBuilder;

    public ClientHandler(Socket socket, PageProvider pageProvider, HttpResponseBuilder responseBuilder) {
        this.socket = socket;
        this.pageProvider = pageProvider;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
             OutputStream out = s.getOutputStream()) {

            // İstek satırı: "GET / HTTP/1.1"
            String requestLine = in.readLine();
            System.out.println("İstek: " + requestLine);

            // Başlıkları boş satıra kadar oku ve yok say
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) { /* geç */ }

            byte[] response;
            if (requestLine != null && requestLine.startsWith("GET")) {
                response = responseBuilder.build(200, "OK", pageProvider.getHtml());
            } else {
                response = responseBuilder.build(405, "Method Not Allowed",
                        "<h1>405 - Desteklenmeyen metot</h1>");
            }
            out.write(response);
            out.flush();
        } catch (IOException e) {
            System.err.println("İstemci hatası: " + e.getMessage());
        }
    }
}