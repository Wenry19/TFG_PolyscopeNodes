package com.upc.EasyProduction.panelManagement;

import javax.swing.JLayeredPane;

import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.ur.urcap.api.contribution.ContributionProvider;

public class MainPanel extends JLayeredPane{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	
	//private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	
	
	public MainPanel(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		
		workflow = Workflow.getInstance();
		workflow.setProvider(provider);
		optionsPanel = OptionsPanel.getInstance();
		
		this.setLayout(null);
		
		this.add(optionsPanel.getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getScrollPanel(), JLayeredPane.DRAG_LAYER);
		this.setBounds(0, 0, 606, 407);
		
	}
	
//	public Workflow getWorkflowInstance() {
//		return workflow;
//	}
	
//	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
//		this.provider = provider;
//		workflow.setProvider(provider);
//	}
	
}
