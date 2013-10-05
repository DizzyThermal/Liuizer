package com.umassd.ece.networksecurity;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class GraphicalUserInterface extends JFrame
{
	// Overall Tabbed Pane
	JTabbedPane jTP = new JTabbedPane();
	JPanel pane_caesar = new JPanel(new FlowLayout());
	JPanel pane_DES = new JPanel(new FlowLayout());
	JPanel pane_RSA = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// GUI Panels
	JPanel p_caesar = new JPanel(new GridLayout(9,1));
	JPanel p_DES = new JPanel(new GridLayout(9,1));
	JPanel p_RSA = new JPanel(new GridLayout(9,1));
	
	// Caesar Shift/Clear Buttons
	JButton caesarShiftButton = new JButton("Shift");
	JButton caesarClearButton = new JButton("Clear");
	
	// DES Calculate/Clear Buttons
	JButton DESCalculateButton = new JButton("Calculate");
	JButton DESClearButton = new JButton("Clear");
	
	// RSA Calculate/Clear Buttons
	JButton RSACalculateButton = new JButton("Calculate");
	JButton RSAClearButton = new JButton("Clear");
	
	// Caesar Cipher Output
	JScrollPane serviceDemandOutputPane = new JScrollPane(new JTextArea());
	
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
		jTP.setPreferredSize(new Dimension(300, 490));
		jTP.addTab("Caesar Cipher", pane_caesar);
		jTP.addTab("DES Encryption", pane_DES);
		jTP.addTab("RSA Encryption", pane_RSA);
		add(jTP);
		jTP.setSelectedIndex(0);
	}
}