package client;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		fa();
	}

	public static void fa() throws Exception {									//�˾�̬����ּ�ڷ�������
		
		Socket s = new Socket(InetAddress.getByName("10.212.165.15"), 6000);	//1. ��ͨ�ܻ���۵ĵ�ַ
		OutputStream os = s.getOutputStream();									//2. ������ǿ��������������
		os.write("exit".getBytes());											//3. ��ʼ������������˵��
		os.close();																//4. �ر������
		s.close();																//5. �ر���������
	}

}
