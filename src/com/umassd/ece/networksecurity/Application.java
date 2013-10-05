package com.umassd.ece.networksecurity;

import javax.swing.JFrame;

public class Application
{
	final static int WIDTH  = 800;
	final static int HEIGHT = 600;
	
	public static void main(String[] args)
	{
		GraphicalUserInterface GUI = new GraphicalUserInterface();

		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setSize(WIDTH, HEIGHT);
		GUI.setResizable(true);
		GUI.setVisible(true);
	}
}