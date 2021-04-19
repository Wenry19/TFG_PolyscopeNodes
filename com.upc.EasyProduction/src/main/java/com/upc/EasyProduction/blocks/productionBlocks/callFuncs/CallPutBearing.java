package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallPutBearing extends CallFuncs{
		
		public CallPutBearing(Workflow wf) {
			
			this.wf = wf;
			
			identation = "      ";
			
			defaultCode = "\n"
					+ "      # $ 62 \"Call PUT_BEARING_MATRIZ_ASSEMBLY\"\n"
					+ "      PUT_BEARING_MATRIZ_ASSEMBLY()\n";
			
			name = "CallPutBearing";
			
			this.setText(name);
			
		}
				
		@Override
		public String generateCode() {
			code = defaultCode;
			
			return code;
		}
}
