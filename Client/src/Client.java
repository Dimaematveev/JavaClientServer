import Jav.Phone;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Начало работы!");
        try (Socket socket = new Socket("127.0.0.1", 8000)) {
            System.out.println("Подключились к серверу!");

            try (Phone phone = new Phone("127.0.0.1",8000)) {
                String request = "Mos";
                phone.writeLine(request);

                String response = phone.readLine();
                System.out.println("Response = " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
