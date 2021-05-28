package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;


public class FlowInstructions extends Block {
	
	protected JLabel infoLabel = new JLabel();
	
	public FlowInstructions() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
	public BlockData getBlockData() {	
		return new BasicBlockData(getClassName(), isSelected);
		
	}
}
