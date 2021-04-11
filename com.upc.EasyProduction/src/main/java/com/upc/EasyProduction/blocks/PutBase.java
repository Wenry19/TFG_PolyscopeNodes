package com.upc.EasyProduction.blocks;

public class PutBase extends Block{
	
	// Singleton (only one instance)
	
	private static PutBase singleton = new PutBase();
	
	private PutBase() {
		
		defaultCode = "\n"
				+ "        # $ 40 \"Call PUT_BASE_MATRIZ_ASSEMBLY\"\n"
				+ "        PUT_BASE_MATRIZ_ASSEMBLY()\n"
				+ "      end";
		
		name = "PutBase";
		
		this.setText(name);
		
	}
	
	public static PutBase getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
