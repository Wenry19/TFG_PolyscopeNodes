package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;

public class Operation extends Block{
		
	public Operation() {
		
		this.setBackground(new Color(0xeae7e7));
	}
	
	
	@Override
	public String getDefaultCode() {
		return "\n" + identation + defaultCode; //ULL!!!!
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return "\n" + identation + code;
	}
	
	public BlockData getBlockData() {
		return new OperationData(getClassName(), isSelected);
	}
}
