package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;


public class Thread extends Block implements ItemListener {
	
	private JToggleButton toggleButton = new JToggleButton("Activate Thread", false);
	
	protected boolean activateThread = false;
	
	private boolean controlUpdateDataModel = true;
	
	public Thread() {
		
		this.setBackground(new Color(0xd3caca));
		
		// param panel
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		toggleButton.addItemListener(this);
		
		this.setEnabled(false);
		
		panel.add(toggleButton);
	}
	
	@Override
	public BlockData getBlockData() {
		return new ThreadData(getClassName(), isSelected, activateThread);
	}
	
	public void setActivateThread(Boolean activateThread) {
		this.activateThread = activateThread;
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false;
		
		toggleButton.setSelected(activateThread); // this does not trigger an action event
		this.setEnabled(activateThread);
		
		controlUpdateDataModel = true;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		int state = e.getStateChange();
		
		if (state == ItemEvent.SELECTED) {
			activateThread = true;
			this.setEnabled(true);
		}
		else {
			activateThread = false;
			
			this.setEnabled(false);
		}
		
		if(controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}
}
