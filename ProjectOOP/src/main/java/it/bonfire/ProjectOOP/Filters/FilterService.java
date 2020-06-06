package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;

import it.bonfire.ProjectOOP.Model.API_Instagram;

public class FilterService {
	HashSet<API_Instagram> api=new HashSet<API_Instagram>();
	public Filter filter=new Filter();

	public HashSet<API_Instagram> getApi() {
		return api;
	}

	public void setApi(HashSet<API_Instagram> api) {
		this.api = api;
	}

	public FilterService(HashSet<API_Instagram> util) {
		api=util;
		
	}
   public void Operator(String field,int a) {
	   if(field.equals("#")) {
			api=filter.photosWithHashtag(api);
			}
		if(field.equals("|")) {
			api=filter.PhotosHight(api,a);
			
		}
		if(field.equals("-")) {
			api=filter.PhotosWight(api,a);
		}
		if(field.equals("?")) {
			api=filter.photosMore100Kb(api,a);
		}
		if(field.equals("!")) {
			api=filter.photosUnder100Kb(api,a);
		}
		
   }
}
