package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PrintP extends Command {
	private static PrintP printP;
	private static GameWorld game;
	
	PrintP(GameWorld gw){
		super("Points");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Points");
		game.printP();
	}
}