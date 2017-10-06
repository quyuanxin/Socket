import java.io.*;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class Client {

    public  static  void main(String[]args){

        try {
            //创建Socket
            Socket socket = new Socket("localhost",8888);
            //发送信息
            OutputStream os =socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            // 传输对象
           // ObjectOutputStream oos = new ObjectOutputStream(os);
           // oos.writeObject();

            pw.write("用户名：admin;密码：123");
            pw.flush();

            socket.shutdownOutput();

            InputStream is =socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info=br.readLine())!=null){
                System.out.println("服务端信息："+info);
            }

            br.close();;
            isr.close();
            is.close();

            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
