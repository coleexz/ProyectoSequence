package Proyectooo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;

public class Player extends Userr {

    public static ArrayList<Player> users = new ArrayList();
    public static String UsuarioLogeado;
    static RandomAccessFile historial,estadisticas;
     private Date creationDate; // Atributo para almacenar la fecha de creación.

    public Player(String _user, String _pass, int _puntos, String color) {
        super(_user, _pass, _puntos, color);
        this.creationDate = new Date(); // Asignar la fecha y hora actual al atributo de creación.
    }

    // Método para obtener la fecha de creación.
    public Date getCreationDate() {
        return creationDate;
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
    
    public static void agregarEstadisticas(String text) {
        try (RandomAccessFile rafhistorial = new RandomAccessFile("Users/historial.hstrl", "rw")) {
            // Si el archivo no existe, RandomAccessFile lo crea automáticamente.
            historial.seek(rafhistorial.length()); // Posicionar el puntero al final del archivo.
            historial.writeUTF(text);     // Escribir el texto en el archivo.
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static String agarrarEstadisticas(){
        String acum="";
        for(Player p : users){
            acum+="Nombre: "+p.user+" Puntos: "+p.puntos+" Fecha de creacion :"+p.getCreationDate()+"\n";
        }
        return acum;
    }

    
}
