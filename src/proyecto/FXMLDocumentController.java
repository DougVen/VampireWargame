/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import sun.audio.AudioPlayer;

/**
 *
 * @author jose
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane tablero = new GridPane();
    private ImageView imageview;
    private Image img = new Image(getClass().getResourceAsStream("peon.png"));
    private Image img2 = new Image(getClass().getResourceAsStream("yes.png"));
    private Image piso = new Image(getClass().getResourceAsStream("floor.png"));
    private Media sonido=new Media(getClass().getResource("sound.mp3").toString());
    private Media stage=new Media(getClass().getResource("stage.mp3").toString());
    //faltan los zombies
    //private Image zombieazul = new Image(getClass().getResourceAsStream("zombie.png"));
    private Image vampiroazul = new Image(getClass().getResourceAsStream("vampiroazul.png"));
    private Image muerteazul = new Image(getClass().getResourceAsStream("muerteazul.png"));
    private Image loboazul = new Image(getClass().getResourceAsStream("loboazul.png"));
    //private Image zombierojo = new Image(getClass().getResourceAsStream("zombie.png"));
    private Image vampirorojo = new Image(getClass().getResourceAsStream("vampirorojo.png"));
    private Image muerterojo = new Image(getClass().getResourceAsStream("muerteroja.png"));
    private Image loborojo = new Image(getClass().getResourceAsStream("loborojo.png"));
    
    
    private ImageView peon = new ImageView(img);
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
       
        playMedia(stage);
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
        
        botones[0][0].setGraphic(new ImageView(loborojo));
        botones[0][5].setGraphic(new ImageView(loboazul));
        botones[3][0].setGraphic(new ImageView(muerterojo));
        botones[3][5].setGraphic(new ImageView(muerteazul));
 
        botones[1][0].setGraphic(new ImageView(vampirorojo));
        botones[1][5].setGraphic(new ImageView(vampiroazul));
        botones[4][0].setGraphic(new ImageView(vampirorojo));
        botones[4][5].setGraphic(new ImageView(vampiroazul));
        
        botones[2][0].setGraphic(new ImageView(muerterojo));
        botones[2][5].setGraphic(new ImageView(muerteazul));
        botones[5][0].setGraphic(new ImageView(loborojo));
        botones[5][5].setGraphic(new ImageView(loboazul));
        
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
                
                doctor=getX(tardis);
                who=getY(tardis);

                if(ult.getGraphic()!=((Node)blank)){
                    playMedia(sonido);
                    posx=batman- doctor;
                    posy= superman-who;
                    if(posx<0)
                        posx=posx *(-1);
                    if(posy<0)
                        posy= posy*(-1);
                    
                    if((posx <=1)&& (posy <=1)){
                        System.out.println("si");
                
                        if(botones[doctor][who].getGraphic()==((Node)blank)){
                            botones[doctor][who].setGraphic(ult.getGraphic());
                            ult.setGraphic(((Node)blank));
                            return;
                        }
                    }      
                }           
                ult=tardis;    
                batman= doctor;
                superman= who;
            }              
        };   
}