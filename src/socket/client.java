//simple client application level-1
package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",1234);
		
		
		System.out.println("Connected to server...");
		
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		out.write("Hello from client...".getBytes());	
		
		byte response[]=new byte[1024];
		in.read(response);
		
		System.out.println("Received message from server...."+new String(response).trim());
		
		socket.close();
		
	}
}
