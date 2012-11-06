package br.com.mariojp.ai.agent.strategies;

import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class DepthFirstSearchInteractive extends Agent {

	public DepthFirstSearchInteractive(AgentModel agent) {
		super(agent);
		// TODO Auto-generated constructor stub
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
					List<INode> list = this.actionCommand.executeActions(no);
					if(!(((INode)list.get(0)).getDepth()%this.iteractiveDepth==0))
						border.addAll(0, list);
					else{
						border.addAll(list);
					}
				}
			}
		}
		this.end = new Date();
		return no;
	}
}
