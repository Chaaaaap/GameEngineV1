package base;

import java.awt.Color;
import java.awt.Graphics;

import figures.BasicFigure;
import figures.Ellipse;

public class Coordinate
{
	
	Vector2D O;
	Matrix2D S, F, T;
	
	public Coordinate(double sx, double sy, double ox, double oy)
	{
		O = new Vector2D(ox, oy);
		S = new Matrix2D(sx, 0, 0, sy);
		F = new Matrix2D(1, 0, 0, -1);
		T = S.multiply(F);
	}
	
	public Vector2D transform(Vector2D v)
	{
		return T.multiply(v).add(O);
	}
	
	public void drawPoint(Graphics g, Vector2D v)
	{
		drawPoint(g, v, 2);
	}
	
	public void drawPoint(Graphics g, Vector2D v, int size)
	{
		Vector2D vp = transform(v);
		g.fillOval((int) vp.getX()-size/2, (int) vp.getY()-size/2, size, size);
	}
	
	public void drawPoint(Graphics g, Vector2D v, Color c, int size)
	{
		Color oldColor = g.getColor();
		g.setColor(c);
		drawPoint(g, v, size);
		g.setColor(oldColor);
	}
	
	public void drawLine(Graphics g, Vector2D v1, Vector2D v2)
	{
		v1 = transform(v1);
		v2 = transform(v2);
		g.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
	}
	
	public void drawCircle(Graphics g, Ellipse e, Vector2D center)
	{
		center = transform(center);
//		Vector2D centerVector = transform(new Vector2D(e.getRadius(), e.getRadius()));
		
//		center = new Vector(center.getX() + centerVector.getX(), center.getY() - centerVector.getY());
//		center = center.sub(transform(new Vector(e.getRadius(), e.getRadius())));
//		int x = (int) center.getX() + e.getRadius();
//		int y = (int) center.getX() - e.getRadius();
		g.drawOval((int)center.getX() - (e.getRadius() / 2), (int)center.getY() - (e.getRadius() / 2), e.getRadius(), e.getRadius());
		
	}
	
	public void drawAxis(Graphics g)
	{
		drawLine(g, new Vector2D(0, 0), new Vector2D(0, 5));
		drawLine(g, new Vector2D(0, 0), new Vector2D(5, 0));
		
		drawLine(g, new Vector2D(0, 5), new Vector2D(0.1, 4.8));
		drawLine(g, new Vector2D(0, 5), new Vector2D(-0.1, 4.8));
		
		drawLine(g, new Vector2D(5, 0), new Vector2D(4.8, 0.1));
		drawLine(g, new Vector2D(5, 0), new Vector2D(4.8, -0.1));
		
	}
	
	public void drawFigure(Graphics g, BasicFigure figure)
	{
		Vector2D[] coordinates = figure.getCoordinates();
		
		for (int i = 0; i < coordinates.length - 1; i++)
		{
			drawLine(g, coordinates[i], coordinates[i + 1]);
		}
		
		drawLine(g, coordinates[coordinates.length - 1], coordinates[0]);
	}
	
}
