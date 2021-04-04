
package com.upc.EasyProduction.dragdrop;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane; // eye!!


public class OptionsPanel extends JPanel {
	
	private JPanel dragDropPanel;
	
	private MouseListener mouseListener;
	
	private LinkedList<Option> options;
			
	public OptionsPanel() {
		
		initialize();
		
		addDefaultOptions();
				
	}
	
	private void initialize() {
		
		mouseListener = new MouseListener();
		
		options = new LinkedList();
		
		// this JPanel which contains the different options
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		this.setSize(406, 407);
		this.setPreferredSize(new Dimension(406, 407));
		
		this.setLocation(200, 0);
		
		//this.setBackground(Color.gray);
		
		// aux JPanel which is used for drag and drop
		
		dragDropPanel = new JPanel();
		dragDropPanel.setLayout(null);
		
		dragDropPanel.setSize(606, 407);
		dragDropPanel.setPreferredSize(new Dimension(606, 407));
		dragDropPanel.setOpaque(false);
		dragDropPanel.setLocation(0, 0);
		
	}
	
	public JPanel getDragDropPanel() {
		return dragDropPanel;
	}
	
	public void addOption(String name) {
		
		Option opt = new Option(name);
		
		
		opt.getDragLabel().addMouseListener(mouseListener);
		opt.getDragLabel().addMouseMotionListener(mouseListener);
		
		opt.addMouseListener(mouseListener);
		
		this.add(opt);
		
		dragDropPanel.add(opt.getDragLabel());
		
		options.add(opt);
	}
	
	private void addDefaultOptions() {
		
		addOption("Sleep");
		addOption("Pop Up");
		addOption("Set Digital Output");
		addOption("Get Digital Input");
		addOption("Set Analog Output");
		addOption("Get Analog Input");
		
	}
	
	public void printOptions() {
		System.out.println(options);
	}
	
	
	
	// inner classes
	
	private class MouseListener extends MouseAdapter {
		
		private int prevX;
		private int prevY;
		
		private int offsetOptionsPanel = 200; // ULL!!
		
		private Option currentOptionSelected;
		
		
		public void mouseClicked(MouseEvent e) {
			
			if (e.getSource() instanceof Option) {
				
				Option opt = (Option) e.getSource();
				
				if (currentOptionSelected != null) {
					currentOptionSelected.getDragLabel().setVisible(false);
				}
				
				opt.getDragLabel().setVisible(true);
				
				opt.getDragLabel().setLocation(opt.getLocation().x + offsetOptionsPanel, opt.getLocation().y);
				
				currentOptionSelected = opt;
			}
			
			System.out.println("clicked" + " " + (e.getSource() instanceof Option));
			
		}
		
		public void mousePressed(MouseEvent e) {
						
			prevX = e.getX();
			prevY = e.getY();
				
		}
		
		public void mouseDragged(MouseEvent e) {
			
			JComponent jc = (JComponent) e.getSource();
			int difX = e.getX() - prevX;
			int difY = e.getY() - prevY;
	        jc.setLocation(jc.getLocation().x + difX, jc.getLocation().y + difY);
	        			
		}
		
		public void mouseReleased(MouseEvent e) {
			
			if (!(e.getSource() instanceof Option)) {
				JLabel draggedLabel = (JLabel) e.getSource();
				draggedLabel.setVisible(false);
			}
			
			System.out.println("released");
			
		}
		
		public void mouseEntered(MouseEvent e) {
			System.out.println("entered"+ ((JLabel)e.getSource()).getText());
		}
	}
	
}