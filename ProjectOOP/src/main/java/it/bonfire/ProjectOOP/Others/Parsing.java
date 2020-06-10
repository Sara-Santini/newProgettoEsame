
package it.bonfire.ProjectOOP.Others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Class which describes the conversion from JSON to an object.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 * 
 */
public class Parsing {
	private int N = 1;

	/**
	 * New collection of API_Instagram
	 */
	HashSet<API_Instagram> collezione1 = new HashSet<>();
	/**
	 * Directory for the downloaded images.
	 */
	private  String dir = "C:\\Users\\39346\\Pictures";
	public String dirOk;
	private  String  path = "\\";

	/**
	 * Method which sets a value to attribute to dir.
	 * 
	 * @param dir
	 */
	public Parsing(String dir,String path) {
	   this.dir=dir;
		this.path = path;
	}
	public Parsing() {
	    
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * Method that gives back the dir.
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * It is a method which adds to the collection the photos of Instagram from a
	 * JSONObject.
	 * 
	 * @see API_Instagram
	 * @see Downloader
	 * @see Photos
	 * @see Album
	 * @see getJSONbyURL
	 * @exception IOException    which is thrown if there is any problem in the
	 *                           process of input/output.
	 * @exception ParseException which is thrown if there is any problem in the
	 *                           process of parsing.
	 * @param jsonObject
	 */
	public HashSet<API_Instagram> GetAPIInstagramFromJson(JSONObject jsonObject) {

		JSONArray posizioni = (JSONArray) jsonObject.get("data");
		JSONObject next = (JSONObject) jsonObject.get("paging");
		String urlString = (String) next.get("next");

		for (int i = 0; i < posizioni.size(); i++) {
			jsonObject = (JSONObject) posizioni.get(i);
			String id = (String) jsonObject.get("id");
			String caption = (String) jsonObject.get("caption");
			String media_type = (String) jsonObject.get("media_type");
			String media_url = (String) jsonObject.get("media_url");

			if (media_type.equals("CAROUSEL_ALBUM")) {
				HashSet<Photos> photos = new HashSet<Photos>();
				JSONObject jsonprovo = (JSONObject) jsonObject.get("children");
				JSONArray album = (JSONArray) jsonprovo.get("data");
				for (int j = 0; j < album.size(); j++) {

					JSONObject jsonObject1 = (JSONObject) album.get(j);
					String albumid = (String) jsonObject1.get("id");

					photos.add(new Photos(albumid));

				}
				API_Instagram ciao = (API_Instagram) new Album(id, caption, media_type, photos);
				collezione1.add(ciao);
			} else {
				Photos foto = new Photos(id, media_url);
				API_Instagram appoggio = (API_Instagram) new Image(id, caption, media_type, foto);
				collezione1.add(appoggio);
			}
		}

//		if (urlString != null) {
//			try {
//				Downloader DOW = new Downloader();
//
//				JSONObject ciao = DOW.getJSONbyURL(urlString);
//				GetAPIInstagramFromJson(ciao);
//			} catch (IOException | ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//
//			}
//
//		}
		return collezione1;
	}

	/**
	 * It is a method which places images, that are already downloaded, of the
	 * collection on a specific directory.
	 * 
	 * @see API_Instagram.
	 * @see Album.
	 * @see Download.
	 * @see Image.
	 * @param collezione which is a collection of API_Instagram and it contains all
	 *                   the photos of the API.
	 * @exception IOException           which is thrown if there is any problem in
	 *                                  the process of input/output.
	 * @exception MalformedURLException which is thrown if there is any problem in
	 *                                  the input of an URL.
	 * 
	 */
	public void DownloadImage(HashSet<API_Instagram> collezione) {

		try {
			Iterator<API_Instagram> l = collezione.iterator();

			while (l.hasNext()) {
				API_Instagram appoggio = l.next();
				if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
					Album util = (Album) appoggio;
					if (!util.getPhotos().isEmpty()) {
						new File(dir + path + "Album" + N).mkdir();
						File file = new File(dir + path + "Album" + N);
						Download(util, file);
					}

				}

				else {
					Image util1 = (Image) appoggio;
					File file = new File(dir + path + util1.getId() + ".jpg");
					Download(util1, file);

				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method that downloads the images of an album of the API.
	 * 
	 * @see extractPixelBytes
	 * @see Album.
	 * @see File.
	 * @param album
	 * @param file
	 * @exception IOException    which is thrown if there is any problem in the
	 *                           process of input/output.
	 * @exception ParseException which is thrown if there is any problem in the
	 *                           process of parsing.
	 */
	public void Download(Album album, File file) {

		Iterator<Photos> p = album.getPhotos().iterator();
		while (p.hasNext()) {
			Photos a = p.next();
			URL url;
			try {
				url = new URL(a.getMedia_Url());

				BufferedImage image = ImageIO.read(url);

				File file2 = new File(file.getPath() + path + a.getId_Photos() + ".jpg");
				ImageIO.write(image, "jpg", file2);
				extractBytePixel(file2, a);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		N++;

	}

	/**
	 * Method that downloads the images of the API.
	 * 
	 * @param image The image that the method downloads.
	 * @param file  The file in which the user wants to be used to download the
	 *              image.
	 * @see Image.
	 * @see extractBytePixel.
	 * @throws IOException which is thrown if there is any problem in the process of
	 *                     input/output.
	 */
	public void Download(Image image, File file) throws IOException {
		String IO = image.getPhotos().getMedia_Url();
		URL url = new URL(IO);
		BufferedImage image1 = ImageIO.read(url);
		ImageIO.write(image1, "jpg", file);
		extractBytePixel(file, image.getPhotos());

	}

	/**
	 * Method that reads the weight and the height of pixels of an image and it sets
	 * the value to the parameters PixelHeight and PixelWeight of a photos.
	 * 
	 * @param file The file which is occupy by the image.
	 * @param foto The photo from which the user wants to know about pixels.
	 * @throws IOException which is thrown if there is any problem in the process of
	 *                     input/output.
	 */
	public void extractBytePixel(File file, Photos foto) throws IOException {
		BufferedImage image1 = ImageIO.read(file);
		byte[] fileContent = Files.readAllBytes(file.toPath());
		int bytes = fileContent.length;
		foto.setnByte(bytes);
		int h = image1.getHeight();
		int w = image1.getWidth();
		foto.setPixelHeight(h);
		foto.setPixelWide(w);
	}

	/**
	 * Method that gives back the N.
	 * 
	 * @return the n
	 */
	public int getN() {
		return N;
	}

	/**
	 * Methods that gives back the Collezione1.
	 * 
	 * @return the collezione1
	 */
	public HashSet<API_Instagram> getCollezione1() {
		return collezione1;
	}

	/**
	 * Method that gives back the path.
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
}
