package Notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class Fuction_File {
	
	GUI gui;
	String fileName;
	String fileAddress;
	
	public Fuction_File(GUI gui)
	{
	     this.gui=gui;	
	     
	}
	
	public void newFile()
	{
		gui.textArea.setText("");
		gui.window.setTitle("New");
	}
    
	public void open()
	{
		FileDialog fd = new FileDialog(gui.window,"Opne",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try
		{
			BufferedReader br = BufferedReader(new FileReader(fileAddress + fileName)); // you need the address to read a file
			
			gui.textArea.setText("");
			
			String line = null;
			
			while((line = br.readLine())!=null)
			{
				gui.textArea.append(line + "\n");
			}
			br.close();
		}
		catch(Exception e) {
			
			System.out.print("File not opened!");
			
		}
	}

	public BufferedReader BufferedReader(FileReader fileReader) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
