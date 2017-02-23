package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Open extends Command {
	private static Open open;
	private static GameWorld game;
	
	Open(GameWorld gw){
		super("Open");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Opening door");
		game.open();
	}
}