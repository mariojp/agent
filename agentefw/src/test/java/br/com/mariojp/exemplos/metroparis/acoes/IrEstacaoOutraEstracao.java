
package br.com.mariojp.exemplos.metroparis.acoes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import br.com.mariojp.exemplos.metroparis.Estacao;
import br.com.mariojp.exemplos.metroparis.Estado;
import br.com.mariojp.exemplos.metroparis.Linha;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file Aspirar.java
* @author Rodrigo e Marcus Vinicius
* @version 1.0
 * <p>Classe que representa a Ação de Ir de uma Estação para outra</p>
 *
 */
public class IrEstacaoOutraEstracao extends AbstractAction{

	
	public List<IState> execute(IState arg0) throws ImpossibleActionException {		
		List<IState> estados = new ArrayList<IState>();
		Estado e= (Estado)arg0;
		Estacao est = e.getEstacao();
		Linha linha = e.getLinha();
		List estacoes = null;
		try {
			estacoes = linha.estacoesAdjacentes(est);
			if (estacoes.size()==0)
				throw new ImpossibleActionException();// não tem pra onde ir
			
			for (Iterator iter = estacoes.iterator(); iter.hasNext();) {
				Estacao estacao = (Estacao) iter.next();
				Estado novoEstado = (Estado) e.clone();
				novoEstado.setEstacao(estacao);
				if (!novoEstado.equals(e))
				estados.add(novoEstado);
			}
			
		} catch (Exception e1) {
			throw new ImpossibleActionException(e1.getMessage());	
		}
		return estados;			
		
	}
	


}
