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
		INode node = (INode) this.firstNode;
		max(node);
		this.end = new Date();
		return node.getNext();
	}

	/**
	 * 
	 * MiniMax, returns the maximum utility of a state
	 * 
	 */
	public double max(INode currentNode) {
		if (this.isGoal(currentNode)) {
			return functions.calculateUtility(currentNode);
		}
		double max = Integer.MIN_VALUE;
		Iterator i = this.actionCommand.executeActions(currentNode).iterator();
		while (i.hasNext()) {
			INode successor = (INode) i.next();
			double minSuccessor = min(successor);
			  if (minSuccessor > max){ 
				  max = minSuccessor;
				  currentNode.setUtility( max );
				  currentNode.setNext(successor);
			 }
			 
		}
		return max;
	}

	/**
	 * 
	 * MiniMax, returns the minimum utility of a state
	 * 
	 */
	public double min(INode currentNode) {

		if (this.isGoal(currentNode)) {
			return functions.calculateUtility(currentNode);
		}

		double min = Integer.MAX_VALUE;
		Iterator i = this.actionCommand.executeActions(currentNode).iterator();
		while (i.hasNext()) {
			INode successor = (INode) i.next();
			double maxSuccessor = max(successor);
			if (maxSuccessor < min){  
			  min = maxSuccessor;
			  currentNode.setUtility( min ); 
			  currentNode.setNext(successor); 
			}
			 
		}
		return min;
	}

}
