package com.mycompany.A2Prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Collide extends Command {
	private static Collide collide;
	private static GameWorld game;
	
	Collide(GameWorld gw){
		super("collide");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("look at those dumb aliens crash");
		game.collide();
	}
}
