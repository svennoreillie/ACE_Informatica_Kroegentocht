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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import helpers.InjectLogger;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame implements MainWindowService {

	@InjectLogger Logger logger;
	private WindowService analyseWindow;
	private InputVisitWindowService inputVisitWindow;
	private InputEstablismentWindowService inputEstablishmentWindow;
	
	
	@Inject
	public MainWindow(InputVisitWindowService inputVisitWindow
			, InputEstablismentWindowService inputEstablishmentWindow
			, AnalyseWindowService analyseWindow) throws Exception { 
		this.inputVisitWindow = inputVisitWindow;
		this.inputEstablishmentWindow = inputEstablishmentWindow;
		this.analyseWindow = analyseWindow;
		initialize();
	}
	
	public void Show() {
		logger.debug("Show method called");
		setVisible(true);
	}
	
	public void Hide() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmRegistartionWindow = new JFrame();
		frmRegistartionWindow.setTitle("Main Window");
		frmRegistartionWindow.setBounds(100, 100, 450, 319);
		frmRegistartionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistartionWindow.getContentPane().setLayout(null);

		setTitle("Main Window");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		
		JButton btnRegister = new JButton("Registration new visit");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Showing visit input window");
				inputVisitWindow.Show();
			}
		});

		btnRegister.setBounds(121, 13, 170, 70);
		frmRegistartionWindow.getContentPane().add(btnRegister);
		btnRegister.setBounds(121, 13, 175, 100);
		getContentPane().add(btnRegister);
		JButton btnAnalyse = new JButton("Analyse registered visits");
		btnAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Showing analys window");
				analyseWindow.Show();
			}
		});

		btnAnalyse.setBounds(121, 96, 170, 70);
		frmRegistartionWindow.getContentPane().add(btnAnalyse);
		
		JButton btnAddEstablishment = new JButton("Add an establishment");
		btnAddEstablishment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Showing establishment input window");
				inputEstablishmentWindow.Show();
			}
		});
		btnAddEstablishment.setBounds(121, 183, 170, 70);
		frmRegistartionWindow.getContentPane().add(btnAddEstablishment);

		btnAnalyse.setBounds(121, 128, 175, 100);
		getContentPane().add(btnAnalyse);
	}
}
