package it.bonfire.ProjectOOP.Statistics;

import java.util.HashSet;

import it.bonfire.ProjectOOP.Exceptions.StatsNotFoundException;
import it.bonfire.ProjectOOP.Model.API_Instagram;

/**
 * Class that manages all the requests of statistics.
 * @author Francesco Voto
 * @author Sara santini
 * @author Arianna Nazzarelli
 *
 */

public class StatisticService {
	/**
	 * It is the average of bytes of the photos of the collection.
	 */
	private float  AverageOfBytes;
	/**
	 * It is the average of pixel of the photos of the collection.
	 */
	private float AverageOfPixel;
	/**
	 * It is the average of Hashtag of the photos of the collection.
	 */
	private float AverageOfHashtag; 
	/**
	 * It is the median of bytes of the photos of the collection.
	 */
    private int MedianOfBytes;
    /**
     * It is the median of pixel of the photos of the collection.
     */
    private long  MedianOfPixels;
    /**
     * It is the total of hashtag of the photos of the collection.
     */
    private int TotHashtag;
    /**
     * It is the variance of pixels of the photos of the collection.
     */
    private double PixelVariance;
    /**
     * It is the variance of bytes of the photos of the collection.
     */
    private float BytesVariance;
    

/**
 * The Constructor.
 * @param api Collection of API_Instagram.
 */
	public StatisticService(HashSet<API_Instagram> api ) throws StatsNotFoundException{
		Statistics stats= new Statistics(api);
		AverageOfBytes= stats.AverageOfBytes();
		AverageOfPixel= stats.AverageOfPixel();
		AverageOfHashtag=stats.AverageOfHashtag();
		MedianOfBytes=stats.MedianOfBytes();
		MedianOfPixels=stats.MedianOfPixels();
		TotHashtag=stats.TotHashtag();
		PixelVariance=stats.PixelVariance();
		BytesVariance=stats.BytesVariance();
		}

	/**
	 * Methods which gives back the string of StatisticService.
	 * 
	 * @return String.
	 */

	@Override
	public String toString() {
		return "StatisticService [AverageOfBytes=" + AverageOfBytes + ", AverageOfPixel=" + AverageOfPixel
				+ ", AverageOfHashtag=" + AverageOfHashtag + ", MedianOfBytes=" + MedianOfBytes + ", MedianOfPixels="
				+ MedianOfPixels + ", TotHashtag=" + TotHashtag + ", PixelVariance=" + PixelVariance
				+ ", BytesVariance=" + BytesVariance + "]";
	}

/**
 * Method that gives back the average of bytes.
 * @return the average of bytes.
 */

	public float getAverageOfBytes() {
		return AverageOfBytes;
	}


/**
 * Method that gives back a average of Pixel.
 * @return the average of bytes.
 */
	public float getAverageOfPixel() {
		return AverageOfPixel;
	}


/**
 * Method that gives back the average of hashtag.
 * @return the average of hashtag.
 */
	public float getAverageOfHashtag() {
		return AverageOfHashtag;
	}


	/**
	 * Method that gives back the median of bytes.
	 * @return the median of bytes.
	 */
	public int getMedianOfBytes() {
		return MedianOfBytes;
	}


/**
 * Method that gives back the median of pixel.
 * @return the median of pixel.
 */
	public long getMedianOfPixels() {
		return MedianOfPixels;
	}


/**
 * Method that gives back the total number of hashtag.
 * @return the total number of hashtag.
 */
	public int getTotHashtag() {
		return TotHashtag;
	}


/**
 * Method that gives back the variance of pixel.
 * @return the variance of pixel.
 */
	public double getPixelVariance() {
		return PixelVariance;
	}


/**
 * Method that gives back the variance of bytes.
 * @return the variance of bytes.
 */
	public float getBytesVariance() {
		return BytesVariance;
	}
}

