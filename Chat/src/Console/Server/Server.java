package Console.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    Scanner sc = new Scanner(System.in);

    public Server(){

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

           new Thread(()->{
               while (true) {
                   String str = null;
                   try {
                       str = in.readUTF();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                   assert str != null;
                   if ("/end".equals(str)) {
                       System.out.println("Client is offline");
                       break;
                   }
                   System.out.println(str);
               }

           }).start();
            new Thread(()->{
                while (true) {
                    try {
                        out.writeUTF(sc.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
