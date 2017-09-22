package tratacabecalho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import tratacabecalho.Cliente;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		try {
			
			ServerSocket servidor = new ServerSocket(12345);
			
			System.out.println("Servidor ouvindo a porta " + servidor.getLocalPort());
			
			while (true) {

				Socket socket = servidor.accept();
				
				System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());
			
				Thread t = new Thread(new Cliente(socket));
				t.start();
				
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
