import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

    public  static  void main(String []args){

        try {
            URL imooc = new URL("http://www.imooc.com");
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议："+url.getProtocol());
            System.out.println("主机："+url.getHost());
            //未指定端口号，则默认的端口号，此时getPort返回值为-1
            System.out.println("端口："+url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("查询字符串："+url.getQuery());
            System.out.println();

            getContent();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void getContent(){
        try {
            URL url = new URL("http://www.baidu.com");
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data!=null){
                System.out.println(data);
                data=br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
