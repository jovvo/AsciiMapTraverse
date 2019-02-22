package amt.model;

public class AsciiMap {

	private char[][] asciiMap;
	
	public AsciiMap(char[][] asciiMap) {
		this.asciiMap = asciiMap;
	}
	
	public char getValue(Coord coord) {
		//for undefined values return empty character
//		if(!(coord.getI() >= 0 && coord.getI() <= asciiMap.length - 1)) return ' ';
//		if(!(coord.getJ() >= 0 && coord.getJ() <= asciiMap[0].length - 1)) return ' ';
//		
		try {
			return asciiMap[coord.getI()][coord.getJ()];
		} catch (Exception e) {
			return ' ';
		}
		
		
	}

	public char[][] getAsciiMap() {
		return asciiMap;
	}

	public void setAsciiMap(char[][] asciiMap) {
		this.asciiMap = asciiMap;
	}
	
}
