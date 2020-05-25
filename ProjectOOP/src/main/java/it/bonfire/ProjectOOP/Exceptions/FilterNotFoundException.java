package it.bonfire.ProjectOOP.Exceptions;

public class FilterNotFoundException extends ClassNotFoundException{

	private static final long serialVersionUID = 1L;

	public FilterNotFoundException() {
		super();
		System.out.println("Filtro inesistente");
		
	}
}
