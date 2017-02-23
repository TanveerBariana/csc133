package com.mycompany.A2Prj;
import com.codename1.charts.util.ColorUtil;
import com.codename1.maps.BoundingBox;
import com.codename1.maps.Coord;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	private int size;
	private int color= ColorUtil.rgb(0, 0, 0); 
	private Point2D location;
	private BoundingBox hitBox;
	//get size of object
	public int getSize(){
		return size;
	}
	//get color of object
	public int getColor(){
		return color;
	}
	//get cordinates of center as (double x, double y)
	public Point2D getLocation(){
		return location; 
	}
	public double getLocationY(){
		Point2D loc= getLocation(); 
		return loc.getY();
	}
	public double getLocationX(){
		Point2D loc= getLocation(); 
		return loc.getX();
	}
	//set color to input 
	public void setColor(int color){
		this.color= color;
		int gray = ColorUtil.rgb(126, 126, 126);
	}
	//set size to input 
	public void setSize(int size){
		this.size= size;
	}
	//set location to input 
	public void setLocation(Point2D location){
		//this.location= new Point2D(RandRange.rand(0.0, 1024.0), RandRange.rand(0.0, 768.0)); 
	}
	//generate teh hit box of the object taking into consideration its center and size. 
	public BoundingBox getHitBox(){
		//get the south east point of the box
		Point2D SW= Cordinates.SW(location, size);
		//get the northwest point of the box
		Point2D NE= Cordinates.NE(location, size);
		//convert from Point2D to Coord to actually be passed into BoundingBox Constructer
		Coord base= new Coord(SW.getY(), SW.getX());
		Coord tip= new Coord(NE.getY(), NE.getX());
		//construct bounding box utilizing the SW and NE points of it
		BoundingBox hitBox= new BoundingBox(base , tip );
		return hitBox; 
	}
	//set hitbox to input
	public void setHitBox(BoundingBox hitBox){
		this.hitBox= hitBox;
	}
}
