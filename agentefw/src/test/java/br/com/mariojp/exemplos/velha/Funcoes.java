package br.com.mariojp.exemplos.velha;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;

public class Funcoes extends Functions {

	public double calculateUtility(INode node) {
		Estado estado = (Estado) node.getState();
		int val = 0;
		if (ganha(estado.getJogo(), estado.getJogador())) {
			val = 1;
		} else if (ganha(estado.getJogo(), estado.getAdversario())) {
			val = -1;
		}
		return val;

	}

	public boolean objectiveFunction(IState estado) {
		return (ganha(((Estado) estado).getJogo(), ((Estado) estado)
				.getJogador())
				|| ganha(((Estado) estado).getJogo(), ((Estado) estado)
						.getAdversario()) || (contaBrancos(((Estado) estado)
				.getJogo()) == 0));
	}

	private boolean ganha(int[][] jogo, int jogador) {
		for (int i = 0; i < Estado.tamanho; i++) {
			if (colunaIgualA(i, jogador, jogo) || linhaIgualA(i, jogador, jogo)) {
				return true;
			}
		}
		if (diagonalPrincialIgualA(jogador, jogo)
				|| diagonalSecundariaIgualA(jogador, jogo)) {
			return true;
		}
		return false;
	}

	private boolean linhaIgualA(int l, int jogador, int[][] jogo) {
		for (int c = 0; c < Estado.tamanho; c++) {
			if (jogo[l][c] != jogador) {
				return false;
			}
		}
		return true;
	}

	private boolean colunaIgualA(int c, int jogador, int[][] jogo) {
		for (int l = 0; l < Estado.tamanho; l++) {
			if (jogo[l][c] != jogador) {
				return false;
			}
		}
		return true;
	}

	private boolean diagonalPrincialIgualA(int jogador, int[][] jogo) {
		for (int i = 0; i < Estado.tamanho; i++) {
			if (jogo[i][i] != jogador) {
				return false;
			}
		}
		return true;
	}

	private boolean diagonalSecundariaIgualA(int jogador, int[][] jogo) {
		for (int i = 0; i < Estado.tamanho; i++) {
			int l = Estado.tamanho - i - 1;
			if (jogo[l][i] != jogador) {
				return false;
			}
		}
		return true;
	}

	public int contaBrancos(int[][] jogo) {
		int soma = 0;
		for (int l = 0; l < Estado.tamanho; l++) {
			for (int c = 0; c < Estado.tamanho; c++) {
				if (jogo[l][c] == 0) {
					soma++;
				}
			}
		}
		return soma;
	}
}
