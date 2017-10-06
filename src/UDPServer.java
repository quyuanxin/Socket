import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public  static  void main(String [] args) throws IOException {
        //创建DatagramSocket，指定端口
        DatagramSocket socket = new DatagramSocket(8800);
        //创建数据报
        System.out.println("****服务器即将启动，等待客户端的连接***");
        byte[]data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        //接收
        socket.receive(packet);
        String info = new String (data,0,packet.getLength());
        System.out.println("客户端："+info);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[]data2 ="欢迎您".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data2,data2.length,address,port);

        socket.send(packet1);
        socket.close();
    }
}
