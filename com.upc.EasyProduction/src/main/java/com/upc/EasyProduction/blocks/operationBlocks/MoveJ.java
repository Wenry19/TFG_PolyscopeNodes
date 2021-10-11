package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.MoveJData;
import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.domain.userinteraction.RobotPositionCallback2;
import com.ur.urcap.api.domain.value.jointposition.JointPositions;
import com.ur.urcap.api.domain.value.robotposition.PositionParameters;

public class MoveJ extends Operation{
	
	private JButton setWayPointButton = new JButton("SetWayPoint");
	
	private JLabel wayPointLabel = new JLabel("WayPoint: -");
	
	private String pos;
	
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
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
		
		panel.add(wayPointLabel, c);
		
		c.gridheight = 1;
		c.gridwidth = 3;
		
		c.gridx = 0;
		c.gridy = 2;
		
		panel.add(setWayPointButton, c);
		
	}
	
	@Override
	public String generateCode() {
		
		code = "movej(get_inverse_kin(" + pos + "))\n";
		
		return "\n" + indentation + code;
		
	}
	
	
	@Override
	public BlockData getBlockData() {		
		return new MoveJData(getClassName(), isSelected, indentation, pos);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		wayPointLabel.setText("WayPoint: " + pos);

		controlUpdateDataModel = true;
	}
	
	
	// setters
	
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	// used to get the robot position
	private class robotPosManagement extends RobotPositionCallback2{

		@Override
		public void onOk(PositionParameters parameters) {
			
			
			//pos = parameters.getJointPositions().toString().replace(" rad,", "").replace(" rad", ""); // trec comes perk sembla que donen problemes al serialitzar-les i guardar-les al datamode...
			
			pos = parameters.getPose().toString();
						
			wayPointLabel.setText("WayPoint (rad): " + pos);
			
			if (controlUpdateDataModel) {
				Workflow.getInstance().updateDataModel(new int[] {wfPos});
			}
			
			
		}
		
	}
	
	
	
}
