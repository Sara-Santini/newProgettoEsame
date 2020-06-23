package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import java.util.Iterator;

import it.bonfire.ProjectOOP.Model.API_Instagram;


public class FilterHa extends Filters {
	/**
	 * Method that downloads images with hashtag.
	 * 
	 * @see API_Instagram
	 * @param collezione  collection of API_Instagram.
	 * @return HashSet
	 */
 public FilterHa(HashSet<API_Instagram> collezione,Integer a) {
	 		super(collezione);
			Iterator<API_Instagram> iter = super.api.iterator();
			while (iter.hasNext()) {
				API_Instagram im = iter.next();
				if (im.getCaption()==null || !im.getCaption().contains("#"))
					iter.remove();

			}
			
		
}
 

 
}
