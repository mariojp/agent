package br.com.mariojp.ai.agent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.mariojp.ai.agent.action.ActionCommand;
import br.com.mariojp.ai.agent.action.IAction;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import br.com.mariojp.ai.agent.view.Graphic;

public abstract class Agent implements IAgent {

	protected Date start = new Date();

	protected Date end = null;

	protected ActionCommand actionCommand = null;

	protected Border border = new Border();
	

	protected List<IState> objectives = new ArrayList<IState>();
	
	protected INode firstNode = null;

	protected IFunctions functions = null;
	
	protected int iteractiveDepth = 1;

	protected int type = IAgent.DEPTH_FIRST_SEARCH;
	
	protected Graphic graphic = Graphic.getInstancia();

	public Agent(AgentModel agent) {
		this.functions = agent.getFunctions();
		this.actionCommand = new ActionCommand(functions);
		this.addActions(agent.getActions());
		this.objectives = agent.getObjectives();
		this.functions.setObjectives(this.objectives);
		this.setFirstNo(agent.getInitState());
		this.graphic.addParentNode(this.firstNode);
		this.iteractiveDepth = agent.getIteractiveDepth();
	}

	public void setFirstNo(IState state) {
		this.firstNode = new Node();
		this.firstNode.setAction("Init State");
		this.firstNode.setState(state);
		this.firstNode.setDepth(0);
		this.firstNode.setParent(null);
	}
	
	public INode getGoalNode(){
		INode node = new Node();
		node.setParent(null);
		node.setAction("Goal State");
		node.setDepth(0);
		node.setState(objectives.get(0));
		return node;
	}
 
	private void addActions(Map<String, IAction> actions) {
		for (Iterator<String> it = actions.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			this.addAction(key, actions.get(key));
		}
	}

	public Date getStart() {
		return start;
	}

	public void setOrder(IFunctions order) {
		this.functions = order;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void addAction(String name, IAction iaction) {
		actionCommand.addAction(name, iaction);
	}

	public void addObjevtive(IState objective) {
		this.objectives.add(objective);
	}

	protected boolean isGoal(INode no) {
		boolean end = functions.objectiveFunction(no.getState());
		for (IState objective :  objectives)
			if (no.getState().equals(objective))
				end = true;
		return end;
	}
	
	protected boolean isStart(INode node){
		return this.firstNode.getState().equals(node.getState());
	}
	

	/**
	 * Search function
	 */
	public abstract INode function() throws EmptyBorderException;

	/**
	 * Organizing the action list through the solution.
	 */
	public List<INode> getPath(INode node) {
		List<INode> path = new ArrayList<INode>();
		while (node != null) {
			path.add(0, node);
			node = node.getParent();
		}
		return path;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		sb.append("Begin       : " + sdf.format(this.start) + "\n");
		sb.append("End         : " + sdf.format(this.end) + "\n");
		sb.append("Time elapsed: " + (this.end.getTime() - this.start.getTime())
				+ "milisecs \n");
		sb.append("Total Nodes Expanded : "+ this.border.getNodes() +"\n");
		sb.append("Total Nodes Visited : "+ this.border.getVisits() +"\n");
		return sb.toString();
	}

	public IFunctions getFunctions() {
		return functions;
	}

	public void setFunctions(IFunctions functions) {
		this.functions = functions;
	}

	public INode getFirstNode() {
		return firstNode;
	}
	
	public void showGraphic(List<INode> list, String name){
		this.graphic.showTree(list, name);
	}
	
	

}
