import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    public static void main(String[] args) {
        //Создаем сервер для приема соощений
        ServerSocket server = null;
        Socket sock;
        try {
            //Ждем клиета
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = server.accept();
            System.out.println("Клиент подключился");
            //Для считывания сообщений из канала
            Scanner sc = new Scanner(sock.getInputStream());
            //Для записи сообщений в канал
            PrintWriter pw = new PrintWriter(sock.getOutputStream());

            //Поток для чтения консоли и отправки клиентам
            new Thread(() -> {
                try {
                    while (true) {
                        Scanner in = new Scanner(System.in);
                        String str = in.nextLine();
                        //Если с конслои ввели еnd,
                        // то останавливаем сервак
                        if (str.equals("end")) break;
                        //Отправляем сообщение клиенту
                        pw.println(str);
                        pw.flush();
                    }

                } catch (Exception e) {
                    System.out.printf("Ошибка чтения введнных данных на сервере и отправки клиенту - > %s", e.getMessage());
                }
            }).start();

            //Ждем сообщений от клиентов
            //Если он отправил end, то останавливаем сервер
            while (true) {
                String str = sc.nextLine();
                System.out.printf("\nСообщение клиента: %s", str);
                if (str.equals("end")) break;
            }


        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
