import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Начало работы!");
        try (Socket socket = new Socket("127.0.0.1", 8000)) {
            System.out.println("Подключились к серверу!");

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
                String request = "Mos";
                writer.write(request);
                writer.newLine();
                writer.flush();
                
                String response = reader.readLine();
                System.out.println("Response = " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
