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
 * Description of StatsByte.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Statistics {
	private HashSet<API_Instagram> collezione= new HashSet<API_Instagram>();
	private Vector<Integer> bytes = new Vector<>();
	private Vector<Long> pixel = new Vector<>();

	/**
	 * @param collezione
	 */
	public Statistics(HashSet<API_Instagram> collezione) {
		this.collezione = collezione;
		if(collezione.isEmpty()) System.out.println( new StatsNotFoundException().getMessage());
		Iterator<API_Instagram> p = this.collezione.iterator();
		while (p.hasNext()) {
			API_Instagram appoggio = p.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Photos> a = album.getPhotos().iterator();

				while (a.hasNext()) {
					Photos appoggio1 = a.next();

					bytes.add((int) (appoggio1.getnByte() / 1024));
					pixel.add((long) (appoggio1.getPixelHeight() * appoggio1.getPixelWeight()));
				}
			} else {
				Image image = (Image) appoggio;
				bytes.add((int) (image.getPhotos().getnByte() / 1024));
				pixel.add((long) (image.getPhotos().getPixelHeight() * image.getPhotos().getPixelWeight()));

			}

		}
	}

	/**
	 * @return the collezione
	 */
	public HashSet<API_Instagram> getCollezione() {
		return collezione;
	}

	/**
	 * @param collezione the collezione to set
	 */
	public void setCollezione(HashSet<API_Instagram> collezione) {
		this.collezione = collezione;
	}

	/**
	 * @return the bytes
	 */
	public Vector<Integer> getBytes() {
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(Vector<Integer> bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the pixel
	 */
	public Vector<Long> getPixel() {
		return pixel;
	}

	/**
	 * @param pixel the pixel to set
	 */
	public void setPixel(Vector<Long> pixel) {
		this.pixel = pixel;
	}

	public float AverageOfBytes() {
		float somma = 0;
		for (int lb : bytes) {
			somma +=lb;
		}
		return somma / bytes.size();
	}


	public float AverageOfPixel() {
		float somma = 0;
		for (long lp : pixel) {
			somma += lp;
		}
		return somma / pixel.size();
	}
	public float MedianOfBytes() {
		Collections.sort(bytes);
		int median = (int) bytes.size() / 2;
		return bytes.get(median);
	}

	public long MedianOfPixels() {
		Collections.sort(pixel);
		int median = (int) pixel.size() / 2;
		return pixel.get(median);
	}

	public float AverageOfHashtag() {
		return TotHashtag() / (float) bytes.size();
	}

	public int TotHashtag() {
		Iterator<API_Instagram> p = collezione.iterator();
		int n = 0;
		while (p.hasNext()) {
			API_Instagram api = p.next();
			for (int i = 0; i < api.getCaption().length(); i++)
				if (api.getCaption().charAt(i) == '#')
					n++;
		}
		return n;
	}
	public float PixelVariance() {
		float average= AverageOfPixel();
		float somma=0;
		for(long pv: pixel) {
			somma=(float) Math.pow((pv-average),2);
		}
		return somma/pixel.size();
	}
	public float BytesVariance() {
		float average= AverageOfBytes();
		float somma=0;
		for(int bv: bytes) {
			somma=(float) Math.pow((bv-average),2);
		}
		return somma/bytes.size();
	}

	public String toString() {
		return "average byte: " + AverageOfBytes() + " average of pixels: " + AverageOfPixel() + " average of hashtag: "
				+ AverageOfHashtag() + "\n" + " median of bytes: " + MedianOfBytes() + " median of pixel: "
				+ MedianOfPixels() + "\n" + " total hashtags: " + TotHashtag() + "\n" +"pixel variance: " + PixelVariance()+"bytes variance: " + BytesVariance();
	}
}
