//simple server application level-2 single-threaded
package socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class productinfo{
	HashMap<String,String> pInfo=new HashMap<>();
	public void method(String key,String pair)
    {
        pInfo.put(key,pair);
    }
		
	public String productDetails(String key) {
		
		return pInfo.get(key);
	}
	
}
public class server {

	public static void main(String[] args) throws IOException {
		
		productinfo p=new productinfo();
		ServerSocket serSocket=new ServerSocket(1234);
		System.out.println("server is waiting for clients");
		p.method("a","100");
		p.method("b","200");
		p.method("c","300");
		while(true) {
			
			Socket s=serSocket.accept();	
			InputStream in=s.getInputStream();
			OutputStream out=s.getOutputStream();
			
			byte buffer[]=new byte[1024];
			in.read(buffer);
			String product=new String((buffer)).trim();
			
			System.out.println("Received message from client...."+product);
			
			String key=p.productDetails(product);
			String kk="the product key is "+key;
			out.write(kk.getBytes());
			s.close();
		}
		
	
		
	}
	
}
