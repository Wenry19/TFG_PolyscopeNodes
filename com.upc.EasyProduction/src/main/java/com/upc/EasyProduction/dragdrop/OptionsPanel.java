
package com.upc.EasyProduction.dragdrop;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane; // eye!!


public class OptionsPanel extends JPanel {
	
	private JPanel dragDropPanel;
	
	public Option opt1;
	public Option opt2;
		
	public OptionsPanel() {
		
		initialize();
		//provisional
		addOption("tests1");
		addOption("tests2");
		addOption("tests3");
		addOption("tests4");
		addOption("tests5");
		addOption("tests6");
		addOption("tests7");
		
		this.add(opt1);
		this.add(opt2);
				
	}
	
	private void initialize() {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		this.setSize(406, 407);
		this.setPreferredSize(new Dimension(406, 407));
		
		this.setLocation(200, 0);
		
		this.setBackground(Color.gray);
		
		//________
		
		this.opt1 = new Option("default1");
		this.opt2 = new Option("default2");
		
		
		this.dragDropPanel = new JPanel();
		this.dragDropPanel.setLayout(null);
		
		this.dragDropPanel.setSize(606, 407);
		this.dragDropPanel.setPreferredSize(new Dimension(606, 407));
		this.dragDropPanel.setOpaque(false);
		this.dragDropPanel.setLocation(0, 0);
		
		//add options labels drag
		this.dragDropPanel.add(this.opt1.getDragLabel());
		this.dragDropPanel.add(this.opt2.getDragLabel());
		
	}
	
	public JPanel getDragDropPanel() {
		return dragDropPanel;
	}
	
	public void addOption(String name) {
		
		Option opt = new Option(name);
		this.add(opt);
	}
	
}