package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class InputWindow {

	private JFrame frmRegistartionWindow;

	/**
	 * Launch the application.
	 */
	public static void OpenNewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputWindow window = new InputWindow();
					window.frmRegistartionWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistartionWindow = new JFrame();
		frmRegistartionWindow.setTitle("Registartion");
		frmRegistartionWindow.setBounds(100, 100, 450, 300);
		frmRegistartionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
