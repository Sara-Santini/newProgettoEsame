/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import it.bonfire.ProjectOOP.Exceptions.EmptyCollectionException;
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
	 * The constructor.
	 * 
	 * @param util A collection of API_Instagram.
	 */
	public FilterService(HashSet<API_Instagram> util) {
		api = util;
	}

	/**
	 * The directory in which it will be created the class.
	 */
	private static String dir = "it.bonfire.ProjectOOP.Filters.Filter";

	/**
	 * Methods that generates the filter's class.
	 * 
	 * @param field It is the field that the user given.
	 * @param a     It is a param passed by the user.
	 * @throws EmptyCollectionException  It is thrown when the user wants to do a filter but the collection is empty.
	 * @throws FilterNotFoundException It is thrown when the filter doesn't exists.                      
	 */

	public void filtering(String field, int a) throws EmptyCollectionException, FilterNotFoundException {

		try {
			Class<?> classe = Class.forName(dir + field);
			Constructor<?> cons = classe.getDeclaredConstructor(HashSet.class, Integer.class);
			Filters filter = (Filters) cons.newInstance(api, a);

			api = filter.getApi();

		} 

		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			throw new FilterNotFoundException();
		}
		 catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method that gives back a collection of API_Instagram.
	 * 
	 * @throws EmptyCollectionException It is thrown when the user wants to do a filter but the collection is empty.
	 * @return Hashset
	 */

	public HashSet<API_Instagram> getApi() throws EmptyCollectionException {
		if (api.isEmpty())
			throw new EmptyCollectionException();
		
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
}

    