package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

	public class Exit extends Command {
		private static Exit exit;
		private static GameWorld game;
		
		Exit(GameWorld gw){
			super("Exit");
			this.game= gw;
		}
		public static void setTarget(GameWorld gw){
			if(game== null){
				game= gw;
			}
		}
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Moving Astronaut");
			game.exit();
		}
	}

