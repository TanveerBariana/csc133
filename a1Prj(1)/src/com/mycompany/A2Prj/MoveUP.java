package com.mycompany.A2Prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveUP extends Command {
	private static MoveUP moveUp;
	private static GameWorld game;
	
	MoveUP(GameWorld gw){
		super("Up");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Up");
		game.moveUp();
	}
}