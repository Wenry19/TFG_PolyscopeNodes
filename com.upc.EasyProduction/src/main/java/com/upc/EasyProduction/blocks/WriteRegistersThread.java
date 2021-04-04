package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class WriteRegistersThread extends Block {
	
	// Singleton (only one instance)
	
	private static WriteRegistersThread singleton = new WriteRegistersThread();
	
	
	private WriteRegistersThread() {
		
		defaultCode = "\n"
				+ "    # $ 89 \"SubTarea_1\"\n"
				+ "    thread SubTarea_1():\n"
				+ "      while (True):\n"
				+ "        # $ 90 \"write_output_integer_register(0,BASEs)\"\n"
				+ "        write_output_integer_register(0,BASEs)\n"
				+ "        # $ 91 \"write_output_integer_register(1,BEARINGs)\"\n"
				+ "        write_output_integer_register(1,BEARINGs)\n"
				+ "        # $ 92 \"write_output_integer_register(2,CAPs)\"\n"
				+ "        write_output_integer_register(2,CAPs)\n"
				+ "        # $ 93 \"write_output_integer_register(5,PRODUCTs)\"\n"
				+ "        write_output_integer_register(5,PRODUCTs)\n"
				+ "        # $ 94 \"write_output_integer_register(6,CyclesCompleted)\"\n"
				+ "        write_output_integer_register(6,CyclesCompleted)\n"
				+ "        # $ 95 \"write_output_float_register(0,BASEtime)\"\n"
				+ "        write_output_float_register(0,BASEtime)\n"
				+ "        # $ 96 \"write_output_float_register(1,BEARINGtime)\"\n"
				+ "        write_output_float_register(1,BEARINGtime)\n"
				+ "        # $ 97 \"write_output_float_register(2,CAP_time)\"\n"
				+ "        write_output_float_register(2,CAP_time)\n"
				+ "        # $ 98 \"write_output_float_register(5,Time_to_Batch)\"\n"
				+ "        write_output_float_register(5,Time_to_Batch)\n"
				+ "        # $ 99 \"write_output_float_register(6,TimeWork)\"\n"
				+ "        write_output_float_register(6,TimeWork)\n"
				+ "      end\n"
				+ "    end\n"
				+ "    threadId_SubTarea_1 = run SubTarea_1()";
		
		name = "WriteRegistersThread";
		
		this.setText(name);
		this.setText(this.name);
		this.setOpaque(true);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.setBackground(Color.LIGHT_GRAY);;
		
	}
	
	public static WriteRegistersThread getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
	
}
