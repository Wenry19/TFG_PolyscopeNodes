
package com.upc.EasyProduction.dragdrop;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Option extends JLabel {

	private String name;
	private final int WIDTH = 200;
	private final int HEIGHT = 50;
	
	private JLabel dragOption;
	private JPanel ddPanel;
	
	Option(String name){
		
		this.name = name;
		
		initialize();
	}

	private void initialize() {
		
		this.dragOption = new JLabel();
		this.dragOption.setText(this.name);
		this.dragOption.setOpaque(true);
		this.dragOption.setVerticalAlignment(JLabel.CENTER);
		this.dragOption.setHorizontalAlignment(JLabel.CENTER);
		this.dragOption.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setSize(new Dimension(WIDTH, HEIGHT));
		this.dragOption.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		this.ddPanel = new JPanel();
		this.ddPanel.setLayout(null);
		this.ddPanel.setSize(606, 407);
		this.ddPanel.setPreferredSize(new Dimension(606, 407));
		this.ddPanel.setOpaque(false);
		this.ddPanel.add(this.dragOption);
		this.ddPanel.setBackground(Color.green);
		this.ddPanel.setVisible(true);
		
		//this.dragOption.setLocation(this.getLocation());
		
		MouseListener mouseListener = new MouseListener();
		dragOption.addMouseListener(mouseListener);
		dragOption.addMouseMotionListener(mouseListener);
		
		this.addMouseListener(mouseListener); // change current dragPanel
		
		this.setText(name);
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				
		this.setOpaque(true);
		
	}
	
	public JPanel getDDPanel() {
		return this.ddPanel;
	}
	
	public String getName() {
		return this.name;
	}
	
	// inner classes
	
	private class MouseListener extends MouseAdapter {
		
		private int prevX;
		private int prevY;
		
		public void mousePressed(MouseEvent e) {
			
			//JComponent jc = (JComponent)e.getSource();
			
			JLabel opt = (JLabel) e.getSource();
			
			prevX = e.getX();
			prevY = e.getY();
			
			// change current dragPanel
			
			CardLayout cardLayout = MainPanel.getInstance().getCardLayout();
			cardLayout.show(MainPanel.getInstance().getDragDropPanelManagement(), opt.getName());
			
			
			System.out.println("pressed");
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
			JComponent jc = (JComponent)e.getSource();
			int difX = e.getX() - prevX;
			int difY = e.getY() - prevY;
	        jc.setLocation(jc.getLocation().x + difX, jc.getLocation().y + difY);
			
			//System.out.println("dragged");
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
			JLabel jlabel = (JLabel)e.getSource();
			//jlabel.setVisible(false);
		}
	}
	
}