package com.upc.EasyProduction.panelManagement;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.ur.urcap.api.contribution.ContributionProvider;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	private JPanel paramPanel;
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	
	private static MainPanel singleton = new MainPanel();
	
	private MainPanel() {
		
		workflow = Workflow.getInstance();
		//workflow.setProvider(provider);
		optionsPanel = OptionsPanel.getInstance();
		
		this.setLayout(null);
		
		this.add(optionsPanel.getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getScrollPanel(), JLayeredPane.DRAG_LAYER);
		this.setBounds(0, 0, 606, 407);
		
	}
	
	public static MainPanel getInstance() {
		return singleton;
	}
	
//	public Workflow getWorkflowInstance() {
//		return workflow;
//	}
	
	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		this.provider = provider;
		workflow.setProvider(provider);
	}
	
}
