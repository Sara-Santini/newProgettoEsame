package it.bonfire.ProjectOOP.Statistics;

import java.util.HashSet;

import it.bonfire.ProjectOOP.Exceptions.StatsNotFoundException;
import it.bonfire.ProjectOOP.Model.API_Instagram;


public class StatisticService {
	private float  AverageOfBytes; 
	private float AverageOfPixel;
	private float AverageOfHashtag; 
    private int MedianOfBytes;
    private long  MedianOfPixels;
    private int TotHashtag;
    private double PixelVariance;
    private float BytesVariance;
    


	public StatisticService(HashSet<API_Instagram> api ) throws StatsNotFoundException {
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



	@Override
	public String toString() {
		return "StatisticService [AverageOfBytes=" + AverageOfBytes + ", AverageOfPixel=" + AverageOfPixel
				+ ", AverageOfHashtag=" + AverageOfHashtag + ", MedianOfBytes=" + MedianOfBytes + ", MedianOfPixels="
				+ MedianOfPixels + ", TotHashtag=" + TotHashtag + ", PixelVariance=" + PixelVariance
				+ ", BytesVariance=" + BytesVariance + "]";
	}



	public float getAverageOfBytes() {
		return AverageOfBytes;
	}



	public float getAverageOfPixel() {
		return AverageOfPixel;
	}



	public float getAverageOfHashtag() {
		return AverageOfHashtag;
	}



	public int getMedianOfBytes() {
		return MedianOfBytes;
	}



	public long getMedianOfPixels() {
		return MedianOfPixels;
	}



	public int getTotHashtag() {
		return TotHashtag;
	}



	public double getPixelVariance() {
		return PixelVariance;
	}



	public float getBytesVariance() {
		return BytesVariance;
	}
}
