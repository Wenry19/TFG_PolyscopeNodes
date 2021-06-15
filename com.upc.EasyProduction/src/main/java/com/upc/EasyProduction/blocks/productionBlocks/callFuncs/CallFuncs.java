package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;


public class CallFuncs extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public CallFuncs() {
		
		panel.setLayout(new GridBagLayout());
	}
	
	@Override
	public BlockData getBlockData() {
		return new BasicBlockData(getClassName(), isSelected);
	}
	
}
