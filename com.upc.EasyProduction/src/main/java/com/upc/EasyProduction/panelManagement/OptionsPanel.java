
package com.upc.EasyProduction.panelManagement;



import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.upc.EasyProduction.blocks.Block;


public class OptionsPanel extends JPanel {
	
	private JPanel dragDropPanel;
	
	private MouseListener mouseListener;
	
	private LinkedList<Option> options;
	
	private JScrollPane scroll;
	
	
	static private OptionsPanel singleton = new OptionsPanel();
			
	private OptionsPanel() {
		
		initialize();
		
		addDefaultOptions();
		
		scroll = new JScrollPane(this);
		
		scroll.setPreferredSize(new Dimension(406, 404));
		scroll.setSize(new Dimension(406, 404));
		scroll.setLocation(200, 0);
				
	}
	
	static public OptionsPanel getInstance() {
		return singleton;
	}
	
	private void initialize() {
		
		mouseListener = new MouseListener();
		
		options = new LinkedList();
		
		// this JPanel which contains the different options
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		this.setSize(400, 400);
		this.setPreferredSize(new Dimension(400, 400)); // 406x407
		
		this.setLocation(200, 0);
				
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
		addOption("PopUp");
		addOption("SetDigitalOutput");
		addOption("GetDigitalInput");
		addOption("SetAnalogOutput");
		addOption("GetAnalogInput");
		
	}
	
	public void printOptions() {
		System.out.println(options);
	}
	
	public JScrollPane getScrollPanel() {
		return scroll;
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
				
				// detect in which block of the workflow the mouse has been released
				
				Workflow wf = Workflow.getInstance();
								
				//System.out.println(((Block) wf.findComponentAt(OptionsPanel.getInstance().getDragDropPanel().getMousePosition(true))).getWorkflowPosition());
				
				// in this way works in Polyscope...
				PointerInfo a = MouseInfo.getPointerInfo();
				Point point = new Point(a.getLocation());
				SwingUtilities.convertPointFromScreen(point, wf);
				
				
				Component target = wf.findComponentAt(point);
				
				if (target != null && target instanceof Block) {
					wf.addBlock(draggedLabel.getText(), ((Block)target).getWorkflowPosition());
				}
				
			}
			
			System.out.println("released");
			
		}
		
		public void mouseEntered(MouseEvent e) {
			System.out.println("entered"+ ((JLabel)e.getSource()).getText());
		}
	}
	
}