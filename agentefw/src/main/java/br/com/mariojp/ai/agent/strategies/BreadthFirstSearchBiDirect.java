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
		INode node = null;
		INode node2 = null;
		INode nodeTemp = null;
		boolean completed = false;
		while (!completed) {
			if (this.border.isEmpty()) {
				throw new EmptyBorderException();
			} else {
				nodeTemp = equalState(this.border.getList(),this.border2.getList());
				if (nodeTemp!=null) {
					completed = true;
				} else {
					node = (INode) this.border.remove(0);
					node2 = this.border2.remove(0);
					List<INode> list = this.actionCommand.executeActions(node);
					border.addAll(list);
					List<INode> list2 = this.actionCommand.revertActions(node2);
					border2.addAll(list2);
				}
			}

		}
		INode nodeTemp2 = this.equalNode(this.border2.getList(),nodeTemp);
		List<INode> list = new ArrayList<INode>();
		do{
			nodeTemp2 = nodeTemp2.getParent();
			list.add(nodeTemp2);
		}while(nodeTemp2.getParent()!=null);
		
		for(int i = 0; i <list.size();i++){
			nodeTemp2 = list.get(i);
			nodeTemp2.setParent(nodeTemp);
			nodeTemp2.setDepth(nodeTemp.getDepth()+1);
			nodeTemp = nodeTemp2;
			
		}
		this.end = new Date();
		return node;
	}
	
	private INode equalNode(List<INode> l,INode n){
		for(int j = 0;j < l.size();j++){
			INode node =l.get(j);
			if(node.getState().equals(n.getState())){
				return node;
			}
		}
		return null;
	}
	
	private INode equalState(List<INode> l1,List<INode> l2){
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
