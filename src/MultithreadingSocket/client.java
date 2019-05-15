package MultithreadingSocket;
import java.io.*;
import java.net.*;

public class client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket=new Socket("127.0.0.1",1234);
		System.out.println("Connection established");
		
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String mssg=br.readLine();
		out.write(mssg.getBytes());
		
		byte response[]=new byte[1024];
		
		in.read(response);
		
		String res=new String(response);
		
		System.out.println("Response from server...."+res);
		
		socket.close();
		
	}
}
