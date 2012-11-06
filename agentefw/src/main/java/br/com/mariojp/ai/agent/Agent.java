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
import br.com.mariojp.ai.agent.view.Grafico;

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
	
	protected Grafico grafico = Grafico.getInstancia();

	public Agent(AgentModel agent) {
		this.functions = agent.getFunctions();
		this.actionCommand = new ActionCommand(functions);
		this.addActions(agent.getActions());
		this.objectives = agent.getObjectives();
		this.functions.setObjectives(this.objectives);
		this.setFirstNo(agent.getInitState());
		this.grafico.adicionaNodePai(this.firstNode);
		this.iteractiveDepth = agent.getIteractiveDepth();
	}

	public void setFirstNo(IState state) {
		this.firstNode = new Node();
		this.firstNode.setAction("Init State");
		this.firstNode.setState(state);
		this.firstNode.setDepth(0);
		this.firstNode.setPai(null);
	}
	
	public INode getGoalNode(){
		INode node = new Node();
		node.setPai(null);
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

	protected boolean isObjetivo(INode no) {
		boolean fim = functions.funcaoObjetivo(no.getState());
		for (IState objective :  objectives)
			if (no.getState().equals(objective))
				fim = true;
		return fim;
	}
	
	protected boolean isStart(INode node){
		return this.firstNode.getState().equals(node.getState());
	}
	

	/**
	 * Funcao de Busca
	 */
	public abstract INode function() throws EmptyBorderException;

	/**
	 * Organiza a lista de a��es da solu��o.
	 */
	public List<INode> obterCaminho(INode no) {
		List<INode> caminho = new ArrayList<INode>();
		while (no != null) {
			caminho.add(0, no);
			no = no.getPai();
		}
		return caminho;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		sb.append("Hora inicio: " + sdf.format(this.start) + "\n");
		sb.append("Hora Fim   : " + sdf.format(this.end) + "\n");
		sb.append("Tempo      : " + (this.end.getTime() - this.start.getTime())
				+ "milisegundos \n");
		sb.append("Total de Nós Expandidos : "+ this.border.getNodes() +"\n");
		sb.append("Total de Nós Visitados : "+ this.border.getVisitas() +"\n");
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
	
	public void exibirGrafico(List<INode> list, String nome){
		this.grafico.exibeArvore(list, nome);
	}
	
	

}
