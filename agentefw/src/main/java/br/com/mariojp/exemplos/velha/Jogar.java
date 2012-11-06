package br.com.mariojp.exemplos.velha;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

public class Jogar extends AbstractAction {

	public List<IState> execute(IState estado) throws ImpossibleActionException {
	       List<IState> suc = new ArrayList<IState>();
        
	       
	       Estado origem = (Estado)estado;
	       int jogador = this.eVezDe(origem.getJogo(),origem.getJogador(),origem.getAdversario());
	       //System.out.println(jogador);
	        // joga em todos os lugares em branco
	        for (int l=0;l<Estado.tamanho;l++) {
	            for (int c=0;c<Estado.tamanho;c++) {
	                if (((Estado)estado).getJogo()[l][c] == 0) {
	                	Estado estadonovo = null;
						estadonovo = (Estado) origem.clone();
	                	estadonovo.getJogo()[l][c] = jogador;
	                	//System.out.println(estadonovo);
	                    suc.add(estadonovo);
	                }
	            }
	        }

	        return suc;
		
	}
	
	private int eVezDe(int[][] jogo, int jogador, int adversario){
		int vez = 0;
		if(contaJogador(jogo,jogador)>=contaJogador(jogo,adversario)){
			vez = adversario;
		}else {
			vez = jogador;
		}
		return vez;
	}
	
	public int contaJogador(int[][] jogo, int jogador) {
		int soma = 0;
		for (int l = 0; l < Estado.tamanho; l++) {
			for (int c = 0; c < Estado.tamanho; c++) {
				if (jogo[l][c] == jogador) {
					soma++;
				}
			}
		}
		return soma;
	}
	
}
