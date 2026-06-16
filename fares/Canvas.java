package fares;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		button = new JButton("Show Path");
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
			myApp.showPath();  // Show the path when button is clicked
			canvasPanel.repaint();
		}
	}
	
	public static void main(String[] args) {
		new Canvas("A Graph");
	}
}