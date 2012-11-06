package br.com.mariojp.ai.agent.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mariojp.ai.agent.INode;

import com.thoughtworks.xstream.XStream;


public class Grafico {
	
	
	private List<INode> arvore = new ArrayList<INode>();
	
	private Map<Integer,Integer> profundidadeList = new HashMap<Integer,Integer>();
	
	private static Grafico instancia;
	
	private int d = 0;
	private int w = 0;
	
	private Grafico(){
	}
	
	public static Grafico getInstancia(){
		if(instancia == null){
			instancia = new Grafico();
			instancia.profundidadeList.put(0,1);
		}
		return instancia;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void addListFilhos(List<INode> filhos,int prof){
		if(this.profundidadeList.containsKey(prof)){
			int i = this.profundidadeList.get(prof);
			i=i+filhos.size();
			w=w<i?i:w;
			this.profundidadeList.put(prof,i);
		}else{
			this.profundidadeList.put(prof,filhos.size());
			d = d<prof?prof:d;
		}
		this.arvore.addAll(filhos);
	}
	

	
	
	public void exibeArvore(List<INode> caminho, String nome) {
		List<TreeNode> lista = new ArrayList<TreeNode>();
		for(int i = 0; i<arvore.size();i++){
			INode node = arvore.get(i);
			int pai = node.getPai()!=null?arvore.indexOf(node.getPai()):-1;
			lista.add(new TreeNode(i,pai,node.toString(),false));
			
		}
		for(int i = 0; i<caminho.size();i++){
			INode node = caminho.get(i);
			if(this.arvore.contains(node)){
				TreeNode tn = lista.get(this.arvore.indexOf(node));
				tn.setSolution(true);
			}
		}
		

		this.exporttaXML(lista, nome);
	}
	
	public int maximaProfundidade(){
		return d;
	}
	
	public int maximaLargura(){
		return w;
	}

	public void adicionaNodePai(INode node) {
		this.arvore.add(node);
	}

	public void exporttaXML(List list, String nome){
		
		XStream xstream = new XStream();
		xstream.alias("TreeNode", TreeNode.class);
		try {
			System.out.println(list.size());
			xstream.toXML(list,new FileOutputStream(nome+".xml"));
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//System.out.println(xml);
		
	}

}
