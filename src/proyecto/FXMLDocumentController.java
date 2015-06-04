/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO;
import java.io.File;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Time;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.audio.AudioPlayer;
import proyecto.LogicaVampire;
import proyecto.HombreLobo;
import proyecto.Muerte;
import proyecto.Vampiro;
import proyecto.Ficha;
        
/**
 *
 * @author jose
 */
public class FXMLDocumentController implements Initializable {
      public LogicaVampire play= new LogicaVampire();
    

    @FXML
    private GridPane tablero = new GridPane();
    private ImageView imageview;
    private Image img2 = new Image(getClass().getResourceAsStream("yes.png"));
    private Image piso = new Image(getClass().getResourceAsStream("floor.png"));
    private Media sonido=new Media(getClass().getResource("sound.mp3").toString());
    private Media son=new Media(getClass().getResource("stage.mp3").toString());
    private File files=new File("access.txt");
    private File files2= new File("special.txt");
    private File files3= new File("mover.txt");
    private File close=new File("close.txt");
    //faltan los zombies
    //private Image zombieazul = new Image(getClass().getResourceAsStream("zombie.png"));
    private Image vampiroazul = new Image(getClass().getResourceAsStream("vampiroazul.png"));
    private Image muerteazul = new Image(getClass().getResourceAsStream("muerteazul.png"));
    private Image loboazul = new Image(getClass().getResourceAsStream("loboazul.png"));
    //private Image zombierojo = new Image(getClass().getResourceAsStream("zombie.png"));
    private Image vampirorojo = new Image(getClass().getResourceAsStream("vampirorojo.png"));
    private Image muerterojo = new Image(getClass().getResourceAsStream("muerteroja.png"));
    private Image loborojo = new Image(getClass().getResourceAsStream("loborojo.png"));
    

    private ImageView blank = new ImageView(img2);
    private Button[][] botones = new Button[6][6];
    private int doctor,who, batman,superman,posx,posy;
    private Button ult= new Button("",((Node)blank));
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        System.out.println("You clicked me!");  
    }
    
    public void check(int a,int b){
        if(botones[a][b].getGraphic()==null)
            System.out.println("3");
    }
    
    public boolean Mover(){
        if(posx<0)
            posx=posx *(-1);
        if(posy<0)
            posy= posy*(-1);

        if((posx <=1)&& (posy <=1)){
        botones[doctor][who].setGraphic(botones[batman][superman].getGraphic());
         ult.setGraphic(((Node)blank));
                play.tablero[who][doctor]=play.tablero[superman][batman];
                play.tablero[superman][batman]=null;
                
                play.Print();
                
        }
        return true;
    }
            
    public void Menu() throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ataques.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));  
            stage.showAndWait();
       
    }
    
    
    public int getX(Button b){
        for (int i = 0; i <botones.length; i++) {
                    for (int j = 0; j < botones[i].length; j++) {
                        if(botones[i][j]==b){
                            doctor=i;
                            who=j;
                        }
                    }
                }           
                return doctor;
    }
    public int getY(Button b){
        for (int i = 0; i <botones.length; i++) {
                    for (int j = 0; j < botones[i].length; j++) {
                        if(botones[i][j]==b){
                            doctor=i;
                            who=j;
                        }
                    }
                }
                if(b instanceof Button)
                    System.out.println("posicion: "+ doctor+" "+who);
                
                return who;
    }
    
    private void playMedia(Media m){
    if (m != null){
        MediaPlayer mp = new MediaPlayer(m);
        
        mp.play();
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        playMedia(son);
        tablero.getColumnConstraints().add(new ColumnConstraints(20)); // column 0 is 100 wide
        tablero.getRowConstraints().add(new RowConstraints(-60));
     
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                
                botones[i][j] = new Button("", blank);
                
                tablero.add(botones[i][j], i, j);
                botones[i][j].setOnAction(mover);
                if(i%2==0&&j%2==0){
                botones[i][j].setStyle("-fx-base: #008B8B");
                } else{
                    
                }   
                if((i==1||i==3||i==5)&&j%2!=0){
                botones[i][j].setStyle("-fx-base:  #008B8B");
                } else{
                    
                }
            }
            
                
           
        }
        
        play.tablero[0][0]= new HombreLobo("rojo");
        play.tablero[5][0]= new HombreLobo("azul");
        play.tablero[0][3]= new Muerte("rojo");
        play.tablero[5][3]= new Muerte("azul");
        
        play.tablero[0][1]= new Vampiro("rojo");
        play.tablero[5][1]= new Vampiro("azul");
        play.tablero[0][4]= new Vampiro("rojo");
        play.tablero[5][4]= new Vampiro("azul");
        
        play.tablero[0][2]= new Muerte("rojo");
        play.tablero[5][2]= new Muerte("azul");
        play.tablero[0][5]= new HombreLobo("rojo");
        play.tablero[5][5]= new HombreLobo("azul");
        
        botones[0][0].setGraphic(play.tablero[0][0].getIcon());
        botones[0][5].setGraphic(play.tablero[5][0].getIcon());
        botones[3][0].setGraphic(play.tablero[0][3].getIcon());
        botones[3][5].setGraphic(play.tablero[5][3].getIcon());
 
        botones[1][0].setGraphic(play.tablero[0][1].getIcon());
        botones[1][5].setGraphic(play.tablero[5][1].getIcon());
        botones[4][0].setGraphic(play.tablero[0][4].getIcon());
        botones[4][5].setGraphic(play.tablero[5][4].getIcon());
        
        botones[2][0].setGraphic(play.tablero[0][2].getIcon());
        botones[2][5].setGraphic(play.tablero[5][2].getIcon());
        botones[5][0].setGraphic(play.tablero[0][5].getIcon());
        botones[5][5].setGraphic(play.tablero[5][5].getIcon());
        
        
        
        
        
        for (int i = 0; i < 6; i++) {
                botones[i][0].setId("Peon:"+i);
                botones[i][5].setId("Peon2:"+i);       
        }       
        //botones[0][5].setGraphic(peon);
    }      
EventHandler mover= new EventHandler()  {
@Override
    public void handle(Event event) {
         
    Object source = event.getTarget();
    Button tardis=(Button)source;
    play.Print();
    doctor=getX(tardis);
    who=getY(tardis);
  
                

    if(ult.getGraphic()!=((Node)blank)){
        try {
            Menu();
            if(close.exists()){
                                close.delete();
                                ult=new Button("", blank);
                                System.out.println("yay");
                                
                            }
      
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        playMedia(sonido);
        posx=batman- doctor;
        posy= superman-who;
        

            if(botones[doctor][who].getGraphic()==((Node)blank)){
                if(files3.exists()){
                   if(Mover()){
                       System.out.println("me movi");
                       ult=new Button("", blank);
                   }
                    files3.delete();
                }
                
                return;
            }
            if(botones[doctor][who].getGraphic()!=((Node)blank)){
                if(play.tablero[who][doctor].getColor().equals(play.tablero[superman][batman].getColor())){
                }else{

                     try {
          
                      
                       System.out.println("Menu");
                       System.out.println("Exito");

                     } catch (Exception ex) {
                         System.out.println("non so");
                        }
                     finally{
                         
                         
                          if(files.exists()){
                             files.delete();
                             botones[doctor][who].disarm();

                        //Aqui alex ataque

                             int ataque= play.tablero[superman][batman].getAtaque();

                             int life=play.tablero[who][doctor].getVida();
                             int escudo=play.tablero[who][doctor].getEscudo();

                              System.out.println("Vida antes: " + life);
                              System.out.println("Escudo antes: " + escudo);
                              System.out.println("Ataque antes: " + ataque);

                              if(ataque>escudo){
                                  ataque= ataque-escudo;
                                  escudo=0;
                              }
                              else{
                                  escudo= escudo-ataque;
                                  ataque=0;
                              }

                              life= life- ataque;

                              //setear las nuevas vida y escudo
                              play.tablero[who][doctor].setEscudo(escudo);
                              play.tablero[who][doctor].setVida(life);

                              System.out.println("Vida despues: " + life);
                              System.out.println("Escudo despues: " + escudo);
                              System.out.println("Ataque despues: " + ataque);
                              System.out.println("--------------");
                              System.out.println("Escudo seteado: "+ play.tablero[who][doctor].getEscudo());
                              System.out.println("Vida seteado: "+ play.tablero[who][doctor].getVida());

                              if(play.tablero[who][doctor].getVida()<=0){
                                  botones[doctor][who].setGraphic((Node)blank);
                              }
                            }

                            if(files2.exists()){
                                files2.delete();
                                //if(play.tablero[who][doctor].getTest().equals("H")){
                                play.tablero[superman][batman].ataqueEspecial(play,botones,tardis,ult);
                                if(play.tablero[who][doctor].getVida()<=0){
                                   botones[doctor][who].setGraphic((Node)blank);
                                }
                                //Aqui special attack alex
                            }
                            
                            
                        }   
                }
            }
              
        
        //parte del special del lobo
        
    }
    ult=tardis;    
    batman= doctor;
    superman= who;
    //no me funciona el special del lobo..
                /*
                                if(play.tablero[superman][batman].getTest().equals("H")){
                                    System.out.println("plss");
                                    if(ult.getGraphic()!=((Node)blank)){
                                    posx=batman- doctor;
                                    posy= superman-who;
                                    if(posx<0)
                                        posx=posx *(-1);
                                    if(posy<0)
                                        posy= posy*(-1);

                                    if((posx <=2)&& (posy <=2)){

                                        if(botones[doctor][who].getGraphic()==((Node)blank)){

                                            botones[doctor][who].setGraphic(ult.getGraphic());
                                            play.tablero[who][doctor]=play.tablero[superman][batman];
                                            play.tablero[superman][batman]=null;
                                            ult.setGraphic(((Node)blank));
                                            play.Print();
                                            return;
                                        }
                                    }
                                    }
                                    System.out.println("falso baby");
                                }
                */

    }
};
}