package br.com.mariojp.ai.agent.exception;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.exceptions
 * @file EmptyBorderException.java
 * @author Mario Jorge Pereira
 * @version 1.1
 *
 * <p>Class that represents the empty border error .</p>
 *
 */
public class EmptyBorderException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyBorderException() {
		super("Empty Border");
	}

}
