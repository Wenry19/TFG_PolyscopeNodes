package com.upc.EasyProduction.impl;


import javax.swing.JPanel;


import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;

public class EasyProductionProgramNodeView implements SwingProgramNodeView<EasyProductionProgramNodeContribution>{
	
	private MainPanel mainPanel;
	
	
	private final ViewAPIProvider apiProvider;
	
	public EasyProductionProgramNodeView(ViewAPIProvider apiProvider) {
		
		this.apiProvider = apiProvider;
		
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		// provider provides us access to the active instance of contribution
		
		this.mainPanel = new MainPanel(provider);
		
		panel.setLayout(null);
		
		panel.add(mainPanel);
		
		
	}

}
