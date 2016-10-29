package base;


public class Matrix2D
{
	
	private double a, b;
	private double c, d;
	
	public Matrix2D(double a, double b, double c, double d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public Vector2D multiply(Vector2D v)
	{
		return new Vector2D(a * v.getX() + b * v.getY(), c * v.getX() + d * v.getY());
	}
	
	public Matrix2D multiply(Matrix2D m)
	{
		return new Matrix2D(a * m.getA() + b * m.getC(), a * m.getB() + b * m.getD(), c * m.getA() + d * m.getC(),
				c * m.getB() + d * m.getD());
	}
	
	public double getA()
	{
		return a;
	}
	
	public double getB()
	{
		return b;
	}
	
	public double getC()
	{
		return c;
	}
	
	public double getD()
	{
		return d;
	}
	
}
