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
	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.firstNode);
		INode node = null;
		boolean completed = false;
		while (!completed) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				node = (INode) this.border.remove(0);
				if (this.isGoal(node)) {
					completed = true;
				} else {
					List<INode> list = this.actionCommand.executeActions(node);
					border.addAll(list);
					Collections.sort(border.getList(),this);
				}
			}
		}
		this.end = new Date();
        return node;
	}

	public int compare(INode node1, INode node2) {
		int res = 0;
		if (node1.getHeuristic() > node2.getHeuristic())
			res = 1;
		else if (node1.getHeuristic() < node2.getHeuristic())
			res = -1;
		return res;
	}

}
