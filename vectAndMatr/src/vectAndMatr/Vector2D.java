package vectAndMatr;

public class Vector2D {
	
	public static void main(String[] args) {
	}
	
	private double x;
	private double y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public void set(int place, double setNum) {
		if (place == 0) {
			this.x = setNum;
		} else if (place == 1) {
			this.y = setNum;
		}
	}
	
	public void set(Vector2D result) {
		for (int i = 0; i < 2; i++) {
			this.set(i, result.get(i));
		}
	}
	
	public double get(int place) {
		if (place == 0) {
			return this.x;
		} else if (place == 1) {
			return this.y;
		} 
		return 0;
	}
	
	public String toString() {
		return this.x + " , " + this.y;
	}
	
	public Vector2D add(Vector2D otherVect) {
		return new Vector2D(
				this.x + otherVect.x,
				this.y + otherVect.y
				);
	}
	
	public double mult(Vector2D otherVect) {
		return this.x * otherVect.x + this.y * otherVect.y;
	}
	
	public Vector2D scale(int scaleFact) {
		return new Vector2D(
				this.x * scaleFact,
				this.y * scaleFact
				);
	}

}
