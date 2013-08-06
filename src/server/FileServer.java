package server;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(6000); 	
		
		System.out.println("开始等待用户传输文件");
		Socket s=server.accept();						
		
		InputStream in = s.getInputStream();	
		byte[] buf = new byte[30000];	
		int length=in.read(buf);	
		System.out.println("file size="+length);
		
		OutputStream out=new FileOutputStream("./MothersDay_2.jpg");	
		out.write(buf,0,length);
		System.out.println("完成文件的传输");
		in.close();										
		out.close();
		s.close();										
		server.close();									

	}

}
