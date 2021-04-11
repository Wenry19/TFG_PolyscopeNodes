package com.upc.EasyProduction.blocks;

public class PutBearing extends Block{
		// Singleton (only one instance)
	
		private static PutBearing singleton = new PutBearing();
		
		
		private PutBearing() {
			
			defaultCode = "\n"
					+ "        # $ 62 \"Call PUT_BEARING_MATRIZ_ASSEMBLY\"\n"
					+ "        PUT_BEARING_MATRIZ_ASSEMBLY()\n"
					+ "      end";
			
			name = "PutBearing";
			
			this.setText(name);
			
		}
		
		public static PutBearing getInstance() {
			return singleton;
		}
		
		// End Singleton
		
		@Override
		protected String generateCode() {
			code = "";
			
			return code;
		}
}
