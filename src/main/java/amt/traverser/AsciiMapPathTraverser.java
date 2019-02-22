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
		
		if (currentVal == ' ') {
			throw new RuntimeException("Can not jump to empty field.");
		}
		
		char previousVal = ' ';
		if (previous != null) {
			previousVal = asciiMap.getAsciiMap()[previous.getI()][previous.getJ()];	
		}		 
		
		if(currentVal == 'x') {
			System.out.println("end of path reached");
			return;
		} else if (currentVal != '-' && currentVal != '|' && currentVal != '+' && currentVal != '@') {
			System.out.println(currentVal);
		}else if (currentVal == '-' || currentVal != '|' || currentVal != '+' || currentVal != '@') {
			//TODO follow direction
			
		}else if (currentVal == '+') {
			//TODO change direction
			
		}
		
		}	

	private Coord findStartCoord(AsciiMap asciiMap) {
		// TODO Auto-generated method stub
		return new Coord(0, 0);
	}
	
}
