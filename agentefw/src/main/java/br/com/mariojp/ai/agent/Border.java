package br.com.mariojp.ai.agent;

import java.util.ArrayList;
import java.util.List;

public class Border {

	private int nodes = 0;
	
	private int visitas = 0;
	
	private List<INode> border = new ArrayList<INode>();

	public void add(INode firstNode) {
		setNodes(getNodes() + 1);
		this.border.add(firstNode);
	}

	public boolean isEmpty() {
		return this.border.isEmpty();
	}

	public INode remove(int i) {
		setVisitas(getVisitas() + 1);
		return this.border.remove(i);
	}

	public boolean containsState(INode node) {
		boolean contain = false;
		for(INode no : this.border){
			if(no.getState().equals(node.getState())){
				contain = true;
			}
		}
		return contain;
	}

	public int size() {
		return this.border.size();
	}

	public void addAll(List<INode> list) {
		setNodes(getNodes() +list.size());
		this.border.addAll(list);
	}

	public List<INode> getList() {
		return this.border;
	}

	public void addAll(int i, List<INode> list) {
		setNodes(getNodes() +list.size());
		this.border.addAll(i, list);
	}

	public int getNodes() {
		return nodes;
	}

	public void setNodes(int nodes) {
		this.nodes = nodes;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	


}
