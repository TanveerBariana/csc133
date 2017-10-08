package com.mycompany.A2Prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AlMove extends Command {
	private static AlMove alMove;
	private static GameWorld game;
	
	AlMove(GameWorld gw){
		super("Move Alien");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Alien Movement Detected");
		game.alMove();
	}
}
