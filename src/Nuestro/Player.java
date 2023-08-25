package Nuestro;

import java.util.Date;

public class Player extends Userr {
    
    public static Player[] usersArray = new Player[100]; 
    public static String UsuarioLogeado;
    String[] fechas;
    
    public Player(String _user, String _pass, int _puntos) {
        super(_user, _pass, _puntos);
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

    public static Player buscarUser(String _user){
        return buscarUser(_user, 0);
    }
    
    private static Player buscarUser(String _user, int index){
        if (index >= usersArray.length)
            return null;
        
        Player actual = usersArray[index];
        
        if (actual != null && actual.getUser().equals(_user))
            return actual;
        return buscarUser(_user, index + 1);
    }
    
    public static void eraseUser(Player _user){
        for (int i = 0; i < usersArray.length; i++) {
            if (usersArray[i] == _user) {
                usersArray[i] = null;
                break;
            }
        }
    }
    
    public static void addLog(String _user, String _message) {
        for (Player usr : usersArray) {
            if (usr != null && usr.getUser().equals(_user)) {
                usr.juegos.add(_message);
            }
        }
    }
    
    public static void addUser(String _user, String _pass){
        if (buscarUser(_user) == null) {
            for (int i = 0; i < usersArray.length; i++) {
                if (usersArray[i] == null) {
                    usersArray[i] = new Player(_user, _pass, 0);
                    break;
                }
            }
        }
    }
    
    public Date getfECHA(){
        Date fecha=new Date();
        return fecha;
    }
    
    public void agregarFecha(String fecha, String jugador1, String jugador2, String resultado) {
        String[] nuevoArreglo = new String[fechas.length + 1];
        System.arraycopy(fechas, 0, nuevoArreglo, 0, fechas.length);
        nuevoArreglo[fechas.length] = (fechas.length)+" "+fecha+"  Jugador1: "+jugador1+"  Jugador2: "+jugador2+"  Resultado: "+resultado;
        fechas = nuevoArreglo;
    }
}

