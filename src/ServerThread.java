import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;

    public  ServerThread (Socket socket){
        this.socket =socket;
    }

    public  void run(){
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os = null;
        PrintWriter pw=null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("客户端信息：" + info);
            }

            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if(br!=null)
                br.close();
                if(isr!=null)
                isr.close();
                if(is!=null)
                is.close();

                if(pw!=null)
                pw.close();
                if(os!=null)
                os.close();
                if(socket!=null)
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
