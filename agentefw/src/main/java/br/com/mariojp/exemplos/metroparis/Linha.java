/*
 * Created on 29/03/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.mariojp.exemplos.metroparis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author Alunois
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Linha {
	private int id;
	private String descricao;
	private List estacoes = new ArrayList();
	
	public Linha(int id,String desc){
		this.id 	   = id;
		this.descricao = desc;
	}
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Returns the descricao.
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao The descricao to set.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}		
	/**
	 * @return Returns the estacoes.
	 */
	public List getEstacoes() {
		return estacoes;
	}
	/**
	 * @param estacoes The estacoes to set.
	 */
	public void setEstacoes(List estacoes) {
		this.estacoes = estacoes;
	}
	
	@SuppressWarnings("unchecked")
	public void adicionaEstacao(Estacao e){
		estacoes.add(e);		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Linha: "+this.getDescricao());
		return sb.toString();
	}
	/**
	 * @param e
	 * @return
	 */
	public boolean passaNaEstacao(Estacao e) {
		for (Iterator iter = estacoes.iterator(); iter.hasNext();) {			
			Estacao estacao = (Estacao) iter.next();
			//Log.addLog(estacao.toString());
			if (estacao.equals(e))
				return true;
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public List estacoesAdjacentes(Estacao e){
		List estacoesAdjacentes = new ArrayList();
		for (int i=0;i<estacoes.size();i++) {
			Estacao estacao = (Estacao) estacoes.get(i);			
			if (estacao.equals(e)){				
				//if (i<(estacoes.size()-1))
				try{
					estacoesAdjacentes.add((Estacao) estacoes.get(i+1));
				}
				catch(Exception e1){}
				
				//if (i>1 && estacoes.size()>0)
				
				try{
					estacoesAdjacentes.add((Estacao) estacoes.get(i-1));
				}
				catch(Exception e2){}
			}
		}		
		return estacoesAdjacentes;				
	}
	
	
	
	
	
}
