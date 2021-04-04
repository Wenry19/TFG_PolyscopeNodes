
package com.upc.EasyProduction.dragdrop;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class Option extends JLabel {

	private String name;
	private final int WIDTH = 190;
	private final int HEIGHT = 40;
	
	private JLabel dragOption;
	
	Option(String name){
		
		this.name = name;
		
		initialize();
	}

	private void initialize() {
		
		this.dragOption = new JLabel();
		this.dragOption.setText(this.name);
		this.dragOption.setOpaque(true);
		this.dragOption.setVerticalAlignment(JLabel.CENTER);
		this.dragOption.setHorizontalAlignment(JLabel.CENTER);
		this.dragOption.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.dragOption.setBackground(Color.GRAY);
		this.dragOption.setVisible(false);
		
		
				
		this.setText(name);
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				
		this.setOpaque(true);
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public JLabel getDragLabel() {
		return this.dragOption;
	}	
}