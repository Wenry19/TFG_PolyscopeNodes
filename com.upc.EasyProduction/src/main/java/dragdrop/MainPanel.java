package dragdrop;

import java.awt.CardLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainPanel extends JLayeredPane {
	
	private OptionsPanel optionsPanel;
	
	// start singleton
	
	private static MainPanel mainPanel = new MainPanel();
	
	private MainPanel() {
		
		optionsPanel = new OptionsPanel();
		
		this.add(optionsPanel, JLayeredPane.DEFAULT_LAYER);
		this.setBounds(0, 0, 606, 407);
		
		
		this.add(optionsPanel.getDragDropPanelManagement(), JLayeredPane.DRAG_LAYER);
	}
	
	public static MainPanel getInstance() {
		return mainPanel;
	}
	
	// end singleton
	
	public CardLayout getCardLayout() {
		return (CardLayout) optionsPanel.getDragDropPanelManagement().getLayout();
	}
	
	public JPanel getDragDropPanelManagement() {
		return optionsPanel.getDragDropPanelManagement();
	}

}
