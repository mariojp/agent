package br.com.mariojp.exemplos.onibus;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;

public class Funcoes extends Functions {
	
	/**
	 * 
	 */
	public Funcoes() {
		
		
	}

	/**
	 * Define o custo
	*/
	public double g(INode arg0) {
		INode ino = (INode) arg0;
		Estado estado = (Estado) ino.getState();		
		Estado pai = (Estado)ino.getPai().getState();
		double valor = 0;				
		valor = BaseDados.getInstancia().getDistanciaDireta(estado.getPonto(),pai.getPonto())*1.1;
		if (!estado.getLinha().equals(pai.getLinha())){
			valor = valor*1.5;
		}
		return valor;
	}
	 
	@Override
	public double h(INode arg0) {
		double valor = 0;
		Estado objetivo =  (Estado) getObjectives().get(0);
		INode ino = (INode) arg0;
		Estado estado = (Estado) ino.getState();	
		valor = valor + BaseDados.getInstancia().getDistanciaDireta(estado.getPonto(),objetivo.getPonto());
		if (ino.getPai()!=null ){
			Estado pai = (Estado) ino.getPai().getState();
			if (!estado.getLinha().equals(pai.getLinha())){
				//valor = valor*1.5;
			}
		}
		return valor;	

	}
	
	
	/**
	 * Retorna o tempo em Horas
	 * @param distancia
	 * @return
	 */
//	private double calcularTempoHoras(double distancia){
//		double vm = BaseDados.getInstancia().getVelocidadeMedia();
//		double tempo= distancia / vm;	
//		return tempo;
//	}
//	
//	private double calcularTempoMinutos(double distancia){		
//		return calcularTempoHoras(distancia) * 60;
//	}
	
	

	
}
