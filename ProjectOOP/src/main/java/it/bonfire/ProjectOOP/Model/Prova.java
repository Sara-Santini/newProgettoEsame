package it.bonfire.ProjectOOP.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.util.HashSet;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;

import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Downloader ciao = new Downloader();
		try {
			 JSONObject cane = ciao.getJSONbyURL("https://graph.instagram.com/me/media?fields=id,media_type,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD");
		   Parsing gatto=new Parsing();
		    HashSet<API_Instagram> topo= gatto.GetAPIInstagramFromJson(cane);
		   ciao.getImageAlbumUrl(topo);
		
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*try {
			ciao.DownloadImage("https://scontent-mxp1-1.cdninstagram.com/v/t51.2885-15/53123426_336001267020626_3492049144165672302_n.jpg?_nc_cat=104&_nc_sid=8ae9d6&_nc_ohc=jGizn3wieXAAX-IYDWi&_nc_ht=scontent-mxp1-1.cdninstagram.com&oh=8a3ab649c0a97c5e3bb6b1cafaf5f66b&oe=5EEA5C31");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
//		try {
//			int cd= ciao.extractBytes();
//			System.out.println(cd);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/*try {
			cd=ciao.extractBytes("https://scontent-mxp1-1.cdninstagram.com/v/t51.2885-15/97297461_170388064432065_4758196192107223142_n.jpg?_nc_cat=106&_nc_sid=8ae9d6&_nc_ohc=wwG80nTknawAX_neCvj&_nc_ht=scontent-mxp1-1.cdninstagram.com&oh=5db1193ecce934182162e9a1d9d04e00&oe=5EEA2607");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
}}
