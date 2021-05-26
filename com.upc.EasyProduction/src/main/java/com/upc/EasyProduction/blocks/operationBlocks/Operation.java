package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;

public class Operation extends Block{
		
	public Operation() {
		
		setBackground(new Color(0xeae7e7));
		
		OperationData aux = new OperationData(getClassName(), isSelected);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
		
	}
	
	
	@Override
	public String getDefaultCode() {
		return "\n" + identation + defaultCode; //ULL!!!! (funciona només si és una línia de codi)
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return "\n" + identation + code;
	}
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new OperationData(getClassName(), isSelected));
		
	}
}
