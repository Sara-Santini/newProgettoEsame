package it.bonfire.ProjectOOP.Others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.HashSet;

import it.bonfire.ProjectOOP.Model.API_Instagram;

import javax.imageio.ImageIO;

public class GetImagebytes {
	private Parsing pars = new Parsing();

	public GetImagebytes(Parsing pars) {

		this.pars = pars;
	}

	public Parsing getPars() {
		return pars;
	}

	public void setPars(Parsing pars) {
		this.pars = pars;
	}

	public int extractBytes(HashSet<API_Instagram> collezione) throws IOException { // open image try(File imgPath = new
																					// URL(url).openStream()) {
		Iterator<API_Instagram> c = collezione.iterator();
		File fi = new File(pars.getDir() + "\\pippo.jpg");
		BufferedImage image = ImageIO.read(fi);
		byte[] fileContent = Files.readAllBytes(fi.toPath());

		return fileContent.length;
	}

}
