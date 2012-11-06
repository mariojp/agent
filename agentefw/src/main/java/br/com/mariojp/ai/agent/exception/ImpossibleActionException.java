package br.com.mariojp.ai.agent.exception;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.ia.agente.busca.exceptions
 * @file AcaoImpossivelException.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * <p>Classe que representa o erro de Ação Impossivel</p>
 *
 */
public class ImpossibleActionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImpossibleActionException() {
        super("Acao nao pode ser executada!");
    }
	
	public ImpossibleActionException(String nomeacao) {
        super("Acao nao pode ser executada "+nomeacao+"!");
    }
}
