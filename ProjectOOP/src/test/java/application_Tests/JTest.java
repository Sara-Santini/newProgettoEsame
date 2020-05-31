package application_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.bonfire.ProjectOOP.Controller.DataBase;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;

class JTest {
	
DataBase data;
Image image;

	@BeforeEach
	void setUp() throws Exception {
		data=new DataBase();
		Fotografia foto=new Fotografia("17963418202137327", "https://scontent.cdninstagram.com/v/t51.2885-15/43914773_544273275994752_2221340766346393107_n.jpg?_nc_cat=108&_nc_sid=8ae9d6&_nc_ohc=a2O2SaubpHkAX_yKNy-&_nc_ht=scontent.cdninstagram.com&oh=90bb3428e81db69913056c8aabcc69c5&oe=5EF81E4A");
		foto.setPixelHeight(1080);
		foto.setPixelWeight(1350);
		foto.setnByte(144426);
		image=new Image("17963418202137327", "Un alba che nasce ai confini di un mondo migliore🏞", "IMAGE",foto );
		data.addApi(image);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
	}}

}