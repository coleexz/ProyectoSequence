/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyectooo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author AdminColeexz
 */
public class ATABLEROCOLE extends javax.swing.JFrame implements ActionListener {

    private String tableroIconos[][] = new String[10][10]; //tablero para verificar que si los iconos son del compañero o no
    private String tableroCartas[][] = new String[10][10]; //tablero para conseguir las cartas y verificar si son cartas especiales
    private ArrayList<ImageIcon> imagenes = new ArrayList();

    char turnoJugador = 'a';
    String posColocar = "";
    public static int numjugadores = 4;
    private Player jugadores[];

    ImageIcon redToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/redToken.png"));
    ImageIcon blueToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/blueToken.png"));
    ImageIcon yellowToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/yellowToken.png"));
    ImageIcon greenToken = new javax.swing.ImageIcon(getClass().getResource("/tokens/greenToken.png"));

   
    //array para cargar las imagenes de la baraja
    private ImageIcon[][] handCardImages = {
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/JS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/JH.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/AD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/KD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/QD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/10D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/9D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AC.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/8D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2C.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/7D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QH.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/6D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/6H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/7H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/8H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10H.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/9S.png"))},
        {new javax.swing.ImageIcon(getClass().getResource("/handCards/JD.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/5D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/4D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/3D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/2D.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/AS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/KS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/QS.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/10S.png")), new javax.swing.ImageIcon(getClass().getResource("/handCards/JC.png"))}
    };
    //arreglo de los nombres de las cartas en el mismo orden del arreglo de las imagenes para luego identificar que carta se selecciono de la baraja
    private String[][] handCardNames = {
        {"JS", "AC", "KC", "QC", "10C", "9C", "8C", "7C", "6C", "JH"},
        {"AD", "7S", "8S", "9S", "10S", "QS", "KS", "AS", "5C", "2S"},
        {"KD", "6S", "10C", "9C", "8C", "7C", "6C", "2D", "4C", "3S"},
        {"QD", "5S", "QC", "8H", "7H", "6H", "5C", "3D", "3C", "4S"},
        {"10D", "4S", "KC", "9H", "2H", "5H", "4C", "4D", "2C", "5S"},
        {"9D", "3S", "AC", "10H", "3H", "4H", "3C", "5D", "AH", "6S"},
        {"8D", "2S", "AD", "QH", "KH", "AH", "2C", "6D", "KH", "7S"},
        {"7D", "2H", "KD", "QD", "10D", "9D", "8D", "7D", "QH", "8S"},
        {"6D", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "9S"},
        {"JD", "5D", "4D", "3D", "2D", "AS", "KS", "QS", "10S", "JC"}
    };

   
    public ATABLEROCOLE(int numjugadores) {
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        cuatrocartas.setVisible(false);
        cincocartas.setVisible(false);
        seiscartas.setVisible(false);
        sietecartas.setVisible(false);

        dosjugadoresizq.setVisible(false);
        tresjugadoresizq.setVisible(false);
        cuatrojugadoresizq.setVisible(false);
        seisjugadoresizq.setVisible(false);
        ochojugadoresizq.setVisible(false);

        dosjugadoresder.setVisible(false);
        tresjugadoresder.setVisible(false);
        cuatrojugadoresder.setVisible(false);
        seisjugadoresder.setVisible(false);
        ochojugadoresder.setVisible(false);

        agregarAcciones();
        vaciarTablero();
        habilitarPaneles();

        Image Rimg = redToken.getImage();
        Image RnewImg = Rimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        redToken = new ImageIcon(RnewImg);

        Image Bimg = blueToken.getImage();
        Image BnewImg = Bimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        blueToken = new ImageIcon(BnewImg);

        Image Yimg = yellowToken.getImage();
        Image YnewImg = Yimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        yellowToken = new ImageIcon(YnewImg);

        Image Gimg = greenToken.getImage();
        Image GnewImg = Gimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        greenToken = new ImageIcon(GnewImg);

        JOptionPane.showMessageDialog(null, "Turno de: " + turnoJugador);
    }
    //resize las imagenes de las cartas de las barajas

    public void vaciarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroIconos[i][j] = "";
            }
        }
        tableroIconos[0][0] = "null";
        tableroIconos[9][0] = "null";
        tableroIconos[9][9] = "null";
        tableroIconos[0][9] = "null";
    }

    public void habilitarPaneles() {
        switch (numjugadores) {
            case 2:
                dosjugadoresizq.setVisible(true);
                dosjugadoresder.setVisible(true);
                sietecartas.setVisible(true);
                break;
            case 3:
                tresjugadoresizq.setVisible(true);
                tresjugadoresder.setVisible(true);
                seiscartas.setVisible(true);
                break;
            case 4:
                cuatrojugadoresizq.setVisible(true);
                cuatrojugadoresder.setVisible(true);
                sietecartas.setVisible(true);
                break;
            case 6:
                seisjugadoresizq.setVisible(true);
                seisjugadoresder.setVisible(true);
                cincocartas.setVisible(true);
                break;
            case 8:
                ochojugadoresizq.setVisible(true);
                ochojugadoresder.setVisible(true);
                cuatrocartas.setVisible(true);

        }
    }

    public boolean chequearIconoVacio(String pos) {
        int x = Integer.parseInt(Character.toString(pos.charAt(0)));
        int y = Integer.parseInt(Character.toString(pos.charAt(1)));

        return tableroIconos[x][y].equals("");

    }

    public boolean chequearCartaEspecial(String pos) {
        return true;
    }

    public boolean chequearGane(String currentColor) {
        int rowCount = 0;
        int diagCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (checkConsecutive(tableroIconos, i, j, 0, 1, currentColor, 5)) {
                    rowCount++;
                    if (rowCount >= 2) {
                        return true;
                    }
                } else {
                    rowCount = 0;
                }

                if (checkConsecutive(tableroIconos, i, j, 1, 1, currentColor, 5)
                        || checkConsecutive(tableroIconos, i, j, 1, -1, currentColor, 5)) {
                    diagCount++;
                    if (diagCount >= 2) {
                        return true;
                    }
                } else {
                    diagCount = 0;
                }
            }
        }

        return false;
    }

    private boolean checkConsecutive(String[][] board, int x, int y, int dx, int dy, String targetColor, int targetCount) {
        int count = 1;

        while (x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y].equals(targetColor)) {
            count++;
            if (count >= targetCount) {
                return true;
            }
            x += dx;
            y += dy;
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = Integer.valueOf(Character.toString(getCords(e.getSource()).charAt(0)));
        int y = Integer.valueOf(Character.toString(getCords(e.getSource()).charAt(1)));
        posColocar = x + "" + y;

        switch (numjugadores) {
            case 2:

            case 3:

                break;

            case 4:

                System.out.println(turnoJugador);

                switch (turnoJugador) {
                    case 'a':
                        if (chequearIconoVacio(x + "" + y)) {
                            getBoton(posColocar).setIcon(redToken);
                            tableroIconos[x][y] = "r";

                            turnoJugador = 'b';
                            if (chequearGane("r") || chequearGane("b") || chequearGane("g") || chequearGane("y")) {

                                JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                System.exit(0);
                            }
                            //si se coloca una ficha se elimina la carta que se uso de la baraja y se coloca una nueva aleatoriamente
                          
                            //se borran las casillas disponibles y se desactivan todos los botones excepto los que ya tienen una ficha, ya hay un metodo que verifica que no se coloque otra ficha donde ya hay una asi que no afecta que quede el boton activo

                            //se desaparece la baraja por un momento mientras el siguiente jugador comienza su turno para que nadie le vea sus cartas
                            layeredpanecartas.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Turno de: " + turnoJugador);
                           //se coloco una ficha, no se vuelve a llamar a set timer de nuevo dentro de si misma, solamente se desactivara para luego volverlo a activar
                            ; //iniciar timer
                            layeredpanecartas.setVisible(true); //se muestra la baraja de nuevo una vez que el siguiente jugador esta listo
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya hay una fcha puesta");
                        }

                        break;

                    case 'b':
                        if (chequearIconoVacio(x + "" + y)) {
                            getBoton(posColocar).setIcon(blueToken);
                            tableroIconos[x][y] = "b";

                            turnoJugador = 'c';
                            if (chequearGane("r") || chequearGane("b") || chequearGane("g") || chequearGane("y")) {

                                JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                System.exit(0);
                            }
                           

                            layeredpanecartas.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Turno de: " + turnoJugador);
                           

                            layeredpanecartas.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya hay una fcha puesta");
                        }
                        break;

                    case 'c':
                        if (chequearIconoVacio(x + "" + y)) {
                            getBoton(posColocar).setIcon(greenToken);
                            tableroIconos[x][y] = "g";

                            turnoJugador = 'd';
                            if (chequearGane("r") || chequearGane("b") || chequearGane("g") || chequearGane("y")) {

                                JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                System.exit(0);
                            }
                           

                            layeredpanecartas.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Turno de: " + turnoJugador);
                          

                            layeredpanecartas.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya hay una fcha puesta");
                        }
                        break;

                    case 'd':
                        if (chequearIconoVacio(x + "" + y)) {
                            getBoton(posColocar).setIcon(yellowToken);
                            tableroIconos[x][y] = "y";

                            turnoJugador = 'a';
                            if (chequearGane("r") || chequearGane("b") || chequearGane("g") || chequearGane("y")) {

                                JOptionPane.showMessageDialog(this, "¡Terminó el juego!");
                                System.exit(0);
                            }
                           
                            layeredpanecartas.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Turno de: " + turnoJugador);
                          
                            layeredpanecartas.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya hay una fcha puesta");
                        }
                        break;

                }
                break;

            case 6:

                break;

            case 8:

                break;
        }

    }

    //para conseguir las coordenadas de los botones despues de presionarlos y usarlas en el array
    public String getCords(Object boton) {
        if (boton == boton00) {
            return "00";
        } else if (boton == boton01) {
            return "01";
        } else if (boton == boton02) {
            return "02";
        } else if (boton == boton03) {
            return "03";
        } else if (boton == boton04) {
            return "04";
        } else if (boton == boton05) {
            return "05";
        } else if (boton == boton06) {
            return "06";
        } else if (boton == boton07) {
            return "07";
        } else if (boton == boton08) {
            return "08";
        } else if (boton == boton09) {
            return "09";
        } else if (boton == boton10) {
            return "10";
        } else if (boton == boton11) {
            return "11";
        } else if (boton == boton12) {
            return "12";
        } else if (boton == boton13) {
            return "13";
        } else if (boton == boton14) {
            return "14";
        } else if (boton == boton15) {
            return "15";
        } else if (boton == boton16) {
            return "16";
        } else if (boton == boton17) {
            return "17";
        } else if (boton == boton18) {
            return "18";
        } else if (boton == boton19) {
            return "19";
        } else if (boton == boton20) {
            return "20";
        } else if (boton == boton21) {
            return "21";
        } else if (boton == boton22) {
            return "22";
        } else if (boton == boton23) {
            return "23";
        } else if (boton == boton24) {
            return "24";
        } else if (boton == boton25) {
            return "25";
        } else if (boton == boton26) {
            return "26";
        } else if (boton == boton27) {
            return "27";
        } else if (boton == boton28) {
            return "28";
        } else if (boton == boton29) {
            return "29";
        } else if (boton == boton30) {
            return "30";
        } else if (boton == boton31) {
            return "31";
        } else if (boton == boton32) {
            return "32";
        } else if (boton == boton33) {
            return "33";
        } else if (boton == boton34) {
            return "34";
        } else if (boton == boton35) {
            return "35";
        } else if (boton == boton36) {
            return "36";
        } else if (boton == boton37) {
            return "37";
        } else if (boton == boton38) {
            return "38";
        } else if (boton == boton39) {
            return "39";
        } else if (boton == boton40) {
            return "40";
        } else if (boton == boton41) {
            return "41";
        } else if (boton == boton42) {
            return "42";
        } else if (boton == boton43) {
            return "43";
        } else if (boton == boton44) {
            return "44";
        } else if (boton == boton45) {
            return "45";
        } else if (boton == boton46) {
            return "46";
        } else if (boton == boton47) {
            return "47";
        } else if (boton == boton48) {
            return "48";
        } else if (boton == boton49) {
            return "49";
        } else if (boton == boton50) {
            return "50";
        } else if (boton == boton51) {
            return "51";
        } else if (boton == boton52) {
            return "52";
        } else if (boton == boton53) {
            return "53";
        } else if (boton == boton54) {
            return "54";
        } else if (boton == boton55) {
            return "55";
        } else if (boton == boton56) {
            return "56";
        } else if (boton == boton57) {
            return "57";
        } else if (boton == boton58) {
            return "58";
        } else if (boton == boton59) {
            return "59";
        } else if (boton == boton60) {
            return "60";
        } else if (boton == boton61) {
            return "61";
        } else if (boton == boton62) {
            return "62";
        } else if (boton == boton63) {
            return "63";
        } else if (boton == boton64) {
            return "64";
        } else if (boton == boton65) {
            return "65";
        } else if (boton == boton66) {
            return "66";
        } else if (boton == boton67) {
            return "67";
        } else if (boton == boton68) {
            return "68";
        } else if (boton == boton69) {
            return "69";
        } else if (boton == boton70) {
            return "70";
        } else if (boton == boton71) {
            return "71";
        } else if (boton == boton72) {
            return "72";
        } else if (boton == boton73) {
            return "73";
        } else if (boton == boton74) {
            return "74";
        } else if (boton == boton75) {
            return "75";
        } else if (boton == boton76) {
            return "76";
        } else if (boton == boton77) {
            return "77";
        } else if (boton == boton78) {
            return "78";
        } else if (boton == boton79) {
            return "79";
        } else if (boton == boton80) {
            return "80";
        } else if (boton == boton81) {
            return "81";
        } else if (boton == boton82) {
            return "82";
        } else if (boton == boton83) {
            return "83";
        } else if (boton == boton84) {
            return "84";
        } else if (boton == boton85) {
            return "85";
        } else if (boton == boton86) {
            return "86";
        } else if (boton == boton87) {
            return "87";
        } else if (boton == boton88) {
            return "88";
        } else if (boton == boton89) {
            return "89";
        } else if (boton == boton90) {
            return "90";
        } else if (boton == boton91) {
            return "91";
        } else if (boton == boton92) {
            return "92";
        } else if (boton == boton93) {
            return "93";
        } else if (boton == boton94) {
            return "94";
        } else if (boton == boton95) {
            return "95";
        } else if (boton == boton96) {
            return "96";
        } else if (boton == boton97) {
            return "97";
        } else if (boton == boton98) {
            return "98";
        } else if (boton == boton99) {
            return "99";
        }
        return "";
    }

    //para conseguir el boton dependiendo de la poscion donde estoy, se utiliza para darle un icono al boton   
    public JButton getBoton(String posicion) {
        switch (posicion) {
            case "00":
                return boton00;
            case "01":
                return boton01;
            case "02":
                return boton02;
            case "03":
                return boton03;
            case "04":
                return boton04;
            case "05":
                return boton05;
            case "06":
                return boton06;
            case "07":
                return boton07;
            case "08":
                return boton08;
            case "09":
                return boton09;
            case "10":
                return boton10;
            case "11":
                return boton11;
            case "12":
                return boton12;
            case "13":
                return boton13;
            case "14":
                return boton14;
            case "15":
                return boton15;
            case "16":
                return boton16;
            case "17":
                return boton17;
            case "18":
                return boton18;
            case "19":
                return boton19;
            case "20":
                return boton20;
            case "21":
                return boton21;
            case "22":
                return boton22;
            case "23":
                return boton23;
            case "24":
                return boton24;
            case "25":
                return boton25;
            case "26":
                return boton26;
            case "27":
                return boton27;
            case "28":
                return boton28;
            case "29":
                return boton29;
            case "30":
                return boton30;
            case "31":
                return boton31;
            case "32":
                return boton32;
            case "33":
                return boton33;
            case "34":
                return boton34;
            case "35":
                return boton35;
            case "36":
                return boton36;
            case "37":
                return boton37;
            case "38":
                return boton38;
            case "39":
                return boton39;
            case "40":
                return boton40;
            case "41":
                return boton41;
            case "42":
                return boton42;
            case "43":
                return boton43;
            case "44":
                return boton44;
            case "45":
                return boton45;
            case "46":
                return boton46;
            case "47":
                return boton47;
            case "48":
                return boton48;
            case "49":
                return boton49;
            case "50":
                return boton50;
            case "51":
                return boton51;
            case "52":
                return boton52;
            case "53":
                return boton53;
            case "54":
                return boton54;
            case "55":
                return boton55;
            case "56":
                return boton56;
            case "57":
                return boton57;
            case "58":
                return boton58;
            case "59":
                return boton59;
            case "60":
                return boton60;
            case "61":
                return boton61;
            case "62":
                return boton62;
            case "63":
                return boton63;
            case "64":
                return boton64;
            case "65":
                return boton65;
            case "66":
                return boton66;
            case "67":
                return boton67;
            case "68":
                return boton68;
            case "69":
                return boton69;
            case "70":
                return boton70;
            case "71":
                return boton71;
            case "72":
                return boton72;
            case "73":
                return boton73;
            case "74":
                return boton74;
            case "75":
                return boton75;
            case "76":
                return boton76;
            case "77":
                return boton77;
            case "78":
                return boton78;
            case "79":
                return boton79;
            case "80":
                return boton80;
            case "81":
                return boton81;
            case "82":
                return boton82;
            case "83":
                return boton83;
            case "84":
                return boton84;
            case "85":
                return boton85;
            case "86":
                return boton86;
            case "87":
                return boton87;
            case "88":
                return boton88;
            case "89":
                return boton89;
            case "90":
                return boton90;
            case "91":
                return boton91;
            case "92":
                return boton92;
            case "93":
                return boton93;
            case "94":
                return boton94;
            case "95":
                return boton95;
            case "96":
                return boton96;
            case "97":
                return boton97;
            case "98":
                return boton98;
            case "99":
                return boton99;
            default:
                return null;
        }
    }

    void agregarAcciones() {
        boton00.addActionListener(this);
        boton01.addActionListener(this);
        boton02.addActionListener(this);
        boton03.addActionListener(this);
        boton04.addActionListener(this);
        boton05.addActionListener(this);
        boton06.addActionListener(this);
        boton07.addActionListener(this);
        boton08.addActionListener(this);
        boton09.addActionListener(this);
        boton10.addActionListener(this);
        boton11.addActionListener(this);
        boton12.addActionListener(this);
        boton13.addActionListener(this);
        boton14.addActionListener(this);
        boton15.addActionListener(this);
        boton16.addActionListener(this);
        boton17.addActionListener(this);
        boton18.addActionListener(this);
        boton19.addActionListener(this);
        boton20.addActionListener(this);
        boton21.addActionListener(this);
        boton22.addActionListener(this);
        boton23.addActionListener(this);
        boton24.addActionListener(this);
        boton25.addActionListener(this);
        boton26.addActionListener(this);
        boton27.addActionListener(this);
        boton28.addActionListener(this);
        boton29.addActionListener(this);
        boton30.addActionListener(this);
        boton31.addActionListener(this);
        boton32.addActionListener(this);
        boton33.addActionListener(this);
        boton34.addActionListener(this);
        boton35.addActionListener(this);
        boton36.addActionListener(this);
        boton37.addActionListener(this);
        boton38.addActionListener(this);
        boton39.addActionListener(this);
        boton40.addActionListener(this);
        boton41.addActionListener(this);
        boton42.addActionListener(this);
        boton43.addActionListener(this);
        boton44.addActionListener(this);
        boton45.addActionListener(this);
        boton46.addActionListener(this);
        boton47.addActionListener(this);
        boton48.addActionListener(this);
        boton49.addActionListener(this);
        boton50.addActionListener(this);
        boton51.addActionListener(this);
        boton52.addActionListener(this);
        boton53.addActionListener(this);
        boton54.addActionListener(this);
        boton55.addActionListener(this);
        boton56.addActionListener(this);
        boton57.addActionListener(this);
        boton58.addActionListener(this);
        boton59.addActionListener(this);
        boton60.addActionListener(this);
        boton61.addActionListener(this);
        boton62.addActionListener(this);
        boton63.addActionListener(this);
        boton64.addActionListener(this);
        boton65.addActionListener(this);
        boton66.addActionListener(this);
        boton67.addActionListener(this);
        boton68.addActionListener(this);
        boton69.addActionListener(this);
        boton70.addActionListener(this);
        boton71.addActionListener(this);
        boton72.addActionListener(this);
        boton73.addActionListener(this);
        boton74.addActionListener(this);
        boton75.addActionListener(this);
        boton76.addActionListener(this);
        boton77.addActionListener(this);
        boton78.addActionListener(this);
        boton79.addActionListener(this);
        boton80.addActionListener(this);
        boton81.addActionListener(this);
        boton82.addActionListener(this);
        boton83.addActionListener(this);
        boton84.addActionListener(this);
        boton85.addActionListener(this);
        boton86.addActionListener(this);
        boton87.addActionListener(this);
        boton88.addActionListener(this);
        boton89.addActionListener(this);
        boton90.addActionListener(this);
        boton91.addActionListener(this);
        boton92.addActionListener(this);
        boton93.addActionListener(this);
        boton94.addActionListener(this);
        boton95.addActionListener(this);
        boton96.addActionListener(this);
        boton97.addActionListener(this);
        boton98.addActionListener(this);
        boton99.addActionListener(this);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATABLEROCOLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATABLEROCOLE(numjugadores).setVisible(true);
            }
        });
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredpanecartas = new javax.swing.JLayeredPane();
        cincocartas = new javax.swing.JPanel();
        cincocartasboton1 = new javax.swing.JButton();
        cincocartasboton2 = new javax.swing.JButton();
        cincocartasboton3 = new javax.swing.JButton();
        cincocartasboton4 = new javax.swing.JButton();
        cincocartasboton5 = new javax.swing.JButton();
        cuatrocartas = new javax.swing.JPanel();
        cuatrocartasboton1 = new javax.swing.JButton();
        cuatrocartasboton2 = new javax.swing.JButton();
        cuatrocartasboton3 = new javax.swing.JButton();
        cuatrocartasboton4 = new javax.swing.JButton();
        sietecartas = new javax.swing.JPanel();
        sietecartasboton1 = new javax.swing.JButton();
        sietecartasboton2 = new javax.swing.JButton();
        sietecartasboton3 = new javax.swing.JButton();
        sietecartasboton4 = new javax.swing.JButton();
        sietecartasboton5 = new javax.swing.JButton();
        sietecartasboton6 = new javax.swing.JButton();
        sietecartasboton7 = new javax.swing.JButton();
        seiscartas = new javax.swing.JPanel();
        seiscartasboton1 = new javax.swing.JButton();
        seiscartasboton2 = new javax.swing.JButton();
        seiscartasboton3 = new javax.swing.JButton();
        seiscartasboton4 = new javax.swing.JButton();
        seiscartasboton5 = new javax.swing.JButton();
        seiscartasboton6 = new javax.swing.JButton();
        TABLERO = new javax.swing.JLayeredPane();
        boton00 = new javax.swing.JButton();
        boton01 = new javax.swing.JButton();
        boton02 = new javax.swing.JButton();
        boton04 = new javax.swing.JButton();
        boton03 = new javax.swing.JButton();
        boton05 = new javax.swing.JButton();
        boton06 = new javax.swing.JButton();
        boton07 = new javax.swing.JButton();
        boton08 = new javax.swing.JButton();
        boton09 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton13 = new javax.swing.JButton();
        boton14 = new javax.swing.JButton();
        boton15 = new javax.swing.JButton();
        boton16 = new javax.swing.JButton();
        boton17 = new javax.swing.JButton();
        boton18 = new javax.swing.JButton();
        boton19 = new javax.swing.JButton();
        boton20 = new javax.swing.JButton();
        boton21 = new javax.swing.JButton();
        boton22 = new javax.swing.JButton();
        boton23 = new javax.swing.JButton();
        boton24 = new javax.swing.JButton();
        boton25 = new javax.swing.JButton();
        boton26 = new javax.swing.JButton();
        boton27 = new javax.swing.JButton();
        boton28 = new javax.swing.JButton();
        boton29 = new javax.swing.JButton();
        boton30 = new javax.swing.JButton();
        boton31 = new javax.swing.JButton();
        boton32 = new javax.swing.JButton();
        boton33 = new javax.swing.JButton();
        boton34 = new javax.swing.JButton();
        boton35 = new javax.swing.JButton();
        boton36 = new javax.swing.JButton();
        boton37 = new javax.swing.JButton();
        boton38 = new javax.swing.JButton();
        boton39 = new javax.swing.JButton();
        boton40 = new javax.swing.JButton();
        boton41 = new javax.swing.JButton();
        boton42 = new javax.swing.JButton();
        boton43 = new javax.swing.JButton();
        boton44 = new javax.swing.JButton();
        boton45 = new javax.swing.JButton();
        boton46 = new javax.swing.JButton();
        boton47 = new javax.swing.JButton();
        boton48 = new javax.swing.JButton();
        boton49 = new javax.swing.JButton();
        boton50 = new javax.swing.JButton();
        boton51 = new javax.swing.JButton();
        boton52 = new javax.swing.JButton();
        boton53 = new javax.swing.JButton();
        boton54 = new javax.swing.JButton();
        boton55 = new javax.swing.JButton();
        boton56 = new javax.swing.JButton();
        boton57 = new javax.swing.JButton();
        boton58 = new javax.swing.JButton();
        boton59 = new javax.swing.JButton();
        boton60 = new javax.swing.JButton();
        boton61 = new javax.swing.JButton();
        boton62 = new javax.swing.JButton();
        boton63 = new javax.swing.JButton();
        boton64 = new javax.swing.JButton();
        boton65 = new javax.swing.JButton();
        boton66 = new javax.swing.JButton();
        boton67 = new javax.swing.JButton();
        boton68 = new javax.swing.JButton();
        boton69 = new javax.swing.JButton();
        boton70 = new javax.swing.JButton();
        boton71 = new javax.swing.JButton();
        boton72 = new javax.swing.JButton();
        boton73 = new javax.swing.JButton();
        boton74 = new javax.swing.JButton();
        boton75 = new javax.swing.JButton();
        boton76 = new javax.swing.JButton();
        boton77 = new javax.swing.JButton();
        boton78 = new javax.swing.JButton();
        boton79 = new javax.swing.JButton();
        boton80 = new javax.swing.JButton();
        boton81 = new javax.swing.JButton();
        boton82 = new javax.swing.JButton();
        boton83 = new javax.swing.JButton();
        boton84 = new javax.swing.JButton();
        boton85 = new javax.swing.JButton();
        boton86 = new javax.swing.JButton();
        boton87 = new javax.swing.JButton();
        boton88 = new javax.swing.JButton();
        boton89 = new javax.swing.JButton();
        boton90 = new javax.swing.JButton();
        boton91 = new javax.swing.JButton();
        boton92 = new javax.swing.JButton();
        boton93 = new javax.swing.JButton();
        boton94 = new javax.swing.JButton();
        boton95 = new javax.swing.JButton();
        boton96 = new javax.swing.JButton();
        boton97 = new javax.swing.JButton();
        boton98 = new javax.swing.JButton();
        boton99 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        layeredpaneizq = new javax.swing.JLayeredPane();
        dosjugadoresizq = new javax.swing.JPanel();
        tresjugadoresizq = new javax.swing.JPanel();
        cuatrojugadoresizq = new javax.swing.JPanel();
        seisjugadoresizq = new javax.swing.JPanel();
        ochojugadoresizq = new javax.swing.JPanel();
        layeredpaneder = new javax.swing.JLayeredPane();
        dosjugadoresder = new javax.swing.JPanel();
        tresjugadoresder = new javax.swing.JPanel();
        cuatrojugadoresder = new javax.swing.JPanel();
        seisjugadoresder = new javax.swing.JPanel();
        ochojugadoresder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1190, 802));

        layeredpanecartas.setPreferredSize(new java.awt.Dimension(700, 202));

        cincocartas.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout cincocartasLayout = new javax.swing.GroupLayout(cincocartas);
        cincocartas.setLayout(cincocartasLayout);
        cincocartasLayout.setHorizontalGroup(
            cincocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cincocartasLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(cincocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cincocartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        cincocartasLayout.setVerticalGroup(
            cincocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cincocartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cincocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cincocartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cincocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cincocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cincocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cincocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        cuatrocartas.setBackground(new java.awt.Color(0, 0, 0));

        cuatrocartasboton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatrocartasboton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cuatrocartasLayout = new javax.swing.GroupLayout(cuatrocartas);
        cuatrocartas.setLayout(cuatrocartasLayout);
        cuatrocartasLayout.setHorizontalGroup(
            cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrocartasLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(cuatrocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatrocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        cuatrocartasLayout.setVerticalGroup(
            cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuatrocartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cuatrocartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuatrocartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatrocartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        sietecartas.setBackground(new java.awt.Color(0, 0, 0));

        sietecartasboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton1ActionPerformed(evt);
            }
        });

        sietecartasboton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton2ActionPerformed(evt);
            }
        });

        sietecartasboton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton3ActionPerformed(evt);
            }
        });

        sietecartasboton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton4ActionPerformed(evt);
            }
        });

        sietecartasboton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton5ActionPerformed(evt);
            }
        });

        sietecartasboton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton6ActionPerformed(evt);
            }
        });

        sietecartasboton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sietecartasboton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sietecartasLayout = new javax.swing.GroupLayout(sietecartas);
        sietecartas.setLayout(sietecartasLayout);
        sietecartasLayout.setHorizontalGroup(
            sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sietecartasLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(sietecartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sietecartasboton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        sietecartasLayout.setVerticalGroup(
            sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sietecartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sietecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sietecartasboton7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sietecartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        seiscartas.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout seiscartasLayout = new javax.swing.GroupLayout(seiscartas);
        seiscartas.setLayout(seiscartasLayout);
        seiscartasLayout.setHorizontalGroup(
            seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seiscartasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seiscartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seiscartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        seiscartasLayout.setVerticalGroup(
            seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seiscartasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seiscartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seiscartasboton6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seiscartasboton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seiscartasboton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seiscartasboton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seiscartasboton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seiscartasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        layeredpanecartas.setLayer(cincocartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(cuatrocartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(sietecartas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredpanecartas.setLayer(seiscartas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredpanecartasLayout = new javax.swing.GroupLayout(layeredpanecartas);
        layeredpanecartas.setLayout(layeredpanecartasLayout);
        layeredpanecartasLayout.setHorizontalGroup(
            layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredpanecartasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cuatrocartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(cincocartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seiscartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(sietecartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layeredpanecartasLayout.setVerticalGroup(
            layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cuatrocartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cincocartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seiscartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layeredpanecartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredpanecartasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sietecartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        TABLERO.setMinimumSize(new java.awt.Dimension(700, 600));
        TABLERO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton00.setBorder(null);
        boton00.setBorderPainted(false);
        boton00.setContentAreaFilled(false);
        boton00.setEnabled(false);
        TABLERO.add(boton00, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 542, 51, 53));

        boton01.setBorder(null);
        boton01.setBorderPainted(false);
        boton01.setContentAreaFilled(false);
        TABLERO.add(boton01, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 542, 51, 53));

        boton02.setBorder(null);
        boton02.setBorderPainted(false);
        boton02.setContentAreaFilled(false);
        TABLERO.add(boton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 542, 51, 53));

        boton04.setBorder(null);
        boton04.setBorderPainted(false);
        boton04.setContentAreaFilled(false);
        TABLERO.add(boton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 542, 51, 53));

        boton03.setBorder(null);
        boton03.setBorderPainted(false);
        boton03.setContentAreaFilled(false);
        TABLERO.add(boton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 542, 51, 53));

        boton05.setBorder(null);
        boton05.setBorderPainted(false);
        boton05.setContentAreaFilled(false);
        TABLERO.add(boton05, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 542, 51, 53));

        boton06.setBorder(null);
        boton06.setBorderPainted(false);
        boton06.setContentAreaFilled(false);
        TABLERO.add(boton06, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 542, 51, 53));

        boton07.setBorder(null);
        boton07.setBorderPainted(false);
        boton07.setContentAreaFilled(false);
        TABLERO.add(boton07, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 542, 51, 53));

        boton08.setBorder(null);
        boton08.setBorderPainted(false);
        boton08.setContentAreaFilled(false);
        TABLERO.add(boton08, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 542, 51, 53));

        boton09.setBorder(null);
        boton09.setBorderPainted(false);
        boton09.setContentAreaFilled(false);
        boton09.setEnabled(false);
        TABLERO.add(boton09, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 542, 51, 53));

        boton10.setBorder(null);
        boton10.setBorderPainted(false);
        boton10.setContentAreaFilled(false);
        TABLERO.add(boton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 483, 51, 53));

        boton11.setBorder(null);
        boton11.setBorderPainted(false);
        boton11.setContentAreaFilled(false);
        TABLERO.add(boton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 483, 51, 53));

        boton12.setBorder(null);
        boton12.setBorderPainted(false);
        boton12.setContentAreaFilled(false);
        TABLERO.add(boton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 483, 51, 53));

        boton13.setBorder(null);
        boton13.setBorderPainted(false);
        boton13.setContentAreaFilled(false);
        TABLERO.add(boton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 483, 51, 53));

        boton14.setBorder(null);
        boton14.setBorderPainted(false);
        boton14.setContentAreaFilled(false);
        TABLERO.add(boton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 483, 51, 53));

        boton15.setBorder(null);
        boton15.setBorderPainted(false);
        boton15.setContentAreaFilled(false);
        TABLERO.add(boton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 483, 51, 53));

        boton16.setBorder(null);
        boton16.setBorderPainted(false);
        boton16.setContentAreaFilled(false);
        TABLERO.add(boton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 483, 51, 53));

        boton17.setBorder(null);
        boton17.setBorderPainted(false);
        boton17.setContentAreaFilled(false);
        TABLERO.add(boton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 483, 51, 53));

        boton18.setBorder(null);
        boton18.setBorderPainted(false);
        boton18.setContentAreaFilled(false);
        TABLERO.add(boton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 483, 51, 53));

        boton19.setBorder(null);
        boton19.setBorderPainted(false);
        boton19.setContentAreaFilled(false);
        TABLERO.add(boton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 483, 51, 53));

        boton20.setBorder(null);
        boton20.setBorderPainted(false);
        boton20.setContentAreaFilled(false);
        TABLERO.add(boton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 423, 51, 53));

        boton21.setBorder(null);
        boton21.setBorderPainted(false);
        boton21.setContentAreaFilled(false);
        TABLERO.add(boton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 423, 51, 53));

        boton22.setBorder(null);
        boton22.setBorderPainted(false);
        boton22.setContentAreaFilled(false);
        TABLERO.add(boton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 423, 51, 53));

        boton23.setBorder(null);
        boton23.setBorderPainted(false);
        boton23.setContentAreaFilled(false);
        TABLERO.add(boton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 423, 51, 53));

        boton24.setBorder(null);
        boton24.setBorderPainted(false);
        boton24.setContentAreaFilled(false);
        TABLERO.add(boton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 423, 51, 53));

        boton25.setBorder(null);
        boton25.setBorderPainted(false);
        boton25.setContentAreaFilled(false);
        TABLERO.add(boton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 423, 51, 53));

        boton26.setBorder(null);
        boton26.setBorderPainted(false);
        boton26.setContentAreaFilled(false);
        TABLERO.add(boton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 423, 51, 53));

        boton27.setBorder(null);
        boton27.setBorderPainted(false);
        boton27.setContentAreaFilled(false);
        TABLERO.add(boton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 423, 51, 53));

        boton28.setBorder(null);
        boton28.setBorderPainted(false);
        boton28.setContentAreaFilled(false);
        TABLERO.add(boton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 423, 51, 53));

        boton29.setBorder(null);
        boton29.setBorderPainted(false);
        boton29.setContentAreaFilled(false);
        TABLERO.add(boton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 423, 51, 53));

        boton30.setBorder(null);
        boton30.setBorderPainted(false);
        boton30.setContentAreaFilled(false);
        TABLERO.add(boton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 364, 51, 53));

        boton31.setBorder(null);
        boton31.setBorderPainted(false);
        boton31.setContentAreaFilled(false);
        TABLERO.add(boton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 364, 51, 53));

        boton32.setBorder(null);
        boton32.setBorderPainted(false);
        boton32.setContentAreaFilled(false);
        TABLERO.add(boton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 364, 51, 53));

        boton33.setBorder(null);
        boton33.setBorderPainted(false);
        boton33.setContentAreaFilled(false);
        TABLERO.add(boton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 364, 51, 53));

        boton34.setBorder(null);
        boton34.setBorderPainted(false);
        boton34.setContentAreaFilled(false);
        TABLERO.add(boton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 364, 51, 53));

        boton35.setBorder(null);
        boton35.setBorderPainted(false);
        boton35.setContentAreaFilled(false);
        TABLERO.add(boton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 364, 51, 53));

        boton36.setBorder(null);
        boton36.setBorderPainted(false);
        boton36.setContentAreaFilled(false);
        TABLERO.add(boton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 364, 51, 53));

        boton37.setBorder(null);
        boton37.setBorderPainted(false);
        boton37.setContentAreaFilled(false);
        TABLERO.add(boton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 364, 51, 53));

        boton38.setBorder(null);
        boton38.setBorderPainted(false);
        boton38.setContentAreaFilled(false);
        TABLERO.add(boton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 364, 51, 53));

        boton39.setBorder(null);
        boton39.setBorderPainted(false);
        boton39.setContentAreaFilled(false);
        TABLERO.add(boton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 364, 51, 53));

        boton40.setBorder(null);
        boton40.setBorderPainted(false);
        boton40.setContentAreaFilled(false);
        TABLERO.add(boton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 305, 51, 53));

        boton41.setBorder(null);
        boton41.setBorderPainted(false);
        boton41.setContentAreaFilled(false);
        TABLERO.add(boton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 305, 51, 53));

        boton42.setBorder(null);
        boton42.setBorderPainted(false);
        boton42.setContentAreaFilled(false);
        TABLERO.add(boton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 305, 51, 53));

        boton43.setBorder(null);
        boton43.setBorderPainted(false);
        boton43.setContentAreaFilled(false);
        TABLERO.add(boton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 305, 51, 53));

        boton44.setBorder(null);
        boton44.setBorderPainted(false);
        boton44.setContentAreaFilled(false);
        TABLERO.add(boton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 305, 51, 53));

        boton45.setBorder(null);
        boton45.setBorderPainted(false);
        boton45.setContentAreaFilled(false);
        TABLERO.add(boton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 305, 51, 53));

        boton46.setBorder(null);
        boton46.setBorderPainted(false);
        boton46.setContentAreaFilled(false);
        TABLERO.add(boton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 305, 51, 53));

        boton47.setBorder(null);
        boton47.setBorderPainted(false);
        boton47.setContentAreaFilled(false);
        TABLERO.add(boton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 305, 51, 53));

        boton48.setBorder(null);
        boton48.setBorderPainted(false);
        boton48.setContentAreaFilled(false);
        TABLERO.add(boton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 305, 51, 53));

        boton49.setBorder(null);
        boton49.setBorderPainted(false);
        boton49.setContentAreaFilled(false);
        TABLERO.add(boton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 305, 51, 53));

        boton50.setBorder(null);
        boton50.setBorderPainted(false);
        boton50.setContentAreaFilled(false);
        TABLERO.add(boton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 245, 51, 53));

        boton51.setBorder(null);
        boton51.setBorderPainted(false);
        boton51.setContentAreaFilled(false);
        TABLERO.add(boton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 245, 51, 53));

        boton52.setBorder(null);
        boton52.setBorderPainted(false);
        boton52.setContentAreaFilled(false);
        TABLERO.add(boton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 245, 51, 53));

        boton53.setBorder(null);
        boton53.setBorderPainted(false);
        boton53.setContentAreaFilled(false);
        TABLERO.add(boton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 245, 51, 53));

        boton54.setBorder(null);
        boton54.setBorderPainted(false);
        boton54.setContentAreaFilled(false);
        TABLERO.add(boton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 245, 51, 53));

        boton55.setBorder(null);
        boton55.setBorderPainted(false);
        boton55.setContentAreaFilled(false);
        TABLERO.add(boton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 245, 51, 53));

        boton56.setBorder(null);
        boton56.setBorderPainted(false);
        boton56.setContentAreaFilled(false);
        TABLERO.add(boton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 245, 51, 53));

        boton57.setBorder(null);
        boton57.setBorderPainted(false);
        boton57.setContentAreaFilled(false);
        TABLERO.add(boton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 245, 51, 53));

        boton58.setBorder(null);
        boton58.setBorderPainted(false);
        boton58.setContentAreaFilled(false);
        TABLERO.add(boton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 245, 51, 53));

        boton59.setBorder(null);
        boton59.setBorderPainted(false);
        boton59.setContentAreaFilled(false);
        TABLERO.add(boton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 245, 51, 53));

        boton60.setBorder(null);
        boton60.setBorderPainted(false);
        boton60.setContentAreaFilled(false);
        TABLERO.add(boton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 185, 51, 53));

        boton61.setBorder(null);
        boton61.setBorderPainted(false);
        boton61.setContentAreaFilled(false);
        TABLERO.add(boton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 185, 51, 53));

        boton62.setBorder(null);
        boton62.setBorderPainted(false);
        boton62.setContentAreaFilled(false);
        TABLERO.add(boton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 185, 51, 53));

        boton63.setBorder(null);
        boton63.setBorderPainted(false);
        boton63.setContentAreaFilled(false);
        TABLERO.add(boton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 185, 51, 53));

        boton64.setBorder(null);
        boton64.setBorderPainted(false);
        boton64.setContentAreaFilled(false);
        TABLERO.add(boton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 185, 51, 53));

        boton65.setBorder(null);
        boton65.setBorderPainted(false);
        boton65.setContentAreaFilled(false);
        TABLERO.add(boton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 185, 51, 53));

        boton66.setBorder(null);
        boton66.setBorderPainted(false);
        boton66.setContentAreaFilled(false);
        TABLERO.add(boton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 185, 51, 53));

        boton67.setBorder(null);
        boton67.setBorderPainted(false);
        boton67.setContentAreaFilled(false);
        TABLERO.add(boton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 185, 51, 53));

        boton68.setBorder(null);
        boton68.setBorderPainted(false);
        boton68.setContentAreaFilled(false);
        TABLERO.add(boton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 185, 51, 53));

        boton69.setBorder(null);
        boton69.setBorderPainted(false);
        boton69.setContentAreaFilled(false);
        TABLERO.add(boton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 185, 51, 53));

        boton70.setBorder(null);
        boton70.setBorderPainted(false);
        boton70.setContentAreaFilled(false);
        TABLERO.add(boton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, 51, 53));

        boton71.setBorder(null);
        boton71.setBorderPainted(false);
        boton71.setContentAreaFilled(false);
        TABLERO.add(boton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 125, 51, 53));

        boton72.setBorder(null);
        boton72.setBorderPainted(false);
        boton72.setContentAreaFilled(false);
        TABLERO.add(boton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 125, 51, 53));

        boton73.setBorder(null);
        boton73.setBorderPainted(false);
        boton73.setContentAreaFilled(false);
        TABLERO.add(boton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 125, 51, 53));

        boton74.setBorder(null);
        boton74.setBorderPainted(false);
        boton74.setContentAreaFilled(false);
        TABLERO.add(boton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 125, 51, 53));

        boton75.setBorder(null);
        boton75.setBorderPainted(false);
        boton75.setContentAreaFilled(false);
        TABLERO.add(boton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 125, 51, 53));

        boton76.setBorder(null);
        boton76.setBorderPainted(false);
        boton76.setContentAreaFilled(false);
        TABLERO.add(boton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 125, 51, 53));

        boton77.setBorder(null);
        boton77.setBorderPainted(false);
        boton77.setContentAreaFilled(false);
        TABLERO.add(boton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 125, 51, 53));

        boton78.setBorder(null);
        boton78.setBorderPainted(false);
        boton78.setContentAreaFilled(false);
        TABLERO.add(boton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 125, 51, 53));

        boton79.setBorder(null);
        boton79.setBorderPainted(false);
        boton79.setContentAreaFilled(false);
        TABLERO.add(boton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 125, 51, 53));

        boton80.setBorder(null);
        boton80.setBorderPainted(false);
        boton80.setContentAreaFilled(false);
        TABLERO.add(boton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 51, 53));

        boton81.setBorder(null);
        boton81.setBorderPainted(false);
        boton81.setContentAreaFilled(false);
        TABLERO.add(boton81, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 51, 53));

        boton82.setBorder(null);
        boton82.setBorderPainted(false);
        boton82.setContentAreaFilled(false);
        TABLERO.add(boton82, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 65, 51, 53));

        boton83.setBorder(null);
        boton83.setBorderPainted(false);
        boton83.setContentAreaFilled(false);
        TABLERO.add(boton83, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 65, 51, 53));

        boton84.setBorder(null);
        boton84.setBorderPainted(false);
        boton84.setContentAreaFilled(false);
        TABLERO.add(boton84, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 65, 51, 53));

        boton85.setBorder(null);
        boton85.setBorderPainted(false);
        boton85.setContentAreaFilled(false);
        TABLERO.add(boton85, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 65, 51, 53));

        boton86.setBorder(null);
        boton86.setBorderPainted(false);
        boton86.setContentAreaFilled(false);
        TABLERO.add(boton86, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 65, 51, 53));

        boton87.setBorder(null);
        boton87.setBorderPainted(false);
        boton87.setContentAreaFilled(false);
        TABLERO.add(boton87, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 65, 51, 53));

        boton88.setBorder(null);
        boton88.setBorderPainted(false);
        boton88.setContentAreaFilled(false);
        TABLERO.add(boton88, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 65, 51, 53));

        boton89.setBorder(null);
        boton89.setBorderPainted(false);
        boton89.setContentAreaFilled(false);
        TABLERO.add(boton89, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 65, 51, 53));

        boton90.setBorder(null);
        boton90.setBorderPainted(false);
        boton90.setContentAreaFilled(false);
        boton90.setEnabled(false);
        TABLERO.add(boton90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 51, 53));

        boton91.setBorder(null);
        boton91.setBorderPainted(false);
        boton91.setContentAreaFilled(false);
        TABLERO.add(boton91, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 7, 51, 53));

        boton92.setBorder(null);
        boton92.setBorderPainted(false);
        boton92.setContentAreaFilled(false);
        TABLERO.add(boton92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 7, 51, 53));

        boton93.setBorder(null);
        boton93.setBorderPainted(false);
        boton93.setContentAreaFilled(false);
        TABLERO.add(boton93, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 7, 51, 53));

        boton94.setBorder(null);
        boton94.setBorderPainted(false);
        boton94.setContentAreaFilled(false);
        TABLERO.add(boton94, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 7, 51, 53));

        boton95.setBorder(null);
        boton95.setBorderPainted(false);
        boton95.setContentAreaFilled(false);
        TABLERO.add(boton95, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 7, 51, 53));

        boton96.setBorder(null);
        boton96.setBorderPainted(false);
        boton96.setContentAreaFilled(false);
        TABLERO.add(boton96, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 7, 51, 53));

        boton97.setBorder(null);
        boton97.setBorderPainted(false);
        boton97.setContentAreaFilled(false);
        TABLERO.add(boton97, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 7, 51, 53));

        boton98.setBorder(null);
        boton98.setBorderPainted(false);
        boton98.setContentAreaFilled(false);
        TABLERO.add(boton98, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 7, 51, 53));

        boton99.setBorder(null);
        boton99.setBorderPainted(false);
        boton99.setContentAreaFilled(false);
        boton99.setEnabled(false);
        TABLERO.add(boton99, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 7, 51, 53));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tokens/tableroimg.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        TABLERO.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        layeredpaneizq.setPreferredSize(new java.awt.Dimension(250, 802));
        layeredpaneizq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout dosjugadoresizqLayout = new javax.swing.GroupLayout(dosjugadoresizq);
        dosjugadoresizq.setLayout(dosjugadoresizqLayout);
        dosjugadoresizqLayout.setHorizontalGroup(
            dosjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        dosjugadoresizqLayout.setVerticalGroup(
            dosjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneizq.add(dosjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 1090));

        javax.swing.GroupLayout tresjugadoresizqLayout = new javax.swing.GroupLayout(tresjugadoresizq);
        tresjugadoresizq.setLayout(tresjugadoresizqLayout);
        tresjugadoresizqLayout.setHorizontalGroup(
            tresjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        tresjugadoresizqLayout.setVerticalGroup(
            tresjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneizq.add(tresjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 1090));

        javax.swing.GroupLayout cuatrojugadoresizqLayout = new javax.swing.GroupLayout(cuatrojugadoresizq);
        cuatrojugadoresizq.setLayout(cuatrojugadoresizqLayout);
        cuatrojugadoresizqLayout.setHorizontalGroup(
            cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        cuatrojugadoresizqLayout.setVerticalGroup(
            cuatrojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneizq.add(cuatrojugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 1090));

        javax.swing.GroupLayout seisjugadoresizqLayout = new javax.swing.GroupLayout(seisjugadoresizq);
        seisjugadoresizq.setLayout(seisjugadoresizqLayout);
        seisjugadoresizqLayout.setHorizontalGroup(
            seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        seisjugadoresizqLayout.setVerticalGroup(
            seisjugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneizq.add(seisjugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 1090));

        javax.swing.GroupLayout ochojugadoresizqLayout = new javax.swing.GroupLayout(ochojugadoresizq);
        ochojugadoresizq.setLayout(ochojugadoresizqLayout);
        ochojugadoresizqLayout.setHorizontalGroup(
            ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        ochojugadoresizqLayout.setVerticalGroup(
            ochojugadoresizqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneizq.add(ochojugadoresizq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 1090));

        layeredpaneder.setPreferredSize(new java.awt.Dimension(240, 802));
        layeredpaneder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout dosjugadoresderLayout = new javax.swing.GroupLayout(dosjugadoresder);
        dosjugadoresder.setLayout(dosjugadoresderLayout);
        dosjugadoresderLayout.setHorizontalGroup(
            dosjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        dosjugadoresderLayout.setVerticalGroup(
            dosjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneder.add(dosjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1090));

        javax.swing.GroupLayout tresjugadoresderLayout = new javax.swing.GroupLayout(tresjugadoresder);
        tresjugadoresder.setLayout(tresjugadoresderLayout);
        tresjugadoresderLayout.setHorizontalGroup(
            tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        tresjugadoresderLayout.setVerticalGroup(
            tresjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneder.add(tresjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1090));

        javax.swing.GroupLayout cuatrojugadoresderLayout = new javax.swing.GroupLayout(cuatrojugadoresder);
        cuatrojugadoresder.setLayout(cuatrojugadoresderLayout);
        cuatrojugadoresderLayout.setHorizontalGroup(
            cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        cuatrojugadoresderLayout.setVerticalGroup(
            cuatrojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneder.add(cuatrojugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1090));

        javax.swing.GroupLayout seisjugadoresderLayout = new javax.swing.GroupLayout(seisjugadoresder);
        seisjugadoresder.setLayout(seisjugadoresderLayout);
        seisjugadoresderLayout.setHorizontalGroup(
            seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        seisjugadoresderLayout.setVerticalGroup(
            seisjugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneder.add(seisjugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1090));

        javax.swing.GroupLayout ochojugadoresderLayout = new javax.swing.GroupLayout(ochojugadoresder);
        ochojugadoresder.setLayout(ochojugadoresderLayout);
        ochojugadoresderLayout.setHorizontalGroup(
            ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        ochojugadoresderLayout.setVerticalGroup(
            ochojugadoresderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        layeredpaneder.add(ochojugadoresder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 1090));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layeredpaneizq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(layeredpanecartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TABLERO, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layeredpaneder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TABLERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredpanecartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(layeredpaneizq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layeredpaneder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuatrocartasboton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatrocartasboton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuatrocartasboton4ActionPerformed

    private void sietecartasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton1ActionPerformed

    }//GEN-LAST:event_sietecartasboton1ActionPerformed

    private void sietecartasboton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton2ActionPerformed

    }//GEN-LAST:event_sietecartasboton2ActionPerformed

    private void sietecartasboton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton3ActionPerformed

    }//GEN-LAST:event_sietecartasboton3ActionPerformed

    private void sietecartasboton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton4ActionPerformed

    }//GEN-LAST:event_sietecartasboton4ActionPerformed

    private void sietecartasboton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton5ActionPerformed

    }//GEN-LAST:event_sietecartasboton5ActionPerformed

    private void sietecartasboton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton6ActionPerformed

    }//GEN-LAST:event_sietecartasboton6ActionPerformed

    private void sietecartasboton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sietecartasboton7ActionPerformed

    }//GEN-LAST:event_sietecartasboton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane TABLERO;
    private javax.swing.JButton boton00;
    private javax.swing.JButton boton01;
    private javax.swing.JButton boton02;
    private javax.swing.JButton boton03;
    private javax.swing.JButton boton04;
    private javax.swing.JButton boton05;
    private javax.swing.JButton boton06;
    private javax.swing.JButton boton07;
    private javax.swing.JButton boton08;
    private javax.swing.JButton boton09;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton13;
    private javax.swing.JButton boton14;
    private javax.swing.JButton boton15;
    private javax.swing.JButton boton16;
    private javax.swing.JButton boton17;
    private javax.swing.JButton boton18;
    private javax.swing.JButton boton19;
    private javax.swing.JButton boton20;
    private javax.swing.JButton boton21;
    private javax.swing.JButton boton22;
    private javax.swing.JButton boton23;
    private javax.swing.JButton boton24;
    private javax.swing.JButton boton25;
    private javax.swing.JButton boton26;
    private javax.swing.JButton boton27;
    private javax.swing.JButton boton28;
    private javax.swing.JButton boton29;
    private javax.swing.JButton boton30;
    private javax.swing.JButton boton31;
    private javax.swing.JButton boton32;
    private javax.swing.JButton boton33;
    private javax.swing.JButton boton34;
    private javax.swing.JButton boton35;
    private javax.swing.JButton boton36;
    private javax.swing.JButton boton37;
    private javax.swing.JButton boton38;
    private javax.swing.JButton boton39;
    private javax.swing.JButton boton40;
    private javax.swing.JButton boton41;
    private javax.swing.JButton boton42;
    private javax.swing.JButton boton43;
    private javax.swing.JButton boton44;
    private javax.swing.JButton boton45;
    private javax.swing.JButton boton46;
    private javax.swing.JButton boton47;
    private javax.swing.JButton boton48;
    private javax.swing.JButton boton49;
    private javax.swing.JButton boton50;
    private javax.swing.JButton boton51;
    private javax.swing.JButton boton52;
    private javax.swing.JButton boton53;
    private javax.swing.JButton boton54;
    private javax.swing.JButton boton55;
    private javax.swing.JButton boton56;
    private javax.swing.JButton boton57;
    private javax.swing.JButton boton58;
    private javax.swing.JButton boton59;
    private javax.swing.JButton boton60;
    private javax.swing.JButton boton61;
    private javax.swing.JButton boton62;
    private javax.swing.JButton boton63;
    private javax.swing.JButton boton64;
    private javax.swing.JButton boton65;
    private javax.swing.JButton boton66;
    private javax.swing.JButton boton67;
    private javax.swing.JButton boton68;
    private javax.swing.JButton boton69;
    private javax.swing.JButton boton70;
    private javax.swing.JButton boton71;
    private javax.swing.JButton boton72;
    private javax.swing.JButton boton73;
    private javax.swing.JButton boton74;
    private javax.swing.JButton boton75;
    private javax.swing.JButton boton76;
    private javax.swing.JButton boton77;
    private javax.swing.JButton boton78;
    private javax.swing.JButton boton79;
    private javax.swing.JButton boton80;
    private javax.swing.JButton boton81;
    private javax.swing.JButton boton82;
    private javax.swing.JButton boton83;
    private javax.swing.JButton boton84;
    private javax.swing.JButton boton85;
    private javax.swing.JButton boton86;
    private javax.swing.JButton boton87;
    private javax.swing.JButton boton88;
    private javax.swing.JButton boton89;
    private javax.swing.JButton boton90;
    private javax.swing.JButton boton91;
    private javax.swing.JButton boton92;
    private javax.swing.JButton boton93;
    private javax.swing.JButton boton94;
    private javax.swing.JButton boton95;
    private javax.swing.JButton boton96;
    private javax.swing.JButton boton97;
    private javax.swing.JButton boton98;
    private javax.swing.JButton boton99;
    private javax.swing.JPanel cincocartas;
    private javax.swing.JButton cincocartasboton1;
    private javax.swing.JButton cincocartasboton2;
    private javax.swing.JButton cincocartasboton3;
    private javax.swing.JButton cincocartasboton4;
    private javax.swing.JButton cincocartasboton5;
    private javax.swing.JPanel cuatrocartas;
    private javax.swing.JButton cuatrocartasboton1;
    private javax.swing.JButton cuatrocartasboton2;
    private javax.swing.JButton cuatrocartasboton3;
    private javax.swing.JButton cuatrocartasboton4;
    private javax.swing.JPanel cuatrojugadoresder;
    private javax.swing.JPanel cuatrojugadoresizq;
    private javax.swing.JPanel dosjugadoresder;
    private javax.swing.JPanel dosjugadoresizq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane layeredpanecartas;
    private javax.swing.JLayeredPane layeredpaneder;
    private javax.swing.JLayeredPane layeredpaneizq;
    private javax.swing.JPanel ochojugadoresder;
    private javax.swing.JPanel ochojugadoresizq;
    private javax.swing.JPanel seiscartas;
    private javax.swing.JButton seiscartasboton1;
    private javax.swing.JButton seiscartasboton2;
    private javax.swing.JButton seiscartasboton3;
    private javax.swing.JButton seiscartasboton4;
    private javax.swing.JButton seiscartasboton5;
    private javax.swing.JButton seiscartasboton6;
    private javax.swing.JPanel seisjugadoresder;
    private javax.swing.JPanel seisjugadoresizq;
    private javax.swing.JPanel sietecartas;
    private javax.swing.JButton sietecartasboton1;
    private javax.swing.JButton sietecartasboton2;
    private javax.swing.JButton sietecartasboton3;
    private javax.swing.JButton sietecartasboton4;
    private javax.swing.JButton sietecartasboton5;
    private javax.swing.JButton sietecartasboton6;
    private javax.swing.JButton sietecartasboton7;
    private javax.swing.JPanel tresjugadoresder;
    private javax.swing.JPanel tresjugadoresizq;
    // End of variables declaration//GEN-END:variables

}
