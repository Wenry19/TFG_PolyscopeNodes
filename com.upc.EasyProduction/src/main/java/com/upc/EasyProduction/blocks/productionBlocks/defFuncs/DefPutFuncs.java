package com.upc.EasyProduction.blocks.productionBlocks.defFuncs;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;


public class DefPutFuncs extends Block implements ChangeListener{
	
	private final Double DEFAULT_VELOCITY = 4.363323129985823;
	private final Double DEFAULT_ACCELERATION = 8.726646259971647;
	
	private final Double SLOW_VELOCITY = DEFAULT_VELOCITY/2.0;
	private final Double SLOW_ACCELERATION = DEFAULT_ACCELERATION/2.0;
	
	private final Double ULTRA_SLOW_VELOCITY = DEFAULT_VELOCITY/8.0;
	private final Double ULTRA_SLOW_ACCELERATION = DEFAULT_ACCELERATION/8.0;
	
	protected Double velocity = DEFAULT_VELOCITY;
	protected Double acceleration = DEFAULT_ACCELERATION;
	
	private JSlider velocitySlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 2);
	private JSlider accelerationSlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 2);
	
	private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
	private JLabel ultraSlowLabel = new JLabel("UltraSlow");
	private JLabel slowLabel = new JLabel("Slow");
	private JLabel defaultLabel = new JLabel("Default");
	
	private JLabel velocityLabel = new JLabel("Velocity");
	private JLabel accelerationLabel = new JLabel("Acceleration");
	
	public DefPutFuncs() {
		
		panel.setLayout(new GridLayout(0, 1, 0, -5));
		// vertical gap -5 perquè sinó, no sé per què, es solapa amb el punter de slider...
		
		velocityLabel.setHorizontalAlignment(JLabel.CENTER);
		accelerationLabel.setHorizontalAlignment(JLabel.CENTER);
		
		Font labelFont = ultraSlowLabel.getFont();
		ultraSlowLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		slowLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		defaultLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		
		// velocity
		
		velocitySlider.addChangeListener(this);
		velocitySlider.setMajorTickSpacing(1);
		velocitySlider.setPaintTicks(true);
		
		labelTable.put(0, ultraSlowLabel);
		labelTable.put(1, slowLabel);
		labelTable.put(2, defaultLabel);
		
		velocitySlider.setLabelTable(labelTable);
		
		velocitySlider.setPaintLabels(true);
		
		// acceleration
		
		accelerationSlider.addChangeListener(this);
		accelerationSlider.setMajorTickSpacing(1);
		accelerationSlider.setPaintTicks(true);
		
		accelerationSlider.setLabelTable(labelTable);
		
		accelerationSlider.setPaintLabels(true);
		
		// panel
		
		panel.add(velocityLabel);
		panel.add(velocitySlider);
		panel.add(accelerationLabel);
		panel.add(accelerationSlider);
		
	}
	
	public Double getVelocity() {
		return velocity;
	}
	
	public Double getAcceleration() {
		return acceleration;
	}
	
	
	public BlockData getBlockData() {
	    
		return new DefPutFuncsData(getClassName(), velocity, acceleration);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPanel() {
		
	}

}
