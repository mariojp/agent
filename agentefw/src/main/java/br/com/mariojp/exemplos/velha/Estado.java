package br.com.mariojp.exemplos.velha;

import br.com.mariojp.ai.agent.AbstractState;

public class Estado extends AbstractState {

	public static short tamanho = 3;

	public static final int jogador1 = 1; //PC

	public static final int jogador2 = 2; //Pessoa

	private int[][] jogo = new int[tamanho][tamanho];
	
	private int adversario = 0;
	private int jogador = 0;
	
	
	

	public int getJogador() {
		return jogador;
	}



	public void setJogador(int jogador) {
		this.jogador = jogador;
	}



	public int[][] getJogo() {
		return jogo;
	}
	
	

	public void setJogo(int[][] jogo) {
		this.jogo = jogo;
	}

	@Override
	public boolean equals(Object arg0) {
		Estado outro = (Estado) arg0;
		boolean igual = false;
		if (this.getJogo().equals(outro.getJogo())) {
			igual = true;
		}
		return igual;
	}

	private int[][] copiajogo(){
		int[][] novojogo = new int[Estado.tamanho][Estado.tamanho];
		  for (int l=0;l<Estado.tamanho;l++) 
	            for (int c=0;c<Estado.tamanho;c++)
	            	novojogo[l][c]=jogo[l][c];
	            
		return novojogo;
	}
	/**
	 * 
	 * @return Object
	 */
	public Object clone() {
		Object copia = null;
		try {
			copia = super.clone();
			
			((Estado) copia).setJogo(this.copiajogo());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return copia;
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int l = 0; l < tamanho; l++) {
			for (int c = 0; c < tamanho; c++) {
				sb.append(jogo[l][c]);
			}
			sb.append('\n');
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		Estado  e = new Estado();
		int[][] jogo = e.getJogo();
		
		
		Estado  e1 = (Estado) ((Estado) e).clone();
		
		jogo[1][1] = 1;
		
		int[][] jogo2 = e1.getJogo();
		jogo2[2][2] = 1;
		
		e.setJogador(2);
		System.out.println("e"+e);
		System.out.println("e"+e.getJogador());
		System.out.println("e1"+e1);
		System.out.println("e1"+e1.getJogador());
	}



    public boolean livre(int l, int c) {
        return this.jogo[l][c] == 0;
    }

    public void joga(int l, int c, int jogador){
    	this.jogo[l][c] = jogador;
    }



	public int getAdversario() {
		return adversario;
	}



	public void setAdversario(int adversario) {
		this.adversario = adversario;
	}
}
