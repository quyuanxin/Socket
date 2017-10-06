import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public  static  void main(String [] args){

        try {
            //创建服务端Socket
            ServerSocket serverSocket = new ServerSocket(8888);
            //监听服务
            System.out.println("****服务器即将启动，等待客户端的连接***");
            Socket socket= serverSocket.accept();
            //数据交互
            InputStream is =socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info=br.readLine())!=null){
                System.out.println("客户端信息："+info);
            }

            socket.shutdownInput();

            OutputStream os =socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();

            //关闭资源
            br.close();;
            isr.close();
            is.close();

            pw.close();
            os.close();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
