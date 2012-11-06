package br.com.mariojp.ai.agent.strategies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.Border;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

public class BreadthFirstSearchBiDirect extends Agent  {
	
	protected Border border2 = new Border();

	public BreadthFirstSearchBiDirect(AgentModel iagent) {
		super(iagent);
	}

	@Override
	public INode function() throws EmptyBorderException {
		this.border.add(this.firstNode);
		this.border2.add(this.getGoalNode());
		INode no = null;
		INode no2 = null;
		INode temp = null;
		boolean concluido = false;
		while (!concluido) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				temp = estadoIgual(this.border.getList(),this.border2.getList());
				if (temp!=null) {
					concluido = true;
				} else {
					no = (INode) this.border.remove(0);
					no2 = this.border2.remove(0);
					List<INode> list = this.actionCommand.executeActions(no);
					border.addAll(list);
					List<INode> list2 = this.actionCommand.revertActions(no2);
					border2.addAll(list2);
				}
			}

		}
		INode temp2 = this.noIgual(this.border2.getList(),temp);
		List<INode> lista = new ArrayList<INode>();
		do{
			temp2 = temp2.getPai();
			lista.add(temp2);
		}while(temp2.getPai()!=null);
		
		for(int i = 0; i <lista.size();i++){
			temp2 = lista.get(i);
			temp2.setPai(temp);
			temp2.setDepth(temp.getDepth()+1);
			temp = temp2;
			
		}
		this.end = new Date();
		return no;
	}
	
	private INode noIgual(List<INode> l,INode n){
		for(int j = 0;j < l.size();j++){
			INode node =l.get(j);
			if(node.getState().equals(n.getState())){
				return node;
			}
		}
		return null;
	}
	
	private INode estadoIgual(List<INode> l1,List<INode> l2){
		for(int i = 0;i<l1.size();i++){
			INode node1 =  l1.get(i);
			for(int j = 0;j < l2.size();j++){
				INode node2 =l2.get(j);
				if(node1.getState().equals(node2.getState())){
					return node1;
				}
				
			}
		}
		return null;
		
	}

}
