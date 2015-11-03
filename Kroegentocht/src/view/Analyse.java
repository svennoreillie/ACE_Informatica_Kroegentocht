package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Analyse extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Analyse() {
		super("Analyse");
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
		splitPane.setRightComponent(panel_right);
		GridBagLayout gbl_panel_right = new GridBagLayout();
		gbl_panel_right.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_right.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_right.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_right.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_right.setLayout(gbl_panel_right);
		
		JLabel lblTotaal = new JLabel("Totaal minuten");
		GridBagConstraints gbc_lblTotaal = new GridBagConstraints();
		gbc_lblTotaal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotaal.gridx = 0;
		gbc_lblTotaal.gridy = 0;
		panel_right.add(lblTotaal, gbc_lblTotaal);
		
		JLabel lblTotalMinutes = new JLabel("0 minutes");
		GridBagConstraints gbc_lblTotalMinutes = new GridBagConstraints();
		gbc_lblTotalMinutes.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalMinutes.gridx = 2;
		gbc_lblTotalMinutes.gridy = 0;
		panel_right.add(lblTotalMinutes, gbc_lblTotalMinutes);
		
		JLabel lblTotaalConsumpties = new JLabel("Gemiddelde minuten");
		GridBagConstraints gbc_lblTotaalConsumpties = new GridBagConstraints();
		gbc_lblTotaalConsumpties.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotaalConsumpties.gridx = 0;
		gbc_lblTotaalConsumpties.gridy = 1;
		panel_right.add(lblTotaalConsumpties, gbc_lblTotaalConsumpties);
		
		JLabel lblAverageMinutes = new JLabel("0 minutes");
		GridBagConstraints gbc_lblAverageMinutes = new GridBagConstraints();
		gbc_lblAverageMinutes.insets = new Insets(0, 0, 5, 0);
		gbc_lblAverageMinutes.gridx = 2;
		gbc_lblAverageMinutes.gridy = 1;
		panel_right.add(lblAverageMinutes, gbc_lblAverageMinutes);
		
		JLabel lblTotaal_1 = new JLabel("Totaal consumpties");
		GridBagConstraints gbc_lblTotaal_1 = new GridBagConstraints();
		gbc_lblTotaal_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotaal_1.gridx = 0;
		gbc_lblTotaal_1.gridy = 2;
		panel_right.add(lblTotaal_1, gbc_lblTotaal_1);
		
		JLabel lblTotalConsumptions = new JLabel("0 drinks");
		GridBagConstraints gbc_lblTotalConsumptions = new GridBagConstraints();
		gbc_lblTotalConsumptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalConsumptions.gridx = 2;
		gbc_lblTotalConsumptions.gridy = 2;
		panel_right.add(lblTotalConsumptions, gbc_lblTotalConsumptions);
		
		JLabel lblLangsteBezoek = new JLabel("Langste bezoek");
		GridBagConstraints gbc_lblLangsteBezoek = new GridBagConstraints();
		gbc_lblLangsteBezoek.insets = new Insets(0, 0, 0, 5);
		gbc_lblLangsteBezoek.gridx = 0;
		gbc_lblLangsteBezoek.gridy = 3;
		panel_right.add(lblLangsteBezoek, gbc_lblLangsteBezoek);
		
		JLabel lblLongestVisit = new JLabel("0 minuten");
		GridBagConstraints gbc_lblLongestVisit = new GridBagConstraints();
		gbc_lblLongestVisit.gridx = 2;
		gbc_lblLongestVisit.gridy = 3;
		panel_right.add(lblLongestVisit, gbc_lblLongestVisit);
		
		JPanel panel_left = new JPanel();
		splitPane.setLeftComponent(panel_left);
		panel_left.setMinimumSize(new Dimension(50, 100));
		panel_left.setLayout(new BoxLayout(panel_left, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Clear");
		panel_left.add(btnNewButton);
	}
	
	public void Show() {
		setVisible(true);
	}

}
