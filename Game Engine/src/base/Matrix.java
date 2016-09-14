package base;

public class Matrix {
	
	private double a,b;
	private double c,d;
	
	public Matrix(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public Vector multiply(Vector v) {
		return new Vector(a * v.getX() + b * v.getY(), c * v.getX() + d * v.getY());
	}
	
	public Matrix multiply(Matrix m) {
		return new Matrix(a * m.getA() + b * m.getC(), a * m.getB() + b * m.getD(),
						  c * m.getA() + d * m.getC(), c * m.getB() + d * m.getD());
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getD() {
		return d;
	}
	
	

}