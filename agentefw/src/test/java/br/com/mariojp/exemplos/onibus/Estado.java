/*
 * Created on 29/03/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.mariojp.exemplos.onibus;

import java.util.Date;

import br.com.mariojp.ai.agent.AbstractState;

public class Estado extends AbstractState {

	private BusStop ponto;
	private Route linha;
	private Date horario;
	private Integer posicaoNaLinha = null;


	/**
	 * Metodo necessario para criar copias do Estado. Caso o estado tenha
	 * somente tipos primitivos, apenas copie este metodo.
	 * 
	 * @return Object
	 */
	public Object clone() {
		Estado copia = new Estado();
		copia.setPonto(this.getPonto());
		copia.setLinha(this.getLinha());
		copia.setPontosNaLinha(this.getPontosNaLinha());
		return copia;
	}

	/**
	 * Verifica se os estados s�o iguais
	 */
	public boolean equals(Object arg0) {
		boolean iguais = false;
		Estado outro = (Estado) arg0;
		if (this.getLinha() != null){
			iguais =  (this.getLinha().equals(outro.getLinha())
					&& this.getPonto().equals(outro.getPonto()));
		}else if(outro.getLinha() == null && this.getLinha() == null ){
			iguais = (this.getPonto().equals(outro.getPonto()));
		}
		
		
		return iguais;
	}

	/**
	 * @return Returns the linha.
	 */
	public Route getLinha() {
		return linha;
	}

	/**
	 * @param linha
	 *            The linha to set.
	 */
	public void setLinha(Route linha) {
		this.linha = linha;
	}

	public BusStop getPonto() {
		return ponto;
	}

	public void setPonto(BusStop ponto) {
		this.ponto = ponto;
	}

	public Integer getPontosNaLinha() {
		return posicaoNaLinha;
	}

	public void setPontosNaLinha(Integer pontosNaLinha) {
		this.posicaoNaLinha = pontosNaLinha;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Linha: ");
		sb.append(this.getLinha());
		sb.append("\n Ponto: ");
		sb.append(this.getPonto());
		return sb.toString();
	}

	



}
