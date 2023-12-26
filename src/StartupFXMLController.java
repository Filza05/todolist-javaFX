/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fkhan
 */
public class StartupFXMLController implements Initializable {

    @FXML
    private Label submitlbl;
    private TextField submittf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void enterAction(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/ToDoGUIFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
      
        stage.setTitle("To Do List");
        stage.setScene(scene);
        stage.show();
    }
    
}
