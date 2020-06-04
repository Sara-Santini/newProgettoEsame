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

import it.bonfire.ProjectOOP.Filters.FilterService;
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

		dati.deleteApi(id);

		return new ResponseEntity<>("image is deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "postCarouselAlbum", method = RequestMethod.POST)
	public ResponseEntity<Object> postCarouselAlbum(@RequestBody Album album) {

		dati.addApi(album);
		return new ResponseEntity<>("album is created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "deleteCarouselAlbum", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCarouselAlbum(@RequestParam(name = "id") String id) {

		dati.deleteApi(id);

		return new ResponseEntity<>("album is deleted", HttpStatus.OK);
	}
	@RequestMapping(value = "getAllStatistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getstats(){
		return new ResponseEntity<>((String)dati.getStatistics(), HttpStatus.OK);
	}
	@RequestMapping(value = "getAverageOfBytes", method=RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfBytes() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().AverageOfBytes()), HttpStatus.OK);
	}
	@RequestMapping(value = "getAverageOfPixel", method=RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfPixel() {

		return new ResponseEntity<>(String.valueOf(dati.getStats().AverageOfPixel()), HttpStatus.OK);
	}
	@RequestMapping(value = "getMedianOfPixels", method=RequestMethod.GET)
	public ResponseEntity<Object> getMedianOfPixels() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().MedianOfPixels()), HttpStatus.OK);
	}
	@RequestMapping(value = "getAverageOfHashtag", method=RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfHashtag() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().AverageOfHashtag()), HttpStatus.OK);
	}
	@RequestMapping(value = "getMedianOfBytes", method=RequestMethod.GET)
	public ResponseEntity<Object> getMedianOfBytes() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().MedianOfBytes()), HttpStatus.OK);
	}
	@RequestMapping(value = "getTotHashtag", method=RequestMethod.GET)
	public ResponseEntity<Object> getTotHashtag() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().TotHashtag()), HttpStatus.OK);
	}
	@RequestMapping(value = "getAllFilters", method = RequestMethod.GET)
	public ResponseEntity<Object> getfilters(){
		dati.getSortPhotos();
		dati.getPhotoHashtag();
        return new ResponseEntity<>("immagini filtrate", HttpStatus.OK);
	}
	@RequestMapping(value = "getFilters", method = RequestMethod.GET)
	public ResponseEntity<Object> getSomeFilters(@RequestParam (name="field")String field ){
		
			FilterService filterService=new FilterService(field,dati.getApi());
		
        return new ResponseEntity<>(filterService.getApi(), HttpStatus.OK);
	}
}
