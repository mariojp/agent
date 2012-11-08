
package br.com.mariojp.exemplos.metroparis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.mariojp.exemplos.metroparis.excecoes.DistanciaNaoInformadaException;
import br.com.mariojp.exemplos.metroparis.excecoes.EstacaoNaoEncontradaException;



/**
 * @author Alunois
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CentralControle {
	
	private static CentralControle instancia;
	public static final int LINHA_AZUL_ESCURO = 1;
	public static final int LINHA_AZUL_CLARO  = 2;
	public static final int LINHA_VERMELHA    = 3;
	public static final int LINHA_AMARELA     = 4;
	
	private double velocidadeMedia = 30;
	
	
	private CentralControle(){
		carga();
	}
	
	public static CentralControle getInstancia(){
		if (instancia == null)
			instancia =new CentralControle();		
		return instancia;
	}
	
	private List distReaisEstacoes;
	private List distDiretasEstacoes;
	private List estacoes;
	private List linhas;
	
	private void carga(){
		
		cargaEstacoes();
		try{
			cargaLinhas();
			cargaDistanciasDiretas();
			cargaDistanciasReais();
		}
		catch(EstacaoNaoEncontradaException e){
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	private void cargaDistanciasDiretas()throws EstacaoNaoEncontradaException  {
		distDiretasEstacoes = new ArrayList();
		
		Distancia d = new Distancia(getEstacao("E1"),getEstacao("E2"),10,Distancia.DISTANCIA_DIRETA);
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E1"),getEstacao("E3"),18.5,Distancia.DISTANCIA_DIRETA);
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E1"),getEstacao("E4"),24.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E5"),36.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E6"),38.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E7"),35.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E8"),25.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E9"),17.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E10"),9.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E11"),16.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E12"),27.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E13"),27.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E1"),getEstacao("E14"),29.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E2"),getEstacao("E3"),8.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E4"),14.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E5"),26.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E6"),29.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E7"),26.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E8"),17.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E9"),10,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E10"),3.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E11"),15.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E12"),20.9,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E13"),19.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E14"),21.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		
		d = new Distancia(getEstacao("E3"),getEstacao("E4"),6.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);		
		d = new Distancia(getEstacao("E3"),getEstacao("E5"),18.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E6"),20.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E7"),17.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E8"),13.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E9"),9.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E10"),10.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E11"),19.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E12"),19.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E13"),12.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E14"),16.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E4"),getEstacao("E5"),12,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E6"),14.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E7"),11.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E8"),12.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E9"),12.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E10"),16.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E11"),23.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E12"),18.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E13"),10.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E14"),15.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E5"),getEstacao("E6"),3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E7"),2.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E8"),19.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E9"),23.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E10"),28.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E11"),34.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E12"),24.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E13"),14.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E14"),17.9,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E6"),getEstacao("E7"),3.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E8"),22.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E9"),25.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E10"),30.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E11"),36.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E12"),27.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E13"),15.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E6"),getEstacao("E14"),18.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E7"),getEstacao("E8"),20,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E9"),23.0,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E10"),27.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E11"),34.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E12"),25.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E13"),12.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E7"),getEstacao("E14"),15.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E8"),getEstacao("E9"),8.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E10"),20.3,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E11"),16.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E12"),6.4,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E13"),22.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E14"),27.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E9"),getEstacao("E10"),13.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E9"),getEstacao("E11"),11.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E9"),getEstacao("E12"),10.9,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E9"),getEstacao("E13"),21.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E9"),getEstacao("E14"),26.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E10"),getEstacao("E11"),17.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E10"),getEstacao("E12"),24.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E10"),getEstacao("E13"),18.7,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E10"),getEstacao("E14"),21.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E11"),getEstacao("E12"),14.2,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E11"),getEstacao("E13"),31.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E11"),getEstacao("E14"),35.5,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E12"),getEstacao("E13"),28.8,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		d = new Distancia(getEstacao("E12"),getEstacao("E14"),33.6,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		d = new Distancia(getEstacao("E13"),getEstacao("E14"),5.1,Distancia.DISTANCIA_DIRETA);		
		distDiretasEstacoes.add(d);
		
		for (Iterator iter = distDiretasEstacoes.iterator(); iter.hasNext();) {
			@SuppressWarnings("unused") Distancia dis = (Distancia) iter.next();			
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void cargaDistanciasReais() throws EstacaoNaoEncontradaException {
		
		distReaisEstacoes = new ArrayList();
		
		Distancia d = new Distancia(getEstacao("E1"),getEstacao("E2"),10.0,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E2"),getEstacao("E3"),8.5,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);		
		d = new Distancia(getEstacao("E2"),getEstacao("E9"),10.0,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E2"),getEstacao("E10"),3.5,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E3"),getEstacao("E4"),6.3,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E9"),9.4,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E3"),getEstacao("E13"),18.7,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E4"),getEstacao("E5"),13,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E8"),15.3,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E4"),getEstacao("E13"),12.8,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E5"),getEstacao("E6"),3,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E7"),2.4,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E5"),getEstacao("E8"),30.0,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E8"),getEstacao("E9"),9.6,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		d = new Distancia(getEstacao("E8"),getEstacao("E12"),6.4,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E9"),getEstacao("E11"),12.2,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
		
		d = new Distancia(getEstacao("E13"),getEstacao("E14"),5.1,Distancia.DISTANCIA_REAL);		
		distReaisEstacoes.add(d);
	}
	
	@SuppressWarnings("unchecked")
	private void cargaLinhas() throws EstacaoNaoEncontradaException  {
		linhas = new ArrayList();
		
		Linha l =new Linha(LINHA_AMARELA,"Linha Amarela");
		l.adicionaEstacao(getEstacao("E10"));
		l.adicionaEstacao(getEstacao("E2"));
		l.adicionaEstacao(getEstacao("E9"));
		l.adicionaEstacao(getEstacao("E8"));
		l.adicionaEstacao(getEstacao("E5"));
		l.adicionaEstacao(getEstacao("E7"));
		linhas.add(l);
		
		l =new Linha(LINHA_AZUL_ESCURO,"Linha Azul Escuro");
		
		l.adicionaEstacao(getEstacao("E1"));
		l.adicionaEstacao(getEstacao("E2"));
		l.adicionaEstacao(getEstacao("E3"));
		l.adicionaEstacao(getEstacao("E4"));
		l.adicionaEstacao(getEstacao("E5"));
		l.adicionaEstacao(getEstacao("E6"));		
		linhas.add(l);
		
		l =new Linha(LINHA_AZUL_CLARO,"Linha Azul Claro");
		l.adicionaEstacao(getEstacao("E12"));
		l.adicionaEstacao(getEstacao("E8"));
		l.adicionaEstacao(getEstacao("E4"));
		l.adicionaEstacao(getEstacao("E13"));
		l.adicionaEstacao(getEstacao("E14"));		
		linhas.add(l);
		
		l =new Linha(LINHA_VERMELHA,"Linha Vermelha");
		l.adicionaEstacao(getEstacao("E11"));
		l.adicionaEstacao(getEstacao("E9"));
		l.adicionaEstacao(getEstacao("E3"));
		l.adicionaEstacao(getEstacao("E13"));		
		linhas.add(l);
		
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void cargaEstacoes() {
		estacoes = new ArrayList();
		Estacao est;					
		est = new Estacao("E1");	
		estacoes.add(est);
		est = new Estacao("E2");			
		estacoes.add(est);
		est = new Estacao("E3");			
		estacoes.add(est);
		est = new Estacao("E4");			
		estacoes.add(est);
		est = new Estacao("E5");			
		estacoes.add(est);
		est = new Estacao("E6");			
		estacoes.add(est);
		est = new Estacao("E7");			
		estacoes.add(est);
		est = new Estacao("E8");			
		estacoes.add(est);
		est = new Estacao("E9");			
		estacoes.add(est);
		est = new Estacao("E10");			
		estacoes.add(est);
		est = new Estacao("E11");			
		estacoes.add(est);
		est = new Estacao("E12");			
		estacoes.add(est);
		est = new Estacao("E13");			
		estacoes.add(est);
		est = new Estacao("E14");			
		estacoes.add(est);		
		
	}
	
	public Estacao getEstacao(String desc) throws EstacaoNaoEncontradaException{
		
		for (int i =0;i<estacoes.size();i++) {
			Estacao e = (Estacao)estacoes.get(i);
			if (e.getDesc().equals(desc))
				return e;
		}
		
		throw new EstacaoNaoEncontradaException("Estação nao econtrada:"+desc);		
	}
	
	
	public double getDistanciaReal(Estacao e1,Estacao e2) throws DistanciaNaoInformadaException{
		
		for (int i =0;i<distReaisEstacoes.size(); i++) {
			Distancia distancia = (Distancia) distReaisEstacoes.get(i);
			if (distancia.getOrigem().equals(e1) &&
					distancia.getDestino().equals(e2))	
				return distancia.getDistancia();
			if (distancia.getOrigem().equals(e2) &&
					distancia.getDestino().equals(e1))	
				return distancia.getDistancia();							
		}
		throw new DistanciaNaoInformadaException("Distancia Real nao informada para "+e1+"-"+e2); 
	}
	
	public double getDistanciaDireta(Estacao e1,Estacao e2) throws DistanciaNaoInformadaException{
		for (int i=0;i<distDiretasEstacoes.size(); i++) {
			Distancia distancia = (Distancia) distDiretasEstacoes.get(i);
			if (distancia.getOrigem().equals(e1) &&
					distancia.getDestino().equals(e2))	
				return distancia.getDistancia();
			if (distancia.getOrigem().equals(e2) &&
					distancia.getDestino().equals(e1))	
				return distancia.getDistancia();							
		}
		throw new DistanciaNaoInformadaException("Distancia Direta nao informada para "+e1+"-"+e2); 
	}
	
	@SuppressWarnings("unchecked")
	public List getLinhas(Estacao e){
		List linhasNaEstacao = new ArrayList();
		for (Iterator iter = linhas.iterator(); iter.hasNext();) {			
			Linha linha = (Linha) iter.next();			
			if (linha.passaNaEstacao(e))
				linhasNaEstacao.add(linha);			
		}
		return linhasNaEstacao;
	}
	
	
	
	/**
	 * @return Returns the estacoes.
	 */
	public List getEstacoes() {
		return estacoes;
	}
	
	public static void main(String args[]){
		Estacao e1 = null;
		Estacao e2 = null;
		try {
			e1 = CentralControle.getInstancia().getEstacao("E2");
			e2 = CentralControle.getInstancia().getEstacao("E2");
		} catch (EstacaoNaoEncontradaException e3) {
			e3.printStackTrace();
		}
		
		
		try {
			System.out.println("Distancia Direta"+CentralControle.getInstancia().getDistanciaDireta(e1,e2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Distancia Real"+CentralControle.getInstancia().getDistanciaReal(e1,e2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return Returns the velocidadeMedia.
	 */
	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	/**
	 * @param velocidadeMedia The velocidadeMedia to set.
	 */
	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
}
