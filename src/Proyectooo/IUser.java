package Proyectooo;

import java.util.ArrayList;

public interface IUser {
    ArrayList<String> getLogs();

    String getUser();

    String getPass();

    int getPuntos();

    void addPuntos();
}

/*



 for(int i = 0; i<players.length; i++){
            if(players[i].equals(_user)){
                juegos.add(_message);
            }
        }
*/