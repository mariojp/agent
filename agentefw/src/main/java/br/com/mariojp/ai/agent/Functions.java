package br.com.mariojp.ai.agent;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Title: Intelligent Agnts</p>
 *
 * <p>Description: Functions Class </p>
 *
 * <p>Copyright: Copyright mariojp(c) 2006</p>
 *
 * @author Mario Jorge Pereira 
 * @version 1.1
 */
public class Functions implements IFunctions {

	
	private List<IState> objectives = new ArrayList<IState>();	
	/**
	 * g(x) represents the node's cost
	 * 
	 * @param o
	 * @return
	 */
	public double g(INode no){
		return 1;
	}

	/**
	 * h(x) represents heuristic's calculation of node.
	 * 
	 * @param o
	 * @return
	 */
	public double h(INode node){
		return 0;
	}
	
	
	public double calculateUtility(INode node) {
		return 0;
	}

	public boolean objectiveFunction(IState node) {
		return false;
	}

	public void setObjectives(List<IState> objectives) {
		this.objectives = objectives;
	}

	public List<IState> getObjectives() {
		return objectives;
	}


}
