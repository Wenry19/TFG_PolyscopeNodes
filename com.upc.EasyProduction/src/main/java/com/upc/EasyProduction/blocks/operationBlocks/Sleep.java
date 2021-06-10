package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.FlowLayout;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.SleepData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Sleep extends Operation implements ChangeListener{
	
	private JSlider durationSlider = new JSlider();
	
	private boolean controlUpdateDataModel = true;
	
	private int duration = 0;
	
	public Sleep() {
		
		defaultCode = "sleep(0)\n";
		
		name = "Sleep"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		durationSlider.setMinimum(0);
		durationSlider.setMaximum(30);
		
		//controlUpdateDataModel = false;
		
		// abans de posar listener així que no cal controlUpdateDataModel
		durationSlider.setValue(0);
		
		//controlUpdateDataModel = true;
		
		durationSlider.setOrientation(JSlider.HORIZONTAL);
		
		durationSlider.addChangeListener(this);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(durationSlider);
		
	}
	
	@Override
	public String generateCode() {
		code = "sleep(" + duration + ")\n";
		
		return "\n" + indentation + code;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider)e.getSource();
		
		if (!source.getValueIsAdjusting()) { 
			
			duration = source.getValue();
			
			if (controlUpdateDataModel) {
				Workflow.getInstance().updateDataModel(new int[] {wfPos});
			}
		}
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		durationSlider.setValue(duration);
				
		controlUpdateDataModel = true;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public BlockData getBlockData() {
	    
		return new SleepData(getClassName(), isSelected, indentation, duration);
		
	}
}
