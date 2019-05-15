//simple client application level-2 single threaded
package socket2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
public static void main(String[] args) throws UnknownHostException, IOException {
	
	Socket socket=new Socket("127.0.0.1",1234);
	
	System.out.println("Client is connected....");
	
	InputStream in=socket.getInputStream();
	OutputStream out=socket.getOutputStream();
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String bs=br.readLine();
	out.write(bs.getBytes());
	System.out.println("Sending the response");
	byte response[]=new byte[1024];
	
	in.read(response);
	
	String res=new String((response)).trim();
	
	System.out.println("Received message from server..."+res);
	socket.close();
}
}
