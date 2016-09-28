package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import figures.BasicFigure;
import figures.Ellipse;

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
		drawPoint(g, v, 2);
	}
	
	public void drawPoint(Graphics g, Vector v, int size)
	{
		Vector vp = transform(v);
		g.fillOval((int) vp.getX()-size/2, (int) vp.getY()-size/2, size, size);
	}
	
	public void drawPoint(Graphics g, Vector v, Color c, int size)
	{
		Color oldColor = g.getColor();
		g.setColor(c);
		drawPoint(g, v, size);
		g.setColor(oldColor);
	}
	
	public void drawLine(Graphics g, Vector v1, Vector v2)
	{
		v1 = transform(v1);
		v2 = transform(v2);
		g.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
	}
	
	public void drawCircle(Graphics g, Ellipse e, Vector center)
	{
		center = transform(center);
		Vector centerVector = transform(new Vector(e.getRadius(), e.getRadius()));
		
//		center = new Vector(center.getX() + centerVector.getX(), center.getY() - centerVector.getY());
//		center = center.sub(transform(new Vector(e.getRadius(), e.getRadius())));
//		int x = (int) center.getX() + e.getRadius();
//		int y = (int) center.getX() - e.getRadius();
		g.drawOval((int)center.getX() - (e.getRadius() / 2), (int)center.getY() - (e.getRadius() / 2), e.getRadius(), e.getRadius());
		
	}
	
	public void drawAxis(Graphics g)
	{
		drawLine(g, new Vector(0, 0), new Vector(0, 5));
		drawLine(g, new Vector(0, 0), new Vector(5, 0));
		
		drawLine(g, new Vector(0, 5), new Vector(0.1, 4.8));
		drawLine(g, new Vector(0, 5), new Vector(-0.1, 4.8));
		
		drawLine(g, new Vector(5, 0), new Vector(4.8, 0.1));
		drawLine(g, new Vector(5, 0), new Vector(4.8, -0.1));
		
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
