import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Начало работы!");


        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Сервер запущен!");
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Клиент подключился!");
                    try (BufferedWriter writer =
                                 new BufferedWriter(
                                         new OutputStreamWriter(
                                                 socket.getOutputStream()
                                         )
                                 );
                         BufferedReader reader =
                                 new BufferedReader(
                                         new InputStreamReader(
                                                 socket.getInputStream()
                                         )
                                 );
                    ) {
                        String request = reader.readLine();
                        String response = "Symbols = " + request.length();
                        System.out.println(request);
                        System.out.println(response);
                        writer.write("Hello from server");
                        writer.newLine();
                        writer.write(response);
                        writer.newLine();
                        writer.flush();

                    } catch (NullPointerException e) {
                       e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //System.out.println("Завершение программы");
    }
}
