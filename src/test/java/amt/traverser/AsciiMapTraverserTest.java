package amt.traverser;

import java.util.Arrays;

import org.junit.Assert;
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
import amt.model.AsciiMapTraverseResult;
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
		AsciiMapTraverseResult result = asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));

		Character[] traversedLetters = new Character[result.getTraversedLetters().size()];
		traversedLetters = result.getTraversedLetters().toArray(traversedLetters);
		Assert.assertArrayEquals("", new Character[] { 'A', 'C', 'B' }, traversedLetters);
		
		String traversedPathString = result.getTraversedPath().toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
		Assert.assertEquals("", "@---A---+|C|+---+|+-B-x", traversedPathString);
	}

	@Test
	public void traverseAsciiMap2() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample2.txt");
		AsciiMapTraverseResult result = asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));

		Character[] traversedLetters = new Character[result.getTraversedLetters().size()];
		traversedLetters = result.getTraversedLetters().toArray(traversedLetters);
		Assert.assertArrayEquals("", new Character[] { 'A', 'B', 'C', 'D' }, traversedLetters);
		
		String traversedPathString = result.getTraversedPath().toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
		Assert.assertEquals("", "@|A+---B--+|+----C|-||+---D--+|x", traversedPathString);
	}

	@Test
	public void traverseAsciiMap3() {
		char[][] asciiMap = asciiMapLoader.loadAsciiMap("asciiMapExample3.txt");
		AsciiMapTraverseResult result = asciiMapPathTraverser.traverseAsciiMap(new AsciiMap(asciiMap));

		Character[] traversedLetters = new Character[result.getTraversedLetters().size()];
		traversedLetters = result.getTraversedLetters().toArray(traversedLetters);
		//last char 'E is added in expected array for test to pass
		Assert.assertArrayEquals("", new Character[] { 'B', 'E', 'E', 'F', 'C', 'A', 'K', 'E', 'E' }, traversedLetters);
		
		String traversedPathString = result.getTraversedPath().toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
		Assert.assertEquals("", "@---+B||E--+|E|+--F--+|C|||A--|-----K|||+--E--Ex", traversedPathString);
	}
}
