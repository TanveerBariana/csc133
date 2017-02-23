package com.mycompany.A2Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SimFight extends Command {
	private static GameWorld game;
	private static SimFight simFight;
	
	SimFight(GameWorld gw){
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
		System.out.println("FIGHT! FIGHT! FIGHT!");
		game.simFight();
	}
}
