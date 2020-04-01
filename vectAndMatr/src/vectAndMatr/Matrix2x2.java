package vectAndMatr;

public class Matrix2x2 {
	
	public static void main(String[] args) {
	}
	
	private double[][] data = new double[2][2];
	private Vector2D row0;
	private Vector2D row1;
	private Vector2D col0;
	private Vector2D col1;

	public Matrix2x2(double m00, double m01, double m10, double m11) {
		this.data[0][0] = m00;
		this.data[0][1] = m01;
		this.data[1][0] = m10;
		this.data[1][1] = m11;
		this.updateVect();
	}
	
	public Matrix2x2() {
		this.data[0][0] = 1;
		this.data[1][0] = 0;
		this.data[0][1] = 0;
		this.data[1][1] = 1;
		this.updateVect();
	}
	
	public void set(int row, int column, double setNum) {
		this.data[row][column] = setNum;
	}
	
	public double get(int row, int column) {
		return this.data[row][column];
	}
	
	public String toString() {
		this.updateVect();
		return ("(" + this.row0 + ") , (" + this.row1 + ")");
	}
	
	public void updateVect() {
		this.row0 = new Vector2D(this.data[0][0], this.data[0][1]);
		this.row1 = new Vector2D(this.data[1][0], this.data[1][1]);
		this.col0 = new Vector2D(this.data[0][0], this.data[1][0]);
		this.col1 = new Vector2D(this.data[0][1], this.data[1][1]);
	}
	
	public Matrix2x2 round(Integer precision) {
		double power = 10^precision;
		return new Matrix2x2(
				((double)Math.round(this.data[0][0] * power))/power,
				((double)Math.round(this.data[0][1] * power))/power,
				((double)Math.round(this.data[1][0] * power))/power,
				((double)Math.round(this.data[1][1] * power))/power
				);
	}
	
	public Matrix2x2 add(Matrix2x2 otherMat) {
		return new Matrix2x2(
				this.data[0][0] + otherMat.data[0][0],
				this.data[0][1] + otherMat.data[0][1],
				this.data[1][0] + otherMat.data[1][0],
				this.data[1][1] + otherMat.data[1][1]
				);
	}
	
	public Matrix2x2 mult(Matrix2x2 otherMat) {
		this.updateVect();
		otherMat.updateVect();
		return new Matrix2x2(
				this.row0.mult(otherMat.col0),
				this.row0.mult(otherMat.col1),
				this.row1.mult(otherMat.col0),
				this.row1.mult(otherMat.col1)
				).round();
	}
	
	public Vector2D mult(Vector2D otherVect) {
		return new Vector2D(
				this.row0.mult(otherVect),
				this.row1.mult(otherVect)
				);
	}
	
	public Matrix2x2 scale(double scaleFact) {
		return new Matrix2x2(
				this.data[0][0] * scaleFact,
				this.data[0][1] * scaleFact,
				this.data[1][0] * scaleFact,
				this.data[1][1] * scaleFact
				).round();
	}
	
	public Matrix2x2 inverse() {
		double determinant = (
				this.data[0][0] * this.data[1][1] -
				this.data[0][1] * this.data[1][0]
				);
		return new Matrix2x2(
				this.data[1][1],
				this.data[0][1] * -1,
				this.data[1][0] * -1,
				this.data[0][0]
				).scale(1/determinant).round();
	}

}
