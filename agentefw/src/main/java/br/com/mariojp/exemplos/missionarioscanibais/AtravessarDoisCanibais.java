package br.com.mariojp.exemplos.missionarioscanibais;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

public class AtravessarDoisCanibais extends AbstractAction{

	public AtravessarDoisCanibais() {
		super();
	}

	public List<IState> execute(IState estado) throws ImpossibleActionException {
		List<IState> novosestados = new ArrayList<IState>();
		Estado novoestado = (Estado) ((Estado) estado).clone();
		int posbarco = novoestado.getBarcoPosicao();
		int cd = novoestado.getQtdCanibaisDireita();
		int ce = novoestado.getQtdCanibaisEsquerda();
		int md = novoestado.getQtdMissionariosDireita();
		int me = novoestado.getQtdMissionariosEsquerda();
		if (posbarco == Estado.BARCO_ESQUERDA) {
			cd++;
			ce--;
			cd++;
			ce--;
			posbarco = Estado.BARCO_DIREITA;
			if (ce < 0 || me < 0) throw new ImpossibleActionException();
			
		} else {
			cd--;
			ce++;
			cd--;
			ce++;
			posbarco = Estado.BARCO_ESQUERDA;
			if (cd < 0 || md < 0) throw new ImpossibleActionException();
		}
		
		if((md<cd && md!=0)|| (me<ce && me!=0)){
			throw new ImpossibleActionException();
		}
		
		
		novoestado.setQtdCanibaisDireita(cd);
		novoestado.setQtdCanibaisEsquerda(ce);
		novoestado.setQtdMissionariosDireita(md);
		novoestado.setQtdMissionariosEsquerda(me);
		novoestado.setBarcoPosicao(posbarco);
		novosestados.add(novoestado);
		return novosestados;
	}

}
