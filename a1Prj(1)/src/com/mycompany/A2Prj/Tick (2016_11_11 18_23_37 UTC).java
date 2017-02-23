package com.mycompany.A2Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Tick extends Command {
	private static GameWorld game;
	private static Tick tick;
	
	Tick(GameWorld gw){
		super("Fight");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Tick Tock");
		game.tick();
	}
}
