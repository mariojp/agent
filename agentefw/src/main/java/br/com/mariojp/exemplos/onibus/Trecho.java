package br.com.mariojp.exemplos.onibus;

public class Trecho {

	private BusStop origem;
	private BusStop destino;
	private double distanciaDireta;
	private double distanciaReal;
	
	public Trecho() {
		// TODO Auto-generated constructor stub
	}
	
	public String getKey() {
		return origem.getLocation()+destino.getLocation();
	}
	
	public Trecho(BusStop origem, BusStop destino, double distanciaDireta,
			double distanciaReal) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distanciaDireta = distanciaDireta;
		this.distanciaReal = distanciaReal;
	}

	public BusStop getOrigem() {
		return origem;
	}
	public void setOrigem(BusStop origem) {
		this.origem = origem;
	}
	public BusStop getDestino() {
		return destino;
	}
	public void setDestino(BusStop destino) {
		this.destino = destino;
	}
	public double getDistanciaDireta() {
		return distanciaDireta;
	}
	public void setDistanciaDireta(double distanciaDireta) {
		this.distanciaDireta = distanciaDireta;
	}
	public double getDistanciaReal() {
		return distanciaReal;
	}
	public void setDistanciaReal(double distanciaReal) {
		this.distanciaReal = distanciaReal;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Trecho outro = (Trecho) arg0;
		return this.getKey().equalsIgnoreCase(outro.getKey());
	}

	

	
}
