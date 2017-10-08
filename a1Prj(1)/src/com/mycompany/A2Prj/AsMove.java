package com.mycompany.A2Prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsMove extends Command {
	private static AsMove asMove;
	private static GameWorld game;
	
	AsMove(GameWorld gw){
		super("Move Astronaut");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Moving Astronaut");
		game.asMove();
	}
}