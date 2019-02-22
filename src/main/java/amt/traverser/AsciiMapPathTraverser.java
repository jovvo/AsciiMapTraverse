package amt.traverser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import amt.model.AsciiMap;
import amt.model.AsciiMapTraverseResult;
import amt.model.Coord;

@Component
public class AsciiMapPathTraverser {
	
	private List<Character> traversedLetters;
	private List<Character> traversedPath;
	
	public AsciiMapTraverseResult traverseAsciiMap(AsciiMap asciiMap) {
		traversedLetters = new ArrayList<>();
		traversedPath = new ArrayList<>();
		
		Coord startCoord = findStartCoord(asciiMap);
		int retValue = followPath(asciiMap, null, startCoord);
		if (retValue == 0) {
			AsciiMapTraverseResult result = new AsciiMapTraverseResult();
			result.setTraversedLetters(traversedLetters);
			result.setTraversedPath(traversedPath);
			return result;
		}
		throw new RuntimeException("Error occured. Please check logs.");
	}
	
	private int followPath(AsciiMap asciiMap, Coord previous, Coord current) {
		char currentVal = asciiMap.getAsciiMap()[current.getI()][current.getJ()];
		
		if (currentVal == ' ') {
			throw new RuntimeException("Can not jump to empty field.");
		}
		
		traversedPath.add(currentVal);
		if (Character.isLetter(currentVal) && currentVal != 'x') {
			traversedLetters.add(currentVal);
		}
		
		Coord nextCoord = null;
		
		if(currentVal == 'x') {
			System.out.println("end of path reached");
			return 0;
		}

		if (previous == null) {
			//find first step (previous is null so direction is unknown)
			
			if (asciiMap.getValue(current.goDown()) != ' ') {
				nextCoord = current.goDown();
			}else if (asciiMap.getValue(current.goLeft()) != ' ') {
				nextCoord = current.goLeft();
			}else if (asciiMap.getValue(current.goRight()) != ' ') {
				nextCoord = current.goRight();
			}else if (asciiMap.getValue(current.goUp()) != ' ') {
				nextCoord = current.goUp();
			}
			if (nextCoord == null) {
				throw new RuntimeException("Unable to find valid path.");
			}
		} else if (currentVal == '-' || currentVal == '|' || Character.isLetter(currentVal)) {
			//try to follow direction
			if(current.getI() > previous.getI()) {
				nextCoord = new Coord(current.getI() + 1, current.getJ());
			} else if (current.getI() < previous.getI()){
				nextCoord = new Coord(current.getI() - 1, current.getJ());
			}else if (current.getJ() > previous.getJ()){
				nextCoord = new Coord(current.getI(), current.getJ() + 1);
			}else if (current.getJ() < previous.getJ()){
				nextCoord = new Coord(current.getI(), current.getJ() - 1);
			}
			
			if (nextCoord == null || Character.isWhitespace(asciiMap.getValue(nextCoord))) {
				nextCoord = changeDirection(asciiMap, previous, current);
			}
		}else if (currentVal == '+') {
			//try to change direction
			nextCoord = changeDirection(asciiMap, previous, current);
		}

		//validate next position is found
		if (nextCoord == null) {
			throw new RuntimeException("Unable to find valid path.");
		}
		
		return followPath(asciiMap, current, nextCoord);
		
		}

	private Coord changeDirection(AsciiMap asciiMap, Coord previous, Coord current) {
		if(current.getI() == previous.getI()) {
			//change i coord
			if(!Character.isWhitespace(asciiMap.getValue(new Coord(current.getI() + 1, current.getJ())))) {
				return new Coord(current.getI() + 1, current.getJ());
			} else if (!Character.isWhitespace(asciiMap.getValue(new Coord(current.getI() - 1, current.getJ())))){
				return new Coord(current.getI() - 1, current.getJ());
			}
			//nextCoord = new Coord(current.getI() + 1, current.getJ());
		} else if (current.getJ() == previous.getJ()){
			//change j coord
			if(!Character.isWhitespace(asciiMap.getValue(new Coord(current.getI(), current.getJ() + 1)))) {
				return new Coord(current.getI(), current.getJ() + 1);
			} else if (!Character.isWhitespace(asciiMap.getValue(new Coord(current.getI(), current.getJ() - 1)))){
				return new Coord(current.getI(), current.getJ() - 1);
			}				
		}
		return null;
	}	

	private Coord findStartCoord(AsciiMap asciiMap) {
		for (int i = 0; i < asciiMap.getAsciiMap().length; i++) {
			for (int j = 0; j < asciiMap.getAsciiMap()[i].length; j++) {
				if (asciiMap.getValue(new Coord(i, j)) == '@') {
					return new Coord(i, j);
				}
			}
		}
		throw new RuntimeException("Unable to find start position.");
	}

}

