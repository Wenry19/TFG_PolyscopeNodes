package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.FlowInstructionsData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class FlowInstructions extends Block {
	
	protected JLabel infoLabel = new JLabel();
	
	public FlowInstructions() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		FlowInstructionsData aux = new FlowInstructionsData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
			
	}
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new FlowInstructionsData(getClassName(), isSelected));
		
	}
}
