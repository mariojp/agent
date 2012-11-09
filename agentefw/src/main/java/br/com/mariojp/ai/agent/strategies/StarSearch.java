package br.com.mariojp.ai.agent.strategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class StarSearch extends Agent implements Comparator<INode>{

	public StarSearch(AgentModel agent) {
		super(agent);
	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.firstNode);
		INode iNode = null;
		boolean completed = false;
		while (!completed) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				iNode = (INode) this.border.remove(0);
				if (this.isGoal(iNode)) {
					completed = true;
				} else {
					List<INode> list = this.actionCommand.executeActions(iNode);
					for(INode node : list){
						if(!border.containsState(node)){
							border.add(node);
						}
					}
					Collections.sort(border.getList(),this);
				}
			}

		}
		this.end = new Date();
		return iNode;
	}

	public int compare(INode node1, INode node2) {
		int res = 0;
		if (this.f(node1) > this.f(node2))
			res = 1;
		else if (this.f(node1) < this.f(node2))
			res = -1;
		return res;
	}
	
	public double f(INode node){
		return node.getCost()+node.getHeuristic();
	}

}
