package base;


public class Matrix3D {

	private double a, b, c;
	private double d, e, f;
	private double g, h, i;
	
	public Matrix3D(double a, double b, double c, double d, double e, double f, double g, double h, double i) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
	}
	
	public Vector3D multiply(Vector3D v) {
		return null;
	}
	
	public Matrix3D multiply(Matrix3D m) {
		return null;
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

	public double getE() {
		return e;
	}

	public double getF() {
		return f;
	}

	public double getG() {
		return g;
	}

	public double getH() {
		return h;
	}

	public double getI() {
		return i;
	}
	
}
