package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class GetCAPs extends Block {
	
	
	public GetCAPs() {
		
		identation = "      ";
		
		defaultCode = "\n"
				+ "      # $ 64 \"'(((( GET CAPs )))))'\"\n"
				+ "      # '(((( GET CAPs )))))'\n"
				+ "      # $ 65 \"Set DO[2]=On\"\n"
				+ "      set_standard_digital_out(2, True)\n"
				+ "      # $ 66 \"CAP_time: Start\"\n"
				+ "      CAP_time_is_counting = True\n"
				+ "      # $ 67 \"Popup: OPERATOR:  *** Place CAP on ASSEMBLY ***\"\n"
				+ "      popup(\"OPERATOR:  *** Place CAP on ASSEMBLY ***\", \"Message\", False, False, blocking=True)\n"
				+ "      # $ 68 \"CAPs≔CAPs+4\"\n"
				+ "      global CAPs=CAPs+4\n"
				+ "      # $ 69 \"CAP_time: Stop\"\n"
				+ "      CAP_time_is_counting = False\n"
				+ "      # $ 70 \"Set DO[2]=Off\"\n"
				+ "      set_standard_digital_out(2, False)";
		
		name = "GetCaps";
		
		this.setText(name);
		this.setBackground(new Color(0xe1e0bd));
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}
}
