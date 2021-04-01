package dragdrop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OptionsPanel extends JPanel{
	
	
	
	public static void main(String[] args) { // tests
		JFrame frame = new JFrame();
		OptionsPanel optPanel = new OptionsPanel();
		Option option = new Option("tests");
		
		MouseListener mouseListener = optPanel.new MouseListener();
		option.addMouseListener(mouseListener);
		option.addMouseMotionListener(mouseListener);
		
		optPanel.add(option);
		//frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(606, 407));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(optPanel);
		frame.pack();
		frame.setVisible(true);
		
		optPanel.setLocation(200, 0);
	}
	
	
	
	public OptionsPanel() {
		
		this.setSize(406, 407);
		this.setPreferredSize(new Dimension(406, 407));
		
		this.setBackground(Color.blue);
		
		this.setLayout(null);

	}
	
	// add option method?
	
	
	// inner classes
	
	private class MouseListener extends MouseAdapter{
		
		private int prevX;
		private int prevY;
				
		public void mousePressed(MouseEvent e) {
			
			JComponent jc = (JComponent)e.getSource();
			
			prevX = e.getX();
			prevY = e.getY();
			
			
			//System.out.println("pressed");
			
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
			
			// gestionar l'entrada del node al workflow
			
			// afegir jlabel que és el que s'arrastrarà, l'altra estarà col·locat al flowlayout del optionspanel
			
			// problema: passar entre panels... -> layeredpanel?? o afegir option al panel base de ur
			
		}
	}
}
