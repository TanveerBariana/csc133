package com.mycompany.a2;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Dialog;
import com.codename1.ui.geom.Point2D;

public class GameWorld extends Observable{
	//size 1024 X 768
	private final int HEIGHT= 768;
	private final int WIDTH= 1024;
	//arraylist of objects
	//ArrayList<GameObject> go= new ArrayList<GameObject>();
	//starting values
	private int numAlien = 0; 
	private int numAstro= 0;
	private Alien alien;
	private int AsInit = 3; 
	private int AlInit = 2;
	private int clock;
	private int score;
	int asLeft, alLeft;
	GameObjectCollection object;
	private Astronaut astro;
	private Spaceship ship; 
	private int lessAlien= 0;
	private int lessAstro= 0;
	private boolean audio;
	Random rand = new Random();
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
		ship= new Spaceship();
		object = new GameObjectCollection();
	}
	public void makeAstro(){
		int red= ColorUtil.rgb(254, 0, 0);
		Astronaut astro= new Astronaut();
		astro.setSpeed(5);
		astro.setColor(red);
		Point2D location= new Point2D(RandRange.rand(0.0, 1024.0), RandRange.rand(0.0, 768.0));
		int size= RandRange.rand(20, 50);
		astro.setSize(size);
		object.add(astro);
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
		object.add(alien);
		numAlien++; 
	}
	public void makeShip(){
		int blue= ColorUtil.rgb(0, 0, 254);
		Spaceship spaceship = new Spaceship();
		spaceship.setColor(blue);
		spaceship.setSize(100);
		object.add(spaceship);
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
		int size= ship.getSize();
		if(size > 50){
			ship.setSize(size- 10);
		}
	}
	public void alMove(){
		//move to rand alien
		Alien alien1;
		Random rand = new Random();
		int alIndex;
		IIterator iter = object.getIterator();
		alIndex = rand.nextInt(AlInit) + 4;
		alien1 = (Alien)iter.objectAt(alIndex);

		double x = alien1.getLocationX();
		double y = alien1.getLocationY();
		Point2D loc= new Point2D(x,y );
		ship.setLocation(loc);
	}
	
	
	public void asMove(){
		//move to rand astronaut
		Astronaut as1;
		Random rand = new Random();
		int asIndex;
		IIterator iter = object.getIterator();
		asIndex = rand.nextInt(AsInit) + 4;
		as1 = (Astronaut)iter.objectAt(asIndex);

		double x = as1.getLocationX();
		double y = as1.getLocationY();
		Point2D loc= new Point2D(x,y );
		ship.setLocation(loc);
	}
	public void moveUp(){
		//move up 10
		
		ship.moveUp();
	}
	public void moveDown(){
		//move down 10
		
		ship.moveDown();
	}
	public void moveLeft(){
		//move left 10
		
		ship.moveLeft();
	}
	public void moveRight(){
		//move right 10
		
		ship.moveRight();
	}
	//if object can move, let it move 
	public void play(){
		IIterator iter = object.getIterator();
		int i= 0;
		while(iter.hasNext()){
			if( iter.objectAt(i) instanceof IMoveable){
				IMoveable obj= (IMoveable)iter.get(i); 
				obj.move();
			}
		}
	}
	public void tick() {
		//tick time forward
		clock = clock + 1;
		IIterator iter = object.getIterator();
		Object currentObject;
		
		while(iter.hasNext()){
			currentObject = iter.getNext();
			if(currentObject instanceof Opponents) {
				((Opponents) currentObject).move();
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	public void open() {
		// open door
		double shipLeft = ship.getLocationX() - (ship.getSize()/2);
		double shipRight = ship.getLocationX() + (ship.getSize()/2);
		double shipDown = ship.getLocationY() - (ship.getSize()/2);
		double shipUp = ship.getLocationY() + (ship.getSize()/2);
		
		IIterator iter = object.getIterator();
		Object currentObject;
		
		while(iter.hasNext()) {
			currentObject = iter.getNext();
			if(currentObject instanceof Alien) {
				if(((Alien) currentObject).getLocationX() > shipLeft
						&& ((Alien) currentObject).getLocationX() < shipRight
						&& ((Alien) currentObject).getLocationY() > shipDown
						&& ((Alien) currentObject).getLocationY() < shipUp) {
					System.out.println("Alien aboard");
					
					lessAlien++;
					score = score - 10;
					
					iter.remove();
				}
			}else if(currentObject instanceof Astronaut) {
				if(((Astronaut) currentObject).getLocationX() > shipLeft
						&& ((Astronaut) currentObject).getLocationX() < shipRight
						&& ((Astronaut) currentObject).getLocationY() > shipDown
						&& ((Astronaut) currentObject).getLocationY() < shipUp) {
					System.out.println("Astronaut safe");
					
					lessAstro++;

					score = score + 10 - astro.getHealth();

					
					iter.remove();
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
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
		object.add(alien);
		int i= 0;
		int j= 0;
		IIterator iter= object.getIterator();
		while(iter.hasNext()){//take out two rand aliens to make space for new one
			if(iter.objectAt(i) instanceof Alien){
				if(j< 2 ){
					object.remove(i);
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
		IIterator iter= object.getIterator();
		int listSize= iter.size();
		int temp = rand.nextInt(listSize);
		while(!(iter.get(temp) instanceof Astronaut)){
			temp = rand.nextInt(listSize);
		}
		int x = ((Astronaut)iter.get(temp)).getHealth();
		if(x> 0){
			int speed = ((Astronaut)iter.get(temp)).getSpeed();
			((Astronaut)iter.get(temp)).setSpeed(speed-1);
			((Astronaut)iter.get(temp)).setHealth(x-1);
		}
	}
	public void printP() {
		//print points
		int y = 0;
		IIterator iter= object.getIterator();
		int i= 0;
		while(iter.hasNext()){
			if(iter.get(i) instanceof Astronaut){
				int x = ((Astronaut)iter.get(i)).getHealth();
				y+= 5+x;
			}
		}
		asLeft = numAstro- lessAstro;
		alLeft = numAlien- lessAlien;
		
		System.out.println("Score: " + y);
        System.out.println("Number of aliens left: " + alLeft);
        System.out.println("Number of Astronauts left outside: " + asLeft);
        System.out.println("Number of Astronauts inside: " + lessAstro);
        System.out.println("Number of Aliens inside: " + lessAlien);
	}
	public int getAlSaved(){
		return lessAlien;
	}
	public int getAsSaved(){
		return lessAstro;
	}
	public int getAlLeft(){
		return alLeft;
	}
	public int getAsLeft(){
		return asLeft;
	}
	public void map() {
		//print map
		IIterator iter = object.getIterator();
		while(iter.hasNext()){
			System.out.print(iter.getNext().toString());
		}
	}
	public void turnOnAudio() {
		audio = true;
		this.setChanged();
		this.notifyObservers();
	}
	public void turnOffAudio() {
		audio = false;
		this.setChanged();
		this.notifyObservers();
	}
	public void toggleAudio() {
		if(audio) {
			audio = false;
		}else{
			audio = true;
		}
		this.setChanged();
		this.notifyObservers();
	}
	public boolean isAudioOn() {
		return audio;
	}
	public void quit() {
		System.exit(0);
	}
	public void exit() {
		if(Dialog.show("You wanna quit?", "","Yes", "Cancel")) {
			quit();
		}
	}
	public int getTotalScore() {
		// TODO Auto-generated method stub
		System.out.println(score);
		return score;
	}
	
}
