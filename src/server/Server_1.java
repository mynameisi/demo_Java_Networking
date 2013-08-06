package server;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		shou();
	}

	public static void shou() throws Exception {		//此静态方法旨在接受数据
		
		ServerSocket server = new ServerSocket(6000); 	//1. 明确总机 ServerSocket 号码为6000
		
		System.out.println("总机开始等待用户");
		Socket s=server.accept();						//2. 调用总机的等待接受accept()方法，等待链接请求
														//   a. 如果没有请求，程序就一直等待
														//   b. 如果有请求，程序就把链接连到一个插槽 Socket 中
		
		InputStream in = s.getInputStream();			//3. 从插槽中获得输入流
		byte[] buf = new byte[100];						//   a. 假设流入的信息，不会超过100个字节，构建一个缓存
		int len = in.read(buf);							//   b. 把数据从缓存中读入
		String message=new String(buf, 0, len);			//   c. 通过缓存构建获得信息对应的字符串
		System.out.println("接收端收到请求: 收到信息: " + message);
		in.close();										//   d. 关闭输入流
		
		s.close();										//4. 关闭分机
		server.close();									//5. 关闭总机
	}
	
	
	public static void fa() throws Exception {									    //此静态方法旨在发送数据
		
		Socket s = new Socket(InetAddress.getByName("10.212.165.15"), 6000);	//1. 拨通总机插槽的地址
		OutputStream os = s.getOutputStream();									//2. 获得我们可以输出语句的链接
		os.write("hello".getBytes());									//3. 开始在这个输出流上说话
		os.close();																//4. 关闭输出流
		s.close();																//5. 关闭数据链接
	}

}

