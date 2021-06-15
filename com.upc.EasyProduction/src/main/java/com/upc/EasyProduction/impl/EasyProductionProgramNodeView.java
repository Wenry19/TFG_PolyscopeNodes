package com.upc.EasyProduction.impl;


import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.upc.EasyProduction.panelManagement.MainPanel;
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
						
		this.mainPanel = MainPanel.getInstance();
		this.mainPanel.setProvider(provider);
		this.mainPanel.setSystemAPI(apiProvider.getSystemAPI());
		this.mainPanel.setUserInteraction(apiProvider.getUserInterfaceAPI().getUserInteraction());
				
		panel.setLayout(null);
		
		panel.add(mainPanel);
		
	}

}
