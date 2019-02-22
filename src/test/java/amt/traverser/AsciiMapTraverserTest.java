package amt.traverser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import amt.app.AsciiMapTraverseApplication;
import amt.loader.AsciiMapLoader;
import amt.model.AsciiMap;
import amt.traverser.AsciiMapPathTraverser;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AsciiMapTraverseApplication.class)
public class AsciiMapTraverserTest {

	@Autowired
	private AsciiMapLoader asciiMapLoader;
	
	@Autowired
	private AsciiMapPathTraverser asciiMapPathTraverser;
	
	@Test
	public void traverseAsciiMap1() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample1.txt");
		asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));
	}
	
	@Test
	public void traverseAsciiMap2() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample2.txt");
		asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));
	}
	
	@Test
	public void traverseAsciiMap3() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample3.txt");
		asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));
	}
}
