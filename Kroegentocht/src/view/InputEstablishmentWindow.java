/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Input Window of GUI, used to input new establishments
 */

package view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.google.inject.Inject;
import model.Address;
import model.Establishment;
import model.TypeOfBusiness;
import services.GenericDataService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class InputEstablishmentWindow extends JFrame implements InputEstablismentWindowService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textOtherType;
	private JTextField textStreet;
	private JTextField textNumber;
	private JTextField textBox;
	private JTextField textZipCode;
	private JTextField textCity;
	private JTextField textPhone;
	private JTextField textMobile;
	private JTextField textEmail;
	private JTextField textFax;
	private JComboBox<TypeOfBusiness> cmbType;
	private GenericDataService<TypeOfBusiness> dataTypeOfBusinessService;
	private GenericDataService<Establishment> dataEstablishmentService;
	
	@Inject
	public InputEstablishmentWindow(GenericDataService <TypeOfBusiness> dataTypeOfBusiness
			, GenericDataService <Establishment> dataEstablishment) throws Exception {
		this.dataTypeOfBusinessService = dataTypeOfBusiness;
		this.dataEstablishmentService = dataEstablishment;
		initialize();
	}	

	public void Show() {
		setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		
		setBounds(100, 100, 589, 505);
		getContentPane().setLayout(null);
		
		JLabel lblTypeOfBusiness = new JLabel("Type Of Business");
		lblTypeOfBusiness.setBounds(12, 13, 176, 16);
		getContentPane().add(lblTypeOfBusiness);
		
		cmbType = new JComboBox<TypeOfBusiness>();
		cmbType.setBounds(12, 42, 176, 22);
		getContentPane().add(cmbType);
		try {
			List <TypeOfBusiness> typeList = dataTypeOfBusinessService.getAll();
			for (TypeOfBusiness typeOfBusiness : typeList) {
				cmbType.addItem(typeOfBusiness);
			}
			
		} 
		catch (Exception e) {
			throw e;
		}
		
		JLabel lblOtherType = new JLabel("Other Type Of Business");
		lblOtherType.setBounds(12, 77, 176, 16);
		getContentPane().add(lblOtherType);
		
		textOtherType = new JTextField();
		textOtherType.setBounds(12, 106, 176, 22);
		getContentPane().add(textOtherType);
		textOtherType.setColumns(10);
		textOtherType.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				clearCmbBox(false);
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				clearCmbBox(true);	
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				clearCmbBox(false);
			}
		});
		
		
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(12, 141, 176, 16);
		getContentPane().add(lblStreet);
		
		textStreet = new JTextField();
		textStreet.setBounds(12, 170, 176, 22);
		getContentPane().add(textStreet);
		textStreet.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(12, 205, 176, 16);
		getContentPane().add(lblNumber);
		
		textNumber = new JTextField();
		textNumber.setBounds(12, 234, 176, 22);
		getContentPane().add(textNumber);
		textNumber.setColumns(10);
		
		JLabel lblBox = new JLabel("Box");
		lblBox.setBounds(12, 269, 176, 16);
		getContentPane().add(lblBox);
		
		textBox = new JTextField();
		textBox.setBounds(12, 294, 176, 22);
		getContentPane().add(textBox);
		textBox.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(12, 329, 56, 16);
		getContentPane().add(lblZipCode);
		
		textZipCode = new JTextField();
		textZipCode.setBounds(12, 358, 176, 22);
		getContentPane().add(textZipCode);
		textZipCode.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(12, 393, 176, 16);
		getContentPane().add(lblCity);
		
		textCity = new JTextField();
		textCity.setBounds(12, 422, 176, 22);
		getContentPane().add(textCity);
		textCity.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(306, 13, 176, 16);
		getContentPane().add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(306, 42, 176, 22);
		getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile phone");
		lblMobile.setBounds(306, 77, 176, 16);
		getContentPane().add(lblMobile);
		
		textMobile = new JTextField();
		textMobile.setBounds(306, 106, 176, 22);
		getContentPane().add(textMobile);
		textMobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(306, 141, 176, 16);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(306, 170, 176, 22);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setBounds(306, 205, 176, 16);
		getContentPane().add(lblFax);
		
		textFax = new JTextField();
		textFax.setBounds(306, 234, 176, 22);
		getContentPane().add(textFax);
		textFax.setColumns(10);
		
		JButton btnClear = new JButton("Clear All");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbType.setSelectedIndex(-1);
				textOtherType.setText("");
				textStreet.setText("");
				textNumber.setText("");
				textBox.setText("");
				textCity.setText("");
				textPhone.setText("");
				textMobile.setText("");
				textEmail.setText("");
				textFax.setText("");
			}
		});
		btnClear.setBounds(306, 307, 176, 25);
		getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(306, 357, 176, 25);
		getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(textStreet.getText()==null || 
						textNumber.getText() == null ||
						textZipCode.getText() == null ||
						textCity.getText() == null || 
						(cmbType.getSelectedIndex() == -1 && textOtherType.getText().equals(""))
						){
					JOptionPane.showMessageDialog(null, "One or more of the requiered fields is not completed.\nThe establishment is not saved!");	
				}
				else{
					Establishment establishment = new Establishment();
					Address address = new Address();
					try{
						if(textOtherType.getText()== ""){
							establishment.setBusinessType((TypeOfBusiness)cmbType.getSelectedItem());
						}
						else{
							establishment.setBusinessType(new TypeOfBusiness (textOtherType.getText()));
						}
						address.setStreet(textStreet.getText());
						address.setNumber(textNumber.getText());
						address.setBox(textBox.getText());
						address.setZipCode(textZipCode.getText());
						address.setCity(textCity.getText());
						address.setPhone(textPhone.getText());
						address.setMobilePhone(textMobile.getText());
						address.setEmail(textEmail.getText());
						address.setFax(textFax.getText());
						establishment.setAddress(address);
						dataEstablishmentService.add(establishment);
						
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});	
	}

	public JComboBox<TypeOfBusiness> getCmbType() {
		return cmbType;
	}

	public void setCmbType(JComboBox<TypeOfBusiness> cmbType) {
		this.cmbType = cmbType;
	}
	
	private void clearCmbBox (boolean b){
		cmbType.setSelectedIndex(-1);
		cmbType.setEnabled(b);
	}
}
