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
import helpers.DBException;
import helpers.DBMissingException;
import model.Establishment;
import model.Visit;
import services.GenericDataService;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class InputVisitWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textDuration;
	private JTextField textConsumption;
	private JComboBox<Establishment> cmbEstablishment;
	private JDateChooser dpDate;
	private GenericDataService<Establishment> dataEstablishment; 

	@Inject
	public InputVisitWindow(GenericDataService <Establishment> dataEstablishment) throws Exception {
		super("DataServiceEstablishment");
		initialize();
		this.dataEstablishment = dataEstablishment;
	}

	
	/**
	 * Launch the application.
	 */
	public static void OpenNewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputVisitWindow window = new InputVisitWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public InputVisitWindow() throws Exception   {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		setTitle("Registartion");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblInputDate = new JLabel("Date of visit");
		lblInputDate.setBounds(12, 13, 175, 16);
		getContentPane().add(lblInputDate);
		
		JLabel lblEstablishment = new JLabel("Establishment");
		lblEstablishment.setBounds(12, 89, 175, 16);
		getContentPane().add(lblEstablishment);
		
		JComboBox<Establishment> cmbEstablishment = new JComboBox<Establishment>();
		cmbEstablishment.setBounds(12, 118, 175, 22);
		getContentPane().add(cmbEstablishment);
		try {
			List <Establishment> typeList = dataEstablishment.getAll();
			for (Establishment establishment : typeList) {
			    cmbEstablishment.addItem(establishment);
			}
		} catch (Exception e) {
			throw e;
		}
		
		JLabel lblTime = new JLabel("Duration of the visit in minutes");
		lblTime.setBounds(220, 13, 187, 16);
		getContentPane().add(lblTime);
		
		textDuration = new JTextField();
		textDuration.setBounds(220, 42, 91, 22);
		getContentPane().add(textDuration);
		textDuration.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total consumptions");
		lblNewLabel.setBounds(220, 89, 187, 16);
		getContentPane().add(lblNewLabel);
		
		textConsumption = new JTextField();
		textConsumption.setBounds(220, 118, 91, 22);
		getContentPane().add(textConsumption);
		textConsumption.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				
				try{
					Visit visit = new Visit();
					Calendar cal = Calendar.getInstance();
					cal.setTime(dpDate.getDate());
					visit.setDate(cal);
					visit.setDurationMinutes(Integer.parseInt(textDuration.getText()));
					visit.setAmountOfConsumptions(Integer.parseInt(textConsumption.getText()));
					visit.setEstablishment((Establishment)cmbEstablishment.getSelectedItem());
					GenericDataService <Visit> datavisit = null;
					try {
						datavisit.add(visit);
					} catch (DBMissingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(214, 181, 97, 25);
		getContentPane().add(btnSave);
		
		JDateChooser dpDate = new JDateChooser();
		dpDate.setBounds(12, 42, 98, 30);
		getContentPane().add(dpDate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				this.clearWindow();
			}
			
			private void clearWindow() {
				cmbEstablishment.setSelectedIndex(-1);
				textDuration.setText("");
				textConsumption.setText("");
				dpDate.setCalendar(null);
			}
			
		});
		btnClear.setBounds(323, 181, 97, 25);
		getContentPane().add(btnClear);
		
		JButton btnAddEstablishment = new JButton("Add Establishment");
		btnAddEstablishment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				InputEstablishmentWindow inputEstablishment = null;
				try {
					inputEstablishment = new InputEstablishmentWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InputEstablishmentWindow.OpenNewScreen();
			}
		});
		btnAddEstablishment.setBounds(214, 215, 206, 25);
		getContentPane().add(btnAddEstablishment);
	}

	public JComboBox<Establishment> getCmbType() {
		return cmbEstablishment;
	}

	public void setCmbType(JComboBox<Establishment> cmbType) {
		this.cmbEstablishment = cmbType;
	}
}
