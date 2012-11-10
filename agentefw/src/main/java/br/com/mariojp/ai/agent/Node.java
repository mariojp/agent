/**
 *
 */
package br.com.mariojp.ai.agent;



/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.impl
 * @file No.java
 * @author Mario Jorge Pereira
 * @version 1.1
 *
 *
 */
public final class Node implements INode {

	/**
	 * State of Node
	 */
	private IState state;

	/**
	 * Parent Node
	 */
	private INode parent;
	
	/**
	 * action used to generate this node
	 */
	private String action;
	
	/**
	 * depth in a tree from start node
	 */
	private int depth;
	
	/**
	 * cost to get to this node
	 */
	private double cost;

	/**
	 * 
	 */
	private double utility;
	
	/**
	 * 
	 */
	private double heuristic;


	private INode next;
	
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getCost()
	 */
	public double getCost() {
		return cost;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setCost(double)
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#getEstado()
	 */
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getState()
	 */
	public IState getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#setEstado(br.edu.ability.agente.busca.interfaces.IEstado)
	 */
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setState(br.com.mariojp.ai.agent.search.IState)
	 */
	public void setState(IState state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#getPai()
	 */
	public INode getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#setPai(br.edu.ability.agente.busca.interfaces.INo)
	 */
	public void setParent(INode parent) {
		this.parent = parent;
	}


	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.action);
		sb.append("\n");
		sb.append(this.cost);
		sb.append("\n");
		sb.append(this.depth);
		sb.append("\n");
		sb.append(this.state.toString());
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getAction()
	 */
	public String getAction() {
		return action;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setAction(java.lang.String)
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getDepth()
	 */
	public int getDepth() {
		return depth;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setDepth(int)
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getUtilidade()
	 */
	public double getUtility() {
		return utility;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setUtilidade(double)
	 */
	public void setUtility(double utility) {
		this.utility = utility;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#getHeuristica()
	 */
	public double getHeuristic() {
		return heuristic;
	}
	/* (non-Javadoc)
	 * @see br.com.mariojp.ai.agent.search.INode#setHeuristica(double)
	 */
	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}
	public INode getNext() {
		return this.next;
	}
	public void setNext(INode node) {
		this.next = node;
		
	}
	

	@Override
	public boolean equals(Object obj) {
		Node no = (Node) obj;
		return this.getState().equals(no.getState());
	}
	
}
