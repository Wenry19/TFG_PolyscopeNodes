package com.upc.EasyProduction.dragdrop;



import javax.swing.JLayeredPane;

import com.upc.EasyProduction.blocks.Workflow;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	
	// start singleton
	
	private static MainPanel mainPanel = new MainPanel();
	
	private MainPanel() {
		
		optionsPanel = new OptionsPanel();
		workflow = Workflow.getInstance();
		
		this.setLayout(null);
		
		this.add(optionsPanel, JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getPanel(), JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
	}
	
	public static MainPanel getInstance() {
		return mainPanel;
	}
	
	// end singleton

}
