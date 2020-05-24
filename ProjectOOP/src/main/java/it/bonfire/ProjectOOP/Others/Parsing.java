/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
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
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Exceptions.*;
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

	/**
	 * Description of the method GetJSONFromUrl.
	 */
	public HashSet<API_Instagram> GetAPIInstagramFromJson(JSONObject jsonObject) {
		HashSet<API_Instagram> collezione = new HashSet<>();

		JSONArray posizioni = (JSONArray) jsonObject.get("data");

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
				collezione.add(ciao);
			} else {
				Fotografia foto=new Fotografia(id, media_url);
				API_Instagram appoggio = (API_Instagram) new Image(id, caption, media_type,foto);
				collezione.add(appoggio);
			}
		}
		return collezione;
	}

	public void DownloadImage(HashSet<API_Instagram> collezione) throws IOException, ErrorFileException{

		try {
			Iterator<API_Instagram> l = collezione.iterator();

			while (l.hasNext()) {
				API_Instagram appoggio = l.next();
				if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
					Album util = (Album) appoggio;

					Iterator<Fotografia> p = util.getFotografias().iterator();
					while (p.hasNext()) {
						Fotografia a = p.next();
						URL url = new URL(a.getMedia_url());
						BufferedImage image = ImageIO.read(url);
						boolean o=new File("C:\\Users\\arian\\OneDrive\\Immagini\\Album" + N).mkdir();
						
						File file = new File(
								"C:\\Users\\arian\\OneDrive\\Immagini\\Album" + N + "\\" + a.getId_photos() + ".jpg");
						ImageIO.write(image, "jpg", file);
						BufferedImage image1 = ImageIO.read(file);
						byte[] fileContent = Files.readAllBytes(file.toPath());
						int bytes = fileContent.length;
						a.setnByte(bytes);
						int h= image1.getHeight();
						int w= image1.getWidth();
						a.setPixelHeight(h);
						a.setPixelWeight(w);
						
					}
					
				N++;
				}
				
					else {
					Image util1 = (Image) appoggio;
					String IO=util1.getFotografias().getMedia_url();
					URL url = new URL(IO);
					BufferedImage image = ImageIO.read(url);
					File file = new File("C:\\Users\\arian\\OneDrive\\Immagini\\" + util1.getId() + ".jpg");
					ImageIO.write(image, "jpg", file);
					BufferedImage image1 = ImageIO.read(file);
					byte[] fileContent = Files.readAllBytes(file.toPath());
					int bytes = fileContent.length;
					util1.getFotografias().setnByte(bytes);
					int h= image1.getHeight();
					int w= image1.getWidth();
					util1.getFotografias().setPixelHeight(h);
					util1.getFotografias().setPixelWeight(w);
					

				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
