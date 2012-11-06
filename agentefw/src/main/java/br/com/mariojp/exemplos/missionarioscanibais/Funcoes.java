package br.com.mariojp.exemplos.missionarioscanibais;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;

public class Funcoes extends Functions {

	public Funcoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double h(INode no) {
		//Obtendo o estado
		Estado e = (Estado)no.getState();
		//Função Heuristica
		return e.getQtdCanibaisEsquerda() + e.getQtdMissionariosEsquerda();
	}

}
