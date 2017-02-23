package com.mycompany.a2;
import com.codename1.ui.geom.Point2D;

//spaceship is a subtype of rescuer
//change i guess?
public class Spaceship extends Rescuer{
	//private int size;
	
	public String toString(){
		String mySum= ("Ship: loc = (" + loc.getX()+ ", "+ loc.getY()+ "), color = "+ getColor()+ ", size = "+ getSize());
		return mySum; 
	}
	//get the size 
	/*public int getSize(){
		return size;
	}*/
	//set the size to input if it is between 50 to 1024
	/*public void setSize(int size){
		if(50< size && size < 1024){
			this.size= size;
		}
	} */

	

	
}
