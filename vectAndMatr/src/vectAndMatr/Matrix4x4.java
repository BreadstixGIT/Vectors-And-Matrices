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
	
	public Matrix4x4(Vector4D first, Vector4D second, Vector4D third, Vector4D fourth, int orientation) {
		if (orientation == 0) {
			this.row0 = first;
			this.row1 = second;
			this.row2 = third;
			this.row3 = fourth;
			this.updateData(0);
			this.updateVect(1);
		} else if (orientation == 1) {
			this.col0 = first;
			this.col1 = second;
			this.col2 = third;
			this.col3 = fourth;
			this.updateData(1);
			this.updateVect(0);
		}
	}
	
	public Matrix4x4(Matrix2x2 first, Matrix2x2 second, Matrix2x2 third, Matrix2x2 fourth, int orientation) {
		if (orientation == 0) {
			this.row0 = new Vector4D(first.getRow(0), second.getRow(0));
			this.row1 = new Vector4D(first.getRow(1), second.getRow(1));
			this.row2 = new Vector4D(third.getRow(0), fourth.getRow(0));
			this.row3 = new Vector4D(third.getRow(1), fourth.getRow(1));
			this.updateData(0);
			this.updateVect(1);
		} else if (orientation == 1) {
			this.col0 = new Vector4D(first.getCol(0), second.getCol(0));
			this.col1 = new Vector4D(first.getCol(1), second.getCol(1));
			this.col2 = new Vector4D(third.getCol(0), fourth.getCol(0));
			this.col3 = new Vector4D(third.getCol(1), fourth.getCol(1));
			this.updateData(1);
			this.updateVect(1);
		}
	}
	
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
		this.updateVect();
	}
	
	public void set(Matrix4x4 initial) {
		initial.updateVect();
		this.setRow(0, initial.getRow(0));
		this.setRow(1, initial.getRow(1));
		this.setRow(2, initial.getRow(2));
		this.setRow(3, initial.getRow(3));
		this.updateData();
	}
	
	public void setRow(int row, Vector4D inRow) {
		if (row == 0) {
			this.row0 = inRow;
		} else if (row == 1) {
			this.row1 = inRow;
		} else if (row == 2) {
			this.row2 = inRow;
		} else if (row == 3) {
			this.row3 = inRow;
		}
		this.updateVect(1);
		this.updateData();
	}
	
	public void setCol(int col, Vector4D inCol) {
		if (col == 0) {
			this.col0 = inCol;
		} else if (col == 1) {
			this.col1 = inCol;
		} else if (col == 2) {
			this.col2 = inCol;
		} else if (col == 3) {
			this.col3 = inCol;
		}
		this.updateVect(0);
		this.updateData();
	}
	
	public double get(int row, int column) {
		return this.data[row][column];
	}
	
	public Vector4D getRow(int row) {
		if (row == 0) {
			return this.row0;
		} else if (row == 1) {
			return this.row1;
		} else if (row == 2) {
			return this.row2;
		} else if (row == 3) {
			return this.row3;
		} else {
			return new Vector4D();
		}
	}
	
	public Vector4D getCol(int col) {
		if (col == 0) {
			return this.col0;
		} else if (col == 1) {
			return this.col1;
		} else if (col == 2) {
			return this.col2;
		} else if (col == 3) {
			return this.col3;
		} else {
			return new Vector4D();
		}
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
	
	public void updateVect(int orientation) {
		if (orientation == 0) {
			this.row0 = new Vector4D(this.get(0, 0), this.get(0,1), this.get(0,2), this.get(0,3));
			this.row1 = new Vector4D(this.get(1, 0), this.get(1,1), this.get(1,2), this.get(1,3));
			this.row2 = new Vector4D(this.get(2, 0), this.get(2,1), this.get(2,2), this.get(2,3));
			this.row3 = new Vector4D(this.get(3, 0), this.get(3,1), this.get(3,2), this.get(3,3));
		} else if (orientation == 1) {
			this.col0 = new Vector4D(this.get(0, 0), this.get(1,0), this.get(2,0), this.get(3,0));
			this.col1 = new Vector4D(this.get(0, 1), this.get(1,1), this.get(2,1), this.get(3,1));
			this.col2 = new Vector4D(this.get(0, 2), this.get(1,2), this.get(2,2), this.get(3,2));
			this.col3 = new Vector4D(this.get(0, 3), this.get(1,3), this.get(2,3), this.get(3,3));
		}
	}
	
	public void updateData() {
		for (int i = 0; i < 4; i++) {
				this.set(0, i, row0.get(i));
				this.set(1, i, row1.get(i));
				this.set(2, i, row2.get(i));
				this.set(3, i, row3.get(i));
		}
	}
	
	public void updateData(int orientation) {
		if (orientation == 0) {
			this.updateData();
		} else if (orientation == 1) {
			for (int i = 0; i < 4; i++) {
				this.set(i, 0, col0.get(i));
				this.set(i, 1, col1.get(i));
				this.set(i, 2, col2.get(i));
				this.set(i, 3, col3.get(i));
			}
		}
	}
	
	public Matrix4x4 round(Integer precision) {
		Matrix4x4 result = new Matrix4x4();
		double power = 10^precision;
		for (Integer i = 0; i < 16; i++) {
			double setNum = (double)Math.round(this.get(i/4, i%2)*power)/power;
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
		return result.round(5);
	}
	
	public Matrix4x4 scale(int scaleFact) {
		Matrix4x4 result = new Matrix4x4();
		for (Integer i = 0; i < 16; i++) {
			result.set(i/4, i%4,
					this.get(i/4, i%4) * scaleFact
					);
		}
		return result.round(5);
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
		return result.round(5);
	}
	
}
