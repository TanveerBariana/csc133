package com.mycompany.A2Prj;

import com.codename1.ui.geom.Point2D;

//alien is a subtype of opponent
public class Alien extends Opponents {
private Point2D loc= getLocation(); 
	
	public String toString(){
		String mySum= ("Ship: loc = (" + loc.getX()+ ", "+ loc.getY()+ "), color = "+ getColor()+ ", size = "+ getSize()+ ", speed = "+ getSpeed()+ ", direction = "+ getDirection());
		return mySum; 
	}
}
