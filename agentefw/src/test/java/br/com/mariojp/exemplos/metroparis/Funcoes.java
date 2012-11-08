package br.com.mariojp.exemplos.metroparis;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.exemplos.metroparis.excecoes.DistanciaNaoInformadaException;

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
//		Obtendo o no
		INode ino = (INode) arg0;
		//Função Heuristica
		
//		Obtendo o estado
		Estado estado = (Estado)ino.getState();		
		//Obtendo o estado pai
		Estado estadoPai = null;
		if (ino.getPai()!=null)
			estadoPai = (Estado)ino.getPai().getState();
		
		double distancia = 0;		
		double tempo = 0;
		
		if (estado.getEstacao().equals(estadoPai.getEstacao())){
			tempo = 4;
		}else {
			try {
				distancia = CentralControle.getInstancia().getDistanciaReal(estado.getEstacao(),estadoPai.getEstacao());
			} catch (DistanciaNaoInformadaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo=calcularTempoMinutos(distancia);
		}
		
		//System.out.println("custo:"+tempo);
		return tempo;
	}
	 
	@Override
	public double h(INode arg0) {
//		Obtendo o no
		INode ino = (INode) arg0;
		//Obtendo o estado
		Estado e = (Estado)ino.getState();		

		// pega um objetivo pq eh uma unica estcação, só diferenciando a linha 
		Estado estadoObjetivo = (Estado) this.getObjectives().get(0);
		
		
		double f ;
		double distancia = 0;		
		@SuppressWarnings("unused") double tempo = 0;
		try {
			//Função Heuristica
			distancia = CentralControle.getInstancia().getDistanciaDireta(e.getEstacao(),estadoObjetivo.getEstacao());
			f = calcularTempoMinutos(distancia);
			
		} catch (DistanciaNaoInformadaException e1) {
			f = 0;// pq estou baldeando da origem para origem só mudando a linha
		}
		//System.out.println("heuristica"+f+"\n"+e.getEstacao()+"\n"+estadoObjetivo.getEstacao());
		return f;
	}
	
	
	/**
	 * Retorna o tempo em Horas
	 * @param distancia
	 * @return
	 */
	private double calcularTempoHoras(double distancia){
		double vm = CentralControle.getInstancia().getVelocidadeMedia();
		double tempo= distancia / vm;	
		return tempo;
	}
	
	private double calcularTempoMinutos(double distancia){		
		return calcularTempoHoras(distancia) * 60;
	}
	
	

	
}
