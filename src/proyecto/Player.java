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
public class Player {
    
    private String Username;
    private String password;

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
    
    
    
    
    
}
