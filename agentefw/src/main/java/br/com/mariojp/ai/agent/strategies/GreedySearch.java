package br.com.mariojp.ai.agent.strategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class GreedySearch extends Agent implements Comparator<INode> {

	public GreedySearch(AgentModel agent) {
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
					border.addAll(list);
					Collections.sort(border.getList(),this);
					}
				}
			}
		this.end = new Date();
        return no;
	}

	public int compare(INode node1, INode node2) {
		int res = 0;
		if (node1.getHeuristica() > node2.getHeuristica())
			res = 1;
		else if (node1.getHeuristica() < node2.getHeuristica())
			res = -1;
		return res;
	}

}
