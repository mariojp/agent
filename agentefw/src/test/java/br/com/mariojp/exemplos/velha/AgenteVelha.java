package br.com.mariojp.exemplos.velha;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class AgenteVelha {

	public static void main(String[] args) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		AgentModel a = new AgentModel();
		a.addAction("Jogar", new Jogar());
		Estado inicial = new Estado();
		inicial.setJogador(Estado.jogador1); // PC 
		inicial.setAdversario(Estado.jogador2);// HUMANO
		a.setInitState(inicial);
		Funcoes funcoes = new Funcoes();
		a.setFunctions(funcoes);
		a.setType(IAgent.MINIMAX);
		IAgent agenteA = AgentFactory.createAgent(a);

		int vez = inicial.getAdversario();
		INode nofinalA = null;
		while (!funcoes.objectiveFunction(a.getInitState())) {
			System.out.println(a.getInitState());
			if (inicial.getAdversario() == vez) {
				vez = inicial.getJogador();
				boolean ok = false;
				while (!ok) {
					// vez do usu�rio jogar
					try {
						System.out.println("\nqual sua jogada?");
						System.out.print("linha (1, 2 ou 3):");
						byte l = (byte) (Integer.parseInt(teclado.readLine()) - 1);
						System.out.print("coluna (1, 2 ou 3):");
						byte c = (byte) (Byte.parseByte(teclado.readLine()) - 1);
						if (inicial.livre(l, c)) {
							inicial.joga(l,c,inicial.getAdversario());
							a.setInitState(inicial);
							ok = true;
						} else {
							System.out.println("Posi��o j� ocupada.");
						}

					} catch (Exception e) {
						System.out.println("Digite n�meros entre 1 e 3");
					}
				}
			} else {
				vez = inicial.getAdversario();
				// vez do computador

				agenteA = AgentFactory.createAgent(a);
				try {
					nofinalA = agenteA.function();
					Estado estado  = (Estado)nofinalA.getState();
					inicial.setJogo(estado.getJogo());
					a.setInitState(inicial);
				} catch (EmptyBorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		System.out.println(a.getInitState());
		System.out.println("\n Fim do jogo!");
	}
}
