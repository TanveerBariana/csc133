package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class MapViewer extends Container implements Observer {
	GameWorld game;
	public MapViewer(GameWorld gw) {
		setLayout(new BorderLayout());
		Container contain = new Container(new FlowLayout());
		contain.setWidth(1000);
		contain.setHeight(610);
		contain.getAllStyles().setBgTransparency(255);
		// TODO Auto-generated constructor stub
		contain.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		add(BorderLayout.CENTER, contain);
		
		this.game = gw;
	}

	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		if(observable instanceof GameWorld){
			game.map();
		}
	}

}
