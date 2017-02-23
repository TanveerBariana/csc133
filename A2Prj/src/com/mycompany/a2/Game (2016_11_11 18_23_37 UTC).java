package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form {
	//set up the Observable components
	private GameWorld gw; 
	private MapViewer mv;
	private ScoreViewer sv;
	private ActionEvent e;
	
	public Game(){
		gw = new GameWorld();
		mv = new MapViewer(gw); 
		sv = new ScoreViewer(gw);
		gw.init();
		play();
		
		gw.addObserver(sv);
		gw.addObserver(mv);
		gw.notifyObservers();
	}
	private void play() {
		sv = new ScoreViewer(gw);
		mv = new MapViewer(gw);
		setLayout(new BorderLayout());
		Container wholeScreen = new Container(new GridLayout(1000,800));
		wholeScreen.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
        wholeScreen.setLayout(new BorderLayout());
        add(BorderLayout.NORTH, sv);
        
        Toolbar bar= new Toolbar(); 
		setToolbar(bar);
		Label title= new Label("Space Fights Game");
		bar.setTitleComponent(title); 
		//Containers 
		Command sHelp= new Command("Help"){
			public void actionPerformed(ActionEvent e){
				Dialog.show("Commands","e: Expand Spaceship\n"
						+ "u: Move up\n"
						+ "l: Move left\n"
						+ "o: Transfer to Astro\n"
						+ "c: Contract Spaceship\n"
						+ "d: Move down\n"
						+ "r: Move right\n"
						+ "a: Transfer to Alien\n"
						+ "s: Door Opens, Update Score\n"
						+ "k: Aliens crash and make Alien\n"
						+ "f: Astro and Alien fight\n"
						+ "t: Clock ticks \n"
						+ "w: create new alien\n"
						+ "x: exit game \n","", "Cancel");
			}
		};
		bar.addCommandToSideMenu(sHelp);
		Command score= new Command("Score"){
			public void actionPerformed(ActionEvent e){
				
			}
		};
		bar.addCommandToSideMenu(score);
		CheckBox soundPow= new CheckBox("Toggle Sound");
		Audio aud= new Audio(gw);
		soundPow.setCommand(aud);
		aud.putClientProperty("Sound toggle", soundPow);
		bar.addCommandToSideMenu(aud);
		
		Command about= new Command("About"){
			public void actionPerformed(ActionEvent e){
				System.out.println("Tanveer Bariana, CSC133, A2Prj");
				Dialog.show("Game: Space Fights Game, CSC133, A2Prj","","", "Cancel");
			}
		};
		bar.addCommandToSideMenu(about);
		final Exit Cexit= new Exit(gw);
		final Button yes= new Button("yes");
		Command exit= new Command("Exit"){
			
			public void actionPerformed(ActionEvent e){
				Dialog.show("Are you sure?", yes, Cexit);
			}
		};
		
		bar.addCommandToSideMenu(exit);
		addKeyListener('x', Cexit);
	//west container
		Container WContainer = new Container(new GridLayout(4,1));
		//expand
		Button expand= new Button("Expand");
		Expand Cexpand= new Expand(gw);
		expand.setCommand(Cexpand);
		expand.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		expand.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		expand.getUnselectedStyle().setBgTransparency(255);
		WContainer.add(expand);
		addKeyListener('e', Cexpand);
		//up 
		Button up = new Button("Up");
		MoveUP Cup= new MoveUP(gw);
		up.setCommand(Cup);
		up.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		up.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		up.getUnselectedStyle().setBgTransparency(255);
		WContainer.add(up);
		addKeyListener('u', Cup);
		//left
		Button left = new Button("Left");
		MoveLeft Cleft= new MoveLeft(gw);
		left.setCommand(Cleft);
		left.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		left.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		left.getUnselectedStyle().setBgTransparency(255);
		WContainer.add(left);
		addKeyListener('l', Cleft);
		//move to astronaut
		Button movAs = new Button("MoveToAstronaut");
		AsMove Cas= new AsMove(gw);
		movAs.setCommand(Cas);
		movAs.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		movAs.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		movAs.getUnselectedStyle().setBgTransparency(255);
		WContainer.add(movAs);
		addKeyListener('o', Cas);
		WContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY) );
		add(BorderLayout.WEST, WContainer);
	//east container
		Container EContainer= new Container (new GridLayout(5,1));
		//contract
		Button contract = new Button("Contract");
		Contract Ccontract= new Contract(gw);
		contract.setCommand(Cas);
		contract.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		contract.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		contract.getUnselectedStyle().setBgTransparency(255);
		EContainer.add(contract);
		addKeyListener('c', Ccontract);
		//down
		Button down = new Button("Down");
		MoveDown Cdown= new MoveDown(gw);
		down.setCommand(Cdown);
		down.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		down.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		down.getUnselectedStyle().setBgTransparency(255);
		EContainer.add(down);
		addKeyListener('d', Cdown);
		//right
		Button right = new Button("Right");
		Contract Cright= new Contract(gw);
		right.setCommand(Cright);
		right.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		right.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		right.getUnselectedStyle().setBgTransparency(255);
		EContainer.add(right);
		addKeyListener('r', Cright);
		//move to alien
		Button moveAl = new Button("MoveToAlien");
		Contract Cal= new Contract(gw);
		right.setCommand(Cal);
		right.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		right.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		right.getUnselectedStyle().setBgTransparency(255);
		EContainer.add(moveAl);
		addKeyListener('a', Cal);
		//open door and score *drop mic
		Button scoreB= new Button("Score");
		Open Copen= new Open(gw);
		scoreB.setCommand(Copen);
		scoreB.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		scoreB.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		scoreB.getUnselectedStyle().setBgTransparency(255);
		EContainer.add(scoreB);
		addKeyListener('s', Copen);
		EContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
		add(BorderLayout.EAST, EContainer);
	//South container
		Container SContainer= new Container(new FlowLayout(Component.CENTER));
		SContainer.getAllStyles().setPadding(Component.RIGHT, 10);
		//collide two aliens and create new alien
		Button newAl= new Button("NewAlien");
		Collide Ccol= new Collide(gw);
		newAl.setCommand(Ccol);
		newAl.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		newAl.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		newAl.getUnselectedStyle().setBgTransparency(255);
		SContainer.add(newAl);
		addKeyListener('w', Ccol);
		//sim fight
		Button fight= new Button("Fight");
		SimFight Cfight= new SimFight(gw);
		fight.setCommand(Cfight);
		fight.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		fight.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		fight.getUnselectedStyle().setBgTransparency(255);
		SContainer.add(fight);
		addKeyListener('f', Cfight);
		//tick clock to move forward
		Button tick= new Button("Tick");
		Tick Ctick= new Tick(gw);
		tick.setCommand(Ctick);
		tick.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		tick.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		tick.getUnselectedStyle().setBgTransparency(255);
		SContainer.add(tick);
		addKeyListener('t', Ctick);
		SContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));
		add(BorderLayout.SOUTH, SContainer);
	//center container
		add(BorderLayout.CENTER, mv);
	//set targets for commands
		Expand.setTarget(gw);
		Contract.setTarget(gw);
		MoveDown.setTarget(gw);
		SimFight.setTarget(gw);
		Collide.setTarget(gw);
		MoveLeft.setTarget(gw);
		MoveRight.setTarget(gw);
		Open.setTarget(gw);
		Audio.setTarget(gw);
		Tick.setTarget(gw);
		AlMove.setTarget(gw);
		AsMove.setTarget(gw);
		MoveUP.setTarget(gw);
		
		this.requestFocus();
		this.setVisible(true);
		this.show();
	}
	
}
