/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartgcc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zange
 */
public class UserOptionsController implements Initializable {

    boolean tCheckBox100_1;
    boolean tCheckBox100_2;
    boolean tCheckBox300_1;
    String tTextField100_2;
    @FXML
    private CheckBox checkBox100_1;
    @FXML
    private TextField textField100_2;
    @FXML
    private CheckBox checkBox100_2;
    @FXML
    private CheckBox checkBox300_1;
    @FXML
    private ComboBox<?> comboBox300_1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SingletonApp s = SingletonApp.getInstance();
       
        tCheckBox100_1   = s.CheckBox100_1;
        tCheckBox100_2   = s.CheckBox100_2;
        tCheckBox300_1   = s.CheckBox300_1;
        tTextField100_2  = s.TextField100_2;
        
        updateUI();
    }    

    private void updateUI() {
        checkBox100_1.setSelected(tCheckBox100_1);
        checkBox100_2.setSelected(tCheckBox100_2);
        checkBox300_1.setSelected(tCheckBox300_1);
        
        textField100_2.setText(tTextField100_2);
    }
    
        
    @FXML
    private void handleCheckBox100_1(ActionEvent event) {
        CheckBox chkbItem = (CheckBox) event.getSource();
        tCheckBox100_1 = !chkbItem.isDisable();
    }

    @FXML
    private void handleTextField100_2(ActionEvent event) {
        TextField txtFieldItem = (TextField) event.getSource();
        tTextField100_2 = txtFieldItem.getText();
    }

    @FXML
    private void handleCheckBox100_2(ActionEvent event) {
        CheckBox chkbItem = (CheckBox) event.getSource();
        tCheckBox100_2 = !chkbItem.isDisable();
    }

    @FXML
    private void handleCheckBox300_1(ActionEvent event) {
    }

    @FXML
    private void handleComboBox300_1(ActionEvent event) {
        CheckBox chkbItem = (CheckBox) event.getSource();
        tCheckBox300_1 = !chkbItem.isDisable();
    }

    @FXML
    private void handleBtnApply(ActionEvent event) {
        
        SingletonApp s   = SingletonApp.getInstance();
        
        s.CheckBox100_1  = tCheckBox100_1;
        s.CheckBox100_2  = tCheckBox100_2;
        s.CheckBox300_1  = tCheckBox300_1;
        s.TextField100_2 = tTextField100_2;
        
        s.SaveAllSettings();
        
        goBack();
    }

    @FXML
    private void handleBtnCancel(ActionEvent event) {
        goBack();
    }
    
    private void goBack(){
        
        SingletonApp s   = SingletonApp.getInstance();
        
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            Stage window = s.stage;
            window.setScene(scene);
            window.show();
        }
        catch(IOException e){
            
        }
    }


}
