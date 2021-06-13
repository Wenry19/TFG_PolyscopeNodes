package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.EmptyOperationData;

public class Operation extends Block{
		
	public Operation() {
		
		this.setBackground(new Color(0xeae7e7));
	}
	
	
	@Override
	public String getDefaultCode() {
		return "\n" + indentation + defaultCode; //ULL!!!! (funciona només si és una línia de codi)
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return "\n" + indentation + code;
	}
	
	public BlockData getBlockData() {
		return new EmptyOperationData(getClassName(), isSelected, indentation);
	}
}
