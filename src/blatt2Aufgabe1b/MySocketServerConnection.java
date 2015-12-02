package blatt2Aufgabe1b;

import java.io.*;
import java.net.*;
 
public class MySocketServerConnection extends Thread {
	private Socket socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public MySocketServerConnection(Socket socket) 
					throws IOException {
		this.socket=socket;
		objectOutputStream=
			new ObjectOutputStream(socket.getOutputStream());
		objectInputStream=
			new ObjectInputStream(socket.getInputStream());
		System.out.println("Server: incoming connection accepted.");
	}
	
	public void run() {
		System.out.println("Server: waiting for message ...");	
		
		try {
			String string=(String)objectInputStream.readObject();
			System.out.println("Server: received '"+string+"'");	
			objectOutputStream.writeObject("server received "+string);
			
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
