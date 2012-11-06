/*
 * Created on 29/03/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.mariojp.exemplos.metroparis;

import br.com.mariojp.ai.agent.AbstractState;


/**
 * @author Marcus Vincius e Rodrigo
 *
 */
public class Estado extends AbstractState {
	
	private Estacao estacao;
	private Linha linha;	
	
	public Estado(){}
	
	public Estado(Estacao _estacao,Linha _linha){
		this.estacao = _estacao;
		this.linha   = _linha ;
	}
	/**
	 * Metodo necessario para criar copias do Estado.
	 * Caso o estado tenha somente tipos primitivos, apenas copie este metodo. 
	 * @return Object
	 */
	public Object clone() { 	
		Estado copia = new Estado();	   	
		copia.setEstacao(this.getEstacao());
		copia.setLinha(this.getLinha());
		return copia;
	}
	
	/**
	 * Verifica se os estados são iguais
	 */
	public boolean equals(Object arg0) {
		Estado outro = (Estado) arg0;
		if(this.getLinha().getId() == outro.getLinha().getId() &&
				this.getEstacao().getDesc().equals(outro.getEstacao().getDesc()))
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * @return Returns the estacao.
	 */
	public Estacao getEstacao() {
		return estacao;
	}
	
	/**
	 * @param estacao The estacao to set.
	 */
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	
	/**
	 * @return Returns the linha.
	 */
	public Linha getLinha() {
		return linha;
	}
	
	/**
	 * @param linha The linha to set.
	 */
	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Linha: ");
		sb.append(this.getLinha().getDescricao());
		sb.append("  ");
		sb.append("Estacao: ");
		sb.append(this.getEstacao().getDesc());			
		return sb.toString();
	}
	
	
}
