package tratacabecalho;

import java.util.HashMap;
import java.util.Map;

public class RequisicaoHTTP {
	private String modo;
	private String recurso;
	private String versaoHttp;
	private Map<String,String> mapa = new HashMap<String,String>();
	
	public Map<String, String> getParams() {
		return mapa;
	}

	public void setParams(Map<String, String> mapa) {
		this.mapa = mapa;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getVersaoHttp() {
		return versaoHttp;
	}

	public void setVersaoHttp(String versaoHttp) {
		this.versaoHttp = versaoHttp;
	}

	public String getParametro(String chave) {
		return mapa.get(chave);
	}
	
	public void addParamentro(String chave, String valor) {
		mapa.put(chave, valor);
	}

	@Override
	public String toString() {
		return "RequisicaoHTTP [modo=" + modo + ", recurso=" + recurso + ", versaoHttp=" + versaoHttp + ", mapa="
				+ mapa + "]";
	}
}
