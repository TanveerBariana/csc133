/*package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionEvent;
public class Game extends Form {
	private GameWorld gw;
	public Game(){
		//create a game world
		gw = new GameWorld();
		gw.init();
		play();
	}
	//begin the game
	private void play() {
		gw.play();
		Label myLabel= new Label("Enter a Command:");// ask for initial input
		this.addComponent(myLabel);
		final TextField myTextField= new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				switch (sCommand.charAt(0)) {
				 	case 'e':
				 		System.out.println("door expanded ");
				 		gw.expand();
				 		break;
				 	case 'a':
				 		//move to alien
				 		System.out.println("moving to random alien");
				 		gw.alMove();
				 		break;
				 	case 'o':
				 		//move to astronaut
				 		System.out.println("moving to random astronaut");
				 		gw.asMove();
				 		break;
				 	case 'r':
				 		//move right
				 		System.out.println("Moving right");
				 		gw.moveRight();
				 		break;
				 	case 'l':
				 		//move left
				 		System.out.println("Moving left");
				 		gw.moveLeft();
				 		break;
				 	case 'u':
				 		//move up
				 		System.out.println("Moving up");
				 		gw.moveUp();
				 		break;
				 	case 'd':
				 		//move down
				 		System.out.println("Moving down");
				 		gw.moveDown();
				 		break;
				 	case 'c':
				 		System.out.println("Contracting door");
				 		gw.contract();
				 		break;
				 	case 't':
				 		//game world clock has ticked. 
				 		//so update info
				 		System.out.println("Updating game world");
				 		gw.tick();
				 		break;
				 	case 's':
				 		//open door and update score
				 		System.out.println("Opening door");
				 		gw.open();
				 		break;
				 	case 'w':
				 		//simulate alien collision
				 		System.out.println("Simulating alien crash");
				 		gw.collide();
				 		break;
				 	case 'f':
				 		//simulate fight between alien and astronaut
				 		System.out.println("Simulating fight");
				 		gw.simFight();
				 		break;
				 	case 'p':
				 		//print points of game state
				 		System.out.println("Game State");
				 		gw.printP();
				 		break;
				 	case 'm':
				 		//print map
				 		System.out.println("Printing map");
				 		gw.map();
				 		break;
				 	case 'x':
				 		System.out.println("you sure?");
				 		
				 		break;
				}	
			}
		});
	}
} */