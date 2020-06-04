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

	public FilterService(String field,HashSet<API_Instagram> util) {
		api=util;
		if(field.contains("#")) {
			api=filter.photosWithHashtag(api);
			}
		if(field.contains("|")) {
			api=filter.PhotosHight(api);
			
		}
		if(field.contains("-")) {
			api=filter.PhotosWight(api);
		}
		if(field.contains("?")) {
			api=filter.photosMore100Kb(api);
		}
		if(field.contains("!")) {
			api=filter.photosUnder100Kb(api);
		}
		
	}

}
