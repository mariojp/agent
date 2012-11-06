package br.com.mariojp.ai.agent;

import java.util.List;

import br.com.mariojp.ai.agent.exception.EmptyBorderException;



public interface IAgent {

	public static final int DEPTH_FIRST_SEARCH   = 0;

	public static final int BREADTH_FIRST_SEARCH = 1;
	
	public static final int GREEDY_SEARCH        = 2;
	
	public static final int START_SEARCH         = 3;
	
	public static final int UNIFORM_COST_SEARCH  = 4;
	
	public static final int MINIMAX  = 5;
	
	public static final int MINIMAX_ALFA_BETA  = 6;
	
	public static final int BREADTH_FIRST_SEARCH_REVERSE = 7;
	
	public static final int BREADTH_FIRST_SEARCH_BI_DIRECT = 8;
	


	public abstract INode function() throws EmptyBorderException;
	
	public abstract List<INode> obterCaminho(INode no);
	
	public abstract INode getFirstNode();
	

	public abstract void exibirGrafico(List<INode> cam, String nome);
	
}
