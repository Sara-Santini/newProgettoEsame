package it.bonfire.ProjectOOP.Exceptions;

public class StatsNotFoundException extends ClassNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StatsNotFoundException(){
		super();
		System.out.println("Attenzione: statica non esistente");
		
	}

}
