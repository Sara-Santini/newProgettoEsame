/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Controller;

import java.io.IOException;
import java.util.HashSet;

import javax.imageio.stream.IIOByteBuffer;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.bonfire.ProjectOOP.Exceptions.PhotoNotFoundException;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of AppController.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
@RestController
public class AppController {
	
	    DataBase dati=new DataBase();

			
			/**
			 * Risponde all richiesta GET /metadata 
			 * @return ArrayList di oggetti Metadata
			 */

			@RequestMapping(value = "metadata", method=RequestMethod.GET)
			public HashSet<API_Instagram> getMetadata(){
					
				return dati.getApi();
			}
			
			@RequestMapping(value = "postImage", method=RequestMethod.POST)
			public HashSet<API_Instagram> postImage(@RequestBody Image image){
				
				dati.addApi(image);
				return dati.getApi();
			}
			@RequestMapping(value = "parPostImage", method=RequestMethod.POST)
			public HashSet<API_Instagram> postParImage(@RequestBody API_Instagram api,@RequestBody Fotografia photo ){
				Image a= new Image(api, photo);
				dati.addApi(a);
				return dati.getApi();
			}
			@RequestMapping(value= "/deleteImage",method=RequestMethod.DELETE)
			public HashSet<API_Instagram> deleteImage(@RequestParam (name ="id")String id){
				try {
					dati.deleteAPI(id);
				} catch (PhotoNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return dati.getApi();				
			}
			
			
}
