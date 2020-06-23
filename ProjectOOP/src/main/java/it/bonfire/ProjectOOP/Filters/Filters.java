package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import it.bonfire.ProjectOOP.Model.API_Instagram;

/**
 * Classes that is extended by all the filters.
 * 
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
public class Filters {
	/**
	 * New collection of Api_Instagram
	 */
	protected HashSet<API_Instagram> api;

	/**
	 * The constructor.
	 * 
	 * @param collezione collection of Api_Instagram.
	 */
	public Filters(HashSet<API_Instagram> collezione) {

		this.api = new HashSet<API_Instagram>(collezione);
	}

	/**
	 * Methods that gives back the collection.
	 * 
	 * @return api
	 */
	public HashSet<API_Instagram> getApi()  {
		
		return api;
	}

}
