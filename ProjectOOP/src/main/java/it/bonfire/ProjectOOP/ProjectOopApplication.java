package it.bonfire.ProjectOOP;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.bonfire.ProjectOOP.Others.Parsing;

@SpringBootApplication
public class ProjectOopApplication {

	public static void main(String[] args) {
		int scelta;
		  String dir = JOptionPane.showInputDialog("Inserisci una directory","C:\\Users\\39346\\Pictures");
		    String token=JOptionPane.showInputDialog("Inserisci il token","IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD");
		    String path="";
		  scelta=JOptionPane.showConfirmDialog(null ,"IL sistema operativo Windows?", "Scelta",JOptionPane.YES_NO_OPTION);
		  if( JOptionPane.YES_OPTION==scelta ) path="\\" ;
		  else if(JOptionPane.NO_OPTION==scelta) path= "/" ;
		  else JOptionPane.showMessageDialog(null, "scelta non valida");
		  Parsing parsing=new Parsing(dir,path,token);
		SpringApplication.run(ProjectOopApplication.class, args);
	}

}
