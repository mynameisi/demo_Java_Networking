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
		System.out.println("�ܻ���ʼ�ȴ��û�");
		Socket s=null;
		while (true) {							
			s = server.accept();					//ÿ�ӵ�һ������, �����ӵ�һ��Socket
			InputStream in = s.getInputStream();
			byte[] buf = new byte[100];
			int len = in.read(buf);
			String message = new String(buf, 0, len);
			if(message.equals("exit")){				//������յ���������exit, ���˳�����
				break;
			}
			System.out.println("���ն��յ�����: �յ���Ϣ: " + message);
			in.close();
		}
		s.close();
		server.close();
	}

}
