package Notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener
       {
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile , menuEdit, menuFormat, menuColor;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	Fuction_File file = new Fuction_File(this);

	public static void main(String[] args) 
	  {
		
		new GUI();

	}
	
	public GUI()
	{
		createWindow();
		CreateTextArea();
		createMenuBar();
		createFileMenu();
		window.setVisible(true);
	}
	

	public void createWindow() {
		
		window = new JFrame("NotePad");
		window.setSize(500,500);
		window.setLocation(250,250);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void CreateTextArea() {
		
		textArea = new JTextArea();
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder()); // remove the border
		window.add(scrollPane);
	//	window.add(textArea);
		
	}
	
	public void createMenuBar()
	{
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}
	
	public void createFileMenu()
	{
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save_AS");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		menuFile.add(iExit);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String  command = e.getActionCommand();
		
		switch(command)
		{
		case "New":file.newFile(); break;
		case "Open":file.open(); break;
		}
	}

}
