package Figures;

import twodimensions.Matrix;
import twodimensions.Vector;

public class BasicFigure
{
	
	private Vector[] Coordinates;
	private Vector Center;
	
	
	public BasicFigure(Vector... coordinates) {
		Coordinates = coordinates;
		
		
		Center = Coordinates[0];
		
		for(int i = 1; i < Coordinates.length; i++)
			Center = Center.add(Coordinates[i]);
		
		Center = Center.divide(Coordinates.length);
	}
	
	public void Rotate(double deegres) {
		
		double radians = Math.toRadians(deegres);
		Matrix rotation = new Matrix(Math.cos(radians), -Math.sin(radians),
									Math.sin(radians), Math.cos(radians));
		
		for(int i = 0; i < Coordinates.length; i++)
			Coordinates[i] = rotation.multiply(Coordinates[i].sub(Center)).add(Center);
	}
	
	public Vector[] getCoordinates() {
		return Coordinates;
	}
	
	public void Draw() {
		
	}
	
/*
 *     S2 S = new S2(50,50,200,400);
    V2 A=new V2(2,2);
    V2 B=new V2(4,2);
    V2 C=new V2(4,4);
    V2 D=new V2(2,4);
    V2 R=A.add(B).add(C).add(D).div(4);
    double phi=Math.PI/3;
    M2 M=new M2(Math.cos(phi), -Math.sin(phi),
    		        Math.sin(phi),  Math.cos(phi));

    V2 Am=M.mul(A.sub(R)).add(R);
    V2 Bm=M.mul(B.sub(R)).add(R);
    V2 Cm=M.mul(C.sub(R)).add(R);
    V2 Dm=M.mul(D.sub(R)).add(R);
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawaxis(g);
      S.drawline(g, A, B);
      S.drawline(g, B, C);
      S.drawline(g, C, D);
      S.drawline(g, D, A);
      S.drawpoint(g, R);

      S.drawline(g, Am, Bm);
      S.drawline(g, Bm, Cm);
      S.drawline(g, Cm, Dm);
      S.drawline(g, Dm, Am);
 */
	
	
	
}
