
package com.upc.EasyProduction.dragdrop;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane; // eye!!


public class OptionsPanel extends JPanel {
	
	private JPanel dragDropPanel;
	
	private MouseListener mouseListener = new MouseListener();
			
	public OptionsPanel() {
		
		initialize();
		//provisional
		addOption("tests1");
		addOption("tests2");
		addOption("tests3");
		addOption("tests4");
		addOption("tests5");
		addOption("tests6");
		addOption("tests7");
				
	}
	
	private void initialize() {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		this.setSize(406, 407);
		this.setPreferredSize(new Dimension(406, 407));
		
		this.setLocation(200, 0);
		
		this.setBackground(Color.gray);
		
		//________
		
		
		this.dragDropPanel = new JPanel();
		this.dragDropPanel.setLayout(null);
		
		this.dragDropPanel.setSize(606, 407);
		this.dragDropPanel.setPreferredSize(new Dimension(606, 407));
		this.dragDropPanel.setOpaque(false);
		this.dragDropPanel.setLocation(0, 0);
		
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
		this.dragDropPanel.add(opt.getDragLabel());
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