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

	public static void shou() throws Exception {		//�˾�̬����ּ�ڽ�������
		
		ServerSocket server = new ServerSocket(6000); 	//1. ��ȷ�ܻ� ServerSocket ����Ϊ6000
		
		System.out.println("�ܻ���ʼ�ȴ��û�");
		Socket s=server.accept();						//2. �����ܻ��ĵȴ�����accept()�������ȴ���������
														//   a. ���û�����󣬳����һֱ�ȴ�
														//   b. ��������󣬳���Ͱ���������һ����� Socket ��
		
		InputStream in = s.getInputStream();			//3. �Ӳ���л��������
		byte[] buf = new byte[100];						//   a. �����������Ϣ�����ᳬ��100���ֽڣ�����һ������
		int len = in.read(buf);							//   b. �����ݴӻ����ж���
		String message=new String(buf, 0, len);			//   c. ͨ�����湹�������Ϣ��Ӧ���ַ���
		System.out.println("���ն��յ�����: �յ���Ϣ: " + message);
		in.close();										//   d. �ر�������
		
		s.close();										//4. �رշֻ�
		server.close();									//5. �ر��ܻ�
	}
	
	
	public static void fa() throws Exception {									    //�˾�̬����ּ�ڷ�������
		
		Socket s = new Socket(InetAddress.getByName("10.212.165.15"), 6000);	//1. ��ͨ�ܻ���۵ĵ�ַ
		OutputStream os = s.getOutputStream();									//2. ������ǿ��������������
		os.write("hello".getBytes());									//3. ��ʼ������������˵��
		os.close();																//4. �ر������
		s.close();																//5. �ر���������
	}

}

