package br.com.mariojp.ai.agent;


/**
 * 
 * @author Mario Jorge Pereira
 *
 */
public interface IState extends Cloneable {

	boolean equals(Object arg0);
	
	Object clone() throws CloneNotSupportedException;
	
}
