package Nuestro;

import java.util.ArrayList;

public abstract class Userr implements IUser {
    protected String user;
    protected String pass;
    protected int puntos;
    protected static ArrayList<String> juegos;

    public Userr(String _user, String _pass, int _puntos) {
        this.user = _user;
        this.pass = _pass;
        this.puntos = _puntos;
        this.juegos = new ArrayList<>();
    }

    public ArrayList<String> getLogs() {
        return juegos;
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

    public void addPuntos() {
        this.puntos += 3;
    }
    
  
     
}