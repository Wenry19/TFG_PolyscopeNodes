package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;

public class CallFuncs extends Block{
	
	protected JLabel infoLabel = new JLabel();
	
	public CallFuncs() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		CallFuncsData aux = new CallFuncsData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();

	}
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new CallFuncsData(getClassName(), isSelected));
		
	}
}
