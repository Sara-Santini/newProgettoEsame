/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Controller;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.bonfire.ProjectOOP.Exceptions.FilterNotFoundException;
import it.bonfire.ProjectOOP.Exceptions.StatsNotFoundException;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Class that manages all the requests the user can makes to the server.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
@RestController
public class AppController {
	/**
	 * Object of DataBase.
	 */
	DataBase dati = new DataBase();


	/**
	 * Method that reply to the request GET/metadata
	 * 
	 * @see DataBase
	 * @return ArrayList of Metadata's objects.
	 * 
	 */

	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {

		return new ResponseEntity<>(dati.getApi(), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request POST/postImage
	 * 
	 * @see DataBase
	 * @return a message that the image is created.
	 * 
	 */
	@RequestMapping(value = "postImage", method = RequestMethod.POST)
	public ResponseEntity<Object> postImage(@RequestBody Image image) {

		dati.addApi(image);
		return new ResponseEntity<>("image is created", HttpStatus.CREATED);
	}

	/**
	 * /** Method that reply to the request DELETE/deleteImage.
	 * 
	 * @param id Identify the photo.
	 * @see DataBase
	 * @return a message that the image is deleted.
	 */
	@RequestMapping(value = "deleteImage", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteImage(@RequestParam(name = "id") String id) {

		dati.deleteApi(id);

		return new ResponseEntity<>("image is deleted", HttpStatus.OK);
	}

	/**
	 * Method that reply to the request POST/postCarouselAlbum.
	 * 
	 * @param album Album that the user wants to set to the collection.
	 * @see DataBase
	 * @return a message that the album is created.
	 */
	@RequestMapping(value = "postCarouselAlbum", method = RequestMethod.POST)
	public ResponseEntity<Object> postCarouselAlbum(@RequestBody Album album) {
		dati.addApi(album);
		return new ResponseEntity<>("album is created", HttpStatus.CREATED);
	}

	/**
	 * Method that reply to the request DELETE/deleteCarouselAlbum.
	 * 
	 * @param id Identify the Album to delete.
	 * @see DataBase
	 * @return a message that the album is deleted.
	 */
	@RequestMapping(value = "deleteCarouselAlbum", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCarouselAlbum(@RequestParam(name = "id") String id) {

		dati.deleteApi(id);

		return new ResponseEntity<>("album is deleted", HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getAllStatistics.
	 * 
	 * @see DataBase
	 * @return all statistics as string.
	 */
	@RequestMapping(value = "getAllStatistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getstats() {
		return new ResponseEntity<>( dati.getStats(), HttpStatus.OK);
	}
	/**
	 * Method that reply to the request GET/getAllStatisticsofFilter.
	 * @see DataBase
	 * @return all the statistics of filtered's images as string.
	 * @throws StatsNotFoundException 
	 */
	
	@RequestMapping(value = "getAllStatisticsofFilter", method = RequestMethod.GET)
	public ResponseEntity<Object> getstatsfilter() throws StatsNotFoundException {
		return new ResponseEntity<>( dati.getStatisticsFilter(), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getAverageOfBytes.
	 * 
	 * @see Database
	 * @return the average of bytes as string.
	 */
	@RequestMapping(value = "getAverageOfBytes", method = RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfBytes() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().getAverageOfBytes()), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getAverageOfPixel.
	 * 
	 * @return the average of pixel as string.
	 */
	@RequestMapping(value = "getAverageOfPixel", method = RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfPixel() {

		return new ResponseEntity<>(String.valueOf(dati.getStats().getAverageOfPixel()), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getMedianOfPixel.
	 * 
	 * @see DataBase.
	 * @return the median of pixels as string.
	 */
	@RequestMapping(value = "getMedianOfPixels", method = RequestMethod.GET)
	public ResponseEntity<Object> getMedianOfPixels() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().getMedianOfPixels()), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getAverageOfHashtag.
	 * 
	 * @return the average of hashtag as string.
	 */
	@RequestMapping(value = "getAverageOfHashtag", method = RequestMethod.GET)
	public ResponseEntity<Object> getAverageOfHashtag() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().getAverageOfHashtag()), HttpStatus.OK);
	}
	/**
	 * Method that reply to the request GET/getMedianOfBytes.
	 * 
	 * @see DataBase.
	 * @return the median of Bytes as string.
	 */
	@RequestMapping(value = "getMedianOfBytes", method = RequestMethod.GET)
	public ResponseEntity<Object> getMedianOfBytes() {
		return new ResponseEntity<>(String.valueOf((int)dati.getStats().getMedianOfBytes()), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getTotHashtag.
	 * 
	 * @see DataBase
	 * @return the total number of hashtag as string.
	 */
	@RequestMapping(value = "getTotHashtag", method = RequestMethod.GET)
	public ResponseEntity<Object> getTotHashtag() {
		return new ResponseEntity<>(String.valueOf(dati.getStats().getTotHashtag()), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getAllFilters
	 * 
	 * @see Database
	 * @return all the filters as string.
	 */
	@RequestMapping(value = "getAllFilters", method = RequestMethod.GET)
	public ResponseEntity<Object> getfilters() {
		dati.getSortPhotos();
		dati.getPhotoHashtag();
		return new ResponseEntity<>("immagini filtrate", HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/getFilters.
	 * 
	 * @param json String of json
	 * @return the filter that the user request with jolly character.
	 * @throws ParseException which is thrown if there is any problem in the process
	 *                        of parsing.
	 * @throws FilterNotFoundException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "getFilters", method = RequestMethod.GET)
	public ResponseEntity<Object> getSomeFilters2(@RequestBody String json) throws ParseException, NumberFormatException, FilterNotFoundException {

		return new ResponseEntity<>(dati.filterservice(json).getApi(), HttpStatus.OK);
	}

	/**
	 * Method that reply to the request GET/searchPhoto.
	 * 
	 * @param id Identify the photo to search.
	 * @return the photo requested by the user.
	 * @throws FilterNotFoundException 
	 */
	@RequestMapping(value = "searchPhoto", method = RequestMethod.GET)
	public ResponseEntity<Object> SearchPhoto(@RequestParam(name = "id") String id) throws FilterNotFoundException {
		return new ResponseEntity<>(dati.SearchPhotos(id), HttpStatus.OK);
	}

}
