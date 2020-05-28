/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Controller;

import java.io.IOException;
import java.util.HashSet;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.bonfire.ProjectOOP.Model.API_Instagram;
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
	
	    HashSet<API_Instagram> dati;

			
			/**
			 * Risponde all richiesta GET /metadata 
			 * @return ArrayList di oggetti Metadata
			 */

			@RequestMapping(value = "metadata", method=RequestMethod.GET)
			public HashSet<API_Instagram> getMetadata(){
				
				return new DataBase().getApi();
			}
			
			
			
}
