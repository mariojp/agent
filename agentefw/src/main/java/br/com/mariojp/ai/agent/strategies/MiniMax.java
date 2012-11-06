package br.com.mariojp.ai.agent.strategies;

import java.util.Date;
import java.util.Iterator;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class MiniMax extends Agent {

	public MiniMax(AgentModel agent) {
		super(agent);
	}

	@Override
	public INode function() throws EmptyBorderException {
		INode no = (INode) this.firstNode;
		max(no);
		this.end = new Date();
		return no.getNext();
	}

	/**
	 * 
	 * MiniMax, retorna a utilidade máxima de um estado
	 * 
	 */
	public double max(INode noCorrente) {
		if (this.isObjetivo(noCorrente)) {
			return functions.calculaUtilidade(noCorrente);
		}
		double maximo = Integer.MIN_VALUE;
		Iterator i = this.actionCommand.executeActions(noCorrente).iterator();
		while (i.hasNext()) {
			INode sucessor = (INode) i.next();
			double minSucessor = min(sucessor);
			  if (minSucessor > maximo){ 
				  maximo = minSucessor;
				  noCorrente.setUtility( maximo );
				  noCorrente.setNext(sucessor);
			 }
			 
		}
		return maximo;
	}

	/**
	 * 
	 * MiniMax, retorna a utilidade mínima de um estado
	 * 
	 */
	public double min(INode noCorrente) {

		if (this.isObjetivo(noCorrente)) {
			return functions.calculaUtilidade(noCorrente);
		}

		double minimo = Integer.MAX_VALUE;
		Iterator i = this.actionCommand.executeActions(noCorrente).iterator();
		while (i.hasNext()) {
			INode sucessor = (INode) i.next();
			double maxSucessor = max(sucessor);
			if (maxSucessor < minimo){  
			  minimo = maxSucessor;
			  noCorrente.setUtility( minimo ); 
			  noCorrente.setNext(sucessor); 
			}
			 
		}
		return minimo;
	}
	
	

}
