package Console.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ConsoleChat {
    private final static String IP_ADDRESS = "localhost";
    private final static int PORT = 8189;
    private static Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ConsoleChat (){
        chatStart();
    }

    public void chatStart () {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream((socket.getOutputStream()));

            new Thread(() -> {
                try{
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equals("/end")) {
                            System.out.println("Server off");
                            break;
                        }
                        System.out.println(strFromServer);
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Мы отключились от сервера");
            }).start();
            new Thread(() -> {
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    try {
                        out.writeUTF(sc.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ConsoleChat();
    }
}
