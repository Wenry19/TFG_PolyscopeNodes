package dragdrop;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane; // eye!!


public class OptionsPanel extends JPanel {
	
	private JPanel dragDropPanelManagement;
	
	private Option opt1;
	private Option opt2;
		
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
		
		this.add(opt1);
		this.add(opt2);
		
	}
	
	private void initialize() {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		this.setSize(406, 407);
		this.setPreferredSize(new Dimension(406, 407));
		
		this.setLocation(200, 0);
		
		this.setBackground(Color.blue);
		
		//________
		
		this.opt1 = new Option("default1");
		this.opt2 = new Option("default2");
		
		
		this.dragDropPanelManagement = new JPanel();
		this.dragDropPanelManagement.setLayout(new CardLayout());
		
		this.dragDropPanelManagement.setSize(606, 407);
		this.dragDropPanelManagement.setPreferredSize(new Dimension(606, 407));
		this.dragDropPanelManagement.setOpaque(false);
		this.dragDropPanelManagement.setLocation(0, 0);
		
		this.dragDropPanelManagement.add(this.opt1.getDDPanel(), this.opt1.getName());
		this.dragDropPanelManagement.add(this.opt2.getDDPanel(), this.opt2.getName());
		
		
	}
	
	public JPanel getDragDropPanelManagement() {
		return dragDropPanelManagement;
	}
	
	public void addOption(String name) {
		
		Option opt = new Option(name);
		this.add(opt);
	}
}
