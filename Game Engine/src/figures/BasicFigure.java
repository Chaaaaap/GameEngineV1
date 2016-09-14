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
	
	public BasicFigure Rotate(double deegres)
	{
		Vector[] coordinates = new Vector[Coordinates.length];
		
		double radians = Math.toRadians(deegres);
		Matrix rotation = new Matrix(Math.cos(radians), -Math.sin(radians), Math.sin(radians), Math.cos(radians));
		
		for (int i = 0; i < Coordinates.length; i++)
			coordinates[i] = rotation.multiply(Coordinates[i].sub(Center)).add(Center);
		
		return new BasicFigure(coordinates);
	}
	
	public BasicFigure flipAroundXAxis()
	{
		Matrix flipMatrix = new Matrix(1, 0, 0, -1);
		
		return Flip(flipMatrix);
	}
	
	public BasicFigure flipAroundYAxis()
	{
		Matrix flipMatrix = new Matrix(-1, 0, 0, 1);
//		Matrix flipMatrix = new Matrix(0, 1, 1, 0);
		
		return Flip(flipMatrix);
	}
	
	private BasicFigure Flip(Matrix flipMatrix)
	{
		Vector[] coordinates = new Vector[Coordinates.length];
		for (int i = 0; i < Coordinates.length; i++)
			coordinates[i] = flipMatrix.multiply(Coordinates[i]);
		
		return new BasicFigure(coordinates);
	}
	
	public Vector[] getCoordinates()
	{
		return Coordinates;
	}
	
	public void Draw()
	{
		
	}
	
	public BasicFigure express(double a, double b) {
		Matrix express = new Matrix(a, 0, 0, b);
		Vector[] temp = new Vector[Coordinates.length];
		Vector diff = express.multiply(Coordinates[0]).sub(Coordinates[0]);
		for (int i = 0; i < temp.length; i++) {
			temp[i] = express.multiply(Coordinates[i]).sub(diff);
		}
		
		return new BasicFigure(temp);
	}
}
