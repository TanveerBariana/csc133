package com.mycompany.A2Prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Contract extends Command {
	private static GameWorld game;
	private Contract contract;
	
	Contract(GameWorld gw){
		super("Contract Door");
		this.game= gw;
	}
	public static void setTarget(GameWorld gw){
		if(game == null)
			game= gw;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("doors contracting");
		game.contract();
	}
}
