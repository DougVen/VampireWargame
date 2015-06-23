/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Player implements Mando {

    private String Username;
    private String password;
    public RandomAccessFile player;
    private RandomAccessFile info;

    public Player(String nombre, String password) {
        this.Username = nombre;
        this.password = password;
       

    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }
    /*
     String Username
     String Password
     boolean logged on
     int puntake
     int partidas
    
     */

    @Override
    public void crearUsuario(String nombre, String pass) {
        
        try {
            RandomAccessFile player2= new RandomAccessFile("player","rw");
            player2.seek(player2.length());
            player2.writeUTF(nombre);
            player2.writeUTF(pass);
            player2.writeBoolean(true);
            player2.writeInt(0);
            player2.writeInt(0);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void eliminar(String nombre, String pass) {
        try {
            RandomAccessFile player2= new RandomAccessFile("player", "rw");
            player2.seek(0);
            long pos = 0;
            while (player2.getFilePointer() > player2.length()) {

                if (player2.readUTF().equals(nombre)) {
                    player2.seek(pos);
                    player2.writeUTF("");
                    player2.writeUTF("");
                    player2.writeBoolean(true);
                    player2.readInt();
                    player2.readInt();

                } else {
                    player2.readUTF();
                    player2.readUTF();
                    player2.readBoolean();
                    player2.readInt();
                    player2.readInt();
                    pos = player2.getFilePointer();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarPartida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long search(String nombre) {
        try {
            RandomAccessFile player2= new RandomAccessFile("player", "rw");
            player2.seek(0);
            long pos = 0;
            while (player2.getFilePointer() < player2.length()) {
                  if (player2.readUTF().equals(nombre)) {
                   return pos;

                } else {
                    player2.readUTF();
                    player2.readUTF();
                    player2.readBoolean();
                    player2.readInt();
                    player2.readInt();
                    pos = player2.getFilePointer();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return -1;
    }

    @Override
    public void print() {
        try {
            
            RandomAccessFile player2= new RandomAccessFile("player", "rw");
            player2.seek(0);
          
            while(player2.getFilePointer()<player2.length()){
                  System.out.println("---");
                System.out.println(player2.readUTF());
                System.out.println(player2.readUTF());
                 player2.readBoolean();
                    player2.readInt();
                    player2.readInt();
                
            }
        } catch (IOException ex) {
            System.out.println("lol");
        }
    }

}
