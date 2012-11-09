package br.com.mariojp.ai.agent;


/**
 * <p>Title: Intelligent Agents</p>
 *
 * <p>Description: Class GenericState </p>
 *
 * <p>Copyright: Copyright mariojp(c) 2006</p>
 *
 * @author Mario Jorge Pereira 
 * @version 1.1
 */
public abstract class AbstractState implements IState {

	public AbstractState() {
		super();
	}

	
	
	 public abstract boolean equals(Object arg0);

    /**
    *
    * @return Object
    */
   public Object clone()throws CloneNotSupportedException{
       return super.clone();
   }


   public abstract String toString();
	

}
