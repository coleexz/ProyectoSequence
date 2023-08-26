package Nuestro;

import java.util.ArrayList;

public class Player extends Userr {
    
    public static ArrayList<Player> users = new ArrayList();
    
    
    
    public Player(String _user, String _pass, int _puntos,char color) {
        super(_user, _pass, _puntos,color);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuntos() {
        return puntos;
    }
    
     public char getColor(){
        return color;
    }
  
    public void setColor(char color){
        this.color = color;
    }

    
    public static Player buscarUser(String _user) {
        for (Player player : users) {
            if (player.getUser().equals(_user)) {
                return player;
            }
        }
        return null;
    }

    public static void eraseUser(Player _user) {
        users.remove(_user);
    }

    public static void addLog(String _user, String _message) {
        Player player = buscarUser(_user);
        if (player != null) {
            player.juegos.add(_message);
        }
    }

    public static void addUser(String _user, String _pass,char color) {
        if (buscarUser(_user) == null) {
            users.add(new Player(_user, _pass, 0,color));
        }
    }
    
}

