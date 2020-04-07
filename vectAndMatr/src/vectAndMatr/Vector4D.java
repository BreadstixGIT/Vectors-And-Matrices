package vectAndMatr;

public class Vector4D {
	
	public static void main(String[] args) {
	}
	
	private double x;
	private double y;
	private double z;
	private double w;

	
	public Vector4D(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4D(Vector2D first, Vector2D second) {
		this.x = first.get(0);
		this.y = first.get(1);
		this.z = second.get(0);
		this.w = second.get(1);
	}
	
	public Vector4D(Matrix2x2 mat) {
		new Vector4D(mat.getRow(0), mat.getRow(1));
	}
	
	public Vector4D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	public void set(int place, double setNum) {
		if (place == 0) {
			this.x = setNum;
		} else if (place == 1) {
			this.y = setNum;
		} else if (place == 2) {
			this.z = setNum;
		} else if (place == 3) {
			this.w = setNum;
		}
	}
	
	public void set(Vector4D initial) {
		for (int i = 0; i < 4; i++) {
			this.set(i, initial.get(i));
		}
	}
	
	public double get(int place) {
		if (place == 0) {
			return this.x;
		} else if (place == 1) {
			return this.y;
		} else if (place == 2) {
			return this.z;
		} else if (place == 3) {
			return this.w;
		} 
		return 0;
	}
	
	public String toString() {
		return "(" + new Vector2D(this.x, this.y)
				+ " , " + new Vector2D(this.z, this.w) + ")";
	}
	
	public Vector4D add(Vector4D otherVect) {
		return new Vector4D(
				this.x + otherVect.x,
				this.y + otherVect.y,
				this.z + otherVect.z,
				this.w + otherVect.w
				);
	}
	
	public double mult(Vector4D otherVect) {
		return this.x * otherVect.x + 
				this.y * otherVect.y +
				this.z * otherVect.z +
				this.w * otherVect.w;
	}
	
	public Vector4D scale(int scaleFact) {
		return new Vector4D(
				this.x * scaleFact,
				this.y * scaleFact,
				this.z * scaleFact,
				this.w * scaleFact
				);
	}

}
