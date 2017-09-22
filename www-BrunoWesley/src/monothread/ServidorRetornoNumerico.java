package monothread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author bwfernandes
 * Retorna as requisições em forma numerica
 */

public class ServidorRetornoNumerico {
	
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket servidor = new ServerSocket(12345);
			System.out.println("Servidor porta:" + servidor.getLocalPort());
			while (true) {
				
				Socket cliente = servidor.accept();
				
				System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
			
				InputStream inputStream = cliente.getInputStream();
				
				int i = 0;
				while( (i = inputStream.read()) !=-1){
					System.out.println(i);
				}
				
				
				cliente.close();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	

}
