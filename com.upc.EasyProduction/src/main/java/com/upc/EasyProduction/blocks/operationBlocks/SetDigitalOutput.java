package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.SetDigitalOutputData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class SetDigitalOutput extends Operation implements ActionListener{
	
	private JRadioButton out0 = new JRadioButton("0");
	private JRadioButton out1 = new JRadioButton("1");
	private JRadioButton out2 = new JRadioButton("2");
	private JRadioButton out3 = new JRadioButton("3");
	private JRadioButton out4 = new JRadioButton("4");
	private JRadioButton out5 = new JRadioButton("5");
	private JRadioButton out6 = new JRadioButton("6");
	private JRadioButton out7 = new JRadioButton("7");
	
	private JRadioButton high = new JRadioButton("H");
	private JRadioButton low = new JRadioButton("L");
	
	private JLabel outsLabel = new JLabel("Select digital output:");
	private JLabel valueLabel = new JLabel("Select value:");
	
	private String out = "0";
	private String value = "False"; // false -> low, true -> high
	
	private boolean controlUpdateDataModel = true;
	
	public SetDigitalOutput() {
		
		defaultCode = "set_standard_digital_out(0,False)";
		
		name = "SetDigitalOutput";
				
		this.setText(name);
		
		// param panel
		
		out0.setSelected(true);
		low.setSelected(true);
		
		out0.addActionListener(this);
		out1.addActionListener(this);
		out2.addActionListener(this);
		out3.addActionListener(this);
		out4.addActionListener(this);
		out5.addActionListener(this);
		out6.addActionListener(this);
		out7.addActionListener(this);
		low.addActionListener(this);
		high.addActionListener(this);
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		buttonGroup1.add(out0);
		buttonGroup1.add(out1);
		buttonGroup1.add(out2);
		buttonGroup1.add(out3);
		buttonGroup1.add(out4);
		buttonGroup1.add(out5);
		buttonGroup1.add(out6);
		buttonGroup1.add(out7);
		
		buttonGroup2.add(low);
		buttonGroup2.add(high);
		
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipady = 10;
		
		c.gridwidth = 8;
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(outsLabel, c);
		
		c.gridx = 0;
		c.gridy = 2;
		
		panel.add(valueLabel, c);
		
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(out0, c);
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(out1, c);
		
		c.gridx = 2;
		c.gridy = 1;
		
		panel.add(out2, c);
		
		c.gridx = 3;
		c.gridy = 1;
		
		panel.add(out3, c);
		
		c.gridx = 4;
		c.gridy = 1;
		
		panel.add(out4, c);
		
		c.gridx = 5;
		c.gridy = 1;
		
		panel.add(out5, c);
		
		c.gridx = 6;
		c.gridy = 1;
		
		panel.add(out6, c);
		
		c.gridx = 7;
		c.gridy = 1;
		
		panel.add(out7, c);
		
		c.gridx = 2;
		c.gridy = 3;
		
		panel.add(low, c);
		
		c.gridx = 5;
		c.gridy = 3;
		
		panel.add(high, c);
	}
	
	public void setOut(String out) {
		this.out = out;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String generateCode() {
		code = "set_standard_digital_out(" + out + "," + value + ")\n";
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new SetDigitalOutputData(getClassName(), isSelected, indentation, out, value);
	}
		
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		out0.setSelected(out.equals("0"));
		out1.setSelected(out.equals("1"));
		out2.setSelected(out.equals("2"));
		out3.setSelected(out.equals("3"));
		out4.setSelected(out.equals("4"));
		out5.setSelected(out.equals("5"));
		out6.setSelected(out.equals("6"));
		out7.setSelected(out.equals("7"));
		
		low.setSelected(value.equals("False"));
		high.setSelected(value.equals("True"));
				
		controlUpdateDataModel = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JRadioButton source = (JRadioButton) e.getSource();
		
		if (source == out0) {
			out = "0";
		}
		else if(source == out1) {
			out = "1";
		}
		else if(source == out2) {
			out = "2";
		}
		else if(source == out3) {
			out = "3";
		}
		else if(source == out4) {
			out = "4";
		}
		else if(source == out5) {
			out = "5";
		}
		else if(source == out6) {
			out = "6";
		}
		else if(source == out7) {
			out = "7";
		}
		else if(source == high) {
			value = "True";
		}
		else if(source == low) {
			value = "False";
		}
		
		if (controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}
}
