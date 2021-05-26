package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.FlowInstructionsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.HumanWorkData;

public class HumanWork extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public HumanWork() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		HumanWorkData aux = new HumanWorkData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
		
	}
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new HumanWorkData(getClassName(), isSelected));
		
	}

}
