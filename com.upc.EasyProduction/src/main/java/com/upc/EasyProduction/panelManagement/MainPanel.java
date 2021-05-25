package com.upc.EasyProduction.panelManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.domain.SystemAPI;

public class MainPanel extends JLayeredPane{
	
	private JPanel paramPanel = new JPanel();
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	private SystemAPI sysAPI;
	
	private static MainPanel singleton = new MainPanel();
	
	private MainPanel() {
		
		this.setLayout(null);
		
		this.add(OptionsPanel.getInstance().getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		
		this.add(OptionsPanel.getInstance().getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(Workflow.getInstance().getScrollPanel(), JLayeredPane.DRAG_LAYER);
		
		 
		paramPanel.setBounds(200, 254, 405, 149);
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
		Workflow.getInstance().setProvider(provider);
	}
	
	public void setSystemAPI(SystemAPI sysAPI) {
		this.sysAPI = sysAPI;
		Workflow.getInstance().setSystemAPI(sysAPI);
	}
	
}
