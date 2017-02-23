package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveRight extends Command {
	private static MoveRight moveRight;
	private static GameWorld game;
	
	MoveRight(GameWorld gw){
		super("Right");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Right");
		game.moveRight();
	}
}