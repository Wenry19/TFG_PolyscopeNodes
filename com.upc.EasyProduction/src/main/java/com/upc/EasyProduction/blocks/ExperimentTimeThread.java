package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ExperimentTimeThread extends Block{	
	
	// Singleton (only one instance)
	
	private static ExperimentTimeThread singleton = new ExperimentTimeThread();
	
	
	private ExperimentTimeThread() {
		
		defaultCode = "\n"
				+ "    # $ 100 \"SubTarea_2\"\n"
				+ "    thread SubTarea_2():\n"
				+ "      while (True):\n"
				+ "        # $ 101 \"If ExperimentTIME≥900\"\n"
				+ "        if (ExperimentTIME >= 900):\n"
				+ "          # $ 102 \"'The Experiment has finished !!!    Thanks'\"\n"
				+ "          # 'The Experiment has finished !!!    Thanks'\n"
				+ "          # $ 103 \"ExperimentTIME: Reset\"\n"
				+ "          ExperimentTIME = 0\n"
				+ "          # $ 104 \"Set DO[0]=On\"\n"
				+ "          set_standard_digital_out(0, True)\n"
				+ "          # $ 105 \"Set DO[2]=On\"\n"
				+ "          set_standard_digital_out(2, True)\n"
				+ "          # $ 106 \"Popup: The Experiment has finished !!! Thanks\"\n"
				+ "          popup(\"The Experiment has finished !!! Thanks\", \"Message\", False, False, blocking=False)\n"
				+ "          halt\n"
				+ "        end\n"
				+ "      end\n"
				+ "    end\n"
				+ "    threadId_SubTarea_2 = run SubTarea_2()";
		
		name = "ExperimentTimeThread";
		blockLabel = new JLabel();
		
		blockLabel.setText(name);
		blockLabel.setText(this.name);
		blockLabel.setOpaque(true);
		blockLabel.setVerticalAlignment(JLabel.CENTER);
		blockLabel.setHorizontalAlignment(JLabel.CENTER);
		blockLabel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		blockLabel.setSize(new Dimension(WIDTH, HEIGHT));
		blockLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		blockLabel.setBackground(Color.LIGHT_GRAY);
		
	}
	
	public static ExperimentTimeThread getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
