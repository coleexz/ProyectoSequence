package Proyectooo;

import java.util.ArrayList;

public abstract class Userr implements IUser {
    protected String user,pass;
    protected String color;
    protected int puntos;
    protected static ArrayList<String> juegos;

    public Userr(String _user, String _pass, int _puntos,String color) {
        this.user = _user;
        this.pass = _pass;
        this.puntos = _puntos;
        this.juegos = new ArrayList<>();
        this.color = color;
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
    
    public String getColor(){
        return color;
    }
  
    public void setColor(String color){
        this.color = color;
    }
    
    public String toString(){
       return "user: "+user +" pass: "+pass+" color : "+color+" puntos: "+puntos;
    }
     
}