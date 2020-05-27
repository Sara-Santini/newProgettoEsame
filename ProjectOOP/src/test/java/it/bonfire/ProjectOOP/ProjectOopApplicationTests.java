package it.bonfire.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Others.Downloader;

@SpringBootTest
class ProjectOopApplicationTests {
	
	@Autowired
	Downloader d = new Downloader();
	Fotografia f = new Fotografia("123457865432");

	@Test
	void test1() {
	assertNull(d.getURL(f.getId_photos()));
	}
	

}
