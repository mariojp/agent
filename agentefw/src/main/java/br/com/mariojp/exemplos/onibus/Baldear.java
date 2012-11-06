package br.com.mariojp.exemplos.onibus;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

public class Baldear extends AbstractAction {

	public List<IState> execute(IState arg0) throws ImpossibleActionException {
		List<IState> estados = new ArrayList<IState>();
		Estado e = (Estado) arg0;
		Route route = e.getLinha();
		BusStop bs = e.getPonto();
		for(Route r : bs.getRoutes()){
			if(!r.equals(route)){
				for(RouteStop rs : r.getRouteStops()){
					if(rs.getBusStop().equals(bs)){
						Estado novoEstado = (Estado) e.clone();
						novoEstado.setLinha(r);
						novoEstado.setPontosNaLinha(rs.getOrdem());
						estados.add(novoEstado);
					}
				}
			}
		}
		if (estados.size() <= 0) {
			throw new ImpossibleActionException("Não gerou estados");
		}
		//System.out.println("Baldear Gerou: "+estados.size());

		return estados;

	}
}
