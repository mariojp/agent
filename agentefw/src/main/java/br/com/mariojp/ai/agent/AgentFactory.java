package br.com.mariojp.ai.agent;

import br.com.mariojp.ai.agent.strategies.BreadthFirstSearch;
import br.com.mariojp.ai.agent.strategies.BreadthFirstSearchBiDirect;
import br.com.mariojp.ai.agent.strategies.BreadthFirstSearchReverse;
import br.com.mariojp.ai.agent.strategies.DepthFirstSearch;
import br.com.mariojp.ai.agent.strategies.GreedySearch;
import br.com.mariojp.ai.agent.strategies.MiniMax;
import br.com.mariojp.ai.agent.strategies.MiniMaxAB;
import br.com.mariojp.ai.agent.strategies.StarSearch;
import br.com.mariojp.ai.agent.strategies.UniformCostSearch;

public class AgentFactory {

	public static IAgent createAgent(AgentModel agent) {
		IAgent newAgent = null;
		switch (agent.getType()) {
		case IAgent.DEPTH_FIRST_SEARCH:
			newAgent = new DepthFirstSearch(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH:
			newAgent = new BreadthFirstSearch(agent);
			break;
		case IAgent.GREEDY_SEARCH:
			newAgent = new GreedySearch(agent);
			break;
		case IAgent.START_SEARCH:
			newAgent = new StarSearch(agent);
			break;
		case IAgent.UNIFORM_COST_SEARCH:
			newAgent = new UniformCostSearch(agent);
			break;
		case IAgent.MINIMAX:
			newAgent = new MiniMax(agent);
			break;
		case IAgent.MINIMAX_ALFA_BETA:
			newAgent = new MiniMaxAB(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH_REVERSE:
			newAgent = new BreadthFirstSearchReverse(agent);
			break;
		case IAgent.BREADTH_FIRST_SEARCH_BI_DIRECT:
			newAgent = new BreadthFirstSearchBiDirect(agent);
			break;
		
		}
		return newAgent;

	}

}
