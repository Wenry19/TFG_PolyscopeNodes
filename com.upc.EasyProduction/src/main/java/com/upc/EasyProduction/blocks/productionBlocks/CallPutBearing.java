package com.upc.EasyProduction.blocks.productionBlocks;

import com.upc.EasyProduction.blocks.Block;

public class CallPutBearing extends Block{
		
		public CallPutBearing() {
			
			defaultCode = "\n"
					+ "        # $ 62 \"Call PUT_BEARING_MATRIZ_ASSEMBLY\"\n"
					+ "        PUT_BEARING_MATRIZ_ASSEMBLY()\n"
					+ "      end";
			
			name = "CallPutBearing";
			
			this.setText(name);
			
		}
				
		@Override
		protected String generateCode() {
			code = "";
			
			return code;
		}
}
