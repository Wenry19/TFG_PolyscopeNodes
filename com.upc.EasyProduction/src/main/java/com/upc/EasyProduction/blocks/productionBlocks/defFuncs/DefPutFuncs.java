package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

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
		}
		
		else if (e.getSource() == accelerationComboBox) {
			
			if (accelerationComboBox.getSelectedItem() == "Default") {
				acceleration = 8.726646259971647;
			}
			
			else if (accelerationComboBox.getSelectedItem() == "Slow") {
				acceleration = 2.726646259971647;
			}			
		}
		
	}
	
	
	public BlockData getDataToSerialize() {
		
		return new DefPutFuncsData(this.getClass().getName(), velocity, acceleration);
		
	}
	
	// inner data class
	
	public class DefPutFuncsData extends BlockData{
		
		private double velocity;
		private double acceleration;
		
		public DefPutFuncsData(String id, double velocity, double acceleration){
			
			this.id = id;
			this.velocity = velocity;
			this.acceleration = acceleration;
			
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "DefPutBase") {
				return new DefPutBase(wf);
			}
			else if (id == "DefPutBearing") {
				return new DefPutBearing(wf);
			}
			else {//if (id == "DefPutProduct") {
				return new DefPutProduct(wf);
			}
		}
		
		public Double getVelocity() {
			return velocity;
		}
		
		public Double getAcceleration() {
			return acceleration;
		}
		
	}

}
