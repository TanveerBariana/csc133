package com.mycompany.A2Prj;
import java.util.Random;
//opponent is a subtype of game object 
public abstract class Opponents extends GameObject{
	private int speed;  
	private int direction; 
	//get the speed
	public int getSpeed(){
		return speed;
	}
	//get the direction
	public int getDirection(){
		return direction;
	}
	//set speed to input
	public void setSpeed(int Speed){
		this.speed= speed;
	}
	//set direction to input
	public void setDirection(int direction){
		this.direction= direction; 
	}
	public void move(){
		
	}
}
