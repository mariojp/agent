package br.com.mariojp.exemplos.aspirador;

import java.util.List;

import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file AgenteAspirador.java
 * @author Mario Jorge Pereira
 * @version 1.1
 *
 * <p>Classe que representa o Agente para o problema do Aspirador</p>
 *
 */
public class AgenteAspirador {


	/**
	 * Metodo main
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		
		
		Estado estadoInicial = new Estado(Estado.SALA_ESQUERDA,
				Estado.SALA_SUJA,Estado.SALA_SUJA); //(a)
		Estado objetivo1 = new Estado(Estado.SALA_ESQUERDA,
				Estado.SALA_LIMPA,Estado.SALA_LIMPA); //(b)
		Estado objetivo2 = new Estado(Estado.SALA_DIREITA,
				Estado.SALA_LIMPA,Estado.SALA_LIMPA);
		//Criando uma instancia da configura��o do agente.
		AgentModel model = new AgentModel();
		//Atribuindo o estado inicial
		model.setInitState(estadoInicial);
		//Adicionando os objetivos
		model.addObjective(objetivo1);
		model.addObjective(objetivo2);
		//Instanciando e adicionando as A��es
		model.addAction("Mover",new Mover());
		model.addAction("Aspirar",new Aspirar());
		//Definindo a estrategia
		model.setType(IAgent.DEPTH_FIRST_SEARCH);
		//Criamos o agente
		IAgent agente = AgentFactory.createAgent(model);
		
		INode nofinal = null;
		try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//nofinal;
		List<INode> cam = agente.getPath(nofinal);
		agente.showGraphic(cam,"aspirador");
		System.out.println(cam);
		System.out.println(agente);
		System.out.println(nofinal);
		System.out.println("-------------");
		
		
		
		
		
		
	}


}