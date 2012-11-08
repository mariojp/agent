
package br.com.mariojp.exemplos.metroparis.acoes;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import br.com.mariojp.exemplos.metroparis.CentralControle;
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
 * <p>Classe que representa a Ação de sair de um metro e pegar outro</p>
 *
 */
public class Baldear extends AbstractAction{

	
	public List<IState> execute(IState arg0) throws ImpossibleActionException {
		
		List<IState> novosEstados = new ArrayList<IState>();		
		Estado e= (Estado)arg0;
		Estacao est = e.getEstacao();
		Linha linha = e.getLinha();
		//System.out.println("[BALDEAR]Vou tentar baldear na "+est+" e "+linha);
		Estado novoEstado = (Estado) e.clone();				
		
		Linha novaLinha = mudarDeLinha(linha,est);
		if (novaLinha!=null){
			novoEstado.setLinha(novaLinha);
			novosEstados.add(novoEstado);			
		}			 
		else
			throw new ImpossibleActionException();
		return novosEstados;
	}
	/**
	 * Tenta mudar de uma estacao para outra
	 * @param linhaAtual
	 * @param e
	 * @return
	 */
	private Linha mudarDeLinha(Linha linhaAtual,Estacao e){
		List linhas = CentralControle.getInstancia().getLinhas(e);
		//System.out.println("Total de Linhas:"+linhas.size());
		for (int i=0;i<linhas.size();i++) {
			Linha linha = (Linha) linhas.get(i);
			if (!linha.equals(linhaAtual))
				return linha;
		}
		return null;
	}
	


}
