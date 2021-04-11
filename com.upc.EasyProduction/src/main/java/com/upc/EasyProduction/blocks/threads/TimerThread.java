package com.upc.EasyProduction.blocks.threads;

public class TimerThread extends Thread { // activate or deactivate timers?
	
	// Singleton (only one instance)
	
	private static TimerThread singleton = new TimerThread();
	
	
	private TimerThread() { // maybe it should be singleton
		
		defaultCode = "\n"
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
		
		name = "TimerThread";
		
		this.setText(name);
	}
	
	public static TimerThread getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = defaultCode;
		
		return code;
	}
	
	
}