import java.awt.Color;

import javax.swing.JButton;


public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Button(String title){
		setText(title);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.black);
		setFocusable(false);
		
	}
}
