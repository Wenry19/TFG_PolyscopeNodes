package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class GetCAPs extends HumanWork {
	
	
	public GetCAPs() {
				
		identation = "      ";
		
		defaultCode = "\n"
				+ "      $ 60 \"'(((( GET CAPs )))))'\"\n"
				+ "      # '(((( GET CAPs )))))'\n"
				+ "      $ 61 \"Ajustar L_Verde=Encender\"\n"
				+ "      set_standard_digital_out(2, True)\n"
				+ "      $ 62 \"CAP_time: Iniciar\"\n"
				+ "      CAP_time_is_counting = True\n"
				+ "      $ 63 \"Aviso: OPERATOR:  *** Place CAP on ASSEMBLY ***\"\n"
				+ "      popup(\"OPERATOR:  *** Place CAP on ASSEMBLY ***\", \"Mensaje\", False, False, blocking=True)\n"
				+ "      $ 64 \"CAPs≔CAPs+4\"\n"
				+ "      global CAPs=CAPs+4\n"
				+ "      $ 65 \"CAP_time: Detener\"\n"
				+ "      CAP_time_is_counting = False\n"
				+ "      $ 66 \"Ajustar L_Verde=Apagar\"\n"
				+ "      set_standard_digital_out(2, False)";
		
		name = "GetCaps";
		
		this.setText(name);
		this.setBackground(new Color(0xe1e0bd));
		
		infoLabel.setText("Operator must place CAPs to finalize products and continue.");
		
		panel.add(infoLabel);
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}
}
