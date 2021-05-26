package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.ExperimentTimeThreadData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;


public class ExperimentTimeThread extends Thread implements ItemListener{
	
	private JToggleButton toggleButton = new JToggleButton("Activate Experiment Timer", false);
	
	protected boolean activateExperimentTimer = false;
	
	private boolean controlUpdateDataModel = true;
	
	public ExperimentTimeThread() {
				
		identation = "  ";
		
		defaultCode = "\n"
				+ "  # $ 100 \"SubTarea_2\"\n"
				+ "  thread SubTarea_2():\n"
				+ "    while (True):\n"
				+ "      # $ 101 \"If ExperimentTIME≥900\"\n"
				+ "      if (ExperimentTIME >= 900):\n"
				+ "        # $ 102 \"'The Experiment has finished !!!    Thanks'\"\n"
				+ "        # 'The Experiment has finished !!!    Thanks'\n"
				+ "        # $ 103 \"ExperimentTIME: Reset\"\n"
				+ "        ExperimentTIME = 0\n"
				+ "        # $ 104 \"Set DO[0]=On\"\n"
				+ "        set_standard_digital_out(0, True)\n"
				+ "        # $ 105 \"Set DO[2]=On\"\n"
				+ "        set_standard_digital_out(2, True)\n"
				+ "        # $ 106 \"Popup: The Experiment has finished !!! Thanks\"\n"
				+ "        popup(\"The Experiment has finished !!! Thanks\", \"Message\", False, False, blocking=False)\n"
				+ "        halt\n"
				+ "      end\n"
				+ "    end\n"
				+ "  end\n"
				+ "  threadId_SubTarea_2 = run SubTarea_2()";
		
		name = "ExperimentTimeThread";
		
		this.setText(name);
		
		// param panel
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		toggleButton.addItemListener(this);
		
		this.setEnabled(false);
		
		panel.add(toggleButton);
		
		
		ExperimentTimeThreadData aux = new ExperimentTimeThreadData(getClassName(), isSelected, activateExperimentTimer);
		blockDataString = gson.toJson(aux);
		blockDataTypeString = aux.getClass().getName();
				
	}
	
	@Override
	public String generateCode() {
		
		if (activateExperimentTimer) {
			code = defaultCode; // falta fer tests de script generat!!
		}
		else {
			code = "\n";
		}
		
		return code;
	}
	
	@Override
	protected void updateBlockData() {
		
		blockDataString = gson.toJson(new ExperimentTimeThreadData(getClassName(), isSelected, activateExperimentTimer));
		
	}
	
	public void setActivateExperimentTimer(Boolean activateExperimentTimer) {
		this.activateExperimentTimer = activateExperimentTimer;
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false;
		
		toggleButton.setSelected(activateExperimentTimer); // this does not trigger an action event
		this.setEnabled(activateExperimentTimer);
		
		controlUpdateDataModel = true;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		int state = e.getStateChange();
		
		if (state == ItemEvent.SELECTED) {
			activateExperimentTimer = true;
			this.setEnabled(true);
		}
		else {
			activateExperimentTimer = false;
			
			this.setEnabled(false);
		}
		
		if(controlUpdateDataModel) {
			updateBlockData();
			Workflow.getInstance().updateDataModel();
		}
	}
}
