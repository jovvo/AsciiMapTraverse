package amt.loader;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import amt.app.AsciiMapTraverseApplication;
import amt.loader.AsciiMapLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AsciiMapTraverseApplication.class)
public class AsciiMapLoaderTest {

	@Autowired
	private AsciiMapLoader asciiMapLoader;
	
	@Test
	public void loadAsciiMap() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample1.txt");
		assertNotNull(asciiMap);
		assertEquals(5, asciiMap.length);
		assertEquals(9, asciiMap[0].length);
		assertEquals('@', asciiMap[0][0]);
		assertEquals('+', asciiMap[4][8]);
	}
	
}
