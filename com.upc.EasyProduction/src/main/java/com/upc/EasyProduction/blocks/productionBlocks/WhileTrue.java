package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class WhileTrue extends Block {
	
	
	public WhileTrue() {
		defaultCode = "\n"
				+ "    while (True):\n"
				+ "      # $ 12 \"Robot Program\"\n"
				+ "      # $ 13 \"'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\"\n"
				+ "      # 'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\n"
				+ "      # $ 14 \"'Programa de Pruebas'\"\n"
				+ "      # 'Programa de Pruebas'\n"
				+ "      # $ 15 \"TimeWork: Start\"\n"
				+ "      TimeWork_is_counting = True\n"
				+ "      # $ 16 \"Time_to_Batch: Start\"\n"
				+ "      Time_to_Batch_is_counting = True\n"
				+ "      # $ 17 \"ExperimentTIME: Start\"\n"
				+ "      ExperimentTIME_is_counting = True\n"
				+ "      # $ 18 \"MoveJ\"\n"
				+ "      # $ 19 \"P_Ready\" \"breakAfter\"\n"
				+ "      movej(get_inverse_kin(p[.298616357137, -.112388877195, .127097072908, -2.221424005928, 2.221422962714, -.000273677751], qnear=[-3.5587941304981996E-5, -1.5707243124591272, -1.5707510153399866, -1.5707724730121058, 1.5706911087036133, -3.606477846318512E-5]), a=8.726646259971647, v=4.363323129985823)";
		
		name = "WhileTrue";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf)); // ull!
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
