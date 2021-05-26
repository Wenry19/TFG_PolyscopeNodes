package com.upc.EasyProduction.blocks.productionBlocks.ini;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.HumanWorkData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;

public class Initialize extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public Initialize() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		InitializeData aux = new InitializeData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
		
		
	}

	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new InitializeData(getClassName(), isSelected));
		
	}

}
