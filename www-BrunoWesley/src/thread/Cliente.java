package thread;

import java.io.InputStream;
import java.net.Socket;

public class Cliente implements Runnable {
	private Socket socket;

	public Cliente(Socket socket) {
		this.socket = socket;		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try 
		{
			InputStream inputStream = this.socket.getInputStream();			
			int i = 0;
			while( (i = inputStream.read()) !=-1){
				System.out.print((char) i);
			}
			
			this.socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	}

