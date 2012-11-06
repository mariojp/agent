package br.com.mariojp.exemplos.missionarioscanibais;

import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
/**
 *
 * <p>Title: Agentes Inteligentes</p>
 *
 * <p>Description: Agente de Busca usando o algoritimo A* para resolver o problema dos canibais e missionarios. </p>
 *
 * <p>Copyright: Copyright Ability(c) 2005</p>
 *
 * <p>Company: Mario e Fabio</p>
 *
 * @author Mario Jorge e Fabio Barreto
 * @version 1.0
 */
public class AgenteMissionarios {


	public static void main(String[] args) {
		AgentModel ab = new AgentModel();
		
		
		ab.addAction("Atravessar 2 canibais",new AtravessarDoisCanibais());
		ab.addAction("Atravessar 2 missionarios",new AtravessarDoisMissionarios());
		ab.addAction("Atravessar 1 canibal",new AtravessarUmCanibal());
		ab.addAction("Atravessar 1 missionario",new AtravessarUmMissionario());
		ab.addAction("Atravessar 1 missionario e 1 canibal",new AtravessarUmMissionarioUmCanibal());
		
		
		/**
		* Cria o estado inicial
		* Com a posição do barco e o numero de
		* canibais e missionarios nas margens.
		*/
		Estado inicial = new Estado();
		inicial.setBarcoPosicao(Estado.BARCO_ESQUERDA);
		inicial.setQtdCanibaisEsquerda(3);
		inicial.setQtdMissionariosEsquerda(3);
		ab.setInitState(inicial);
		
		
		Estado objetivo = new Estado();
		objetivo.setQtdCanibaisDireita(3);
		objetivo.setQtdMissionariosDireita(3);
		objetivo.setBarcoPosicao(Estado.BARCO_DIREITA);
		
		ab.addObjective(objetivo);
		
		ab.setFunctions(new Funcoes());
		
		ab.setType(IAgent.BREADTH_FIRST_SEARCH);
		
		IAgent agente = AgentFactory.createAgent(ab);
		
		
		INode nofinal = null;
		try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List cam = agente.obterCaminho(nofinal);
		//agente.exibirGrafico(null);
		System.out.println(agente);
		System.out.println(nofinal);
		System.out.println(agente);
		System.out.println(nofinal);
		
	}
	
	







}
