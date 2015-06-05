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
    public TextField username;
    public TextField newUsername;
    public PasswordField password;
    public PasswordField newPassword;
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
               stage.show();
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
        boolean flag = true;
        if(newUsername.getText()!=null&&newPassword.getText()!= null){
           for(Player p : players){
            if(newUsername.getText().equals(p.getUsername()) && newPassword.getText().equals(p.getPassword())){
                System.out.println("el Jugador ya existe");
                flag=false;
            }
            
           }
           if(flag==true)
           players.add(new Player(newUsername.getText(),newPassword.getText()));
 
        }else{
            System.out.println("Agregue usuario y/o Contraseña");
        }
        
        newUsername.setText(null);
        newPassword.setText(null);
        
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
        newUsername.setText(null);
        newPassword.setText(null);
        username.setText(null);
        password.setText(null);
    }    
    
}

