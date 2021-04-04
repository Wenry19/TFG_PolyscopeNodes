package com.upc.EasyProduction.dragdrop;



import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.blocks.Workflow;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	
	// start singleton
	
	private static MainPanel mainPanel = new MainPanel();
	
	private MainPanel() {
		
		optionsPanel = new OptionsPanel();
		workflow = Workflow.getInstance();
		
		JScrollPane aux = new JScrollPane(workflow.getPanel());
		JScrollPane aux2 = new JScrollPane(optionsPanel);
		aux.setPreferredSize(new Dimension(200, 407));
		aux.setSize(new Dimension(200, 407));
		
		aux2.setPreferredSize(new Dimension(406, 407));
		aux2.setSize(new Dimension(406, 407));
		
		this.setLayout(null);
		
		this.add(optionsPanel, JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(aux, JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
	}
	
	public static MainPanel getInstance() {
		return mainPanel;
	}
	
	// end singleton

}
