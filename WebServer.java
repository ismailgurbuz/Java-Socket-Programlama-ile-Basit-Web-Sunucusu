import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Belirtilen portu dinler ve gelen bağlantıları ClientHandler'a devreder.
 * Tek sorumluluğu: bağlantı kabul etmek (SOLID - S).
 */
public class WebServer {

    private final int port;
    private final PageProvider pageProvider;
    private final HttpResponseBuilder responseBuilder;
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public WebServer(int port, PageProvider pageProvider, HttpResponseBuilder responseBuilder) {
        this.port = port;
        this.pageProvider = pageProvider;
        this.responseBuilder = responseBuilder;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Sunucu başlatıldı: http://localhost:" + port);
            while (true) {
                Socket client = serverSocket.accept(); // bağlantı gelene kadar bekler
                pool.execute(new ClientHandler(client, pageProvider, responseBuilder));
            }
        }
    }
}