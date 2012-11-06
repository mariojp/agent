package br.com.mariojp.ai.agent;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Title: Agentes Inteligentes</p>
 *
 * <p>Description: Classe EstadoGenerico </p>
 *
 * <p>Copyright: Copyright mariojp(c) 2006</p>
 *
 * @author Mario Jorge Pereira 
 * @version 1.1
 */
public class Functions implements IFunctions {

	
	private List<IState> objectives = new ArrayList<IState>();	
	/**
	 * função g(x) representa o calculo do custo do nó.
	 * 
	 * @param o
	 * @return
	 */
	public double g(INode no){
		return 1;
	}

	/**
	 * função h(x) representa o calculo da heuristica do nó.
	 * 
	 * @param o
	 * @return
	 */
	public double h(INode no){
		return 0;
	}
	
	
	public double calculaUtilidade(INode no) {
		return 0;
	}

	public boolean funcaoObjetivo(IState no) {
		return false;
	}

	public void setObjectives(List<IState> objectives) {
		this.objectives = objectives;
	}

	public List<IState> getObjectives() {
		return objectives;
	}


}
