package com.upc.EasyProduction.panelManagement;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getScrollPanel(), JLayeredPane.DRAG_LAYER);
		
		
		paramPanel = new JPanel();
		paramPanel.setBounds(200, 254, 405, 149);
		//paramPanel.setBackground(Color.blue);
		paramPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(paramPanel, JLayeredPane.DEFAULT_LAYER);
		
		this.setBounds(0, 0, 606, 407);
		
	}
	
	public static MainPanel getInstance() {
		return singleton;
	}
	
	public void updateParamPanel(JScrollPane panel) {
		paramPanel.removeAll();
		
		paramPanel.setLayout(null);
		paramPanel.add(panel);
		
		paramPanel.revalidate();
		paramPanel.repaint();
		
	}
	
	public void clearParamPanel() {
		paramPanel.removeAll();
		paramPanel.revalidate();
		paramPanel.repaint();
	}
	
	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		this.provider = provider;
		workflow.setProvider(provider);
	}
	
}
