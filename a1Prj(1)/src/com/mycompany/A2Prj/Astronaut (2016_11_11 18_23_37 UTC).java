package com.mycompany.A2Prj;
import com.codename1.ui.geom.Point2D;

//astronaut is a subtype of oponent
public class Astronaut extends Opponents{
	//set health for astronaut
	private int health= 5;
	public void setHealth(int i){
		this.health= health;
	}
	//get health 
	public int getHealth(){
		return health;
	}

	public String toString(){
		Point2D loc= getLocation(); 
		String mySum= ("Ship: loc = (" + loc.getX()+ ", "+ loc.getY()+ "), color = "+ getColor()+ ", size = "+ getSize()+ ", speed = "+ getSpeed()+ ", direction = "+ getDirection()+", health = "+ getHealth());
			return mySum; 
		}
}
