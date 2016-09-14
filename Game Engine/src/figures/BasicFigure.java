package figures;

import base.Matrix;
import base.Vector;

public class BasicFigure
{
	
	private Vector[] Coordinates;
	private Vector Center;
	
	public BasicFigure(Vector... coordinates){
		Coordinates = coordinates;
		
		Center = Coordinates[0];
		
		for (int i = 1; i < Coordinates.length; i++)
			Center = Center.add(Coordinates[i]);
		
		Center = Center.divide(Coordinates.length);
	}
	
	public void Rotate(double deegres) {
		
		double radians = Math.toRadians(deegres);
		Matrix rotation = new Matrix(Math.cos(radians), -Math.sin(radians), Math.sin(radians), Math.cos(radians));
		
		for (int i = 0; i < Coordinates.length; i++)
			Coordinates[i] = rotation.multiply(Coordinates[i].sub(Center)).add(Center);
	}
	
	public Vector[] getCoordinates() {
		return Coordinates;
	}
	
	public BasicFigure translate(Vector v) {
		
		Vector[] temp = new Vector[Coordinates.length];
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Coordinates[i].add(v);
		}
		return new BasicFigure(temp);	
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
