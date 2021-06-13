package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.Operation;


public class EmptyOperationData extends BlockData{
	
	private String indentation;
	
	public EmptyOperationData(String className, Boolean isSelected, String indentation) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
	}
	
	@Override
	public Block getBlockInstance() {
				
		Operation b = (Operation) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setPanel();
				
		return (Block) b;
	}
}
