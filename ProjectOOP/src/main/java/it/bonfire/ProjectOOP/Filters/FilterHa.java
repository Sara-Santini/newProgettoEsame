package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import java.util.Iterator;


import it.bonfire.ProjectOOP.Model.API_Instagram;

/**
 * Class that downloads image with hashtag.
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
public class FilterHa extends Filters {
	/**
	 * @see API_Instagram api
	 * @param collezione  collection of API_Instagram.
	 * @return HashSet
	 */
 public FilterHa(HashSet<API_Instagram> collezione,Integer a){
	 super(collezione);
			Iterator<API_Instagram> iter = super.api.iterator();
			while (iter.hasNext()) {
				API_Instagram im = iter.next();
				if (im.getCaption()==null || !im.getCaption().contains("#"))
					iter.remove();

			}
			
		
}
 

 
}
