package it.bonfire.ProjectOOP.Exceptions;

public class PhotoNotFoundException extends Exception{
	public PhotoNotFoundException() {
		super();
		System.out.println("Photo not founded!");
	}
	public PhotoNotFoundException(String message) {
		super(message);
		}

}
