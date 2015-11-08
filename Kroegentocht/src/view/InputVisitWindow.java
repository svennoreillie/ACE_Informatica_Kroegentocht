/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Input Window of GUI, used to input new visits
 */

package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.apache.logging.log4j.Logger;

import javax.swing.JButton;
import com.google.inject.Inject;
import com.toedter.calendar.JDateChooser;
import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import model.Establishment;
import model.Visit;
import services.GenericDataService;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class InputVisitWindow extends JFrame implements InputVisitWindowService {

	/**
	 * 
	 */
	@InjectLogger Logger logger;
	private static final long serialVersionUID = 1L;
	private JTextField textDuration;
	private JTextField textConsumption;
	private JComboBox<Establishment> cmbEstablishment;
	private JDateChooser dpDate;
	private GenericDataService<Establishment> dataEstablishmentService;
	private InputEstablismentWindowService inputEstablishmentWindow;
	private GenericDataService<Visit> dataVisit; 

	@Inject
	public InputVisitWindow(GenericDataService<Establishment> dataEstablishment
			, InputEstablismentWindowService inputEstablishmentWindow
			, GenericDataService<Visit> dataVisit) throws Exception {	
		this.dataEstablishmentService = dataEstablishment;
		this.inputEstablishmentWindow = inputEstablishmentWindow;
		this.dataVisit = dataVisit;
		initialize();
	}
	
	public void Show() {
		logger.debug("Show method called");
		setVisible(true);
	}

	public void Hide() {
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		setTitle("Registartion");
		setBounds(100, 100, 450, 300);
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
			List <Establishment> typeList = dataEstablishmentService.getAll();
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
			public void actionPerformed(ActionEvent e) {
				if(cmbEstablishment.getSelectedIndex() == -1 ||
						dpDate.getDate() == null ||
						textDuration.getText() == "" ||
						textConsumption.getText() == ""
					)
				{
					JOptionPane.showMessageDialog(null, "One or more of the requiered fields is not completed.\nThe visit is not saved!");	
				}
				else{
					try{
						Visit visit = new Visit();
						Calendar cal = Calendar.getInstance();
						cal.setTime(dpDate.getDate());
						visit.setDate(cal);
						visit.setDurationMinutes(Integer.parseInt(textDuration.getText()));
						visit.setAmountOfConsumptions(Integer.parseInt(textConsumption.getText()));
						visit.setEstablishment((Establishment)cmbEstablishment.getSelectedItem());
						try {
							dataVisit.add(visit);
						} catch (DBMissingException e1) {	
							e1.printStackTrace();
						}
						clearWindow();
					} 
					catch (DBException e1) {
						e1.printStackTrace();
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "An error has occured by registering your Visit.\nThe visit is not saved!");
					}
				}
			}

			private void closeWindow() {
				this.closeWindow();
				
			}
		});
		btnSave.setBounds(214, 181, 97, 25);
		getContentPane().add(btnSave);
		
		this.dpDate = new JDateChooser();
		dpDate.setBounds(12, 42, 98, 30);
		getContentPane().add(dpDate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearWindow();
			}
		});
		
		btnClear.setBounds(323, 181, 97, 25);
		getContentPane().add(btnClear);
		
		JButton btnAddEstablishment = new JButton("Add Establishment");
		btnAddEstablishment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputEstablishmentWindow.Show();
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
	
	private void clearWindow() {
		cmbEstablishment.setSelectedIndex(-1);
		textDuration.setText("");
		textConsumption.setText("");
		dpDate.setCalendar(null);
	}
}
