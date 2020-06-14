/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;


import java.util.HashSet;

import it.bonfire.ProjectOOP.Exceptions.FilterNotFoundException;
import it.bonfire.ProjectOOP.Model.API_Instagram;

/**
 * Class that manages all the requests of filter with jolly character.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */

public class FilterService {
	/**
	 * New collection of API_instagram.
	 */
	private HashSet<API_Instagram> api = new HashSet<API_Instagram>();
	/**
	 * New object of filter.
	 */
	public Filter filter = new Filter();

	/**
	 * The constructor.
	 * 
	 * @param util A collection of API_Instagram.
	 */
	public FilterService(HashSet<API_Instagram> util) {
		api = util;
	}

	/**
	 * Method that gives the collection.
	 * @see API_Instagram api
	 * @return HashSet
	 */
	public HashSet<API_Instagram> getApi() {
		return api;
	}

	/**
	 * Method which sets a value to attribute to the collection.
	 * 
	 * @param api Collection of API_Instagram.
	 */
	public void setApi(HashSet<API_Instagram> api) {
		this.api = api;
	}

	/**
	 * Method that manages the requests of filter with jolly character
	 * 
	 * @param field The jolly character that gives the requested filter by the user.
	 * @param a     The value the user wants.
	 * @see Filter filter
	 * @throws FilterNotFoundException It is thrown when the filter doesn't exists. 
	 */

	public void Operator(String field, int a) throws FilterNotFoundException{
		
		if (field.equals("#")) {
			api = filter.photosWithHashtag(api);
		}
		
		else if (field.equals("|")) {
			api = filter.PhotosHeight(api, a);

		}
		else if (field.equals("-")) {
			api = filter.PhotosWide(api, a);
		}
		else if (field.equals("?")) {
			api = filter.photosMore100Kb(api, a);
		}
		else if (field.equals("!")) {
			api = filter.photosUnder100Kb(api, a);
		}
		else throw new FilterNotFoundException();
		
 
}

}
