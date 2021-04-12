package com.upc.EasyProduction.blocks.productionBlocks;

import com.upc.EasyProduction.blocks.Block;

public class CallPutProduct extends Block{		
		
		public CallPutProduct() {
			
			identation = "        ";
			
			defaultCode = "\n"
					+ "        # $ 88 \"Call PUT_PRODUCT_TO_PALLET\"\n"
					+ "        PUT_PRODUCT_TO_PALLET()\n"
					+ "        Loop_1 = Loop_1 + 1\n";
			
			name = "CallPutProduct";
			
			this.setText(name);
			
			
		}
		
		@Override
		public String generateCode() {
			code = defaultCode;
			
			return code;
		}

}
