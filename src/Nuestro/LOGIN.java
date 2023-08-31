/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author AdminColeexz
 */
public class LOGIN extends JFrame implements ActionListener {

    
    JPanel panellogin = new JPanel();
    JLabel bienvenido = new JLabel("Bienvenido al menu de login!");
    JTextField usernamefield = new JTextField();
    JPasswordField passwordfield = new JPasswordField();
    JButton botonlogin = new JButton();
    JButton botonCrearPlayer = new JButton();
    JLabel lblUsuario = new JLabel();
    JLabel lblPassword = new JLabel();
    static RandomAccessFile raf;
    
    public LOGIN(){
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        add(panellogin);
        panellogin.setLayout(null);
        panellogin.setSize(500,500);
      
       
        bienvenido.setBounds(170,10,200,100);
        panellogin.add(bienvenido);
        
        usernamefield.setText("");
        usernamefield.setBounds(200, 150,200,50);
        panellogin.add(usernamefield);
        
        passwordfield.setBounds(200,225,200,50);
        passwordfield.setText("");
        panellogin.add(passwordfield);
        
      
        botonlogin.setText("Iniciar sesion");
        botonlogin.setBounds(100, 320, 120, 50);
        botonlogin.addActionListener(this);
        panellogin.add(botonlogin);
        
        botonCrearPlayer.setText("Crear Player");
        botonCrearPlayer.setBounds(270, 320, 120, 50);
        botonCrearPlayer.addActionListener(this);
        panellogin.add(botonCrearPlayer);
        
        lblUsuario.setText("Usuario: ");
        lblUsuario.setBounds(100, 150, 100, 30);
        panellogin.add(lblUsuario);
        
        lblPassword.setText("Contraseña: ");
        lblPassword.setBounds(100, 225, 110, 30);
        panellogin.add(lblPassword);
        
        createUsersFile();   
        Player.loadUsersFromFile("Users/users.usr");
        
        for (int i = 0; i < Player.users.size(); i++) {
            System.out.println(Player.users.get(i).user);
        }
    }
    //crea el directorio y luego el archivo donde se guardaran los usuarios
    static void createUsersFile() {
        File directory = new File("Users");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Se creo el directorio: " + directory.getName());
            } else {
                System.out.println("Error. No se pudo crear el directorio");
            }
        } else {
            System.out.println("El directorio ya existe");
        }             
        
        try {
            raf = new RandomAccessFile("Users/users.usr", "rw");
        } catch (IOException e) {
            System.err.println("Error. No se pudo crear el archivo");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==botonlogin){
            String user,pass;
            user=usernamefield.getText();
            pass=passwordfield.getText();
            
            if(!user.isEmpty() && !pass.isEmpty()){
                if(Player.buscarUser(user)!=null){
                    if (Player.buscarUser(user).getPass().equals(pass)) {
                        JOptionPane.showMessageDialog(this, "inicio de sesion terminado exitosamente\nprocedera al menu principal!");
                        usernamefield.setText("");
                        passwordfield.setText("");
                        MENUPRINCIPAL menu = new MENUPRINCIPAL();
                        menu.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Contrasena incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontro dicha cuenta");
                }
            } else {
               JOptionPane.showMessageDialog(this,"Debe de llenar los espacios para ingresar");
            }
        }
        
        if (e.getSource() == botonCrearPlayer) {
            CREATE create = new CREATE();
            create.setVisible(true);
            this.dispose();
        }
        
        if(e.getSource()==usernamefield){
            usernamefield.setText("");
        }
         
        if(e.getSource()==passwordfield){
            passwordfield.setText("");
        }
    }
}
