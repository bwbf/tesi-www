package tratacabecalho;

import java.io.InputStream;
import java.net.Socket;
import tratacabecalho.RequisicaoHTTP;


/**
 * 
 * @author bwfernandes
 *
 */

public class Cliente implements Runnable{

	private Socket socket;

	public Cliente(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = this.socket.getInputStream();
			int i = 0;
			String parada = "";
			int contLinha = 0;
			
			RequisicaoHTTP req = new RequisicaoHTTP();

			while ((i = inputStream.read()) != -1) {
				if (i != 13 && i != 10) {
					parada += (char) i;
				}

				if (i == 10) {
					contLinha++;
					if (contLinha == 1) {

						String[] conteudo = parada.split(" ");

						req.setModo(conteudo[0]);
						req.setRecurso(conteudo[1]);
						req.setVersaoHttp(conteudo[2]);
						
						parada = "";
					}else {
						if(!parada.isEmpty()) {
							int indice   = parada.indexOf(":");
							String chave = parada.substring(0, indice);
							String valor = parada.substring(indice + 1, parada.length());
							
							req.addParamentro(chave, valor);

							parada = "";
						}
					}
					
				}
			}

			System.out.print(req.toString());
			

			this.socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
