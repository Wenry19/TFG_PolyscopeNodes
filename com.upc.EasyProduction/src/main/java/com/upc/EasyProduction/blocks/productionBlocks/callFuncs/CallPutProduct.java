package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallPutProduct extends CallFuncs{		
		
		public CallPutProduct() {
			
			identation = "        ";
			
			defaultCode = "\n"
					+ "        # $ 88 \"Call PUT_PRODUCT_TO_PALLET\"\n"
					+ "        PUT_PRODUCT_TO_PALLET()\n"
					+ "        Loop_1 = Loop_1 + 1\n";
			
			name = "CallPutProduct";
			
			this.setText(name);
			
			infoLabel.setText("Call of the function PutProduct defined previously.");
			
			panel.add(infoLabel);
			
			
		}
		
		@Override
		public String generateCode() {
			code = defaultCode;
			
			return code;
		}

}
