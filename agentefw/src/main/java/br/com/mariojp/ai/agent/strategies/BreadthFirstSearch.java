package br.com.mariojp.ai.agent.strategies;

import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class BreadthFirstSearch extends Agent  {

	public BreadthFirstSearch(AgentModel iagent) {
		super(iagent);

	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.firstNode);
		INode no = null;
		boolean concluido = false;
		while (!concluido) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				no = (INode) this.border.remove(0);
				if (this.isObjetivo(no)) {
					concluido = true;
				} else {
					int antes = border.size();
					List<INode> list = this.actionCommand.executeActions(no);
					for(INode node : list){
						if(!border.containsState(node)){
							border.add(node);
						}
					}
					int depois = border.size();
					//System.out.println("Borda adicionou "+(depois - antes) +" Ficou com :"+ depois);
					
				}
			}
		}
		this.end = new Date();
		return no;
	}

}
