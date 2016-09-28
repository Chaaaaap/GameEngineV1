package base;

public class Vector
{
	
	private double x, y;
	
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector add(Vector v)
	{
		return new Vector(x + v.getX(), y + v.getY());
	}
	
	public Vector sub(Vector v)
	{
		return new Vector(x - v.getX(), y - v.getY());
	}
	
	public Vector divide(double x)
	{
		return new Vector(this.x / x, this.y / x);
	}
	
	public Vector multiply(double x)
	{
		return new Vector(this.x * x, this.y * x);
	}
	
	public double length()
	{
		return Math.sqrt(x*x+y*y);
	}
	
	public Vector unit()
	{
		return new Vector(x, y).divide(length());
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
}
