package com.umassd.ece.networksecurity;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SpreadSheet extends JPanel
{
	private JTable jT;

	public SpreadSheet(String[][] data)
	{
		super(new GridLayout(1,0));
		String[] emptyLabels = new String[data[0].length];
		for(int i = 0; i < emptyLabels.length; i++)
			emptyLabels[i] = " ";

		jT = new JTable(data, emptyLabels);
		TableModel model = new DefaultTableModel(data, emptyLabels)
		{
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};

		jT.setModel(model);
		jT.setTableHeader(null);
		jT.setPreferredScrollableViewportSize(new Dimension(500,70));
		jT.setFillsViewportHeight(true);

		add(new JScrollPane(jT));
	}
}