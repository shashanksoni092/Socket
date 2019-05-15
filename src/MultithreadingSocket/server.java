package MultithreadingSocket;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class productInfo{
	Map<String,String>productinfo=new HashMap<>();
	
	public void put(String key,String pair) {
		
		productinfo.put(key, pair);
		
	}
	public String get(String key) {
		return productinfo.get(key);
	}
}

class multiThreading extends Thread{

	Socket socket;
	productInfo p=new productInfo();
	public multiThreading(Socket socket){
		this.socket=socket;
	}
	public void run() {
		
		try {
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			p.put("a", "100");
			p.put("b", "200");
			p.put("c", "300");
			
			byte buffer[]=new byte[1024];
			
			in.read(buffer);
			
			String product=new String(buffer).trim();
			
			System.out.println("Message received from client"+product);
			
			
			String pair=p.get(product);
			String response="The Product price is "+pair;
			out.write(response.getBytes());
			
			socket.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	
	
}
public class server {

	public static void main(String[] args) throws IOException {
		
		
	ServerSocket serSocket=new ServerSocket(1234);
	
	
	while(true) {
		
		System.out.println("waiting for clients...");
		Socket socket=serSocket.accept();
		System.out.println("Threading done for client");
		new multiThreading(socket).start();
		
		
	}
		
	}
}
