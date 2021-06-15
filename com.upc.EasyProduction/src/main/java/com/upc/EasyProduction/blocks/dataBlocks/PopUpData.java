package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.PopUp;

public class PopUpData extends BlockData{
	
	private String indentation;
	
	private String title;
	private String message;
	
	private boolean isMessage;
	private boolean isWarning;
	private boolean isError;
	private boolean isBlocking;
	
	public PopUpData(String className, Boolean isSelected, String indentation, String title, String message, boolean isMessage, boolean isWarning, boolean isError, boolean isBlocking) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.title = title;
		this.message = message;
		this.isMessage = isMessage;
		this.isWarning = isWarning;
		this.isError = isError;
		this.isBlocking = isBlocking;
	}
	
	@Override
	public Block getBlockInstance() {
				
		PopUp b = (PopUp) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setTitle(title);
		b.setMessage(message);
		b.setIsMessage(isMessage);
		b.setIsWarning(isWarning);
		b.setIsError(isError);
		b.setIsBlocking(isBlocking);
		
		b.setPanel();
				
		return (Block) b;
	}

}
