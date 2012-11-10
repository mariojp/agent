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
					int before = border.size();
					List<INode> list = this.actionCommand.executeActions(iNode);
					for(INode node : list){
						if(!border.containsState(node)){
							border.add(node);
						}
					}
					int after = border.size();
					//System.out.println("Added border "+(after - before) +" Stayed with :"+ after);
					
				}
			}
		}
		this.end = new Date();
		return iNode;
	}

}
