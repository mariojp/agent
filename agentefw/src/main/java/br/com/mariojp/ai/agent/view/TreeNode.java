package br.com.mariojp.ai.agent.view;

import jakarta.xml.bind.annotation.XmlRootElement;

public class TreeNode {
	
	private int number;
	
	int parent;
	
	private String label;

	private boolean solution;


	/**
	 * @param number
	 * @param parent
	 * @param label
	 * @param solution
	 */
	public TreeNode(int number, int parent, String label, boolean solution) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.label = label;
		this.parent = parent;
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

	
	public int getNumber() {
		return number;
	}

	
	public void setNumber(int number) {
		this.number = number;
	}

	
	public int getParent() {
		return parent;
	}

	
	public void setParent(int parent) {
		this.parent = parent;
	}
	
}
