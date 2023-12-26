/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author fkhan
 */
public class ToDoGUIFXMLController implements Initializable {

  @FXML
  public TextField tn1,dt1,tm1,sb1,ln1,dd1,removetf,tn2,dt2,tm2,sb2,ln2,dd2,searchtf,marktf,sendertf,recievertf;
  public TextArea dsc1,dsc2,searchta,displayta;
  public Label insertlbl,removelbl,updatelbl,marklbl,emaillbl;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void insertAction (ActionEvent i) throws IOException, NumberFormatException
    {
        ToDoList task = new ToDoList();
        try{
        task.InsertTask(Integer.parseInt(tn1.getText()), dt1.getText(), tm1.getText(), sb1.getText(), dsc1.getText(), ln1.getText(), dd1.getText());
        insertlbl.setText("Task " + Integer.parseInt(tn1.getText()) + " Successfully added to your list.");
        tn1.setText("");
        dt1.setText("");
        tm1.setText("");
        sb1.setText("");
        ln1.setText("");
        dd1.setText("");
        dsc1.setText("");}
        
        catch(NumberFormatException e)
        {
           tn1.setText("Please enter a number here!!!");
        }
        
        catch(IOException r)
        {
           tn1.setText("Sorry, an unexpected error occured");
        }
        
    }
    
    public void removeAction (ActionEvent r) throws IOException, NumberFormatException
    {
      try
      {
        ToDoList task = new ToDoList();
       
        if (task.removeTask(Integer.parseInt(removetf.getText())))
        {
            removelbl.setText("Task " +Integer.parseInt(removetf.getText()) + " Successfully Removed!" );
        }
        else
        {
            removelbl.setText("Task not Found! You must have not entered it or you have already removed it. Try Again.");
                    
        }
      }
      
      catch (NumberFormatException w)
      {
          removetf.setText("Enter a number here");
      }
        
        
    }
    
    public void updateAction (ActionEvent u) throws IOException, NumberFormatException
    {
        ToDoList task = new ToDoList();
        try{
      
        if(task.updateTask(Integer.parseInt(tn2.getText()), dt2.getText(), tm2.getText(), sb2.getText(), dsc2.getText(), ln2.getText(), dd2.getText()))
        {
             updatelbl.setText("Task " +Integer.parseInt(tn2.getText()) + " Successfully Updated!" );
        }
        else
        {
            updatelbl.setText("Task not Found! You must have not entered it or you have already removed it. Try Again.");
        }
        
        tn2.setText("");
        dt2.setText("");
        tm2.setText("");
        sb2.setText("");
        ln2.setText("");
        dd2.setText("");
        dsc2.setText("");}
        
        catch (NumberFormatException e)
        {
            tn2.setText("Please Enter a Number Here!!!");
        }
    }
    
    public void searchAction (ActionEvent s) throws IOException, FileNotFoundException
    {
       
         try
        {
            Scanner fileIn = new Scanner(new File("Task" + Integer.parseInt(searchtf.getText()) + ".txt"));
            String task = fileIn.nextLine();
            searchta.setText(task);  
            fileIn.close();
            
        }
        catch(FileNotFoundException e)
        {
            searchta.setText("Task not Found! You must have not entered it or you have already removed it. Try Again.");
        }
   
       
    }
    
    public void displayAction (ActionEvent d) throws FileNotFoundException
    {
        try{
                String projectDirectory = System.getProperty("user.dir");
                File directoryPath = new File(projectDirectory);
		//To List text files only
		File[] files = directoryPath.listFiles (new FilenameFilter() {
			@Override
                       
			public boolean accept(File dir, String name) 
                        {
				return name.endsWith(".txt");
                         /*filtering only the text files so that if a task file is removed when
                        removing a task from todolist, only the text files are
                        retrieved and printed, so all tasks are printed as they are.*/
			}
		});
                            
                            for (File file : files) {
                            Scanner input = new Scanner(new File("" + file.getName()));
                            String task = input.nextLine();
                            displayta.appendText(task + "\n\n");
                            input.close();
		}}
        
        catch (FileNotFoundException e)
        {
            displayta.setText("No Task Entered Yet!!");
        }
    }
    
    
    public void markAction (ActionEvent m) throws IOException
    {
     if (new File("Task" + Integer.parseInt(marktf.getText()) + ".txt").exists())
     {
        FileWriter writer = new FileWriter("Task" + Integer.parseInt(marktf.getText()) + ".txt");
        writer.write("Task " + Integer.parseInt(marktf.getText()) + " was marked as done!.");
        writer.close();
        marklbl.setText("Task "+ Integer.parseInt(marktf.getText()) + " is now marked as done!");
     }
       else
       {
            marklbl.setText("Task not Found! You must have not entered it or you have already removed it. Try Again.");
       }
    }
    
    
    public void handleResetAction(ActionEvent r)
    {
        tn1.setText("");
        dt1.setText("");
        tm1.setText("");
        sb1.setText("");
        ln1.setText("");
        dd1.setText("");
        dsc1.setText("");
        tn2.setText("");
        dt2.setText("");
        tm2.setText("");
        sb2.setText("");
        ln2.setText("");
        dd2.setText("");
        dsc2.setText("");
        removetf.setText("");
        searchtf.setText("");
        marktf.setText("");
        searchta.setText("");
        displayta.setText("");
        insertlbl.setText("");
        removelbl.setText("");
        updatelbl.setText("");
        marklbl.setText((""));
        
    }
    }
    
   

