
package com.upc.EasyProduction.dragdrop;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
		
		this.dragOption.setVisible(false);
		
		MouseListener mouseListener = new MouseListener();
		dragOption.addMouseListener(mouseListener);
		dragOption.addMouseMotionListener(mouseListener);
		
		this.addMouseListener(mouseListener);
				
		this.setText(name);
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				
		this.setOpaque(true);
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public JLabel getDragLabel() {
		return this.dragOption;
	}
	
	// inner classes
	
	private class MouseListener extends MouseAdapter {
		
		private int prevX;
		private int prevY;
		
		private boolean canRelease = false;
		//private boolean canExit = false;
		
		private int offsetOptionsPanel = 200; // ULL!!
		
		public void mousePressed(MouseEvent e) {
						
			prevX = e.getX();
			prevY = e.getY();
			
			System.out.println("pressed");
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
			try {
				Option opt = (Option) e.getSource();
				opt.getDragLabel().setVisible(true);
				
				opt.getDragLabel().setLocation(opt.getLocation().x + offsetOptionsPanel, opt.getLocation().y);
				}
			
			catch (Exception except) {}
			
			finally {
				System.out.println("entered!!");
			}
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
			JComponent jc = (JComponent) e.getSource();
			int difX = e.getX() - prevX;
			int difY = e.getY() - prevY;
	        jc.setLocation(jc.getLocation().x + difX, jc.getLocation().y + difY);
	        
	        canRelease = true;
			
			//System.out.println("dragged");
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
			if (canRelease) {
				JLabel opt = (JLabel) e.getSource();
				opt.setVisible(false);
				canRelease = false;
			}
			
			System.out.println("released!!");
		}
	}	
}