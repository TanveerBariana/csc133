package com.mycompany.a2;
import com.codename1.ui.geom.Point2D;

//rescuer is a subtype of GameObject 
public abstract class Rescuer extends GameObject implements IGuided {
	protected Point2D loc= getLocation(); 	
	public void move(){
		
	}
	public void moveUp(){
		if(loc.getY()< 1024.0){
			Point2D L= new Point2D(loc.getX(), loc.getY()+10);
			setLocation(L);
		}
	}
	public void moveDown(){
		if(loc.getY()> 0.0){
			Point2D L= new Point2D(loc.getX(), loc.getY()-10);
			setLocation(L);
		}
	}
	public void moveJump(Point2D location) {
		setLocation(loc);
	}

	public void moveLeft() {
		if(loc.getY()> 0.0){
			Point2D L= new Point2D(loc.getX()-10, loc.getY());
			setLocation(L);
		}
	}

	public void moveRight() {
		Point2D loc = getLocation();
		if(loc.getY()< 768.0){
			Point2D L= new Point2D(loc.getX()+10, loc.getY());
			setLocation(L);
		}
		
	}

}
