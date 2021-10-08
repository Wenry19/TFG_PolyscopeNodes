package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.ScriptData;
import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;

/**
 * This class represents the Script block.
 * @author Enric Lamarca Ferrés
 *
 */
public class Script extends Operation{
	
	/**
	 * Script JTextField of the parameters panel.
	 */
	private JTextField scriptField = new JTextField();
	/**
	 * Auxiliary boolean that is used to avoid updating the contribution DataModel when it is not the intention.
	 */
	private boolean controlUpdateDataModel = true;
	
	/**
	 * Constructor.
	 */
	public Script() {
		
		defaultCode = "# Enter your code here";
		
		name = "Script"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		scriptField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KeyboardTextInput keyboardInput = Workflow.getInstance().getUserInteraction().getKeyboardInputFactory().createStringKeyboardInput().setInitialValue(code);
				keyboardInput.show(scriptField, new KeyboardInputCallback<String>() {
					
					@Override
					public void onOk(String value) {
						
						code = value;
						scriptField.setText(value);
						
						if (controlUpdateDataModel) {
							Workflow.getInstance().updateDataModel(new int[] {wfPos});
						}
						
					}
				});
			}
		});
		
		panel.setLayout(new GridLayout(1, 1));
		
		panel.add(scriptField);
		
	}
	
	@Override
	public String generateCode() {
		
		// indentation of every line entered by the user
		// this time is not only one line of code to add indentation...
		
		if (code.equals("")) {
			return "\n" + indentation + defaultCode;
		}

		
		// split the code by lines and add the correspondent indentation to each line
		
		String lines[] = code.split("\n"); // diria que al fer split els salts de linia no s'inclouen...
		
		String indentedCode = "\n";
		
		for (int i = 0; i < lines.length; i++) {
			
			indentedCode = indentedCode + indentation + lines[i] + "\n"; // afegim salt de linia perk diria que split es menja els salts de linia
			
		}
		
		return indentedCode;
	}
	
	@Override
	public BlockData getBlockData() {
		return new ScriptData(getClassName(), isSelected, indentation, code);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		scriptField.setText(code);

		controlUpdateDataModel = true;
	}
	
	// setters
	
		/**
		 * Setter of the code text.
		 * @param code code text.
		 */
		public void setCode(String code) {
			this.code = code;
		}
	
}
