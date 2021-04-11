package com.upc.EasyProduction.blocks;

public class PutProduct extends Block{
	
		// Singleton (only one instance)??
	
		private static PutProduct singleton = new PutProduct();
		
		
		private PutProduct() {
			
			defaultCode = "\n"
					+ "          # $ 88 \"Call PUT_PRODUCT_TO_PALLET\"\n"
					+ "          PUT_PRODUCT_TO_PALLET()\n"
					+ "          Loop_1 = Loop_1 + 1\n"
					+ "        end\n"
					+ "      end\n"
					+ "    end";
			
			name = "PutProduct";
			
			this.setText(name);
			
			
		}
		
		public static PutProduct getInstance() {
			return singleton;
		}
		
		// End Singleton
		
		@Override
		protected String generateCode() {
			code = "";
			
			return code;
		}

}
