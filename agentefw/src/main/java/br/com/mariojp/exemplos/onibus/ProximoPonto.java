package br.com.mariojp.exemplos.onibus;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

public class ProximoPonto extends AbstractAction {

	public List<IState> execute(IState arg0) throws ImpossibleActionException {
		List<IState> estados = new ArrayList<IState>();
		Estado e = (Estado) arg0;
		Route linha = e.getLinha();

		if (linha != null) {
			RouteStop lp = linha.proximoPonto(e.getPontosNaLinha());
			if (lp != null) {
				Estado novoEstado = (Estado) e.clone();
				novoEstado.setPonto(lp.getBusStop());
				novoEstado.setPontosNaLinha(lp.getOrdem());
				estados.add(novoEstado);
			}
		}
		
		if (estados.size() <= 0) {
			throw new ImpossibleActionException("Não gerou estados");
		}
		//System.out.println("Proximo Ponto gerou: "+estados.size());
		return estados;

	}
}
