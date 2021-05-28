package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;


public class CallPutBearing extends CallFuncs{
		
		public CallPutBearing() {
			
			indentation = "      ";
			
			defaultCode = "\n"
					+ "      $ 58 \"Invocar PUT_BEARING_MATRIZ_ASSEMBLY\"\n"
					+ "      PUT_BEARING_MATRIZ_ASSEMBLY()";
			
			name = "CallPutBearing";
			
			this.setText(name);
			
			infoLabel.setText("Call of the function PutBearing defined previously.");
			
			panel.add(infoLabel);
			
		}
				
		@Override
		public String generateCode() {
			code = defaultCode;
			
			return code;
		}
}
