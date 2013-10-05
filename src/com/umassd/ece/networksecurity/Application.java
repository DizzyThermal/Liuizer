package com.umassd.ece.networksecurity;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application
{
	static int WIDTH  = 800;
	static int HEIGHT = 600;
	
	public static void main(String[] args)
	{
		GraphicalUserInterface GUI = new GraphicalUserInterface();

		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setSize((System.getProperty("os.name").contains("Windows"))?(WIDTH + 4):WIDTH, (System.getProperty("os.name").contains("Windows"))?(HEIGHT + 1):HEIGHT);
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.getClass().getResource("images/Application_Icon.png")));
		GUI.setResizable(false);
		GUI.setVisible(true);
	}
}