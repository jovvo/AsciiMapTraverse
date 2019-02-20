package amt.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class AsciiMapLoader {

	public char[][] loadAsciiMap(String filePath) {
		char[][] asciiMap;
		File file;
		try {
			file = new ClassPathResource(filePath).getFile();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to load file.");
		}
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to load file.");
		}

		try {
			asciiMap = new char[countLines(file)][];
		} catch (IOException e) {
			scanner.close();
			throw new RuntimeException("Unable to count file lines.");
		}

		int lineNo = 0;
		while (scanner.hasNextLine()) {
			asciiMap[lineNo] = scanner.nextLine().toCharArray();
			lineNo++;
		}
		scanner.close();
		return asciiMap;
	}

	private static int countLines(File file) throws IOException {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to read number of lines.");
		}
		int lineCount = 0;
		while (reader.readLine() != null) {
			lineCount++;
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineCount;
	}

}
