package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Audio extends Command{
	private static Audio audio;
	private static GameWorld game;
	
	Audio(GameWorld gw) {
		super("Toggle Sound");
		this.game = gw;
	}
	public static void setTarget(GameWorld gw) {
		if(game == null) {
			game = gw;
		}
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Sound toggle on or off");
		game.toggleAudio();
	}

}