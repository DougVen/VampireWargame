/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class AtaquesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button attack,cancel,sattack;
    LogicaVampire t=new LogicaVampire();
    @FXML
    private void Cancel() throws IOException{
        Stage stage = (Stage) cancel.getScene().getWindow();
        File close=new File("close.txt");
        close.createNewFile();
    // do what you have to do
    stage.close();
    }
    
    private void terminar() throws IOException{
        Stage stage = (Stage) cancel.getScene().getWindow();
        File close=new File("close.txt");
        close.createNewFile();
    // do what you have to do
    stage.close();
    }
    
    @FXML
    public void Attack() throws IOException{
        
        File file= new File("access.txt");
        file.createNewFile();
        Cancel();

    }
    
    @FXML
    public void SpecialAttack() throws IOException{
        File file= new File("special.txt");
        file.createNewFile();
        
        Cancel();
    }
    
    @FXML
    public void Mover() throws IOException {
        File file= new File("mover.txt");
        System.out.println("mover");
        file.createNewFile();
        Cancel();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ;
        
        
    }    
    
}
