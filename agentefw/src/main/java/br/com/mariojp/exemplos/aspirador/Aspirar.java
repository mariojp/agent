package br.com.mariojp.exemplos.aspirador;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file Aspirar.java
 * @author Mario Jorge Pereira
 * @version 1.1
 *
 * <p>Classe que representa a Ação de Aspirar para o problema do Aspirador</p>
 *
 */
public class Aspirar extends AbstractAction {

	/**
	 * Metodo que descreve a ação de aspirar para o problema do Aspirador.
	 */
	public List<IState> execute(IState estado) throws ImpossibleActionException {
		List<IState> novosestados = new ArrayList<IState>();
		Estado original = (Estado) estado;
		Estado novoestado = (Estado) original.clone();
		int salaAtual = novoestado.getSalaAtual();
		int salaDireita = novoestado.getSalaDireita();
		int salaEsquerda = novoestado.getSalaEsquerda();
		//Se o aspirador esta na sala direita e ela esta suja ele aspira.
		if (salaAtual == Estado.SALA_DIREITA && salaDireita == Estado.SALA_SUJA){
			novoestado.setSalaDireita(Estado.SALA_LIMPA);
			//Se o aspirador esta na sala esquerda e ela esta suja ele aspira.
		}else if(salaAtual == Estado.SALA_ESQUERDA && salaEsquerda == Estado.SALA_SUJA){
			novoestado.setSalaEsquerda(Estado.SALA_LIMPA);
		}else{
			//Caso o aspirador não esta em uma sala suja ele não deve aspirar.
			//Esta ação não pode ser executada.
			throw new ImpossibleActionException("Aspirar");
		}
		novosestados.add(novoestado);
		return novosestados;
	}
	
	@Override
	public List<IState> revert(IState estado) throws ImpossibleActionException {
		List<IState> novosestados = new ArrayList<IState>();
		Estado original = (Estado) estado;
		Estado novoestado = (Estado) original.clone();
		int salaAtual = novoestado.getSalaAtual();
		int salaDireita = novoestado.getSalaDireita();
		int salaEsquerda = novoestado.getSalaEsquerda();
		//Se o aspirador esta na sala direita e ela esta limpa ele suja.
		if (salaAtual == Estado.SALA_DIREITA && salaDireita == Estado.SALA_LIMPA){
			novoestado.setSalaDireita(Estado.SALA_SUJA);
			//Se o aspirador esta na sala esquerda e ela esta limpa ele suja.
		}else if(salaAtual == Estado.SALA_ESQUERDA && salaEsquerda == Estado.SALA_LIMPA){
			novoestado.setSalaEsquerda(Estado.SALA_SUJA);
		}else{
			//Caso o aspirador esta em uma sala suja ele não deve sujar.
			//Esta ação não pode ser executada.
			throw new ImpossibleActionException("Aspirar");
		}
		novosestados.add(novoestado);
		return novosestados;
	}


}
