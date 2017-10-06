import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMul {
    public static  void main(String []args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket=null;
            //监听服务
            System.out.println("****服务器即将启动，等待客户端的连接***");
            int count=0;
            while (true) {
              socket   = serverSocket.accept();
              ServerThread serverThread = new ServerThread(socket);
              serverThread.setPriority(4);
              serverThread.start();
              count++;
              System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
