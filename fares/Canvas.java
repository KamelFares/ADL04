package fares;

import javax.swing.JButton;

/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Canvas extends JFrame implements ActionListener { // ActionListener for Lab3
	public static Graphics PEN;
	private CanvasPanel canvasPanel;
	private Application myApp;
	
	private JButton button; // for Lab3
	
	private class CanvasPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics pen) {
			super.paintComponent(pen);
			PEN = pen;
			myApp.draw();
		}
	}
	
	public Canvas(String title) {
		super(title);
		setLayout(new BorderLayout());
		myApp = new Application();
		add(canvasPanel = new CanvasPanel(), BorderLayout.CENTER);
		
		button = new JButton();
		button.addActionListener(this);
		add(button, BorderLayout.WEST);
		
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			//myApp.showPath();
			canvasPanel.repaint();
		}
	}
	
	public static void main(String[] args) {
		new Canvas("A Graph");
	}
}