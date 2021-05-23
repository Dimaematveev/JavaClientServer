import Jav.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Начало работы!");


        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Сервер запущен!");
            while (true) {
                try (Phone phone = new Phone(server)) {
                    String request = phone.readLine();
                    String response = "Symbols = " + request.length();
                    System.out.println(request);
                    System.out.println(response);
                    phone.writeLine("Hello from server");
                    phone.writeLine(response);


                } catch (NullPointerException e) {
                e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //System.out.println("Завершение программы");
    }
}
