package amt.model;

public class Coord {
	private int i;
	private int j;

	public Coord(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public Coord goUp() {
		return new Coord(i - 1, j);
	}
	
	public Coord goRight() {
		return new Coord(i, j + 1);
	}
	
	public Coord goDown() {
		return new Coord(i + 1, j);
	}
	
	public Coord goLeft() {
		return new Coord(i, j - 1);
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
	
}
