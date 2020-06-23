package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;

import it.bonfire.ProjectOOP.Model.API_Instagram;

public class Filters {
	protected HashSet<API_Instagram> api=new HashSet<API_Instagram>();
	


	public Filters(HashSet<API_Instagram> collezione) {
		this.api=collezione;
	}



	public HashSet<API_Instagram> getApi() {
		return api;
	}
 
}
