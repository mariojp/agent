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
     * MiniMax, retorna a utilidade máxima de um estado
     *
     * alpha: a melhor utilidade até o momento para MAX
     * beta: a melhor utilidade até o momento para MIN
     */
    public double max(INode noCorrente, double alpha, double beta, int p) {
        
        if (this.getFunctions().funcaoObjetivo(noCorrente.getState())) {
            return this.functions.calculaUtilidade(noCorrente);
        }
        
        Iterator i = this.actionCommand.executeActions(noCorrente).iterator();
        while (i.hasNext()) {
             
            INode sucessor = (INode)i.next();
            double vlSucessor = min( sucessor, alpha, beta, p+1);
            
            if (vlSucessor > alpha) {
                alpha = vlSucessor;
                
                // poda alpha
                if (alpha >= beta) {
                    return beta;
                }
                
                noCorrente.setUtility( alpha );
                noCorrente.setNext( sucessor );
            }
        }
        
        return alpha;
    }
    
    /**
     *
     * MiniMax, retorna a utilidade mínima de um estado
     *
     */
    public double min(INode noCorrente, double alpha, double beta, int p) {
        
        if (this.functions.funcaoObjetivo(noCorrente.getState())) {
            return this.functions.calculaUtilidade(noCorrente);
        }
        
        Iterator i = this.actionCommand.executeActions(noCorrente).iterator();
        while (i.hasNext()) {
            INode sucessor = (INode)i.next();
            double vlSucessor = max( sucessor, alpha, beta, p+1);
            
            if (vlSucessor < beta) {
                beta = vlSucessor;
                
                if (beta <= alpha) {
                    return alpha;
                }
                
                noCorrente.setUtility( beta );
                noCorrente.setNext( sucessor );
                
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
