package br.com.mariojp.ai.agent;

public interface INode {
	
	/**
	 * @return Returns the cost.
	 */
	public abstract double getCost();

	/**
	 * @param cost The cost to set.
	 */
	public abstract void setCost(double cost);

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#getEstado()
	 */
	public abstract IState getState();

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#setEstado(br.edu.ability.agente.busca.interfaces.IEstado)
	 */
	public abstract void setState(IState state);

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#getPai()
	 */
	public abstract INode getParent();

	/* (non-Javadoc)
	 * @see br.edu.ability.agente.busca.generico.INo#setPai(br.edu.ability.agente.busca.interfaces.INo)
	 */
	public abstract void setParent(INode parent);

	public abstract String toString();

	public abstract String getAction();

	public abstract void setAction(String action);

	public abstract int getDepth();

	public abstract void setDepth(int depth);

	public abstract double getUtility();

	public abstract void setUtility(double utility);

	public abstract double getHeuristic();

	public abstract void setHeuristic(double heuristic);

	public abstract INode getNext();
	
	public abstract void setNext(INode node);

}