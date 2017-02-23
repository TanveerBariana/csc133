package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveDown extends Command {
	private static MoveDown moveDown;
	private static GameWorld game;
	
	MoveDown(GameWorld gw){
		super("Down");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Down");
		game.moveDown();
	}
}