package base;

public class Vector2D
{
	
	private double x, y;
	
	public Vector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2D add(Vector2D v)
	{
		return new Vector2D(x + v.getX(), y + v.getY());
	}
	
	public Vector2D sub(Vector2D v)
	{
		return new Vector2D(x - v.getX(), y - v.getY());
	}
	
	public Vector2D divide(double x)
	{
		return new Vector2D(this.x / x, this.y / x);
	}
	
	public Vector2D multiply(double x)
	{
		return new Vector2D(this.x * x, this.y * x);
	}
	
	public double length()
	{
		return Math.sqrt(x*x+y*y);
	}
	
	public Vector2D unit()
	{
		return new Vector2D(x, y).divide(length());
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
