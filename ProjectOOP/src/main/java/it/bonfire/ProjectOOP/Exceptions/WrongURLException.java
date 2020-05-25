package it.bonfire.ProjectOOP.Exceptions;

import java.net.MalformedURLException;

public class WrongURLException extends MalformedURLException{
	private static final long serialVersionUID = 1L;

public WrongURLException() {
	super();
 System.out.println("Attenzione: URL errato.");
	
}
}
