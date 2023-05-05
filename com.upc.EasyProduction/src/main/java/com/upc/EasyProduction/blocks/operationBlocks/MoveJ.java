package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.domain.userinteraction.RobotPositionCallback2;
import com.ur.urcap.api.domain.value.robotposition.PositionParameters;

public class MoveJ extends Operation{
	
	private JButton setWayPointButton = new JButton("SetWayPoint");
	
	private JLabel WayPointLabel = new JLabel("WayPoint: -");
	
	public MoveJ() {
		
		defaultCode = "\n# Insert moveJ\n";
		
		name = "MoveJ"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		setWayPointButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				robotPosManagement callback = new robotPosManagement();
				
				Workflow.getInstance().getUserInteraction().getUserDefinedRobotPosition(callback);
				
			}
			
		});
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 5;
		c.ipady = 10;
		
		c.gridheight = 1;
		c.gridwidth = 3;
		
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(WayPointLabel, c);
		
		c.gridheight = 1;
		c.gridwidth = 3;
		
		c.gridx = 0;
		c.gridy = 2;
		
		panel.add(setWayPointButton, c);
		
	}
	
	
	// used to get the robot position
	private class robotPosManagement extends RobotPositionCallback2{

		@Override
		public void onOk(PositionParameters parameters) {
			// TODO Auto-generated method stub
			
			
		}
		
	}
	
	
	
}
