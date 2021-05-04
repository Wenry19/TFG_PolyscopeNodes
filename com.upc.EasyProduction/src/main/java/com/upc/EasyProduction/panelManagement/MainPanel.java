package com.upc.EasyProduction.panelManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.ur.urcap.api.contribution.ContributionProvider;

public class MainPanel extends JLayeredPane implements ActionListener{
	
	private OptionsPanel optionsPanel;
	private Workflow workflow;
	private JPanel paramPanel = new JPanel();
	
	private JPanel simOrRealPanel = new JPanel();
	JRadioButton simulationButton = new JRadioButton("Sim");
	JRadioButton realExecButton = new JRadioButton("Real");
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	
	private static MainPanel singleton = new MainPanel();
	
	private MainPanel() {
		
		workflow = Workflow.getInstance();
		optionsPanel = OptionsPanel.getInstance();
		
		this.setLayout(null);
		
		this.add(optionsPanel.getScrollPanel(), JLayeredPane.DEFAULT_LAYER);
		
		this.add(optionsPanel.getDragDropPanel(), JLayeredPane.DRAG_LAYER);
		
		this.add(workflow.getScrollPanel(), JLayeredPane.DRAG_LAYER);
		
		 
		paramPanel.setBounds(200, 254, 405, 149);
		paramPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.add(paramPanel, JLayeredPane.DEFAULT_LAYER);
		
		this.setBounds(0, 0, 606, 407);
		
		iniSimOrRealPanel();
		
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
	
	private void iniSimOrRealPanel() {
		
		simOrRealPanel.setLayout(new FlowLayout());
		
		simOrRealPanel.setSize(406, 30);
		simOrRealPanel.setPreferredSize(new Dimension(406, 30));
		simOrRealPanel.setLocation(200, 0);
		
		ButtonGroup group = new ButtonGroup();
		group.add(simulationButton);
		group.add(realExecButton);
		
		simulationButton.addActionListener(this);
		realExecButton.addActionListener(this);
		
		simOrRealPanel.add(simulationButton);
		simOrRealPanel.add(realExecButton);
		
		this.add(simOrRealPanel, JLayeredPane.DEFAULT_LAYER);
		
		simulationButton.setSelected(true); // default option (does not trigger an action event!!)
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == simulationButton) {
			Workflow.getInstance().setSim(true);
		}
		else { // real execution
			Workflow.getInstance().setSim(false);
		}
		//Workflow.getInstance().updateDataModel(); // ULL!!
	}
	
}
