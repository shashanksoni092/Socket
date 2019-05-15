//simple server application level-1
package socket;
import java.io.*;
import java.net.*;

public class server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serSocket=new ServerSocket(1234);
		
		System.out.println("Waiting for client");
		
		Socket socket=serSocket.accept();
		System.out.println("client connected...");
		
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		System.out.println("");
		
		byte bufferMessage[]=new byte[1024];
		in.read(bufferMessage);
		
		System.out.println("Received meassage from client.... "+ new String(bufferMessage).trim());
		
		out.write("Hello from server....".getBytes());
		
		serSocket.close();
		socket.close();
		
	}
		
}
