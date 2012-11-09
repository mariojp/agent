package br.com.mariojp.ai.agent.exception;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.exceptions
 * @file AcaoImpossivelException.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * <p>Class representing the Impossible Action Error</p>
 *
 */
public class ImpossibleActionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImpossibleActionException() {
        super("Action can not be executed!");
    }
	
	public ImpossibleActionException(String actionName) {
        super("Action can not be executed "+actionName+"!");
    }
}
