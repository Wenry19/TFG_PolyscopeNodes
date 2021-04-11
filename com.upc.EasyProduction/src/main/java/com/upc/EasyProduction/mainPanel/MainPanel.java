package com.upc.EasyProduction.mainPanel;



import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.dragdrop.OptionsPanel;
import com.upc.EasyProduction.workflow.Workflow;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	
	// start singleton
	
	private static MainPanel mainPanel = new MainPanel();
	
	private MainPanel() {
		
		optionsPanel = OptionsPanel.getInstance();
		workflow = Workflow.getInstance();
		
		this.setLayout(null);
		
		this.add(optionsPanel.getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getScrollPanel(), JLayeredPane.DRAG_LAYER);
		this.setBounds(0, 0, 606, 407);
		
	}
	
	public static MainPanel getInstance() {
		return mainPanel;
	}
	
	// end singleton

}
