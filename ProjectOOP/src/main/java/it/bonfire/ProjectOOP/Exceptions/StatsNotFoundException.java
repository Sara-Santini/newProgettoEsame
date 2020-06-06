package it.bonfire.ProjectOOP.Exceptions;

public class StatsNotFoundException extends ClassNotFoundException {
 private String message="Attenzione: statistica non esistente";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StatsNotFoundException(){
		super();
		
	}
	public StatsNotFoundException(String string){
		super(string);
		
	}
	public String getMessage() {
		return message;
	}

}
