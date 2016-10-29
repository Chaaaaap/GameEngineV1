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
		return new Matrix3D(a*m.getA()+b*m.getD()+c*m.getG(), a*m.getB()+b*m.getE()+c*m.getH(), a*m.getC()+b*m.getF()+c*m.getI(),
							d*m.getA()+e*m.getD()+f*m.getG(), d*m.getB()+e*m.getE()+f*m.getH(), d*m.getC()+e*m.getF()+c*m.getI(),
							g*m.getA()+h*m.getD()+i*m.getG(), g*m.getB()+h*m.getE()+i*m.getH(), g*m.getC()+h*m.getF()+i*m.getI());
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
