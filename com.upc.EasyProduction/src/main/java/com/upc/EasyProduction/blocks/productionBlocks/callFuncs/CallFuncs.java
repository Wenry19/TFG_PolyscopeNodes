package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;

public class CallFuncs extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public CallFuncs() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	public BlockData getBlockData() {
		return new CallFuncsData(getClassName(), isSelected);
	}
	
}
