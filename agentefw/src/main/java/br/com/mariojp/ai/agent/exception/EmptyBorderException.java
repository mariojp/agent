package br.com.mariojp.ai.agent.exception;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.exceptions
 * @file FronteiraVaziaException.java
 * @author Mario Jorge Pereira
 * @version 1.1
 *
 * <p>Classe que representa o erro de fronteira vazia.</p>
 *
 */
public class EmptyBorderException extends Exception {


	private static final long serialVersionUID = 1L;

	public EmptyBorderException() {
		super("Emapty Border");
	}

}
