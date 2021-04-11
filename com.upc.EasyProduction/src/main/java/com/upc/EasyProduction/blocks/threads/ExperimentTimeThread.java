package com.upc.EasyProduction.blocks.threads;

public class ExperimentTimeThread extends Thread{	
	
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
		
		this.setText(name);
		
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
