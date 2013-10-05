package com.umassd.ece.networksecurity;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SpinnerNumberModel;

import com.umassd.ece.networksecurity.functions.Caesar;

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
	
	// Caesar Buttons
	private JButton caesarShiftButton			= new JButton("Shift");
	private JButton caesarAddSpinners			= new JButton("+");
	private JButton caesarRemoveSpinners		= new JButton("-");
	
	private JCheckBox caesarReverse				= new JCheckBox("Reverse Loop");
	
	// DES Buttons
	private JButton DESCalculateButton			= new JButton("Calculate");
	
	// RSA Buttons
	private JButton RSACalculateButton			= new JButton("Calculate");
	
	// Caesar Cipher Output
	private JScrollPane serviceDemandOutputPane	= new JScrollPane(new JTextArea());
	
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
		// Input Panel (JLabel and JTextField)
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
		caesarButtonPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 60));
		
		
		// Output Panel (Shift/Clear Buttons and Output JLabel/JTextField)
		caesarOutputPanel.add(new JLabel(Resources.ccOutputString + ":"));
		JTextField jTFOutput = new JTextField();
		jTFOutput.setPreferredSize(new Dimension(jTP_WIDTH-24, 25));
		caesarOutputPanel.add(jTFOutput);
		caesarOutputPanel.setPreferredSize(new Dimension(jTP_WIDTH-10, 100));
		
		pane_caesar.add(caesarInputPanel);
		pane_caesar.add(caesarSpinnerPanel);
		pane_caesar.add(caesarButtonPanel);
		pane_caesar.add(caesarOutputPanel);
		
		pane_caesar.setPreferredSize(new Dimension());
		
		caesarAddSpinners.addActionListener(this);
		caesarRemoveSpinners.addActionListener(this);
		caesarShiftButton.addActionListener(this);
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
	}
}