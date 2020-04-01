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
