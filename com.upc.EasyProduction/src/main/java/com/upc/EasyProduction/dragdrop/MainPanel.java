package com.upc.EasyProduction.dragdrop;


import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLayeredPane;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	
	// start singleton
	
	private static MainPanel mainPanel = new MainPanel();
	
	private MainPanel() {
		
		optionsPanel = new OptionsPanel();
		
		this.add(optionsPanel, JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		
	}
	
	public static MainPanel getInstance() {
		return mainPanel;
	}
	
	// end singleton
	
	public void test() {
		System.out.println(optionsPanel.opt1.getLocation());
	}

}
