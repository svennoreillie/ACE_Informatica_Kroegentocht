/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Main Window of GUI, used to naviagte towards input and/or analyse windows
 */

package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmRegistartionWindow;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public void Show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmRegistartionWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistartionWindow = new JFrame();
		frmRegistartionWindow.setTitle("Main Window");
		frmRegistartionWindow.setBounds(100, 100, 450, 300);
		frmRegistartionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistartionWindow.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Registration new visit");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputWindow inputWindow = new InputWindow();
				inputWindow.OpenNewScreen();
			}
		});
		btnRegister.setBounds(121, 13, 175, 100);
		frmRegistartionWindow.getContentPane().add(btnRegister);
		
		
		
		
		JButton btnAnalyse = new JButton("Analyse registered visits");
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AnalyseWindow analysewindow = new AnalyseWindow();
				// TODO create constructor and use it here
				// TODO create OpenNewscreen() method en use it here
			}
		});
		btnAnalyse.setBounds(121, 128, 175, 100);
		frmRegistartionWindow.getContentPane().add(btnAnalyse);
	}

}
