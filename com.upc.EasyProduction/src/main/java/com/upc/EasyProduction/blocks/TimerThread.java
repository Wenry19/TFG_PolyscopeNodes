package com.upc.EasyProduction.blocks;

public class TimerThread extends Block { // activate or deactivate timers?
	
	final private String defaultCode = "\n"
			+ "    thread Timer_Thread():\n"
			+ "      while (True):\n"
			+ "        if (CAP_time_is_counting):\n"
			+ "          CAP_time = CAP_time + get_steptime()\n"
			+ "        end\n"
			+ "        if (ExperimentTIME_is_counting):\n"
			+ "          ExperimentTIME = ExperimentTIME + get_steptime()\n"
			+ "        end\n"
			+ "        if (TimeWork_is_counting):\n"
			+ "          TimeWork = TimeWork + get_steptime()\n"
			+ "        end\n"
			+ "        if (BASEtime_is_counting):\n"
			+ "          BASEtime = BASEtime + get_steptime()\n"
			+ "        end\n"
			+ "        if (Time_to_Batch_is_counting):\n"
			+ "          Time_to_Batch = Time_to_Batch + get_steptime()\n"
			+ "        end\n"
			+ "        if (BEARINGtime_is_counting):\n"
			+ "          BEARINGtime = BEARINGtime + get_steptime()\n"
			+ "        end\n"
			+ "        sync()\n"
			+ "      end\n"
			+ "    end\n"
			+ "    run Timer_Thread()";
	
	private String code;
	
	
	// Singleton (only one instance)
	
	private static TimerThread singleton = new TimerThread();
	
	
	private TimerThread() { // maybe it should be singleton
		
	}
	
	public static TimerThread getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	public String getCode() {
		return generateCode();
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	private String generateCode() {
		code = defaultCode;
		
		return code;
	}
	
	
}
