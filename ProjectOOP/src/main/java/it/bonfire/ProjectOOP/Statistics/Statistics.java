/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Statistics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import it.bonfire.ProjectOOP.Exceptions.StatsNotFoundException;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Class in which are described the statistics that the user can makes with the
 * collection.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Statistics {
	/**
	 * New collection of API_Instagram.
	 */
	private HashSet<API_Instagram> collezione = new HashSet<API_Instagram>();
	/**
	 * New collection of Bytes.
	 */
	private Vector<Integer> bytes = new Vector<>();
	/**
	 * New collection of pixel.
	 */
	private Vector<Long> pixel = new Vector<>();

	/**
	 * The Constructor.
	 * 
	 * @see API_Instagram.
	 * @see Image.
	 * @see Photos.
	 * @see Album.
	 * @param collezione New collection of API_Instagram.
	 */
	public Statistics(HashSet<API_Instagram> collezione) {
		this.collezione = collezione;
		if (collezione.isEmpty())
			System.out.println(new StatsNotFoundException().getMessage());
		Iterator<API_Instagram> p = this.collezione.iterator();
		while (p.hasNext()) {
			API_Instagram appoggio = p.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Photos> a = album.getPhotos().iterator();

				while (a.hasNext()) {
					Photos appoggio1 = a.next();

					bytes.add((int) (appoggio1.getnByte() / 1024));
					pixel.add((long) (appoggio1.getPixelHeight() * appoggio1.getPixelWide()));
				}
			} else {
				Image image = (Image) appoggio;
				bytes.add((int) (image.getPhotos().getnByte() / 1024));
				pixel.add((long) (image.getPhotos().getPixelHeight() * image.getPhotos().getPixelWide()));

			}

		}
	}

	/**
	 * Method that gives back the collection of API_Instagram.
	 * 
	 * @return HashSet<API_Instagram>
	 */
	public HashSet<API_Instagram> getCollezione() {
		return collezione;
	}

	/**
	 * Method which sets a value to attribute to collection.
	 * 
	 * @param collezione the collection to set
	 */
	public void setCollezione(HashSet<API_Instagram> collezione) {
		this.collezione = collezione;
	}

	/**
	 * Method that gives back the bytes of an image.
	 * 
	 * @return the bytes
	 */
	public Vector<Integer> getBytes() {
		return bytes;
	}

	/**
	 * Method which sets a value to attribute to bytes.
	 * 
	 * @param bytes the bytes to set
	 */
	public void setBytes(Vector<Integer> bytes) {
		this.bytes = bytes;
	}

	/**
	 * Method that gives back the number of Bytes of an image.
	 * 
	 * @return the pixel
	 */
	public Vector<Long> getPixel() {
		return pixel;
	}

	/**
	 * Method which sets a value to attribute to pixel.
	 * 
	 * @param pixel the pixel to set
	 */
	public void setPixel(Vector<Long> pixel) {
		this.pixel = pixel;
	}

	/**
	 * Method that gives back the average of bytes.
	 * 
	 * @return float
	 */
	public float AverageOfBytes() {
		float somma = 0;
		for (int lb : bytes) {
			somma += lb;
		}
		return somma / bytes.size();
	}

	/**
	 * Method that gives back the average of pixel.
	 * 
	 * @return float
	 */
	public float AverageOfPixel() {
		float somma = 0;
		for (long lp : pixel) {
			somma += lp;
		}
		return somma / pixel.size();
	}

	/**
	 * Method that gives back the median of bytes.
	 * 
	 * @return float
	 * 
	 */
	public int MedianOfBytes() {
		Collections.sort(bytes);
		int median = (int) bytes.size() / 2;
		return bytes.get(median);
	}

	/**
	 * Method that gives back the median of pixel.
	 * 
	 * @return long
	 * 
	 */
	public long MedianOfPixels() {
		Collections.sort(pixel);
		int median = (int) pixel.size() / 2;
		return pixel.get(median);
	}

	/**
	 * Method that gives back the average of hashtag.
	 * 
	 * @return float
	 * 
	 */
	public float AverageOfHashtag() {
		return TotHashtag() / (float) bytes.size();
	}

	/**
	 * Method that gives back the total number of hashtag in the collection.
	 * 
	 * @see API_Instagram
	 * @return Integer
	 */
	public int TotHashtag() {
		Iterator<API_Instagram> p = collezione.iterator();
		int n = 0;
		while (p.hasNext()) {
			API_Instagram api = p.next();
			if(api.getCaption()!=null) {
			for (int i = 0; i < api.getCaption().length(); i++)
				if (api.getCaption().charAt(i) == '#')
					n++;
		}
		}
		return n;
	}

	/**
	 * Method that gives back the variance of pixels.
	 * 
	 * @see AverageOfPixel.
	 * @return float.
	 */
	public float PixelVariance() {
		float average = AverageOfPixel();
		float somma = 0;
		for (long pv : pixel) {
			somma = (float) Math.pow((pv - average), 2);
		}
		return somma / pixel.size();
	}

	/**
	 * Method that gives back the variance of bytes.
	 * 
	 * @see AverageOfBytes
	 * @return float.
	 */
	public float BytesVariance() {
		float average = AverageOfBytes();
		float somma = 0;
		for (int bv : bytes) {
			somma = (float) Math.pow((bv - average), 2);
		}
		return somma / bytes.size();
	}

	/**
	 * Methods which gives back the string of Statistics.
	 * 
	 * @return String.
	 */

	public String toString() {
		return "Average byte: " + AverageOfBytes() + " Average of pixels: " + AverageOfPixel() + " Average of hashtag: "
				+ AverageOfHashtag() + "\n" + " Median of bytes: " + MedianOfBytes() + " Median of pixel: "
				+ MedianOfPixels() + "\n" + " Total hashtags: " + TotHashtag()+ "\n" 
				+ "Pixel variance: "
				+ PixelVariance() + "Bytes variance: " + BytesVariance();
	}
}
