package vectAndMatr;

public class Matrix4x4 {

	public static void main(String[] args) {
	}
	
	private double[][] data = new double[4][4];
	private Vector4D row0;
	private Vector4D row1;
	private Vector4D row2;
	private Vector4D row3;
	private Vector4D col0;
	private Vector4D col1;
	private Vector4D col2;
	private Vector4D col3;
	
	public Matrix4x4() {
		this.identity();
		this.updateVect();
	}
	
	public void identity() {
		for (int i = 0; i < 4; i++) {
			this.set(i, i, 1);
		}
	}
	
	public void set(int row, int column, double setNum) {
		this.data[row][column] = setNum;
	}
	
	public double get(int row, int column) {
		return this.data[row][column];
	}
	
	public String toString() {
			this.updateVect();
			return "(" + this.row0 + this.row1 + this.row2 + this.row3 + ")";
	}
	
	public void updateVect() {
		this.row0 = new Vector4D(this.get(0, 0), this.get(0,1), this.get(0,2), this.get(0,3));
		this.row1 = new Vector4D(this.get(1, 0), this.get(1,1), this.get(1,2), this.get(1,3));
		this.row2 = new Vector4D(this.get(2, 0), this.get(2,1), this.get(2,2), this.get(2,3));
		this.row3 = new Vector4D(this.get(3, 0), this.get(3,1), this.get(3,2), this.get(3,3));
		this.col0 = new Vector4D(this.get(0, 0), this.get(1,0), this.get(2,0), this.get(3,0));
		this.col1 = new Vector4D(this.get(0, 1), this.get(1,1), this.get(2,1), this.get(3,1));
		this.col2 = new Vector4D(this.get(0, 2), this.get(1,2), this.get(2,2), this.get(3,2));
		this.col3 = new Vector4D(this.get(0, 3), this.get(1,3), this.get(2,3), this.get(3,3));
	}
	
	public Matrix4x4 round() {
		Matrix4x4 result = new Matrix4x4();
		for (Integer i = 0; i < 16; i++) {
			double setNum = (double)Math.round(this.get(i/4, i%2)*1000)/1000;
			result.set(i/4, i%4, setNum);
		}
		return result;
	}
	
	public Matrix4x4 add(Matrix4x4 otherMat) {
		Matrix4x4 result = new Matrix4x4();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result.set(1, j, 
						this.get(i, j) + otherMat.get(i,  j)
						);
			}
		}
		return result.round();
	}
	
	public Matrix4x4 scale(int scaleFact) {
		Matrix4x4 result = new Matrix4x4();
		for (Integer i = 0; i < 16; i++) {
			result.set(i/4, i%4,
					this.get(i/4, i%4) * scaleFact
					);
		}
		return result.round();
	}
	
	public Matrix4x4 mult(Matrix4x4 otherMat) {
		Matrix4x4 result = new Matrix4x4();
		this.updateVect();
		otherMat.updateVect();
		result.set(0, 0, this.row0.mult(otherMat.col0));
		result.set(0, 1, this.row0.mult(otherMat.col1));
		result.set(0, 2, this.row0.mult(otherMat.col2));
		result.set(0, 3, this.row0.mult(otherMat.col3));
		result.set(1, 0, this.row1.mult(otherMat.col0));
		result.set(1, 1, this.row1.mult(otherMat.col1));
		result.set(1, 2, this.row1.mult(otherMat.col2));
		result.set(1, 3, this.row1.mult(otherMat.col3));
		result.set(2, 0, this.row2.mult(otherMat.col0));
		result.set(2, 1, this.row2.mult(otherMat.col1));
		result.set(2, 2, this.row2.mult(otherMat.col2));
		result.set(2, 3, this.row2.mult(otherMat.col3));
		result.set(3, 0, this.row3.mult(otherMat.col0));
		result.set(3, 1, this.row3.mult(otherMat.col1));
		result.set(3, 2, this.row3.mult(otherMat.col2));
		result.set(3, 3, this.row3.mult(otherMat.col3));
		return result.round();
	}
	
}
