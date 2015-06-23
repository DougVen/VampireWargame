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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.RandomAccess;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    ArrayList<Player> players = new ArrayList<>();

    @FXML
    private Button login;
    public TextField username;
    public TextField newUsername;
    public PasswordField password;
    public PasswordField newPassword;
    private Label warning;
    public Label background;
    private Image img2 = new Image(getClass().getResourceAsStream("castlevania.jpg"));
    public Player player=new Player("","");
    

    @FXML
    public void Crear() {
       
    }

    public void Login() throws Exception {
       
        
        if (username.getText() != null && password.getText() != null) {
            if (player.search(username.getText()) != -1) {
                RandomAccessFile player2= new RandomAccessFile("player", "rw");
                player2.seek(player.search(username.getText()));
                player2.readUTF();
                String t = player2.readUTF();
                if (t.equals(password.getText())) {
                    Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Juego");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } else {
                    System.out.println("Usuario Incorrecto o no existe");
                }
            }

        }

    }

    public boolean search() {

        for (Player p : players) {
            if (username.getText().equals(p.getUsername()) || password.getText().equals(p.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    public void Salir() {
        exit();
    }

    @FXML
    public void CrearJugador() throws IOException {
        boolean flag = true;
        if (newUsername.getText() != null && newPassword.getText() != null) {

            if (player.search(newUsername.getText())== -1) {
                players.add(new Player(newUsername.getText(), newPassword.getText()));
                player.crearUsuario(newUsername.getText(), newPassword.getText());
                Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Juego");
                stage.setScene(new Scene(root1));
                stage.show();
            }

        } else {
            System.out.println("Agregue usuario y/o Contraseña");
        }

        newUsername.setText(null);
        newPassword.setText(null);

    }

    @FXML
    public void Imprimir() {
       
        player.print();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        newUsername.setText(null);
        newPassword.setText(null);
        username.setText(null);
        password.setText(null);
        background.setGraphic(new ImageView(img2));
    }

}
