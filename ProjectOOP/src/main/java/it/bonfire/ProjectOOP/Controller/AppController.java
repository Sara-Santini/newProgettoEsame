/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Controller;

import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;

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

	DataBase dati = new DataBase();

	/**
	 * Risponde all richiesta GET /metadata
	 * 
	 * @return ArrayList di oggetti Metadata
	 */

	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {

		return new ResponseEntity<>(dati.getApi(), HttpStatus.OK);
	}

	@RequestMapping(value = "postImage", method = RequestMethod.POST)
	public ResponseEntity<Object> postImage(@RequestBody Image image) {

		dati.addApi(image);
		return new ResponseEntity<>("image is created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "parPostImage", method = RequestMethod.POST)
	public HashSet<API_Instagram> postParImage(@RequestBody API_Instagram api, @RequestBody Photos photo) {
		Image a = new Image(api, photo);
		dati.addApi(a);
		return dati.getApi();
	}

	@RequestMapping(value = "deleteImage", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteImage(@RequestParam(name = "id") String id) {

		dati.deleteAPI(id);

		return new ResponseEntity<>("image is deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "postCarouselAlbum", method = RequestMethod.POST)
	public ResponseEntity<Object> postCarouselAlbum(@RequestBody Album album) {

		dati.addApi(album);
		return new ResponseEntity<>("album is created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "deleteCarouselAlbum", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCarouselAlbum(@RequestParam(name = "id") String id) {

		dati.deleteAPI(id);

		return new ResponseEntity<>("album is deleted", HttpStatus.OK);
	}
	@RequestMapping(value = "getAllStatistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getstats(){
		return new ResponseEntity<>((String)dati.getStatistics(), HttpStatus.OK);
	}
	@RequestMapping(value = "getAllFilters", method = RequestMethod.GET)
	public ResponseEntity<Object> getfilters(){
		dati.getSortPhotos();
		dati.getPhotoHashtag();
        return new ResponseEntity<>("immagini filtrate", HttpStatus.OK);
	}
}
