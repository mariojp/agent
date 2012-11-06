package br.com.mariojp.ai.agent.action;

import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

public abstract class AbstractAction implements IAction {

	public List<IState> execute(IState estado) throws ImpossibleActionException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IState> revert(IState estado) throws ImpossibleActionException {
		// TODO Auto-generated method stub
		return null;
	}

}
