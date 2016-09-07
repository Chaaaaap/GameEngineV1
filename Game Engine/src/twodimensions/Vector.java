package twodimensions;

public class Vector {
	
	private double x,y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector add(Vector v) {
		return new Vector(x + v.getX(), y + v.getY());
	}
	
	public Vector sub(Vector v) {
		return new Vector(x - v.getX(), y - v.getY());
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	
}
