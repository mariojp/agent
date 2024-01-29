package br.com.mariojp.ai.agent.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mariojp.ai.agent.INode;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

//import com.thoughtworks.xstream.XStream;


public class Graphic {
	
	
	private List<INode> tree = new ArrayList<INode>();
	
	private Map<Integer,Integer> depthList = new HashMap<Integer,Integer>();
	
	private static Graphic instance;
	
	private int d = 0;
	private int w = 0;
	
	private Graphic(){
	}
	
	public static Graphic getInstancia(){
		if(instance == null){
			instance = new Graphic();
			instance.depthList.put(0,1);
		}
		return instance;
	}
	
	public void addChildrenList(List<INode> children,int depth){
		if(this.depthList.containsKey(depth)){
			int i = this.depthList.get(depth);
			i=i+children.size();
			w=w<i?i:w;
			this.depthList.put(depth,i);
		}else{
			this.depthList.put(depth,children.size());
			d = d<depth?depth:d;
		}
		this.tree.addAll(children);
	}
	

	
	
	public void showTree(List<INode> path, String name) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i = 0; i<tree.size();i++){
			INode node = tree.get(i);
			int parent = node.getParent()!=null?tree.indexOf(node.getParent()):-1;
			list.add(new TreeNode(i,parent,node.toString(),false));
			
		}
		for(int i = 0; i<path.size();i++){
			INode node = path.get(i);
			if(this.tree.contains(node)){
				TreeNode tn = list.get(this.tree.indexOf(node));
				tn.setSolution(true);
			}
		}
		

		this.exportXML(list, name);
	}
	
	public int maxDepth(){
		return d;
	}
	
	public int maxWidth(){
		return w;
	}

	public void addParentNode(INode node) {
		this.tree.add(node);
	}

	public void exportXML(List<TreeNode> list, String nome){
		
//		XStream xstream = new XStream();
//		xstream.alias("TreeNode", TreeNode.class);
//		try {
//			System.out.println(list.size());
//			xstream.toXML(list,new FileOutputStream(nome+".xml"));
//
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		//System.out.println(xml);

		try {
			JAXBContext context = JAXBContext.newInstance(TreeNodeListWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			TreeNodeListWrapper wrapper = new TreeNodeListWrapper();
			wrapper.setList(list);

			marshaller.marshal(wrapper, new FileOutputStream(nome + ".xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); // Captura outras exceções, incluindo as relacionadas ao JAXB
		}
	}

	@XmlRootElement(name = "SolutionTree")
	static class TreeNodeListWrapper {

		private List<TreeNode> list;

		public List<TreeNode> getList() {
			return list;
		}

		public void setList(List<TreeNode> list) {
			this.list = list;
		}
	}
}
