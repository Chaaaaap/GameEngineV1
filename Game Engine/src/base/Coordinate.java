package base;

import java.awt.Graphics;

import figures.BasicFigure;

public class Coordinate
{
	
	Vector O;
	Matrix S, F, T;
	
	public Coordinate(double sx, double sy, double ox, double oy)
	{
		O = new Vector(ox, oy);
		S = new Matrix(sx, 0, 0, sy);
		F = new Matrix(1, 0, 0, -1);
		T = S.multiply(F);
	}
	
	public Vector transform(Vector v)
	{
		return T.multiply(v).add(O);
	}
	
	public void drawPoint(Graphics g, Vector v)
	{
		Vector vp = transform(v);
		g.fillOval((int) vp.getX(), (int) vp.getY(), 2, 2);
	}
	
	public void drawLine(Graphics g, Vector v1, Vector v2)
	{
		v1 = transform(v1);
		v2 = transform(v2);
		g.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
	}
	
	public void drawAxis(Graphics g)
	{
		drawLine(g, new Vector(0, 0), new Vector(0, 1));
		drawLine(g, new Vector(0, 0), new Vector(1, 0));
		
	}
	
	public void drawFigure(Graphics g, BasicFigure figure)
	{
		Vector[] coordinates = figure.getCoordinates();
		
		for (int i = 0; i < coordinates.length - 1; i++)
		{
			drawLine(g, coordinates[i], coordinates[i + 1]);
		}
		
		drawLine(g, coordinates[coordinates.length - 1], coordinates[0]);
	}
	
}
