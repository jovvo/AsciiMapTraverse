package amt.model;

import java.util.ArrayList;
import java.util.List;

public class AsciiMapTraverseResult {
	
	private List<Character> traversedLetters = new ArrayList<>();
	private List<Character> traversedPath = new ArrayList<>();
	public List<Character> getTraversedLetters() {
		return traversedLetters;
	}
	public void setTraversedLetters(List<Character> traversedLetters) {
		this.traversedLetters = traversedLetters;
	}
	public List<Character> getTraversedPath() {
		return traversedPath;
	}
	public void setTraversedPath(List<Character> traversedPath) {
		this.traversedPath = traversedPath;
	}
	
}
