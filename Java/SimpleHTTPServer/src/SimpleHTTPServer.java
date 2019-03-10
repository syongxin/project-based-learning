import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 */
public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        // ServerSocket is used to receive connections in Server application
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Server listening for connection at port 8080 ... ");

        while (true) {
            try {
                // Socket is used to send and receive data from individual client.
                final Socket client = server.accept();
                // 1. Read HTTP request from the client socket
                // 2. Prepare an HTTP response
                // 3. Send HTTP response to client
                // 4. Close the socket
                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }

                Date date = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + date;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            } catch (Exception e) {
                throw e;
            }

        }
    }
}
