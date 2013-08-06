package server;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		shou();
	}

	public static void shou() throws Exception {
		ServerSocket server = new ServerSocket(6000);
		System.out.println("总机开始等待用户");
		Socket s=null;
		while (true) {							
			s = server.accept();					//每接到一个请求, 就连接到一个Socket
			InputStream in = s.getInputStream();
			byte[] buf = new byte[100];
			int len = in.read(buf);
			String message = new String(buf, 0, len);
			if(message.equals("exit")){				//如果接收到的请求是exit, 则退出程序
				break;
			}
			System.out.println("接收端收到请求: 收到信息: " + message);
			in.close();
		}
		s.close();
		server.close();
	}

}
