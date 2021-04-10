package com.upc.EasyProduction.impl;

import javax.swing.JScrollPane;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.upc.EasyProduction.MainPanel.MainPanel;
import com.upc.EasyProduction.blocks.Workflow;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;

public class EasyProductionProgramNodeView implements SwingProgramNodeView<EasyProductionProgramNodeContribution>{
	
	private Workflow workflow = Workflow.getInstance();
	private MainPanel mainPanel = MainPanel.getInstance();

//	// TESTS IN ECLIPSE --------------------------------------------------------
//	public EasyProductionProgramNodeView() {
//		this.apiProvider = null;
//	}
//	
//	public static void main(String [ ] args) { // proving
//		int margin = 8;
//		//Style style = new V5Style();
//		//Style style = new V3Style();
//
//		JPanel jPanel = new JPanel();
//		jPanel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
//		//new LightUpProgramNodeView(null, style).buildUI(jPanel, null);
//		new EasyProductionProgramNodeView().buildUI(jPanel, null);
//
//		JFrame jFrame = new JFrame();
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jFrame.add(jPanel);
//		jFrame.setPreferredSize(new Dimension(606, 407));
//		//jFrame.setSize(new Dimension(200, 24));
//		jFrame.setVisible(true);
//		jFrame.pack();
//	}
//	// TESTS IN ECLIPSE --------------------------------------------------------
	
	
	
	private final ViewAPIProvider apiProvider;
	
	public EasyProductionProgramNodeView(ViewAPIProvider apiProvider) {
		
		this.apiProvider = apiProvider;
		
	}
	
	private JComboBox<Float> ioComboBox = new JComboBox<Float>();
	
	public void setIOComboBoxItems(Float[] items) { // Contribution will be able to communicate through these methods
		// first we want to be sure that is empty
		
		ioComboBox.removeAllItems();
		ioComboBox.setModel(new DefaultComboBoxModel<Float>(items));
		
	}
	
	public void setIOComboBoxSelection(Float item) { // Contribution will be able to communicate through these methods
		ioComboBox.setSelectedItem(item);
	}
	
	private Box createIOComboBox(final JComboBox<Float> combo, final ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel label = new JLabel(" Velocity of put base ");
		
		combo.setPreferredSize(new Dimension(104, 30));
		combo.setMaximumSize(combo.getPreferredSize());
		
		// we want to be notified if user selects one option of the combo box
		combo.addItemListener(new ItemListener() { // eye!!
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					provider.get().onNbasesSelection((Float) e.getItem()); // provider.get() returns our active instance of our contribution
					
				}
				
			}
		});
		
		box.add(label);
		// following the label: (it is an horizontal box so it will be next to the label on the right)
		box.add(combo);
		
		return box;
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		// provider provides us access to the active instance of contribution
		
		panel.setLayout(null);
		
		panel.add(mainPanel);
		
		
	}

}
