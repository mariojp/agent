package br.com.mariojp.exemplos.aspirador;

import br.com.mariojp.ai.agent.AbstractState;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file Estado.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * <p>Classe que representa a o Ambiente para o problema do Aspirador</p>
 *
 */
public class Estado extends AbstractState {

	/**
	 * Constantes 
	 */
	public static final int SALA_LIMPA = 0;
	public static final int SALA_SUJA = 1;
	public static final int SALA_DIREITA = 0;
	public static final int SALA_ESQUERDA = 1;
	
	private int salaAtual;
	private int salaDireita;
	private int salaEsquerda;
	
	 public Estado(){
	 }
	 
	 public Estado(int salaAtual,int salaDireita, int salaEsquerda){
		 this.salaAtual = salaAtual;
		 this.salaDireita = salaDireita;
		 this.salaEsquerda = salaEsquerda;
	 }
	
    /**
    * Metodo necessario para criar copias do Estado.
    * Caso o estado tenha somente tipos primitivos, apenas copie este metodo. 
    * @return Object
    */
   public Object clone() {
       Object copia = null;
       try {
			copia = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
       return copia;
   }
	
	/**
	 * Verifica se os estados são iguais
	 */
	public boolean equals(Object arg0) {
        Estado outro = (Estado) arg0;
        boolean igual = false;
        if(this.getSalaDireita() == outro.getSalaDireita() &&
        	this.getSalaEsquerda() == outro.getSalaEsquerda() &&
        	this.getSalaAtual() == outro.getSalaAtual()) {
            igual = true;
        }
        return igual;
	}

	/**
	 * Obtem a sala atual do aspirador (DIREITA ou ESQUERDA). 
	 * @return int - Sala Atual
	 */
	public int getSalaAtual() {
		return salaAtual;
	}

	/**
	 * Atribui a sala atual do aspirador (DIREITA ou ESQUERDA). 
	 * @param salaAtual
	 */
	public void setSalaAtual(int salaAtual) {
		this.salaAtual = salaAtual;
	}

	/**
	 * Obtem o estado da sala direita (SUJA ou LIMPA)
	 * @return int - Estado da Sala
	 */
	public int getSalaDireita() {
		return salaDireita;
	}

	/**
	 * Atribui o estado da sala direita (SUJA ou LIMPA) 
	 * @param salaDireita
	 */
	public void setSalaDireita(int salaDireita) {
		this.salaDireita = salaDireita;
	}

	/**
	 * Obtem o estado da sala esquerda (SUJA ou LIMPA)
	 * @return int - Estado da Sala
	 */
	public int getSalaEsquerda() {
		return salaEsquerda;
	}

	/**
	 * Atribui o estado da sala esquerda (SUJA ou LIMPA) 
	 * @param salaEsquerda
	 */
	public void setSalaEsquerda(int salaEsquerda) {
		this.salaEsquerda = salaEsquerda;
	}
	

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Sala Direita: ");
		sb.append((this.getSalaDireita()==Estado.SALA_LIMPA)?"SALA LIMPA":"SALA SUJA");
		sb.append("\n");
		sb.append("Sala Esquerda: ");
		sb.append((this.getSalaEsquerda()==Estado.SALA_LIMPA)?"SALA LIMPA":"SALA SUJA");
		sb.append("\n");
		sb.append("Aspirador: ");
		sb.append((this.getSalaAtual()==Estado.SALA_DIREITA)?"SALA DIREITA":"SALA ESQUERDA");
		sb.append('\n');
		return sb.toString();
	}

}
