package com.upc.EasyProduction.impl;


import javax.swing.JPanel;

import com.upc.EasyProduction.panelManagement.MainPanel;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;

public class EasyProductionProgramNodeView implements SwingProgramNodeView<EasyProductionProgramNodeContribution>{
	
	private MainPanel mainPanel = MainPanel.getInstance();

//	// TESTS IN ECLIPSE --------------------------------------------------------
//	public EasyProductionProgramNodeView() {
//		this.apiProvider = null;
//	}
//	
//	public static void main(String [ ] args) { // proving
//		int margin = 8;
//		//Style style = new V5Style();
//		//Style style = new V3Style();
//
//		JPanel jPanel = new JPanel();
//		jPanel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
//		//new LightUpProgramNodeView(null, style).buildUI(jPanel, null);
//		new EasyProductionProgramNodeView().buildUI(jPanel, null);
//
//		JFrame jFrame = new JFrame();
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jFrame.add(jPanel);
//		jFrame.setPreferredSize(new Dimension(606, 407));
//		//jFrame.setSize(new Dimension(200, 24));
//		jFrame.setVisible(true);
//		jFrame.pack();
//	}
//	// TESTS IN ECLIPSE --------------------------------------------------------
	
	
	
	private final ViewAPIProvider apiProvider;
	
	public EasyProductionProgramNodeView(ViewAPIProvider apiProvider) {
		
		this.apiProvider = apiProvider;
		
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		// provider provides us access to the active instance of contribution
		
		panel.setLayout(null);
		
		panel.add(mainPanel);
		
		
	}

}
