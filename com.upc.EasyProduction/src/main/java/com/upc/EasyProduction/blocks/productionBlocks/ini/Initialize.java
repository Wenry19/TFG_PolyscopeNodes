package com.upc.EasyProduction.blocks.productionBlocks.ini;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;


public class Initialize extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public Initialize() {
		
		panel.setLayout(new GridBagLayout());
		
	}
	
	public BlockData getBlockData() {
		
		return new BasicBlockData(getClassName(), isSelected);
		
	}

}
