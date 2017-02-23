package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Expand extends Command {
	private static Expand expand;
	private static GameWorld game;
	
	Expand(GameWorld gw){
		super("Door expanded ");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Spaceship is big now");
		game.collide();
	}
}
