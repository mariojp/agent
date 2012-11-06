package br.com.mariojp.ai.agent.action;

import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

/**
 * Interface de uma ação a ser executada.
 * 
 * As ações devem implementar esta interface. 
 * 
 * @author Mario Jorge Pereira
 *
 */
public interface IAction {

	/**
	 * Metodo que deve ser implementado retonando o estado apos a ação aplicada.
	 * @param estado
	 * @return List - Retorna uma lista contendo de 1 a N Estados possiveis depois da ação aplicada.
	 * @throws ImpossibleActionException
	 */
	public List<IState> execute(IState estado) throws ImpossibleActionException;
	
	
	public List<IState> revert(IState estado) throws ImpossibleActionException;

}