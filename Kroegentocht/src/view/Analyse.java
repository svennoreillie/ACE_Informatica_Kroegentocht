package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import model.TypeOfBusiness;
import services.DataAnalyseService;
import services.helpers.Filter;

import com.jgoodies.forms.layout.FormLayout;
import com.google.inject.Inject;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Analyse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DataAnalyseService analyseService;
	private JComboBox<TypeOfBusiness> comboBox;
	private JDateChooser startDatePicker;
	private JDateChooser eindDatePicker;

	@Inject
	public Analyse(DataAnalyseService analyseService) {
		super("Analyse");
		init();
		
		this.analyseService = analyseService;
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Invoer");
		menuBar.add(mntmNewMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(3.0);
		contentPane.add(splitPane);
		
		JPanel panel_right = new JPanel();
		panel_right.setBorder(new EmptyBorder(10, 10, 10, 10));
		splitPane.setRightComponent(panel_right);
		panel_right.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("130px:grow"),
				ColumnSpec.decode("15px"),
				ColumnSpec.decode("64px:grow"),},
			new RowSpec[] {
				RowSpec.decode("16px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		
		JLabel lblTotaal = new JLabel("Totaal minuten");
		panel_right.add(lblTotaal, "1, 1, left, center");
		
		JLabel lblTotalMinutes = new JLabel("0 minutes");
		panel_right.add(lblTotalMinutes, "3, 1, left, center");
		
		JLabel lblTotaalConsumpties = new JLabel("Gemiddelde minuten");
		panel_right.add(lblTotaalConsumpties, "1, 3, left, center");
		
		JLabel lblAverageMinutes = new JLabel("0 minutes");
		panel_right.add(lblAverageMinutes, "3, 3, left, center");
		
		JLabel lblTotaal_1 = new JLabel("Totaal consumpties");
		panel_right.add(lblTotaal_1, "1, 5, left, center");
		
		JLabel lblTotalConsumptions = new JLabel("0 drinks");
		panel_right.add(lblTotalConsumptions, "3, 5, left, center");
		
		JLabel lblLangsteBezoek = new JLabel("Langste bezoek");
		panel_right.add(lblLangsteBezoek, "1, 7, left, center");
		
		JLabel lblLongestVisit = new JLabel("0 minuten");
		panel_right.add(lblLongestVisit, "3, 7, left, center");
		

		
		JPanel panel_left = new JPanel();
		splitPane.setLeftComponent(panel_left);
		panel_left.setMinimumSize(new Dimension(50, 100));
		GridBagLayout gbl_panel_left = new GridBagLayout();
		gbl_panel_left.columnWidths = new int[]{0, 0};
		gbl_panel_left.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_left.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_left.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_left.setLayout(gbl_panel_left);
		
		JLabel lblBegindatum = new JLabel("Begindatum");
		GridBagConstraints gbc_lblBegindatum = new GridBagConstraints();
		gbc_lblBegindatum.insets = new Insets(0, 0, 5, 0);
		gbc_lblBegindatum.gridx = 0;
		gbc_lblBegindatum.gridy = 0;
		panel_left.add(lblBegindatum, gbc_lblBegindatum);
		
		this.startDatePicker = new JDateChooser();
		startDatePicker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				CalcResult();
			}
		});
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 0;
		gbc_dateChooser.gridy = 1;
		panel_left.add(startDatePicker, gbc_dateChooser);
		
		JLabel lblEinddatum = new JLabel("Einddatum");
		GridBagConstraints gbc_lblEinddatum = new GridBagConstraints();
		gbc_lblEinddatum.insets = new Insets(0, 0, 5, 0);
		gbc_lblEinddatum.gridx = 0;
		gbc_lblEinddatum.gridy = 2;
		panel_left.add(lblEinddatum, gbc_lblEinddatum);
		
		this.eindDatePicker = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 0;
		gbc_dateChooser_1.gridy = 3;
		panel_left.add(this.eindDatePicker, gbc_dateChooser_1);
		
		JLabel lblTypeZaak = new JLabel("Type zaak");
		GridBagConstraints gbc_lblTypeZaak = new GridBagConstraints();
		gbc_lblTypeZaak.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeZaak.gridx = 0;
		gbc_lblTypeZaak.gridy = 4;
		panel_left.add(lblTypeZaak, gbc_lblTypeZaak);
		
		this.comboBox = new JComboBox<TypeOfBusiness>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 5;
		panel_left.add(comboBox, gbc_comboBox);
		
		JButton btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 7;
		panel_left.add(btnClear, gbc_btnClear);
	}
	
	public void Show() {
		setVisible(true);
	}
	
	private void CalcResult() {
		//Create filter
		Filter f = new Filter();
		f.setBusinessType((TypeOfBusiness)this.comboBox.getSelectedItem());
		f.setStartDate(this.startDatePicker.getCalendar());
		f.setEndDate(this.eindDatePicker.getCalendar());
		
		
	}

}