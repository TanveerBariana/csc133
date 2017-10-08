package com.mycompany.A2Prj;
import com.codename1.ui.geom.Point2D;
//this class was created to generate the South West and North East bounds of a hitBox 
//to be used to construct a new Bounding box utilizing the objects size and current location
public class Cordinates {
	static Point2D sw;
	static Point2D ne; 
	static double sizeD;
	//spit out the south west point
	public static Point2D SW(Point2D location, int size){
		//the diagonal of a box of size size
		sizeD=((size*Math.sqrt(2))/2);
		
		Point2D sw= new Point2D(location.getX()-(sizeD/2), location.getY()-(sizeD/2));
		return sw;
	}
	//spit out the north east point
	public static Point2D NE(Point2D location, int size){
		sizeD=((size*Math.sqrt(2))/2);
		Point2D ne= new Point2D(location.getX()+(sizeD/2), location.getY()+(sizeD/2));
		return ne;
	}
}
