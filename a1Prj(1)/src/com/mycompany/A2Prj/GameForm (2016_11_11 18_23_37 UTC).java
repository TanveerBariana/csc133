package com.mycompany.A2Prj;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class GameForm extends Form {
	private GameWorld gw; 
	public GameForm(){
		gw = new GameWorld();
		gw.init();
		gui();
		
	}

	private void gui(){
		//componentas 
		Container NMaster= new Container();
		Container NTop= new Container();
		Container NBot= new Container();
		Toolbar bar= new Toolbar(); 
		setToolbar(bar);
		Command help= new Command("Help");
		Command score= new Command("Score");
		Command sound= new Command("Sound");
		Command about= new Command("About");
		Command exit= new Command("Exit");
		Button expand= new Button("Expand");
		Button up = new Button("Up");
		Button left = new Button("Left");
		Button movA = new Button("MoveToAstronaut");
		Button contract = new Button("Contract");
		Button down = new Button("Down");
		Button right = new Button("Right");
		Button moveAl = new Button("MoveToAlien");
		Button newAl= new Button("NewAlien");
		Button fight= new Button("Fight");
		Button tick= new Button("Tick");
		Button scoreB= new Button("Score");
		//layout
		this.setLayout(new BorderLayout());	
		NTop.setLayout(new FlowLayout());
		NTop.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		NMaster.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		//add components into containers
		//addCommandToOverflowMenue();
		bar.addCommandToOverflowMenu(about);
		bar.addCommandToOverflowMenu(sound);
		bar.addCommandToOverflowMenu(exit);
		bar.addCommandToOverflowMenu(score);
		bar.setTitle("Space Fights Game");
		bar.addCommandToRightBar(help);
		//NTop.add(bar);
		NMaster.add(NTop);
		NMaster.add(NBot);
		this.add(BorderLayout.NORTH, NMaster); 
		//west
		this.add(BorderLayout.WEST, expand);
		this.add(BorderLayout.WEST, up);
		this.add(BorderLayout.WEST, left);
		this.add(BorderLayout.WEST, movA);
		//east
		this.add(BorderLayout.EAST, contract);
		this.add(BorderLayout.EAST, down);
		this.add(BorderLayout.EAST, right);
		this.add(BorderLayout.EAST, moveAl);
		this.add(BorderLayout.EAST, scoreB);
		//south
		this.add(BorderLayout.SOUTH, newAl);
		this.add(BorderLayout.SOUTH, fight);
		this.add(BorderLayout.SOUTH, tick);
		
		//this.show();
	}
	
}
