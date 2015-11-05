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

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import helpers.InjectLogger;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame implements MainWindowService {

	
	@InjectLogger Logger logger;
	private InputWindowService inputWindow;
	private AnalyseWindowService analyseWindow;
	
	@Inject
	public MainWindow(InputWindowService inputWindow, AnalyseWindowService analyseWindow) { 
		this.inputWindow = inputWindow;
		this.analyseWindow = analyseWindow;
		
		initialize();
	}
	
	public void Show() {
		
		logger.debug("Show method called");
		setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Main Window");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Registration new visit");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenInput();
			}
		});
		btnRegister.setBounds(121, 13, 175, 100);
		getContentPane().add(btnRegister);
		
		

		JButton btnAnalyse = new JButton("Analyse registered visits");
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenAnalyse();
			}
		});
		btnAnalyse.setBounds(121, 128, 175, 100);
		getContentPane().add(btnAnalyse);
	}

	
	public void OpenInput() {
		this.inputWindow.Show();
	}
	
	public void OpenAnalyse() {
		this.analyseWindow.Show();
	}
	
}
