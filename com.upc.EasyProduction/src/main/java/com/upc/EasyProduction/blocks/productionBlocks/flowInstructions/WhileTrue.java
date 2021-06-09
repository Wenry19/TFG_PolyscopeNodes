package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class WhileTrue extends FlowInstructions {
	
	
	public WhileTrue() {
				
		indentation = "    ";
		
		defaultCode = "\n"
				+ "  while (True):\n"
				+ "    $ 12 \"Programa de robot\"\n"
				+ "    $ 13 \"'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\"\n"
				+ "    # 'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\n"
				+ "    $ 14 \"'Programa de Pruebas'\"\n"
				+ "    # 'Programa de Pruebas'\n"
				+ "    $ 15 \"TimeWork: Iniciar\"\n"
				+ "    TimeWork_is_counting = True\n"
				+ "    $ 16 \"Time_to_Batch: Iniciar\"\n"
				+ "    Time_to_Batch_is_counting = True\n"
				+ "    $ 17 \"ExperimentTIME: Iniciar\"\n"
				+ "    ExperimentTIME_is_counting = True\n";
		
		name = "While(True)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf)); // ull!
		
		infoLabel.setText("<html>Main While True. It is necessary to disable Polyscope infinite<br/>loop for good indentation of the generated script.</html>");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = "\n"
				+ "  while (True):\n"
				+ "    $ 12 \"Programa de robot\"\n"
				+ "    $ 13 \"'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\"\n"
				+ "    # 'Ver 3.0 rev 04/12/2020   4bases on stack 4bearing on stack &statistics'\n"
				+ "    $ 14 \"'Programa de Pruebas'\"\n"
				+ "    # 'Programa de Pruebas'\n"
				+ "    $ 15 \"TimeWork: Iniciar\"\n"
				+ "    TimeWork_is_counting = True\n"
				+ "    $ 16 \"Time_to_Batch: Iniciar\"\n"
				+ "    Time_to_Batch_is_counting = True\n"
				+ "    $ 17 \"ExperimentTIME: Iniciar\"\n"
				+ "    ExperimentTIME_is_counting = True\n";
		
		return code;
	}
}
