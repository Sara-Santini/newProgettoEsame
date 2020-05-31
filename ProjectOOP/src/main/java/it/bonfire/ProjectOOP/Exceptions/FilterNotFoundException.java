package it.bonfire.ProjectOOP.Exceptions;

import java.io.IOException;

public class FilterNotFoundException extends IOException{

	private static final long serialVersionUID = 1L;

	public FilterNotFoundException() {
		super();
		System.out.println("failed filter");
		
	}
	
	public String getMessage(){
	return "failed filter";
	}
}
