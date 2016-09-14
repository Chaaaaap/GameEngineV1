package figures;

import base.Matrix;
import base.Vector;

public class BasicFigure
{
	
	private Vector[] Coordinates;
	private Vector Center;
	
	public BasicFigure(Vector... coordinates)
	{
		Coordinates = coordinates;
		
		Center = Coordinates[0];
		
		for (int i = 1; i < Coordinates.length; i++)
			Center = Center.add(Coordinates[i]);
		
		Center = Center.divide(Coordinates.length);
	}
	
	public void Rotate(double deegres)
	{
		
		double radians = Math.toRadians(deegres);
		Matrix rotation = new Matrix(Math.cos(radians), -Math.sin(radians), Math.sin(radians), Math.cos(radians));
		
		for (int i = 0; i < Coordinates.length; i++)
			Coordinates[i] = rotation.multiply(Coordinates[i].sub(Center)).add(Center);
	}
	
	public Vector[] getCoordinates()
	{
		return Coordinates;
	}
	
	public void Draw()
	{
		
	}
	
}
