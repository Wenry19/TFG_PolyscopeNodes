package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.upc.EasyProduction.blocks.Block;

public class DefPutFuncs extends Block implements ActionListener{
	
	JComboBox velocityComboBox;
	JLabel velocityLabel;
	
	JComboBox accelerationComboBox;
	JLabel accelerationLabel;
	
	Double velocity;
	Double acceleration;
	
	public DefPutFuncs() {
		
		velocity = 4.363323129985823;
		
		acceleration = 8.726646259971647;
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		
		String[] Values = {"Default", "Slow"};
		
		// velocity
		velocityComboBox = new JComboBox(Values);
		velocityComboBox.addActionListener(this);
		velocityComboBox.setPreferredSize(new Dimension(100, 20));
		
		velocityLabel = new JLabel("Velocity");

		// acceleration
		accelerationComboBox = new JComboBox(Values);
		accelerationComboBox.addActionListener(this);
		
		accelerationLabel = new JLabel("Acceleration");
		
		panel.add(velocityLabel);
		panel.add(velocityComboBox);
		panel.add(accelerationLabel);
		panel.add(accelerationComboBox);
		
		frame.add(panel);
		//frame.pack();
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == velocityComboBox) {
			
			if (velocityComboBox.getSelectedItem() == "Default") {
				velocity = 4.363323129985823;
			}
			
			else if (velocityComboBox.getSelectedItem() == "Slow") {
				velocity = 0.5;
			}
			
			//System.out.println(velocity);
			
		}
		
		else if (e.getSource() == accelerationComboBox) {
			
			if (accelerationComboBox.getSelectedItem() == "Default") {
				acceleration = 8.726646259971647;
			}
			
			else if (accelerationComboBox.getSelectedItem() == "Slow") {
				acceleration = 2.726646259971647;
			}
			
			//System.out.println(acceleration);
			
		}
		
	}

}
