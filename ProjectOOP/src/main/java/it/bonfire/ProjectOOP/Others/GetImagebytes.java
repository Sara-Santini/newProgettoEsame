package it.bonfire.ProjectOOP.Others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;
import java.net.URL;
import java.util.HashSet;

import it.bonfire.ProjectOOP.Model.API_Instagram;

import javax.imageio.ImageIO;

public class GetImagebytes {
	Parsing pars;
	public int extractBytes (HashSet<API_Instagram> collezione) throws IOException { // open image try(File imgPath = new URL(url).openStream()) {
	   Iterator<API_Instagram> c = collezione.iterator(); 
	   File fi = new File(pars.getDir()+"\\pippo.jpg");
	   BufferedImage image = ImageIO.read(fi);
	   byte[] fileContent = Files.readAllBytes(fi.toPath());

	 

	 

	return fileContent.length; } 

}
