/*
 * Created on 05/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.mariojp.ai.agent;

import java.util.List;

/**
 * @author alunois
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IFunctions {
	/**
	 * g(x) represents the node's cost
	 * 
	 * @param o
	 * @return
	 */
	public abstract double g(INode node);

	
	public abstract double calculateUtility(INode node);
	/**
	 * h(x) represents heuristic's calculation of node.
	 * 
	 * @param o
	 * @return
	 */
	public abstract double h(INode node);

	public abstract boolean objectiveFunction(IState state);
	
	public abstract void setObjectives(List<IState> objectives);

	public abstract List<IState> getObjectives();	
	
	
}