package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveLeft extends Command {
	private static MoveLeft moveLeft;
	private static GameWorld game;
	
	MoveLeft(GameWorld gw){
		super("Left");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Left");
		game.moveLeft();
	}
}
