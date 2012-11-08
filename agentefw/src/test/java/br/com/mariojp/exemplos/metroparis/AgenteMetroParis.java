
package br.com.mariojp.exemplos.metroparis;

import java.util.Iterator;
import java.util.List;

import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import br.com.mariojp.exemplos.metroparis.acoes.Baldear;
import br.com.mariojp.exemplos.metroparis.acoes.IrEstacaoOutraEstracao;
import br.com.mariojp.exemplos.metroparis.excecoes.EstacaoNaoEncontradaException;

/**
 * 
 * @project metroParis
 * @package br.com.rodmarc.metroparis
 * @file AgenteMetroparis
 * @author Rodrigo e Marcus Vinicius
 * @version 1.0
 *
 * <p>Classe que representa o Agente para o problema do Metro de paris</p>
 *
 */
public class AgenteMetroParis {
	
	public static void main(String args[]) throws EstacaoNaoEncontradaException{

		AgentModel agent= new AgentModel();
		
		/**
		 * Inicia as ações e adiciona a lista de ações. 
		 */
		agent.addAction("Baldear",new Baldear());
		agent.addAction("Ir de uma estacao a outra",new IrEstacaoOutraEstracao());
		
		/**
		 * Cria estado inicial
		 */
		Estacao estInicial = (Estacao)CentralControle.getInstancia().getEstacao("E14");
		Linha lInicial = (Linha) CentralControle.getInstancia().getLinhas(estInicial).get(0);
		Estado estadoInicial = new Estado(estInicial,lInicial);
		agent.setInitState(estadoInicial);
		
		/**
		 * Cria e adiciona os estados que atendem ao objetivo.
		 */
		Estacao estFinal = (Estacao)CentralControle.getInstancia().getEstacao("E4");
		List linhas =CentralControle.getInstancia().getLinhas(estFinal);
		for (Iterator iter = linhas.iterator(); iter.hasNext();) {
			Linha linha = (Linha) iter.next();
			agent.addObjective(new Estado(estFinal,linha));
		}
		
		agent.setFunctions(new Funcoes());
		agent.setType(IAgent.BREADTH_FIRST_SEARCH);
		
		IAgent agente =  AgentFactory.createAgent(agent);
		
		
				
		INode nofinal = null;
		try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List cam = agente.obterCaminho(nofinal);
		//agente.exibirGrafico(null);
		System.out.println(cam);
		System.out.println(agente);
		System.out.println(nofinal);
	}


}

