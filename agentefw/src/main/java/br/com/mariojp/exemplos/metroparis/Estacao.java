package br.com.mariojp.exemplos.metroparis;



/**
* 
* @project AgenteFW
* @package br.com.rodmarc.metroparis
* @file Estacao.java
* @author Rodrigo e Marcus Vinicius
* @version 1.0
* <p>Classe que representa  o Estado para o problema do metrô de paris</p>
*
*/
public class Estacao {
	
	
	/**
	 * Descrição da Estação
	 */	
	private String desc;
	
	
	public Estacao(){
		
	}
	
	public Estacao(String _desc){	
		this.desc = _desc;
	}
	

	/**
	 * @return Retorna a descricao.
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc - Seta a descricao.
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Compara duas Estacoes
	 */
	public boolean equals(Object arg0) {
		Estacao outraEstacao = (Estacao)arg0;
		if (this.getDesc().equals(outraEstacao.getDesc()))
			return true;
		return false;
	}

	/**
	 * Retorna a string do objeto
	 */
	public String toString() {
		StringBuffer toString = new StringBuffer();
		toString.append(" Estacao"+getDesc()+"\n");
		return toString.toString();
	}

	
}
