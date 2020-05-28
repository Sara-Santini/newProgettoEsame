
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
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Description of Parsing.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 * 
 */
public class Parsing {
	public static int N = 1;
	HashSet<API_Instagram> collezione1 = new HashSet<>();
	private String dir="C:\\Users\\arian\\OneDrive\\Immagini";
	
	

	public String getDir() {
		return dir;
	}

	/**
	 * Description of the method GetJSONFromUrl.
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
				HashSet<Fotografia> fotografias = new HashSet<Fotografia>();
				JSONObject jsonprovo = (JSONObject) jsonObject.get("children");
				JSONArray album = (JSONArray) jsonprovo.get("data");
				for (int j = 0; j < album.size(); j++) {

					JSONObject jsonObject1 = (JSONObject) album.get(j);
					String albumid = (String) jsonObject1.get("id");

					fotografias.add(new Fotografia(albumid));

				}
				API_Instagram ciao = (API_Instagram) new Album(id, caption, media_type, fotografias);
				collezione1.add(ciao);
			} else {
				Fotografia foto = new Fotografia(id, media_url);
				API_Instagram appoggio = (API_Instagram) new Image(id, caption, media_type, foto);
				collezione1.add(appoggio);
			}
		}

//		if (urlString != null) {
//			Downloader DOW = new Downloader();
//			try {
//				JSONObject ciao = DOW.getJSONbyURL(urlString);
//				GetAPIInstagramFromJson(ciao);
//			} catch (IOException | ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
		return collezione1;

	}

	public void DownloadImage(HashSet<API_Instagram> collezione) throws IOException {

		try {
			Iterator<API_Instagram> l = collezione.iterator();

			while (l.hasNext()) {
				API_Instagram appoggio = l.next();
				if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
					Album util = (Album) appoggio;
					Download(util);
					
				}

				else {
					Image util1 = (Image) appoggio;
					Download(util1);

				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Download(Album album) {

		Iterator<Fotografia> p = album.getFotografias().iterator();
		while (p.hasNext()) {
			Fotografia a = p.next();
			URL url;
			try {
				url = new URL(a.getMedia_url());

				BufferedImage image = ImageIO.read(url);
				new File(dir+"\\Album" + N).mkdir();
				File file = new File(dir+ "\\Album" + N + "\\" + a.getId_photos() + ".jpg");
				ImageIO.write(image, "jpg", file);
				extractBytePixel(file, a);
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

	public void Download(Image image) throws IOException {
		String IO = image.getFotografias().getMedia_url();
		URL url = new URL(IO);
		BufferedImage image1 = ImageIO.read(url);
		File file = new File(dir+ "\\" + image.getId() + ".jpg");
		ImageIO.write(image1, "jpg", file);
		extractBytePixel(file, image.getFotografias());

	}

	public void extractBytePixel(File file, Fotografia foto) throws IOException {
		BufferedImage image1 = ImageIO.read(file);
		byte[] fileContent = Files.readAllBytes(file.toPath());
		int bytes = fileContent.length;
		foto.setnByte(bytes);
		int h = image1.getHeight();
		int w = image1.getWidth();
		foto.setPixelHeight(h);
		foto.setPixelWeight(w);
	}

}

