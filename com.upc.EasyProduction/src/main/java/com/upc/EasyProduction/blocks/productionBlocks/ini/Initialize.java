package com.upc.EasyProduction.blocks.productionBlocks.ini;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;

public class Initialize extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public Initialize() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
	public BlockData getBlockData() {
		
		return new InitializeData(getClassName(), isSelected);
		
	}

}
