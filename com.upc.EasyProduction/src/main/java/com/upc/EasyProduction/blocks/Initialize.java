package com.upc.EasyProduction.blocks;

public class Initialize {
	
	final private String defaultCode = "\n"
			+ "    global cnt_1=0\n"
			+ "    global cnt_3=0\n"
			+ "    global cnt_5=0\n"
			+ "    global cont_1=0\n"
			+ "    global interpolate_2=0.0\n"
			+ "    global interpolate_3=0.0\n"
			+ "    global BASEtime=0\n"
			+ "    global BEARINGtime=0\n"
			+ "    global CAP_time=0\n"
			+ "    global ExperimentTIME=0\n"
			+ "    global TimeWork=0\n"
			+ "    global Time_to_Batch=0\n"
			+ "    global CAP_time_is_counting=False\n"
			+ "    global ExperimentTIME_is_counting=False\n"
			+ "    global TimeWork_is_counting=False\n"
			+ "    global BASEtime_is_counting=False\n"
			+ "    global Time_to_Batch_is_counting=False\n"
			+ "    global BEARINGtime_is_counting=False"
			+ "\n"
			+ "    # $ 2 \"BeforeStart\"\n"
			+ "    # $ 3 \"N_Bases≔0\"\n"
			+ "    global N_Bases=0\n"
			+ "    # $ 4 \"N_Bearings≔0\"\n"
			+ "    global N_Bearings=0\n"
			+ "    # $ 5 \"BASEs≔0\"\n"
			+ "    global BASEs=0\n"
			+ "    # $ 6 \"BEARINGs≔0\"\n"
			+ "    global BEARINGs=0\n"
			+ "    # $ 7 \"CAPs≔0\"\n"
			+ "    global CAPs=0\n"
			+ "    # $ 8 \"PRODUCTs≔0\"\n"
			+ "    global PRODUCTs=0\n"
			+ "    # $ 9 \"CyclesCompleted≔0\"\n"
			+ "    global CyclesCompleted=0\n"
			+ "    # $ 10 \"Set DO[0]=Off\"\n"
			+ "    set_standard_digital_out(0, False)\n"
			+ "    # $ 11 \"Set DO[2]=Off\"\n"
			+ "    set_standard_digital_out(2, False)";
	
	
	private String code;
	
	private int numberIniBases;
	private int numberIniBearings;
	private int numberIniProducts;
	
	// Singleton (only one instance)
	
	private static Initialize singleton = new Initialize();
	
	
	private Initialize() { // maybe it should be singleton
		
		numberIniBases = 0;
		numberIniBearings = 0;
		numberIniProducts = 0;
		
	}
	
	public static Initialize getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	
	public void setNumberIniBases(int numberIniBases) {
		if (numberIniBases > 4) numberIniBases = 4;
		this.numberIniBases = numberIniBases;
	}
	
	public void setNumberIniBearings(int numberIniBearings) {
		if (numberIniBearings > 4) numberIniBearings = 4;
		this.numberIniBearings = numberIniBearings;
	}

	public void setNumberIniProducts(int numberIniProducts) {
		if (numberIniProducts > 4) numberIniProducts = 4;
		this.numberIniProducts = numberIniProducts;
	}
	
	public int getNumberIniBases() {
		return this.numberIniBases;
	}
	
	public int getNumberIniBeaings() {
		return this.numberIniBearings;
	}
	
	public int getNumberIniProducts() {
		return this.numberIniProducts;
	}
	
	public String getCode() {
		return generateCode();
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	private String generateCode() {
		code =  "\n"
				+ "    global cnt_1=0\n"
				+ "    global cnt_3=0\n"
				+ "    global cnt_5=0\n"
				+ "    global cont_1=0\n"
				+ "    global interpolate_2=0.0\n"
				+ "    global interpolate_3=0.0\n"
				+ "    global BASEtime=0\n"
				+ "    global BEARINGtime=0\n"
				+ "    global CAP_time=0\n"
				+ "    global ExperimentTIME=0\n"
				+ "    global TimeWork=0\n"
				+ "    global Time_to_Batch=0\n"
				+ "    global CAP_time_is_counting=False\n"
				+ "    global ExperimentTIME_is_counting=False\n"
				+ "    global TimeWork_is_counting=False\n"
				+ "    global BASEtime_is_counting=False\n"
				+ "    global Time_to_Batch_is_counting=False\n"
				+ "    global BEARINGtime_is_counting=False"
				+ "\n"
				+ "    # $ 2 \"BeforeStart\"\n"
				+ "    # $ 3 \"N_Bases≔0\"\n"
				+ "    global N_Bases=" + Integer.toString(numberIniBases) + "\n"
				+ "    # $ 4 \"N_Bearings≔0\"\n"
				+ "    global N_Bearings=" + Integer.toString(numberIniBearings) + "\n"
				+ "    # $ 5 \"BASEs≔0\"\n"
				+ "    global BASEs=" + Integer.toString(numberIniBases) + "\n"
				+ "    # $ 6 \"BEARINGs≔0\"\n"
				+ "    global BEARINGs=" + Integer.toString(numberIniBearings) + "\n"
				+ "    # $ 7 \"CAPs≔0\"\n"
				+ "    global CAPs=0\n"
				+ "    # $ 8 \"PRODUCTs≔0\"\n"
				+ "    global PRODUCTs=" + Integer.toString(numberIniProducts) + "\n"
				+ "    # $ 9 \"CyclesCompleted≔0\"\n"
				+ "    global CyclesCompleted=0\n"
				+ "    # $ 10 \"Set DO[0]=Off\"\n"
				+ "    set_standard_digital_out(0, False)\n"
				+ "    # $ 11 \"Set DO[2]=Off\"\n"
				+ "    set_standard_digital_out(2, False)";
		
		return code;
	}
	
	
}
