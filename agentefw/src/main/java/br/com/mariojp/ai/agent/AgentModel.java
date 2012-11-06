package br.com.mariojp.ai.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mariojp.ai.agent.action.IAction;

public class AgentModel {

	
	private Map<String,IAction> actions = new HashMap<String,IAction>();
	
	private IState initState = null;
	
	private List<IState> objectives = new ArrayList<IState>();
	
	private IFunctions functions = new Functions();
	
	private int type = IAgent.DEPTH_FIRST_SEARCH;
	
	protected int iteractiveDepth = 1;
	

	public int getIteractiveDepth() {
		return iteractiveDepth;
	}

	public void setIteractiveDepth(int iteractiveDepth) {
		this.iteractiveDepth = iteractiveDepth;
	}

	public Map<String, IAction> getActions() {
		return actions;
	}
	
	public void addAction(String key,IAction action){
		this.actions.put(key,action);
	}

	public void setActions(Map<String, IAction> actions) {
		this.actions = actions;
	}



	public IFunctions getFunctions() {
		return functions;
	}

	public void setFunctions(IFunctions functions) {
		this.functions = functions;
	}

	public List<IState> getObjectives() {
		return objectives;
	}

	public void addObjective(IState objective){
		this.objectives.add(objective);
	}
	
	public void setObjectives(List<IState> objectives) {
		this.objectives = objectives;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public IState getInitState() {
		return initState;
	}

	public void setInitState(IState initState) {
		this.initState = initState;
	}
	
	
	
}
