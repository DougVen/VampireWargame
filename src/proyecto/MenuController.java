/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author jose
 */
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ArrayList<Player> players= new ArrayList<>();
    
    @FXML
    private Button login;
    private TextField username;
    private TextField newUsername;
    private PasswordField password;
    private PasswordField newPassword;
    private Label warning;
    
    
    
    @FXML
    public void Crear(){

     
    }
    
    public void Login() throws Exception{
        
         if(username.getText() !=null && password.getText() != null){
             if(search()){
               Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
               Stage stage = new Stage();
               stage.setTitle("Juego");
               stage.setScene(new Scene(root1));
               stage.showAndWait();
             }
            
                 
         }
         
          System.out.println("Usuario Incorrecto o no existe");
        
    }
    
   public boolean search(){
       
       for(Player p : players){
           if(username.getText().equals(p.getUsername()) || password.getText().equals(p.getPassword())){
               return true;
           }       
       }      
       return false;  
   }
    
    @FXML
    public void Salir(){
        exit();
    }
    
    @FXML
    public void CrearJugador(){
        
        if(newUsername.getText()!=null&&newPassword.getText()!= null){
          players.add(new Player(newUsername.getText(),newPassword.getText()));
        }else{
            System.out.println("Agregue usuario y/o Contraseña");
        }
    }
    
    @FXML
    public void Imprimir(){
        for(Player p: players){
            System.out.println("-------------");
            System.out.println(p.getUsername());
            System.out.println("-------------");
        }
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Crear();
        
    }    
    
}

