/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Input Window of GUI, used to input new visits
 */

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.google.inject.Inject;
import com.toedter.calendar.JDateChooser;

import model.TypeOfBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputWindow extends JFrame implements InputWindowService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmRegistartionWindow;
	private JTextField textOtherchooise;
	private JTextField textDuration;
	private JTextField textField;
	private JComboBox<TypeOfBusiness> cmbType;
	 

	/**
	 * Launch the application.
	 */
	public void Show() {
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

	@Inject
	public InputWindow() {
		initialize();
		//TODO fill cmbType with all options
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistartionWindow = new JFrame();
		frmRegistartionWindow.setTitle("Registartion");
		frmRegistartionWindow.setBounds(100, 100, 450, 300);
		frmRegistartionWindow.getContentPane().setLayout(null);
		
		JLabel lblInputDate = new JLabel("Date of visit");
		lblInputDate.setBounds(12, 13, 175, 16);
		frmRegistartionWindow.getContentPane().add(lblInputDate);
		
		JLabel lblTypeOfBusiness = new JLabel("Type of business");
		lblTypeOfBusiness.setBounds(12, 89, 175, 16);
		frmRegistartionWindow.getContentPane().add(lblTypeOfBusiness);
		
		JComboBox<TypeOfBusiness> cmbType = new JComboBox();
		cmbType.setBounds(12, 118, 175, 22);
		frmRegistartionWindow.getContentPane().add(cmbType);
		
		JLabel lblOtherType = new JLabel("If you choose other:");
		lblOtherType.setBounds(12, 153, 175, 16);
		frmRegistartionWindow.getContentPane().add(lblOtherType);
		
		textOtherchooise = new JTextField();
		textOtherchooise.setBounds(12, 182, 175, 22);
		frmRegistartionWindow.getContentPane().add(textOtherchooise);
		textOtherchooise.setColumns(10);
		
		JLabel lblTime = new JLabel("Duration of the visit in minutes");
		lblTime.setBounds(220, 13, 187, 16);
		frmRegistartionWindow.getContentPane().add(lblTime);
		
		textDuration = new JTextField();
		textDuration.setBounds(220, 42, 91, 22);
		frmRegistartionWindow.getContentPane().add(textDuration);
		textDuration.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total consumptions");
		lblNewLabel.setBounds(220, 89, 187, 16);
		frmRegistartionWindow.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(220, 118, 91, 22);
		frmRegistartionWindow.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Saving visit and check input
			}
		});
		btnSave.setBounds(214, 181, 97, 25);
		frmRegistartionWindow.getContentPane().add(btnSave);
		
		JDateChooser dpDate = new JDateChooser();
		dpDate.setBounds(12, 42, 98, 30);
		frmRegistartionWindow.getContentPane().add(dpDate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				this.clearWindow();
			}

			private void clearWindow() {
				// TODO Auto-generated method stub
				//this.cmbType.setSelectedIndex(-1);
			}
		});
		btnClear.setBounds(323, 181, 97, 25);
		frmRegistartionWindow.getContentPane().add(btnClear);
	}

	public JComboBox<TypeOfBusiness> getCmbType() {
		return cmbType;
	}

	public void setCmbType(JComboBox<TypeOfBusiness> cmbType) {
		this.cmbType = cmbType;
	}
	
}
