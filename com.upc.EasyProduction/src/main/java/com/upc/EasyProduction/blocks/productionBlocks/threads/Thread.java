package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.Color;


import javax.swing.BorderFactory;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Thread extends Block{
	
	public Thread() {
		this.setBackground(new Color(0xd3caca));
		//this.setBorder(BorderFactory.createDashedBorder(null, 5, 5)); // no li agrada a polyscope
		
		ThreadData aux = new ThreadData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
		
	}
	
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new ThreadData(getClassName(), isSelected));
		
	}
	
	
	/*@Override
	public void unselectBlock() {
		this.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
	}*/
}
