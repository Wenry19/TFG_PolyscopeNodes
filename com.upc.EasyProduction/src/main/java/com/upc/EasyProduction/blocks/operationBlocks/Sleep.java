package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.SleepData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Sleep extends Operation implements ChangeListener{
	
	private JSlider durationSlider = new JSlider();
	private JLabel durationLabel  = new JLabel();
	
	private int duration = 15;
	
	private boolean controlUpdateDataModel = true;
	
	public Sleep() {
		
		defaultCode = "sleep(15)\n";
		
		name = "Sleep"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		durationLabel.setHorizontalAlignment(JLabel.CENTER);
		
		durationLabel.setText("Duration = 15s");
		
		durationSlider.setMinimum(0);
		durationSlider.setMaximum(30);
		
		//controlUpdateDataModel = false;
		
		// abans de posar listener així que no cal controlUpdateDataModel
		durationSlider.setValue(15);
		
		//controlUpdateDataModel = true;
		
		durationSlider.setOrientation(JSlider.HORIZONTAL);
		
		
		durationSlider.addChangeListener(this);
		
		panel.setLayout(new GridLayout(3, 1, 5, 5));
		
		panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		panel.add(durationLabel);
		
		panel.add(durationSlider);
		
	}
	
	@Override
	public String generateCode() {
		code = "sleep(" + duration + ")\n";
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new SleepData(getClassName(), isSelected, indentation, duration);
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		durationSlider.setValue(duration);
				
		controlUpdateDataModel = true;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider)e.getSource();
		
		if (!source.getValueIsAdjusting()) { 
			
			duration = source.getValue();
			
			durationLabel.setText("Duration = " + String.valueOf(source.getValue()) + "s");
			
			if (controlUpdateDataModel) {
				Workflow.getInstance().updateDataModel(new int[] {wfPos});
			}
		}
	}
	
	// setters
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
