package it.bonfire.ProjectOOP.Model;

import java.io.IOException;
import java.util.HashSet;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import it.bonfire.ProjectOOP.Filters.Filter;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;


public class MainDowImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Downloader load = new Downloader();
		  int scelta;
		  String dir = JOptionPane.showInputDialog("Inserisci una directory");
		  String path="";
		  scelta=JOptionPane.showConfirmDialog(null ,"IL sistema operativo Windows?", "Scelta",JOptionPane.YES_NO_OPTION);
		  if( JOptionPane.YES_OPTION==scelta ) path="\\" ;
		  else if(JOptionPane.NO_OPTION==scelta) path= "/" ;
		  else JOptionPane.showMessageDialog(null, "scelta non valida");
		try {
		
			JSONObject obj = load.getJSONbyURL("https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD");
			Parsing pars = new Parsing(dir,path);
			HashSet<API_Instagram> api_insta = pars.GetAPIInstagramFromJson(obj);
			load.getImageAlbumUrl(api_insta);
			pars.DownloadImage(api_insta);
			Filter filter=new Filter();
//			filter.dowPhotosWithHashtag(api_insta);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
