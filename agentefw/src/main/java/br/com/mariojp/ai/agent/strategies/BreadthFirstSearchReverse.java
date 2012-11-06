package br.com.mariojp.ai.agent.strategies;

import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class BreadthFirstSearchReverse extends Agent  {

	public BreadthFirstSearchReverse(AgentModel iagent) {
		super(iagent);

	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.getGoalNode());
		INode no = null;
		boolean concluido = false;
		while (!concluido) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				no = (INode) this.border.remove(0);
				if (this.isStart(no)) {
					concluido = true;
				} else {
					List<INode> list = this.actionCommand.revertActions(no);
					border.addAll(list);
				}
			}

		}
		this.end = new Date();
		return no;
	}

}
