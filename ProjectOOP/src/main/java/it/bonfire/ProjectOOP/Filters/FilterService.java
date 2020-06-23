/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;


import it.bonfire.ProjectOOP.Model.API_Instagram;

/**
 * Class that manages all the requests of filter with jolly character.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
//
//public class FilterService {
//	/**
//	 * New collection of API_instagram.
//	 */
//	private HashSet<API_Instagram> api = new HashSet<API_Instagram>();
//	/**
//	 * New object of filter.
//	 */
//	public Filter filter = new Filter();
//
//	/**
//	 * The constructor.
//	 * 
//	 * @param util A collection of API_Instagram.
//	 */
//	public FilterService(HashSet<API_Instagram> util) {
//		api = util;
//	}
//
//	/**
//	 * Method that gives the collection.
//	 * @see API_Instagram api
//	 * @return HashSet
//	 */
//	public HashSet<API_Instagram> getApi() {
//		return api;
//	}
//
//	/**
//	 * Method which sets a value to attribute to the collection.
//	 * 
//	 * @param api Collection of API_Instagram.
//	 */
//	public void setApi(HashSet<API_Instagram> api) {
//		this.api = api;
//	}
//
//	/**
//	 * Method that manages the requests of filter with jolly character
//	 * 
//	 * @param field The jolly character that gives the requested filter by the user.
//	 * @param a     The value the user wants.
//	 * @see Filter filter
//	 * @throws FilterNotFoundException It is thrown when the filter doesn't exists. 
//	 */
//
//	public void Operator(String field, int a) throws FilterNotFoundException{
//		
//		if (field.equals("#")) {
//			api = filter.photosWithHashtag(api);
//		}
//		
//		else if (field.equals("|")) {
//			api = filter.PhotosHeight(api, a);
//
//		}
//		else if (field.equals("-")) {
//			api = filter.PhotosWide(api, a);
//		}
//		else if (field.equals("?")) {
//			api = filter.photosMore100Kb(api, a);
//		}
//		else if (field.equals("!")) {
//			api = filter.photosUnder100Kb(api, a);
//		}
//		else throw new FilterNotFoundException();
//		
// 
//}
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
 * The directory in which it will be created the class.
 */
		private static String dir="it.bonfire.ProjectOOP.Filters.Filter";
		
		/**
		 * Methods which generates the filter's class. 
		 * @param field It is the field that the user given.
		 * @param a It is a param passed by the user.
		 * @exception ClassNotFoundException It is thrown when the class doesn't exists.
		 * @exception NoSuchMethodException It is thrown when a particular method cannot be found.
		 * @exception SecurityException It is thrown to indicate a security violation.
		 * @exception InstantiationException It is thrown when the application tries to create an instance of a class using the newInstance method in class, but the specified class object cannot be instantiated. 
		 * @exception IllegalAccessException It is thrown when an application tries to reflectively create an instance, set or get a field, or invoke a method, but the currently executing method does not have access to the definition of the specified class, field, method or constructor.
		 * @exception IllegalArgumentException It is thrown to indicate that a method has been passed an illegal or inappropriate argument.
		 * @exception InvocationTargetException It is thrown by an invoked method or constructor.
		 */
		
		public void filtering(String field, int a) {

			try {
				Class<?> classe = Class.forName(dir + field);
				Constructor<?> cons = classe.getDeclaredConstructor(HashSet.class, Integer.class);
				Filters filter = (Filters) cons.newInstance(api, a);
				api = filter.getApi();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		

}
		/**
		 * Method that gives back a collection of API_Instagram.
		 * @return Hashset
		 */
		public  HashSet<API_Instagram> getApi() {
			return api;
		}
		}
