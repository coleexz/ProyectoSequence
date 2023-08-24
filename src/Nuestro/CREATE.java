/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CREATE extends JFrame implements ActionListener{

    JPanel panelCreatePlayer = new JPanel();
    JTextField userfield = new JTextField();
    JPasswordField passwordfield = new JPasswordField();
    JLabel lblUsuario = new JLabel();
    JLabel lblPassword = new JLabel();
    JLabel lblTitulo = new JLabel();
    JButton botonCrearPlayer = new JButton();
    JButton botonRegresar = new JButton();
    
    public CREATE(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelCreatePlayer.setSize(500, 500);
        panelCreatePlayer.setLayout(null);
        panelCreatePlayer.setBackground(new Color(0x123456));
        add(panelCreatePlayer);
       
        userfield.setText("");
        userfield.setBounds(200, 180, 200, 30);
        panelCreatePlayer.add(userfield);
        
        passwordfield.setText("");
        passwordfield.setBounds(200, 270, 200, 30);
        panelCreatePlayer.add(passwordfield);
        
        lblUsuario.setText("User: ");
        lblUsuario.setBounds(80, 180, 100, 30);
        lblUsuario.setFont(new Font(null,Font.BOLD, 20));
        lblUsuario.setForeground(Color.white);
        panelCreatePlayer.add(lblUsuario);
        
        lblPassword.setText("Password: ");
        lblPassword.setBounds(80, 270, 110, 30);
        lblPassword.setFont(new Font(null,Font.BOLD, 20));
        lblPassword.setForeground(Color.white);
        panelCreatePlayer.add(lblPassword);
        
        lblTitulo.setText("CREAR PLAYER");
        lblTitulo.setBounds(130, 50, 250, 50);
        lblTitulo.setFont(new Font(null, Font.PLAIN, 30));
        lblTitulo.setForeground(Color.white);
        panelCreatePlayer.add(lblTitulo);
        
        botonRegresar.setText("Regresar");
        botonRegresar.setBounds(80, 380, 100, 30);
        botonRegresar.addActionListener(this);
        botonRegresar.setBackground(Color.white);
        panelCreatePlayer.add(botonRegresar);
        
        botonCrearPlayer.setText("Crear Player");
        botonCrearPlayer.setBounds(280, 380, 120, 30);
        botonCrearPlayer.addActionListener(this);
        botonCrearPlayer.setBackground(Color.white);
        panelCreatePlayer.add(botonCrearPlayer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegresar) {
            LOGIN login = new LOGIN();
            login.setVisible(true);
            this.dispose();
        }
        
        if (e.getSource() == botonCrearPlayer) {
            if(userfield.getText().isEmpty()|| passwordfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "LLene todos los campos");
            }else{
                String username=userfield.getText();
                String password=passwordfield.getText();
                //guardar usuario
                if(Player.buscarUser(username) == null){
                   Player.addUser(username, password);
                   Player.UsuarioLogeado = username;
                   JOptionPane.showMessageDialog(null, "Se ha registrado el usuario");
     //LOGIN login = new LOGIN();
     //login.setVisible(true);
                   MENUPRINCIPAL menu=new MENUPRINCIPAL();
                   menu.setVisible(true);
                   userfield.setText("");
                   passwordfield.setText("");
                   this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe");
                }    
            }
        }
    }
}
