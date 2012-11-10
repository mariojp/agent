package br.com.mariojp.ai.agent.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.mariojp.ai.agent.IFunctions;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.Node;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import br.com.mariojp.ai.agent.view.Graphic;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.acoes
 * @file ActionCommand.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * 
 *          <p>
 *          Class that manages the actions of Agent
 *          </p>
 */
public class ActionCommand {

	/**
	 * 
	 */
	public ActionCommand(IFunctions order) {
		this.functions = order;
	}
	
	private Map<String, IAction> actions = new HashMap<String, IAction>();

	private ArrayList<IState> statsOpen = new ArrayList<IState>();

	private IFunctions functions = null;

	private boolean stateRepeat = false;

	/**
	 * Apply actions
	 * 
	 * @param node
	 *            - Node that actions should be implemented
	 * @return List - List of resulting nodes
	 */
	public List<INode> executeActions(INode node) {
		ArrayList<INode> links = new ArrayList<INode>();
		statsOpen.add(node.getState());
		for (String name : actions.keySet()) {
			IAction action = actions.get(name);
			List<IState> newStates = new ArrayList<IState>();
			try {
				newStates.addAll(action.execute(node.getState()));
				Iterator<IState> ite = newStates.iterator();
				while (ite.hasNext()) {
					IState newState = ite.next();
					// o nó não pode repetir no par
					if (!(!stateRepeat && node.getParent() != null && node.getParent()
							.getState().equals(newState))) {
						if (!statsOpen.contains(newState)) {
							INode iNode = new Node();
							iNode.setDepth(node.getDepth() + 1);
							iNode.setState(newState);
							iNode.setAction(name);
							iNode.setParent(node);
							iNode.setCost(node.getCost() + (functions.g(iNode)));
							iNode.setHeuristic(functions.h(node));
							links.add(iNode);
						}
					}
				}
			} catch (ImpossibleActionException e) {
				//e.printStackTrace();
			}

		}
		Graphic.getInstancia().addChildrenList(links, node.getDepth() + 1);
		return links;

	}

	/**
	 * Revert actions
	 * 
	 * @param node
	 *            - Node that actions should be implemented
	 * @return List - List of resulting nodes
	 */
	public List<INode> revertActions(INode node) {
		ArrayList<INode> links = new ArrayList<INode>();
		Iterator it = actions.keySet().iterator();
		while (it.hasNext()) {
			String name = (String) it.next();
			IAction action = actions.get(name);
			List<IState> newStates = new ArrayList<IState>();
			try {
				newStates.addAll(action.revert(node.getState()));
				Iterator<IState> ite = newStates.iterator();
				while (ite.hasNext()) {
					IState newState = ite.next();
					if (!(!stateRepeat && node.getParent() != null && node.getParent()
							.getState().equals(newState))) {
						INode iNode = new Node();
						iNode.setDepth(node.getDepth() + 1);
						iNode.setState(newState);
						iNode.setAction(name);
						iNode.setParent(node);
						iNode.setCost(node.getCost() + (functions.g(iNode)));
						iNode.setHeuristic(functions.h(node));
						links.add(iNode);
					}
				}
			} catch (ImpossibleActionException e) {
			}

		}
		return links;

	}

	public void addAction(String name, IAction action) {
		this.actions.put(name, action);
	}

	public void setStateRepeat(boolean repeat) {
		this.stateRepeat = repeat;
	}

}
