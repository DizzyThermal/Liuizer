package com.umassd.ece.networksecurity;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SpinnerNumberModel;

import com.umassd.ece.networksecurity.functions.Caesar;
import com.umassd.ece.networksecurity.functions.DES;
import com.umassd.ece.networksecurity.functions.RSA;

public class GraphicalUserInterface extends JFrame implements ActionListener
{
	private int jTP_WIDTH = 788;
	private int jTP_HEIGHT = 567;
	
	// Overall Tabbed Pane
	private JTabbedPane jTP						= new JTabbedPane();
	private JPanel pane_caesar					= new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pane_DES						= new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pane_RSA						= new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// Caesar Shift Panels
	private JPanel caesarInputPanel				= new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel caesarSpinnerPanel			= new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel caesarButtonPanel			= new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel caesarOutputPanel			= new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// DES Panels
	private JPanel desInputPanel				= new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel desButtonPanel				= new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel desOutputPanel				= new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// RSA Panels
	private JPanel rsaInputPanel				= new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel rsaButtonPanel				= new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel rsaOutputPanel				= new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// Caesar Buttons
	private JButton caesarShiftButton			= new JButton("Shift");
	private JButton caesarAddSpinners			= new JButton("+");
	private JButton caesarRemoveSpinners		= new JButton("-");
	
	private JCheckBox caesarReverse				= new JCheckBox("Reverse Loop");
	
	// DES Buttons
	private JButton desEncryptButton			= new JButton("Encrypt");
	
	// RSA Buttons
	private JButton rsaEncryptButton			= new JButton("Encrypt/Decrypt");
	
	// Output Panes
	private JScrollPane desOutputPane			= new JScrollPane(new JTextArea());
	private JScrollPane rsaOutputPane			= new JScrollPane(new JTextArea());
	
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
		// Input Panel
		caesarInputPanel.add(new JLabel(Resources.ccInputString + ":"));
		JTextField jTFInput = new JTextField();
		jTFInput.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		caesarInputPanel.add(jTFInput);
		JLabel jL = new JLabel(Resources.ccSpinnerString + ":");
		jL.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		caesarInputPanel.add(jL);
		caesarAddSpinners.setPreferredSize(new Dimension(45, 25));
		caesarRemoveSpinners.setPreferredSize(new Dimension(45, 25));
		caesarInputPanel.add(caesarAddSpinners);
		caesarInputPanel.add(caesarRemoveSpinners);
		caesarInputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 115));
		
		// Spinner Panel
		JSpinner jSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 26, 1));
		jSpinner.setPreferredSize(new Dimension(50, 25));
		caesarSpinnerPanel.add(jSpinner);
		caesarSpinnerPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 30));
		
		// Button Panel
		JLabel space = new JLabel(" ");
		space.setPreferredSize(new Dimension(jTP_WIDTH-200, 25));
		caesarButtonPanel.add(space);
		caesarButtonPanel.add(caesarReverse);
		caesarShiftButton.setPreferredSize(new Dimension(100, 25));
		caesarButtonPanel.add(caesarShiftButton);
		caesarButtonPanel.setPreferredSize(new Dimension(jTP_WIDTH-15, 60));
		
		// Output Panel
		caesarOutputPanel.add(new JLabel(Resources.ccOutputString + ":"));
		JTextField jTFOutput = new JTextField();
		jTFOutput.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		caesarOutputPanel.add(jTFOutput);
		caesarOutputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 100));
		
		pane_caesar.add(caesarInputPanel);
		pane_caesar.add(caesarSpinnerPanel);
		pane_caesar.add(caesarButtonPanel);
		pane_caesar.add(caesarOutputPanel);
		
		caesarAddSpinners.addActionListener(this);
		caesarRemoveSpinners.addActionListener(this);
		caesarShiftButton.addActionListener(this);
	}
	
	private void createDESPane()
	{
		// Input Panel
		desInputPanel.add(new JLabel(Resources.desInputString + ":"));
		JTextField jTFInput = new JTextField();
		jTFInput.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		desInputPanel.add(jTFInput);
		desInputPanel.add(new JLabel(Resources.desKeyString + ":"));
		JTextField jTFKey = new JTextField();
		jTFKey.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		desInputPanel.add(jTFKey);
		desInputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 110));
		
		// Button Panel
		desEncryptButton.setPreferredSize(new Dimension(100, 25));
		desButtonPanel.add(desEncryptButton);
		desButtonPanel.setPreferredSize(new Dimension(jTP_WIDTH-15, 30));
		
		// Output Panel
		desOutputPanel.add(new JLabel(Resources.desOutputString + ":"));
		desOutputPane.setPreferredSize(new Dimension(jTP_WIDTH-23, 352));
		((JTextArea)((JViewport)desOutputPane.getComponent(0)).getView()).setEditable(false);
		desOutputPanel.add(desOutputPane);
		desOutputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 500));
		
		pane_DES.add(desInputPanel);
		pane_DES.add(desButtonPanel);
		pane_DES.add(desOutputPanel);
		
		rsaEncryptButton.addActionListener(this);
	}
	
	private void createRSAPane()
	{
		// Input Panel
		rsaInputPanel.add(new JLabel(Resources.rsaInputP + ":"));
		JTextField jTFInputP = new JTextField();
		jTFInputP.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		rsaInputPanel.add(jTFInputP);
		rsaInputPanel.add(new JLabel(Resources.rsaInputQ + ":"));
		JTextField jTFInputQ = new JTextField();
		jTFInputQ.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		rsaInputPanel.add(jTFInputQ);
		rsaInputPanel.add(new JLabel(Resources.rsaInputE + ":"));
		JTextField jTFInputE = new JTextField();
		jTFInputE.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		rsaInputPanel.add(jTFInputE);
		rsaInputPanel.add(new JLabel(Resources.rsaInputM + ":"));
		JTextField jTFInputM = new JTextField();
		jTFInputM.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		rsaInputPanel.add(jTFInputM);
		rsaInputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 210));
		
		// Button Panel
		rsaEncryptButton.setPreferredSize(new Dimension(150, 25));
		rsaButtonPanel.add(rsaEncryptButton);
		rsaButtonPanel.setPreferredSize(new Dimension(jTP_WIDTH-15, 30));
		
		// Output Panel
		rsaOutputPanel.add(new JLabel(Resources.rsaOutputString + ":"));
		rsaOutputPane.setPreferredSize(new Dimension(jTP_WIDTH-23, 252));
		((JTextArea)((JViewport)rsaOutputPane.getComponent(0)).getView()).setEditable(false);
		rsaOutputPanel.add(rsaOutputPane);
		rsaOutputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 300));
		
		pane_RSA.add(rsaInputPanel);
		pane_RSA.add(rsaButtonPanel);
		pane_RSA.add(rsaOutputPanel);
		
		desEncryptButton.addActionListener(this);
	}
	
	private void setupTabs()
	{
		jTP.setPreferredSize(new Dimension(jTP_WIDTH, jTP_HEIGHT));
		jTP.addTab("Caesar Cipher", pane_caesar);
		jTP.addTab("DES Encryption", pane_DES);
		jTP.addTab("RSA Encryption", pane_RSA);
		add(jTP);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == caesarShiftButton)
		{
			String inputString = ((JTextField)caesarInputPanel.getComponent(1)).getText();
			int[] charSteps = new int[caesarSpinnerPanel.getComponentCount()];
			for(int i = 0; i < charSteps.length; i++)
				charSteps[i] = (int)((JSpinner)caesarSpinnerPanel.getComponent(i)).getValue();
			
			boolean right = (caesarReverse.isSelected())?false:true;
			
			String outputString = Caesar.shift(inputString, charSteps, right);
			
			((JTextField)caesarOutputPanel.getComponent(1)).setText(outputString);
		}
		else if(e.getSource() == caesarAddSpinners)
		{
			if(caesarSpinnerPanel.getComponentCount() < 13)
			{
				JSpinner jSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 26, 1));
				jSpinner.setPreferredSize(new Dimension(50, 25));
				caesarSpinnerPanel.add(jSpinner);
				
				revalidate();
				repaint();
			}
		}
		else if(e.getSource() == caesarRemoveSpinners)
		{
			if(caesarSpinnerPanel.getComponentCount() > 1)
			{
				caesarSpinnerPanel.remove(caesarSpinnerPanel.getComponentCount() - 1);
				
				revalidate();
				repaint();
			}
		}
		else if(e.getSource() == desEncryptButton)
		{
			String message = ((JTextField)desInputPanel.getComponent(1)).getText();
			String key = ((JTextField)desInputPanel.getComponent(3)).getText();
			
			ArrayList<String> output = DES.encrypt(key, message);
			String outputString = "";
			for(int i = 0; i < output.size(); i++)
				outputString += output.get(i);
			
			// Set Output
			((JTextArea)((JViewport)desOutputPane.getComponent(0)).getView()).setText(outputString);
		}
		else if(e.getSource() == rsaEncryptButton)
		{
			String pIn = ((JTextField)rsaInputPanel.getComponent(1)).getText();
			String qIn = ((JTextField)rsaInputPanel.getComponent(3)).getText();
			String eIn = ((JTextField)rsaInputPanel.getComponent(5)).getText();
			String MIn = ((JTextField)rsaInputPanel.getComponent(7)).getText();
			
			ArrayList<String> output = RSA.encrypt(BigInteger.valueOf(Long.parseLong(pIn)), BigInteger.valueOf(Long.parseLong(qIn)), BigInteger.valueOf(Long.parseLong(eIn)), BigInteger.valueOf(Long.parseLong(MIn)));
			String outputString = "";
			for(int i = 0; i < output.size(); i++)
				outputString += output.get(i) + "\n";
			
			// Set Output
			((JTextArea)((JViewport)rsaOutputPane.getComponent(0)).getView()).setText(outputString);
		}
	}
}