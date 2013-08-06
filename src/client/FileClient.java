package client;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient {
	public static void main(String[] args) throws Exception{
		fa();
	}

	final static String IP="10.212.165.15";
	final static String LH="127.0.0.1";
	public static void fa() throws Exception {									  
		
		Socket s = new Socket(InetAddress.getByName(LH), 6000);	
		InputStream in=new FileInputStream("./MothersDay.jpg");
		byte[] buffer=new byte[in.available()];
		in.read(buffer);
		OutputStream out = s.getOutputStream();									
		out.write(buffer);
		in.close();
		out.close();																
		s.close();																 
	}

}
