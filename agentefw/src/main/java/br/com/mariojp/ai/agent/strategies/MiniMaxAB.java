 package br.com.mariojp.ai.agent.strategies;
import java.util.Date;
import java.util.Iterator;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;


public class MiniMaxAB extends Agent{
    
    public MiniMaxAB(AgentModel agente) {
    	super(agente);
    }
    
   
    /**
     *
     * MiniMax, returns the maximum utility of a state
     *
     * alpha: the best utility of a state for MAX 
     * beta: the best utility of a state for MAX 
     */
    public double max(INode currentNode, double alpha, double beta, int p) {
        
        if (this.getFunctions().objectiveFunction(currentNode.getState())) {
            return this.functions.calculateUtility(currentNode);
        }
        
        Iterator i = this.actionCommand.executeActions(currentNode).iterator();
        while (i.hasNext()) {
             
            INode successor = (INode)i.next();
            double vlSuccessor = min( successor, alpha, beta, p+1);
            
            if (vlSuccessor > alpha) {
                alpha = vlSuccessor;
                
                // cuts alpha
                if (alpha >= beta) {
                    return beta;
                }
                
                currentNode.setUtility( alpha );
                currentNode.setNext( successor );
            }
        }
        
        return alpha;
    }
    
    /**
     *
     * MiniMax, returns the minimum utility of a state
     *
     */
    public double min(INode currentNode, double alpha, double beta, int p) {
        
        if (this.functions.objectiveFunction(currentNode.getState())) {
            return this.functions.calculateUtility(currentNode);
        }
        
        Iterator i = this.actionCommand.executeActions(currentNode).iterator();
        while (i.hasNext()) {
            INode successor = (INode)i.next();
            double vlSuccessor = max( successor, alpha, beta, p+1);
            
            if (vlSuccessor < beta) {
                beta = vlSuccessor;
                
                if (beta <= alpha) {
                    return alpha;
                }
                
                currentNode.setUtility( beta );
                currentNode.setNext( successor );
                
            }
        }
        return beta;
    }

	@Override
	public INode function() throws EmptyBorderException {
		INode no = (INode) this.border.remove(0);
		max(no,-10000,10000,1);
		this.end = new Date();
		return no.getNext();
	}
    
    
}
