package Proyectooo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Player extends Userr {

    public static ArrayList<Player> users = new ArrayList();
    public static String UsuarioLogeado;
    String[] fechas;

    public Player(String _user, String _pass, int _puntos, String color) {
        super(_user, _pass, _puntos, color);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Player> getUsers() {
        return users;
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

    public static void addUser(String _user, String _pass, String color) {
        if (buscarUser(_user) == null) {
            users.add(new Player(_user, _pass, 0, color));
        }
    }

    //obtener fecha de creacion del user
    public Date getfECHA() {
        Date fecha = new Date();
        return fecha;
    }

    //mostrar los logs
    public void Logs(String fecha, String jugador1, String jugador2, String resultado) {
        String[] nuevoArreglo = new String[fechas.length + 1];
        System.arraycopy(fechas, 0, nuevoArreglo, 0, fechas.length);
        nuevoArreglo[fechas.length] = (fechas.length) + " " + fecha + "  Jugador1: " + jugador1 + "  Jugador2: " + jugador2 + "  Resultado: " + resultado;
        fechas = nuevoArreglo;
    }

    //guarda el usuario en el archivo que se creo
    public static void saveUsersToFile(String filename) {
        try {
            LOGIN.raf.seek(0);
            for (Player player : users) {
                LOGIN.raf.writeUTF(player.getUser());
                LOGIN.raf.writeUTF(player.getPass());
                LOGIN.raf.writeUTF(player.getColor());
            }
        } catch (IOException e) {
            System.out.println("Error. No se pudo guardar el usuario");
        }
    }

    //carga los usuarios creados y guardados en el archivo
    public static void loadUsersFromFile(String filename) throws IOException {
        System.out.println(LOGIN.raf.getFilePointer());
        try {
            while (LOGIN.raf.getFilePointer() < LOGIN.raf.length()) {
                String user = LOGIN.raf.readUTF();
                String pass = LOGIN.raf.readUTF();
                String color = LOGIN.raf.readUTF();
                addUser(user, pass, color);

            }
        } catch (IOException e) {
            System.out.println("Error. No se pudieron cargar los usuarios");
        }
    }
}
