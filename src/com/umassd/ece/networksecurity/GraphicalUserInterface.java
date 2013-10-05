package com.umassd.ece.networksecurity;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class GraphicalUserInterface extends JFrame
{
	private final int jTP_WIDTH = 788;
	private final int jTP_HEIGHT = 563;
	
	// Overall Tabbed Pane
	private JTabbedPane jTP = new JTabbedPane();
	private JPanel pane_caesar = new JPanel(new FlowLayout());
	private JPanel pane_DES = new JPanel(new FlowLayout());
	private JPanel pane_RSA = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// GUI Panels
	private JPanel p_caesar = new JPanel(new GridLayout(9,1));
	private JPanel p_DES = new JPanel(new GridLayout(9,1));
	private JPanel p_RSA = new JPanel(new GridLayout(9,1));
	
	// Caesar Shift/Clear Buttons
	private JButton caesarShiftButton = new JButton("Shift");
	private JButton caesarClearButton = new JButton("Clear");
	
	// DES Calculate/Clear Buttons
	private JButton DESCalculateButton = new JButton("Calculate");
	private JButton DESClearButton = new JButton("Clear");
	
	// RSA Calculate/Clear Buttons
	private JButton RSACalculateButton = new JButton("Calculate");
	private JButton RSAClearButton = new JButton("Clear");
	
	// Caesar Cipher Output
	private JScrollPane serviceDemandOutputPane = new JScrollPane(new JTextArea());
	
	public GraphicalUserInterface()
	{
		super("Liuizer (" + Resources.VERSION_NUMBER + " - " + Resources.VERSION_CODENAME + ") - The All-In-One ECE 489 Solver");
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		setLayout(fl);
		
		createPanes();
		setupTabs();
	}
	
	private void createPanes()
	{
		createCaesarPane();
		createDESPane();
		createRSAPane();
	}
	
	private void createCaesarPane()
	{
		
	}
	
	private void createDESPane()
	{
		
	}
	
	private void createRSAPane()
	{
		
	}
	
	private void setupTabs()
	{
		jTP.setPreferredSize(new Dimension(jTP_WIDTH, jTP_HEIGHT));
		jTP.addTab("Caesar Cipher", pane_caesar);
		jTP.addTab("DES Encryption", pane_DES);
		jTP.addTab("RSA Encryption", pane_RSA);
		add(jTP);
		jTP.setSelectedIndex(0);
	}
}