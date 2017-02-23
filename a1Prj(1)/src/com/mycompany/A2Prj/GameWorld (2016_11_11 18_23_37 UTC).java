package com.mycompany.A2Prj;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class GameWorld extends Observable{
	//size 1024 X 768
	private final int HEIGHT= 768;
	private final int WIDTH= 1024;
	//arraylist of objects
	ArrayList<GameObject> go= new ArrayList<GameObject>();
	//starting values
	private int numAlien = 0; 
	private int numAstro= 0;
	private Alien alien; 
	private Astronaut astro;
	private Spaceship spaceship; 
	private int lessAlien= 0;
	private int lessAstro;
	Random rand= new Random();
	public void init(){
		//initial setup
		makeAstro();
		makeAstro();
		makeAstro();
		makeAlien();
		makeAlien();
		makeShip();
	}
	public GameWorld(){
		alien= new Alien();
		astro= new Astronaut();
		spaceship= new Spaceship();
	}
	public void makeAstro(){
		int red= ColorUtil.rgb(254, 0, 0);
		Astronaut astro= new Astronaut();
		astro.setSpeed(5);
		astro.setColor(red);
		Point2D location= new Point2D(RandRange.rand(0.0, 1024.0), RandRange.rand(0.0, 768.0));
		int size= RandRange.rand(20, 50);
		astro.setSize(size);
		go.add(astro);
		numAstro++; 
	}
	public void makeAlien(){
		int green= ColorUtil.rgb(0, 254, 0);
		Alien alien= new Alien();
		alien.setSpeed(5);
		alien.setColor(green);
		Point2D location= new Point2D(RandRange.rand(0.0, 1024.0), RandRange.rand(0.0, 768.0));
		int size= RandRange.rand(20, 50);
		alien.setSize(size);
		go.add(alien);
		numAlien++; 
	}
	public void makeShip(){
		int blue= ColorUtil.rgb(0, 0, 254);
		Spaceship spaceship = new Spaceship();
		spaceship.setColor(blue);
		spaceship.setSize(100);
		go.add(spaceship);
	}
	//input methods
	public void expand(){
		//make space ship door bigger
		Spaceship ship= new Spaceship();
		int size= ship.getSize();
		if(size < 1024){
			ship.setSize(size+ 10);
		}
	}
	public void contract(){
		//make ship door smaller
		Spaceship ship= new Spaceship();
		int size= ship.getSize();
		if(size > 50){
			ship.setSize(size- 10);
		}
	}
	public void alMove(){
		//move to rand alien
		Spaceship ship = new Spaceship();
		while(true){
			int i= rand.nextInt(go.size());
				if(go.get(i) instanceof Alien){
					Point2D loc= ((Alien)go.get(i)).getLocation();
					ship.setLocation(loc);
				}
			}
	}
	public void asMove(){
		//move to rand astronaut
		Spaceship ship = new Spaceship();
		while(true){
		int i= rand.nextInt(go.size());
			if(go.get(i) instanceof Astronaut){
				Point2D loc= ((Astronaut)go.get(i)).getLocation();
				ship.setLocation(loc);
			}
		}
	}
	public void moveUp(){
		//move up 10
		Spaceship ship = new Spaceship();
		ship.moveUp();
	}
	public void moveDown(){
		//move down 10
		Spaceship ship = new Spaceship();
		ship.moveDown();
	}
	public void moveLeft(){
		//move left 10
		Spaceship ship = new Spaceship();
		ship.moveLeft();
	}
	public void moveRight(){
		//move right 10
		Spaceship ship = new Spaceship();
		ship.moveRight();
	}
	//if object can move, let it move 
	public void play(){
		for(int i = 0; i< go.size(); i++){
			if( go.get(i) instanceof IMoveable){
				IMoveable obj= (IMoveable)go.get(i); 
				obj.move();
			}
		}
	}
	public void tick() {
		//tick time forward
		for(int i =0; i <go.size(); i++){
			if(go.get(i) instanceof Opponents){
				((Opponents)go.get(i)).move();
			}
		}
	}
	public void open() {
		// open door
		Spaceship ship = new Spaceship();
		for(int i = go.size(); i >0;i++){
			Point2D loc= ship.getLocation();
			double x= loc.getX();
			double y= loc.getY();
			if(go.get(i).getLocationX() >= ship.getLocationX()- (ship.getSize()/2)){
				if(go.get(i) instanceof Alien){
					lessAlien++;
					go.remove(i);
				}
				if(go.get(i) instanceof Astronaut){
					lessAstro++;
					go.remove(i);
				}
			}
					
		}
	}
	public void collide() {
		//collied aliens a nd make a new one
		numAlien--;// net gain from this is -1
		int X= rand.nextInt(WIDTH);
		int Y= rand.nextInt(HEIGHT);
		int green= ColorUtil.rgb(0, 254, 0);
		Alien alien= new Alien();
		alien.setColor(green);
		int dir= rand.nextInt(360);
		alien.setSpeed(5);
		Point2D loc = new Point2D(X, Y); 
		alien.setLocation(loc);
		alien.setDirection(dir);
		go.add(alien);
		int j= 0;
		for(int i= 0; i< go.size(); i++){//take out two rand aliens to make space for new one
			if(go.get(i) instanceof Alien){
				if(j< 2 ){
					go.remove(i);
					j++;
				}else{
					break;
				}
			}
		}
	}
	public void simFight() {
		//simulate a fight between astronaut and alien
		int purple = ColorUtil.rgb(254, 0, 254);
		
		int listSize= go.size();
		int temp = rand.nextInt(listSize);
		while(!(go.get(temp) instanceof Astronaut)){
			temp = rand.nextInt(listSize);
		}
		int x = ((Astronaut)go.get(temp)).getHealth();
		if(x> 0){
			int speed = ((Astronaut)go.get(temp)).getSpeed();
			((Astronaut)go.get(temp)).setSpeed(speed-1);
			((Astronaut)go.get(temp)).setHealth(x-1);
		}
	}
	public void printP() {
		//print points
		int y = 0;
		for(int i= 0 ; i < go.size(); i++ ){
			if(go.get(i) instanceof Astronaut){
				int x = ((Astronaut)go.get(i)).getHealth();
				y+= 5+x;
			}
		}
		int asLeft = numAstro- lessAstro;
		int alLeft = numAlien- lessAlien;
		
		System.out.println("Score: " + y);
        System.out.println("Number of aliens left: " + alLeft);
        System.out.println("Number of Astronauts left outside: " + asLeft);
        System.out.println("Number of Astronauts inside: " + lessAstro);
        System.out.println("Number of Aliens inside: " + lessAlien);
	}
	public void map() {
		//print map
		for(int i=0; i< go.size(); i++){
			if(go.get(i) instanceof IMoveable){
				IMoveable mov= (IMoveable)go.get(i);
				System.out.println(mov);
			}
		}
	}
	
}
