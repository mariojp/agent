package br.com.mariojp.exemplos.aspirador;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;

/**
 * 
 * @author m4r10
 * 
 */
public class Mover extends AbstractAction {

	@Override
	public List<IState> execute(IState estado) {
		List<IState> novosestados = new ArrayList<IState>();
		Estado copia = (Estado) ((Estado) estado).clone();
		if (copia.getSalaAtual() == Estado.SALA_ESQUERDA) { // Verifica qual a sala atual
			copia.setSalaAtual(Estado.SALA_DIREITA); // Move para sala direita
		} else {
			copia.setSalaAtual(Estado.SALA_ESQUERDA); // Move para sala esquerda
		}
		novosestados.add(copia);
		return novosestados;
	}

	@Override
	public List<IState> revert(IState estado) {
		List<IState> novosestados = new ArrayList<IState>();
		Estado original = (Estado) estado;
		Estado novoestado = (Estado) original.clone();
		int salaAtual = novoestado.getSalaAtual();
		// Se o aspirador esta na sala esquerda
		if (salaAtual == Estado.SALA_DIREITA) {
			// Move para Direita
			novoestado.setSalaAtual(Estado.SALA_ESQUERDA);
		} else {
			// Move para Direita
			novoestado.setSalaAtual(Estado.SALA_DIREITA);
		}
		novosestados.add(novoestado);
		return novosestados;
	}

}
