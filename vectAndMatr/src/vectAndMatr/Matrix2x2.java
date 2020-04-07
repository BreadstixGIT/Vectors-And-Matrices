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
	
	public Matrix2x2(Vector2D first, Vector2D second, int orient) {
		if (orient == 0) {
			this.data[0][0] = first.get(0);
			this.data[0][1] = first.get(1);
			this.data[1][0] = second.get(0);
			this.data[1][1] = second.get(1);
			this.updateVect();
		} else if (orient == 1) {
			this.data[0][0] = first.get(0);
			this.data[0][1] = second.get(0);
			this.data[1][0] = first.get(1);
			this.data[1][1] = second.get(1);
			this.updateVect();
		}
	}
	
	public Matrix2x2(Vector4D vect) {
		new Matrix2x2(
				new Vector2D(vect.get(0), vect.get(1)),
				new Vector2D(vect.get(2), vect.get(3)), 0
				);
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
	
	public void set(Matrix2x2 initial) {
		initial.updateVect();
		this.setRow(0, initial.getRow(0));
		this.setRow(1, initial.getRow(1));
		this.updateData();
	}
	
	public void setRow(int row, Vector2D inRow) {
		if (row == 0) {
			this.row0 = inRow;
		} else if (row == 1) {
			this.row1 = inRow;
		}
		this.updateVect(1);
		this.updateData();
	}
	
	public void setCol(int col, Vector2D inCol) {
		if (col == 0) {
			this.col0 = inCol;
		} else if (col == 1) {
			this.col1 = inCol;
		}
		this.updateVect(0);
		this.updateData();
	}
	
	public double get(int row, int column) {
		return this.data[row][column];
	}
	
	public Vector2D getRow(int row) {
		if (row == 0) {
			return this.row0;
		} else if (row == 1) {
			return this.row1;
		} else {
			return new Vector2D();
		}
	}
	
	public Vector2D getCol(int col) {
		if (col == 0) {
			return this.col0;
		} else if (col == 1) {
			return this.col1;
		} else {
			return new Vector2D();
		}
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
	
	public void updateVect(int orientation) {
		if (orientation == 0) {
			this.row0 = new Vector2D(this.data[0][0], this.data[0][1]);
			this.row1 = new Vector2D(this.data[1][0], this.data[1][1]);
		} else if (orientation == 1) {
			this.col0 = new Vector2D(this.data[0][0], this.data[1][0]);
			this.col1 = new Vector2D(this.data[0][1], this.data[1][1]);
		}
	}

	public void updateData() {
		for (int i = 0; i < 2; i++) {
			this.set(0, i, row0.get(i));
			this.set(1, i, row1.get(i));
		}
	}
	
	public void updateData(int orientation) {
		if (orientation == 0) {
			this.updateVect();
		} else if(orientation == 1) {
			for (int i = 0; i < 2; i++) {
				this.set(i, 0, col0.get(i));
				this.set(i, 1, col1.get(i));
			}
		}
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
				).round(5);
	}
	
	public Vector2D mult(Vector2D otherVect) {
		this.updateVect();
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
				).round(5);
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
				).scale(1/determinant).round(5);
	}

}
