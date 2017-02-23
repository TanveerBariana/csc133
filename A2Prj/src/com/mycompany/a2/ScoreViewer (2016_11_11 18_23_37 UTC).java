package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
	
public class ScoreViewer extends Container implements Observer{
	private Label totalScore;
	private Label AsSave;
	private Label AlSave;
	private Label AsLeft;
	private Label AlLeft;
	private Label audio;
	private GameWorld gw;
	public ScoreViewer(GameWorld game) {
		// TODO Auto-generated constructor stub
		totalScore = new Label("  Total Score: " + game.getTotalScore());
		AsSave = new Label(" Astronauts Saved: " + game.getAsSaved());
		AlSave = new Label("Aliens  That Breached: " + game.getAlSaved());
		AsLeft = new Label("Astronauts Left: " + game.getAsLeft());
		AlLeft = new Label("Aliens Left: " + game.getAlLeft());
		audio = new Label("Sound: " + game.isAudioOn());
		setLayout(new FlowLayout(Component.CENTER));
		//Container topContainer = new Container(new GridLayout(1,6));
		Container topContainer = new Container();
		totalScore.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(totalScore);
		AlSave.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(AlSave);
		AlSave.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(AlSave);
		AsLeft.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(AsLeft);
		AlLeft.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(AlLeft);
		audio.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(audio);
		topContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.WHITE));
		//add(BorderLayout.NORTH, topContainer);
		add(topContainer);
		
		this.gw = game;
	}

	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}
