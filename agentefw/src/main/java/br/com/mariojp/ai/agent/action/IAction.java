package br.com.mariojp.ai.agent.action;

import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

/**
 * Interface of an action to be performed.
 * 
 * Actions should implement this interface.
 * 
 * @author Mario Jorge Pereira
 *
 */
public interface IAction {

	/**
	 * Method to be implemented returning the state after the action applied.
	 * @param state
	 * @return List - A list containing from 1 to N possible states after the action applied.
	 * @throws ImpossibleActionException
	 */
	public List<IState> execute(IState state) throws ImpossibleActionException;
	
	
	public List<IState> revert(IState state) throws ImpossibleActionException;

}