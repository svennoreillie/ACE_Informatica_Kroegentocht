/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: View voor analyse, bevat filter en labels met resultaten
 */

package view;

/*
import java.awt.BorderLayout;
import java.awt.EventQueue;
*/
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import model.ModelBase;
import model.TypeOfBusiness;
import model.Visit;
import services.DataAnalyseService;
import services.GenericDataService;
import services.events.DataChangedEvent;
import services.events.DataChangedEventFiringService;
import services.events.DataChangedEventFiringSource;
import services.helpers.Filter;
import com.jgoodies.forms.layout.FormLayout;
import com.google.inject.Inject;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class AnalyseWindow extends JFrame implements AnalyseWindowService, DataChangedEvent<Visit> {

	@InjectLogger Logger logger;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DataAnalyseService analyseService;
	private JComboBox<TypeOfBusiness> comboBox;
	private JDateChooser startDatePicker;
	private JDateChooser eindDatePicker;
	private JLabel lblTotalMinutes;
	private JLabel lblAverageMinutes;
	private JLabel lblTotalConsumptions;
	private JLabel lblLongestVisit;
	private JLabel lblAantalBezoeken;

	private DataChangedEventFiringService<Visit> visitChangedService;

	private GenericDataService<TypeOfBusiness> tobDataService;

	@Inject
	public AnalyseWindow(DataAnalyseService analyseService
			, DataChangedEventFiringService<Visit> visitChanged
			, GenericDataService<TypeOfBusiness> tobDataService) {
		super("Analyse");
		
		
		this.analyseService = analyseService;
		this.visitChangedService = visitChanged;
		this.tobDataService = tobDataService;
		
		init();
	}
	
	public void Show() {
		logger.debug("Show method called");
		setVisible(true);
		
		this.visitChangedService.addListener(this);
	}
	
	public void Hide() {
		logger.debug("Hide method called");
		setVisible(false);
		
		this.visitChangedService.removeListener(this);
	}

	private void init() {
		setBounds(100, 100, 450, 300);
		setResizable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		contentPane.add(splitPane);
		
		JPanel panel_right = new JPanel();
		panel_right.setBorder(new EmptyBorder(10, 10, 10, 10));
		splitPane.setRightComponent(panel_right);
		panel_right.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("15px"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));
		
		
		JLabel lblTotaal = new JLabel("Totaal minuten");
		panel_right.add(lblTotaal, "1, 1, left, center");
		
		this.lblTotalMinutes = new JLabel("0 minutes");
		panel_right.add(this.lblTotalMinutes, "3, 1, left, center");
		
		JLabel lblTotaalConsumpties = new JLabel("Gemiddelde minuten");
		panel_right.add(lblTotaalConsumpties, "1, 3, left, center");
		
		this.lblAverageMinutes = new JLabel("0 minutes");
		panel_right.add(this.lblAverageMinutes, "3, 3, left, center");
		
		JLabel lblTotaal_1 = new JLabel("Totaal consumpties");
		panel_right.add(lblTotaal_1, "1, 5, left, center");
		
		this.lblTotalConsumptions = new JLabel("0 drinks");
		panel_right.add(this.lblTotalConsumptions, "3, 5, left, center");
		
		JLabel lblLangsteBezoek = new JLabel("Langste bezoek");
		panel_right.add(lblLangsteBezoek, "1, 7, left, center");
		
		this.lblLongestVisit = new JLabel("0 minuten");
		panel_right.add(this.lblLongestVisit, "3, 7, left, center");
		
		JLabel lblAantalBezoekenLabel = new JLabel("Aantal bezoeken");
		panel_right.add(lblAantalBezoekenLabel, "1, 9, left, center");
		
		this.lblAantalBezoeken = new JLabel("0 bezoeken");
		panel_right.add(this.lblAantalBezoeken, "3, 9, left, center");
		

		
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
		eindDatePicker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				CalcResult();
			}
		});
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 0;
		gbc_dateChooser_1.gridy = 3;
		panel_left.add(this.eindDatePicker, gbc_dateChooser_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFilter();
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 7;
		panel_left.add(btnClear, gbc_btnClear);
	}
	
	protected void ClearFilter() {
		this.comboBox.setSelectedIndex(-1);
		this.startDatePicker.setCalendar(null);
		this.eindDatePicker.setCalendar(null);
	}
	
	
	private void CalcResult() {
		try {
			logger.info("Calculating analyse fields");
			//Create filter
			Filter f = new Filter();
			f.setStartDate(this.startDatePicker.getCalendar());
			f.setEndDate(this.eindDatePicker.getCalendar());
		
			this.lblLongestVisit.setText(String.format("%d minuten", this.analyseService.getLongestVisit(f)));
			this.lblAverageMinutes.setText(String.format("%d minuten", this.analyseService.getAverageMinutes(f)));
			this.lblTotalConsumptions.setText(String.format("%d consumpties", this.analyseService.getTotalConsumptions(f)));
			this.lblTotalMinutes.setText(String.format("%d minuten", this.analyseService.getTotalMinutes(f)));
			this.lblAantalBezoeken.setText(String.format("%d bezoeken", this.analyseService.getTotalVisits(f)));
		} catch (DBMissingException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			logger.error(e.getMessage()); 
			logger.error(e.getStackTrace());
			
		} catch (DBException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			logger.error(e.getMessage()); 
			logger.error(e.getStackTrace());
		}
	}


	@Override
	public void EntityAdded(Visit entity) {
		//Refresh page if visible
		if (this.isVisible()) {
			this.CalcResult();
		}
	}

}
