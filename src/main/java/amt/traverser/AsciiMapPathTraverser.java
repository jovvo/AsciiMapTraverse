package amt.traverser;

import org.springframework.stereotype.Component;

import amt.model.AsciiMap;
import amt.model.Coord;

@Component
public class AsciiMapPathTraverser {
	
	public void traverseAsciiMap(AsciiMap asciiMap) {
		Coord startCoord = findStartCoord(asciiMap);
		followPath(asciiMap, null, startCoord);
	}
	
	private void followPath(AsciiMap asciiMap, Coord previous, Coord current) {
		char currentVal = asciiMap.getAsciiMap()[current.getI()][current.getJ()];
		System.out.println(currentVal);
		
		Coord nextCoord = null;
		
		if (currentVal == ' ') {
			throw new RuntimeException("Can not jump to empty field.");
		}
		
		char previousVal = ' ';
		if (previous != null) {
			previousVal = asciiMap.getAsciiMap()[previous.getI()][previous.getJ()];	
		}else {
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
			followPath(asciiMap, current, nextCoord);
				
		} 		 
		
		
		
		if(currentVal == 'x') {
			System.out.println("end of path reached");
			return;
		}else if (currentVal == '-' || currentVal == '|' || Character.isLetter(currentVal)) {
			//TODO follow direction
			if(current.getI() > previous.getI()) {
				nextCoord = new Coord(current.getI() + 1, current.getJ());
			} else if (current.getI() < previous.getI()){
				nextCoord = new Coord(current.getI() - 1, current.getJ());
			}else if (current.getJ() > previous.getJ()){
				nextCoord = new Coord(current.getI(), current.getJ() + 1);
			}else if (current.getJ() < previous.getJ()){
				nextCoord = new Coord(current.getI(), current.getJ() - 1);
			}
			
		}else if (currentVal == '+') {
			//TODO change direction
			if(current.getI() == previous.getI()) {
				//change i coord
				if(asciiMap.getValue(new Coord(current.getI() + 1, current.getJ())) != ' ') {
					nextCoord = new Coord(current.getI() + 1, current.getJ());
				} else if (asciiMap.getValue(new Coord(current.getI() - 1, current.getJ())) != ' '){
					nextCoord = new Coord(current.getI() - 1, current.getJ());
				}
				//nextCoord = new Coord(current.getI() + 1, current.getJ());
			} else if (current.getJ() == previous.getJ()){
				//change j coord
				if(asciiMap.getValue(new Coord(current.getI(), current.getJ() + 1)) != ' ') {
					nextCoord = new Coord(current.getI(), current.getJ() + 1);
				} else if (asciiMap.getValue(new Coord(current.getI(), current.getJ() - 1)) != ' '){
					nextCoord = new Coord(current.getI(), current.getJ() - 1);
				}				
			}
		}

		if (nextCoord == null) {
			throw new RuntimeException("Unable to find valid path.");
		}
		
		followPath(asciiMap, current, nextCoord);
		
		}	

	private Coord findStartCoord(AsciiMap asciiMap) {
		// TODO Auto-generated method stub
		return new Coord(0, 0);
	}
	
}
