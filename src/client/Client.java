package client;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		fa();
	}

	public static void fa() throws Exception {									//此静态方法旨在发送数据
		
		Socket s = new Socket(InetAddress.getByName("10.212.165.15"), 6000);	//1. 拨通总机插槽的地址
		OutputStream os = s.getOutputStream();									//2. 获得我们可以输出语句的链接
		os.write("exit".getBytes());											//3. 开始在这个输出流上说话
		os.close();																//4. 关闭输出流
		s.close();																//5. 关闭数据链接
	}

}
