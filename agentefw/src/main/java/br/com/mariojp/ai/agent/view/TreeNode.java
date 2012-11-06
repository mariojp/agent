package br.com.mariojp.ai.agent.view;

public class TreeNode {
	
	private int numero;
	
	int pai;
	
	private String label;

	private boolean solution;


	/**
	 * @param numero
	 * @param pai
	 * @param label
	 * @param solution
	 */
	public TreeNode(int numero, int pai, String label, boolean solution) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		this.label = label;
		this.pai = pai;
		this.solution = solution;
	}

	public TreeNode(){
	}
	
	public boolean getSolution() {
		return solution;
	}
	
	public boolean isSolution() {
		return solution;
	}

	public void setSolution(boolean solution) {
		this.solution = solution;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPai() {
		return pai;
	}

	public void setPai(int pai) {
		this.pai = pai;
	}

	
}
