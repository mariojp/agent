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
import br.com.mariojp.ai.agent.view.Grafico;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.acoes
 * @file ActiooesCommand.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * 
 *          <p>
 *          Classe que gerencia as A��es do Agente
 *          </p>
 */
public class ActionCommand {

	/**
	 * 
	 */
	public ActionCommand(IFunctions order) {
		this.functions = order;
	}

	/**
	 * Map das que guarda a instacia das a��es.
	 */
	private Map<String, IAction> actions = new HashMap<String, IAction>();

	private ArrayList<IState> statsOpen = new ArrayList<IState>();

	private IFunctions functions = null;

	private boolean stateRepeat = false;

	/**
	 * Metodo que aplica as a��es e retorna uma Lista de Nos resultantes das
	 * a��es.
	 * 
	 * @param no
	 *            - No que as a��es devem ser aplicadas
	 * @return List - Lista de Nos
	 */
	public List<INode> executeActions(INode no) {
		ArrayList<INode> links = new ArrayList<INode>();
		statsOpen.add(no.getState());
		for (String nome : actions.keySet()) {
			IAction acao = actions.get(nome);
			List<IState> estadosnovos = new ArrayList<IState>();
			try {
				estadosnovos.addAll(acao.execute(no.getState()));
				Iterator<IState> ite = estadosnovos.iterator();
				while (ite.hasNext()) {
					IState estadoNovo = ite.next();
					// o nó não pode repetir no par
					if (!(!stateRepeat && no.getPai() != null && no.getPai()
							.getState().equals(estadoNovo))) {
						if (!statsOpen.contains(estadoNovo)) {
							INode novo = new Node();
							novo.setDepth(no.getDepth() + 1);
							novo.setState(estadoNovo);
							novo.setAction(nome);
							novo.setPai(no);
							novo.setCost(no.getCost() + (functions.g(novo)));
							novo.setHeuristica(functions.h(no));
							links.add(novo);
						}
					}
				}
			} catch (ImpossibleActionException e) {
				//e.printStackTrace();
			}

		}
		Grafico.getInstancia().addListFilhos(links, no.getDepth() + 1);
		return links;

	}

	/**
	 * Metodo que aplica as a��es e retorna uma Lista de Nos resultantes das
	 * a��es.
	 * 
	 * @param no
	 *            - No que as a��es devem ser aplicadas
	 * @return List - Lista de Nos
	 */
	public List<INode> revertActions(INode no) {
		ArrayList<INode> links = new ArrayList<INode>();
		Iterator it = actions.keySet().iterator();
		while (it.hasNext()) {
			String nome = (String) it.next();
			IAction acao = actions.get(nome);
			List<IState> estadosnovos = new ArrayList<IState>();
			try {
				estadosnovos.addAll(acao.revert(no.getState()));
				Iterator<IState> ite = estadosnovos.iterator();
				while (ite.hasNext()) {
					IState estadoNovo = ite.next();
					if (!(!stateRepeat && no.getPai() != null && no.getPai()
							.getState().equals(estadoNovo))) {
						INode novo = new Node();
						novo.setDepth(no.getDepth() + 1);
						novo.setState(estadoNovo);
						novo.setAction(nome);
						novo.setPai(no);
						novo.setCost(no.getCost() + (functions.g(novo)));
						novo.setHeuristica(functions.h(no));
						links.add(novo);
					}
				}
			} catch (ImpossibleActionException e) {
			}

		}
		return links;

	}

	/**
	 * Adiciona a��es a lista de a��es.
	 * 
	 * @param nome
	 *            - Nome que identifica a a��o.
	 * @param acao
	 *            - instancia de uma a��o.
	 */
	public void addAction(String name, IAction action) {
		this.actions.put(name, action);
	}

	public void setStateRepeat(boolean repetir) {
		this.stateRepeat = repetir;
	}

}
