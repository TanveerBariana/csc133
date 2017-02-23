package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Map extends Command {
	private static Map map;
	private static GameWorld game;
	
	Map(GameWorld gw){
		super("Map");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game== null){
			game= gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("maps over there");
		game.map();
	}
}
