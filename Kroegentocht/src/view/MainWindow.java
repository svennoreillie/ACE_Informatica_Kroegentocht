package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import application.House;
import application.ReservationService;
import model.DateFactory;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;

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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Registration new visit");
		btnRegister.setBounds(121, 13, 175, 100);
		frame.getContentPane().add(btnRegister);
		btnRegister.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked (MouseEvent e){
				InputWindow inputWindow = new InputWindow();
				InputWindow.setVisible(true);
			}
		}
		);
		
		/*
		 JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int numbernights = Integer.parseInt(textField_2.getText());

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String stringDate = sdf.format(dp.getDate());
					model.Date date = DateFactory.generateDate(stringDate);

					ReservationService rs = new ReservationService();
					List<House> houselist = rs.getAvailableHouses(date, numbernights);
					for (House h : houselist) {
						unitsAvailable.addItem(h);
					}

					if (houselist.size() < 1) {
						JOptionPane.showMessageDialog(null, "No bungalows available.");
					} else {
						unitsAvailable.setEnabled(true);
					}
				}

				catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Throwable ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		 */
		
		JButton btnAnalyse = new JButton("Analyse registered visits");
		btnAnalyse.setBounds(121, 128, 175, 100);
		frame.getContentPane().add(btnAnalyse);
	}

}
