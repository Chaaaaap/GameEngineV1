package base;


public class Vector3D {
	double x, y, z;

	public Vector3D(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}

	public double length() {
		return Math.sqrt(x*x+y*y+z*z);
	}

	public Vector3D unit() {
		return this.mul(1/length());
	}

	public Vector3D add(Vector3D v) {
		return new Vector3D(x+v.x, y+v.y, z+v.z);
	}

	public Vector3D sub(Vector3D v) {
		return new Vector3D(x-v.x, y-v.y, z-v.z);
	}

	public Vector3D mul(double k) {
		return new Vector3D(x*k, y*k, z*k);
	}

	public double dot(Vector3D v) {
		return x*v.x+y*v.y+z*v.z;
	}

	public Vector3D cross(Vector3D v) {
		return new Vector3D(y*v.z-z*v.y,
				z*v.x-x*v.z,
				x*v.y-y*v.x);
	}

	public String toString() {
		return "("+x+","+y+","+z+")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	
//	public static void main(String[] args) {
//		System.out.println("Test V2 - 3D vector");
//		Vector3D a = new Vector3D(1, 1, 2);
//		Vector3D b = new Vector3D(2, -1, 1);
//		System.out.println("a=" + a);
//		System.out.println("a.add(a)=" + a.add(a));
//		System.out.println("a.sub(a)=" + a.sub(a));
//		System.out.println("a.mul(3)=" + a.mul(3));
//		System.out.println("a.mul(-1)=" + a.mul(-1));
//		System.out.println("a.dot(a)=" + a.dot(a));
//		System.out.println("a.cross(b)=" + a.cross(b));
//	} // main()
}

