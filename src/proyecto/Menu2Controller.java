/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author jose
 */
public class Menu2Controller implements Initializable {

     @FXML
    public Button bnuevapartida;
    public Button bverinformacion;
    public Button bcpassword;
    public Button bcerrarcuenta;
    public Button bRanking;
    public Button blogs;
    public Button blogout;
    public TextArea Areatexto;
    public Label background2;
    private Image img2 = new Image(getClass().getResourceAsStream("castlevania.jpg"));
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    background2.setGraphic(new ImageView(img2));     
    
    Areatexto.setText("Mi informacion: ");
    Areatexto.appendText(" mi informacion!");
    
    }
    
    @FXML
    public void Salir(){
        exit();
    }
    
    @FXML
    public void nuevaPartida() throws Exception{
        
        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
               
               Stage stage = new Stage();
               stage.setTitle("Juego");
               stage.setScene(new Scene(root2));
               stage.show();
               
        
    }
    
}
