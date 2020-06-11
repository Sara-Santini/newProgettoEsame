package application_Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import it.bonfire.ProjectOOP.Controller.DataBase;
import it.bonfire.ProjectOOP.Exceptions.FilterNotFoundException;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;

class JTest {
	
  public DataBase data;
  public Image image;
  public Album album;


	@BeforeEach
	void setUp() throws Exception {
		data=new DataBase();
		Photos foto=new Photos("17963418202137327", "https://scontent.cdninstagram.com/v/t51.2885-15/43914773_544273275994752_2221340766346393107_n.jpg?_nc_cat=108&_nc_sid=8ae9d6&_nc_ohc=a2O2SaubpHkAX_yKNy-&_nc_ht=scontent.cdninstagram.com&oh=90bb3428e81db69913056c8aabcc69c5&oe=5EF81E4A");
		foto.setPixelHeight(1080);
		foto.setPixelWide(1350);;
		foto.setnByte(144426);
		image=new Image("17963418202137327", "Un alba che nasce ai confini di un mondo migliore🏞", "IMAGE",foto );
		data.addApi(image);
		HashSet <Photos> photos = new HashSet<Photos>();
		Photos photo1=new Photos("17872742938318962","https://scontent.cdninstagram.com/v/t51.2885-15/52929473_530102834182818_7229678577976313998_n.jpg?_nc_cat=110&_nc_sid=8ae9d6&_nc_ohc=luOEmk44cEgAX8TJho7&_nc_ht=scontent.cdninstagram.com&oh=ca675ba9ff17cefa6bf0f8521946594e&oe=5EFB89C0");
		Photos photos2= new Photos("17851463515365484","https://scontent.cdninstagram.com/v/t51.2885-15/53123426_336001267020626_3492049144165672302_n.jpg?_nc_cat=104&_nc_sid=8ae9d6&_nc_ohc=5mBtYREdAIAAX-AD-Se&_nc_ht=scontent.cdninstagram.com&oh=1dd225528ebf553b2014c225bf439665&oe=5EFA2E31");
		photo1.setPixelHeight(768);
		photo1.setPixelWide(614);
		photo1.setnByte(74588);
		photos.add(photo1);	
		photos2.setPixelHeight(960);
		photos2.setPixelWide(768);
		photos2.setnByte(94343);
		photos.add(photos2);	
		album= new Album("18038680510033530","Il più grande spreco nel mondo è la differenza tra ciò che siamo e ciò che potremmo diventare.\\n#ancona" , "ALBUM", photos);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		assertAll("valori",()-> assertEquals("17963418202137327", image.getId()),
		()->assertEquals("Un alba che nasce ai confini di un mondo migliore🏞",image.getCaption()),
		()->assertEquals("IMAGE",image.getMedia_type()),
		()->assertEquals(144426,image.getPhotos().getnByte()),
		()-> assertEquals(1080,image.getPhotos().getPixelHeight()),
		()->assertEquals(1350,image.getPhotos().getPixelWide()),
		()-> assertNotNull(image.getPhotos().getMedia_Url()));
		}
	
	@Test
	void test2() {
		assertThrows(ResponseStatusException.class, ()->data.deleteApi("17963418202137328"));
	}
	@Test
	void test3() {
		assertThrows(ResponseStatusException.class,()->data.addApi(image));
	}
	@Test
	void test4() {
		assertTrue(data.deleteApi("17963418202137327"));
	}
	@Test
	void test5() {
		assertAll("valori",()-> assertEquals("18038680510033530",album.getId()),
				()->assertEquals("Il più grande spreco nel mondo è la differenza tra ciò che siamo e ciò che potremmo diventare.\\n#ancona", album.getCaption()),
				()->assertEquals("ALBUM", album.getMedia_type()),
				()->assertNotNull(album.getPhotos()));
	}
	@Test
	void test6() {
		assertNotSame(album, image);
	}
	@Test
	void test7() {
		assertThrows(FilterNotFoundException.class,()->data.SearchPhotos("178842938318964"));
	}
	@Test
	void test8() {
		assertThrows(FilterNotFoundException.class,()->data.filterservice("{ \"filter\": [ { \"field\": \"%\", \"param\": \"5\" }]}"));
	}
}


