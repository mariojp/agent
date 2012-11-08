package br.com.mariojp.exemplos.metroparis;

public class Distancia {

	public static final int DISTANCIA_DIRETA = 1;
	public static final int DISTANCIA_REAL   = 2;
	private Estacao origem;
	private Estacao destino;
	private double distancia;
	private int tipoDistancia;
	
	public Distancia(Estacao _origem,Estacao _destino,double _distancia,int _tipoDistancia){
		this.origem  = _origem;
		this.destino = _destino;
		this.distancia = _distancia;
		this.tipoDistancia = _tipoDistancia;
	}
	/**
	 * @return Returns the destino.
	 */
	public Estacao getDestino() {
		return destino;
	}
	
	/**
	 * @return Returns the distancia.
	 */
	public double getDistancia() {
		return distancia;
	}
	
	/**
	 * @return Returns the origem.
	 */
	public Estacao getOrigem() {
		return origem;
	}
	
	
	/**
	 * Retorna a string do objeto
	 */
	public String toString() {
		StringBuffer toString = new StringBuffer();
		toString.append(" Estacao de Origem:"+this.getOrigem().getDesc()+"\n");
		toString.append(" Estacao de Destino:"+this.getDestino().getDesc()+"\n");
		toString.append(" A Distancia "+(this.tipoDistancia == DISTANCIA_DIRETA?"Direta":"Real")+" :"+this.getDistancia()+"\n");
		return toString.toString();
	}
	/**
	 * @return Returns the tipoDistancia.
	 */
	public int getTipoDistancia() {
		return tipoDistancia;
	}
	/**
	 * @param tipoDistancia The tipoDistancia to set.
	 */
	public void setTipoDistancia(int tipoDistancia) {
		this.tipoDistancia = tipoDistancia;
	}
	
}
