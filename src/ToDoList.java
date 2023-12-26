
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;


//This code creates a new text file for a new task so that one text file contains one task.
//Different methods are then done on those text files or tasks 


/*THESE TEXT FILES ARE BEING SAVED IN "C:\\Users\\Admin\\Documents\\NetBeansProjects\\ToDoListTest" IN MY PC.
IF FILE PATH IS DIFFERENT ON YOUR PC, PLEASE ADDRESS THIS ISSUE ACCORDINGLY*/



public class ToDoList {
    private String date,time,subject,description,location,deadline;

    
     public void setDate (String date)
    {
        this.date=date;
    }
    
     public String getDate ()
    {
        return this.date;
    }
     
     public void setTime (String time)
    {
        this.time=time;
    }
      
     public String getTime ()
    {
        return this.time;
    }
       
     public void setSubject (String sub)
    {
        this.subject=sub;
    }
      
     public String getSubject ()
    {
        return this.subject;
    }
          
     public void setDescription (String desc)
    {
        this.description=desc;
    }
        
     public String getDescription ()
    {
        return this.description;
    }  
         
     public void setLocation (String loc)
    {
        this.location=loc;
    }
         
     public String getLocation ()
    {
        return this.location;
    } 
        
     public void setDeadline (String ddl)
    {
        this.deadline=ddl;
    }
         
     public String getDeadline ()
    {
        return this.deadline;
    } 
 
    public void InsertTask (int ID, String dt,String tm, String sub,String desc, String loc, String ddl) throws IOException
    {       
        //To insert a task in a text file 
        File Tasks = new File ("Task" + ID + ".txt");
        try (PrintWriter output = new PrintWriter ("Task" + ID + ".txt")) {
            output.println("Task number:"+ ID + "\t\tDate:"+ dt +"\t\tTime:" + tm + "\t\tSubject:" + sub + "\t\tDescription:" + desc + "\t\tLocation:" + loc + "\t\tDeadline:" + ddl + "\n");
            output.close();
        }  
    }
    
    public boolean updateTask (int ID,String dt,String tm, String sub,String desc, String loc, String ddl) throws FileNotFoundException, IOException
    {
        try
        {
        //To overwrite the previous content in the text file of the mentioned task
        FileWriter writer = new FileWriter("Task" + ID + ".txt");
        writer.write("Task number:"+ ID + "\t\tDate:"+ dt + "\t\tTime:" + tm + "\t\tSubject:" + sub + "\t\tDescription:" + desc + "\t\tLocation:" + loc + "\t\tDeadline:" + ddl + "\n");
        writer.close();
        return true;
        }
        catch (Exception e)
        {
            return false; 
        }
    }
    
    public boolean removeTask (int ID) throws IOException
    {
        try
        {
        File Tasks = new File ("Task" + ID + ".txt");
        
        //To close the text file if it is open somewhere, otherwise it won't be removed
        FileReader fread = new FileReader(Tasks);
        BufferedReader br = new BufferedReader (fread);
        br.close();
        fread.close();
        
        if (Tasks.delete()) {
            return true;
        }
        }
        
        catch(Exception e)
        {
            return false;
        }
        return false;
        
    }
   
}
