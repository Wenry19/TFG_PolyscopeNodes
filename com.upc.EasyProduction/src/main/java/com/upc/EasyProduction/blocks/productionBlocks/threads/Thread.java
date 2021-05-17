package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.Color;


import javax.swing.BorderFactory;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Thread extends Block{
	
	protected boolean activateExperimentTimer = false;
	
	public Thread() {
		this.setBackground(new Color(0xd3caca));
		//this.setBorder(BorderFactory.createDashedBorder(null, 5, 5)); // no li agrada a polyscope
	}
	
	@Override
	public BlockData getBlockData() {
		
		return new ThreadData(getClassName(), isSelected);
		
	}
	/*@Override
	public void unselectBlock() {
		this.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
	}*/
}
