package figures;

import base.Matrix2D;
import base.Vector2D;

public class BasicFigure
{
	
	private Vector2D[] Coordinates;
	private Vector2D Center;
	
	public BasicFigure(Vector2D... coordinates){
		Coordinates = coordinates;
		
		Center = Coordinates[0];
		
		for (int i = 1; i < Coordinates.length; i++)
			Center = Center.add(Coordinates[i]);
		
		Center = Center.divide(Coordinates.length);
	}
	
	public BasicFigure Rotate(double deegres)
	{
		Vector2D[] coordinates = new Vector2D[Coordinates.length];
		
		double radians = Math.toRadians(deegres);
		Matrix2D rotation = new Matrix2D(Math.cos(radians), -Math.sin(radians), Math.sin(radians), Math.cos(radians));
		
		for (int i = 0; i < Coordinates.length; i++)
			coordinates[i] = rotation.multiply(Coordinates[i].sub(Center)).add(Center);
		
		return new BasicFigure(coordinates);
	}
	
	public BasicFigure flipAroundXAxis()
	{
		Matrix2D flipMatrix = new Matrix2D(1, 0, 0, -1);
		
		return Flip(flipMatrix);
	}
	
	public BasicFigure flipAroundYAxis()
	{
		Matrix2D flipMatrix = new Matrix2D(-1, 0, 0, 1);
		// Matrix flipMatrix = new Matrix(0, 1, 1, 0);
		
		return Flip(flipMatrix);
	}
	
	public BasicFigure Shears(double a, double b)
	{
		Vector2D[] coordinates = new Vector2D[Coordinates.length];
		Matrix2D shearMatrix = new Matrix2D(1, a, b, 1);
		
		Vector2D diff = shearMatrix.multiply(Coordinates[0]).sub(Coordinates[0]);
		
		for(int i = 0; i < coordinates.length; i++)
			coordinates[i] = shearMatrix.multiply(Coordinates[i]).sub(diff);
		
		return new BasicFigure(coordinates);
	}
	
	private BasicFigure Flip(Matrix2D flipMatrix)
	{
		Vector2D[] coordinates = new Vector2D[Coordinates.length];
		for (int i = 0; i < Coordinates.length; i++)
			coordinates[i] = flipMatrix.multiply(Coordinates[i]);
		
		return new BasicFigure(coordinates);
	}
	
	public Vector2D[] getCoordinates() {
		return Coordinates;
	}
	
	public BasicFigure translate(Vector2D v) {
		
		Vector2D[] temp = new Vector2D[Coordinates.length];
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Coordinates[i].add(v);
		}
		return new BasicFigure(temp);	
	}

	public BasicFigure express(double a, double b) {
		Matrix2D express = new Matrix2D(a, 0, 0, b);
		Vector2D[] temp = new Vector2D[Coordinates.length];
		
		Vector2D diff = express.multiply(Coordinates[0]).sub(Coordinates[0]);
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = express.multiply(Coordinates[i]).sub(diff);
		}
		
		return new BasicFigure(temp);
	}
}
