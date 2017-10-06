import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressDemo {
    public static  void main(String [] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名："+address.getHostName());
        System.out.println("IP地址："+address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
        System.out.println("IP地址："+Arrays.toString(bytes));
        System.out.println(address);//直接输出InetAddress对象

        InetAddress address1 = InetAddress.getByName("DESKTOP-7LG2TQU");
    }

}
