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
    JTextField Nombrefield = new JTextField();
    JPasswordField confirmarpasswordfield = new JPasswordField();
    JLabel lblUsuario = new JLabel();
    JLabel lblPassword = new JLabel();
    JLabel lblNombre = new JLabel();
    JLabel lblConfirmar = new JLabel();
    JLabel lblConfirmarPassword = new JLabel();
    JLabel lblTitulo = new JLabel();
    JButton botonCrearPlayer = new JButton();
    JButton botonRegresar = new JButton();
    
    public CREATE(){
        setSize(500,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelCreatePlayer.setSize(500, 700);
        panelCreatePlayer.setLayout(null);
        panelCreatePlayer.setBackground(new Color(0x123456));
        add(panelCreatePlayer);
        
        lblTitulo.setText("CREAR PLAYER");
        lblTitulo.setBounds(130, 50, 250, 50);
        lblTitulo.setFont(new Font(null, Font.PLAIN, 30));
        lblTitulo.setForeground(Color.white);
        panelCreatePlayer.add(lblTitulo);
        
        Nombrefield.setText("");
        Nombrefield.setBounds(210, 180, 200, 30);
        panelCreatePlayer.add(Nombrefield);
       
        userfield.setText("");
        userfield.setBounds(210, 270, 200, 30);
        panelCreatePlayer.add(userfield);
        
        passwordfield.setText("");
        passwordfield.setBounds(210, 360, 200, 30);
        panelCreatePlayer.add(passwordfield);
        
        confirmarpasswordfield.setText("");
        confirmarpasswordfield.setBounds(210, 450, 200, 30);
        panelCreatePlayer.add(confirmarpasswordfield);
        
        lblNombre.setText("Nombre: ");
        lblNombre.setBounds(70, 180, 100, 30);
        lblNombre.setFont(new Font(null,Font.BOLD, 20));
        lblNombre.setForeground(Color.white);
        panelCreatePlayer.add(lblNombre);
        
        lblUsuario.setText("Usuario: ");
        lblUsuario.setBounds(70, 270, 100, 30);
        lblUsuario.setFont(new Font(null,Font.BOLD, 20));
        lblUsuario.setForeground(Color.white);
        panelCreatePlayer.add(lblUsuario);
        
        lblPassword.setText("Contraseña: ");
        lblPassword.setBounds(70, 360, 130, 30);
        lblPassword.setFont(new Font(null,Font.BOLD, 20));
        lblPassword.setForeground(Color.white);
        panelCreatePlayer.add(lblPassword);
        
        lblConfirmar.setText("Confirmar");
        lblConfirmar.setBounds(70, 440, 110, 30);
        lblConfirmar.setFont(new Font(null,Font.BOLD, 20));
        lblConfirmar.setForeground(Color.white);
        panelCreatePlayer.add(lblConfirmar); 
        
        lblConfirmarPassword.setText("Contraseña");
        lblConfirmarPassword.setBounds(70, 470, 110, 30);
        lblConfirmarPassword.setFont(new Font(null,Font.BOLD, 20));
        lblConfirmarPassword.setForeground(Color.white);
        panelCreatePlayer.add(lblConfirmarPassword); 
        
        botonRegresar.setText("Regresar");
        botonRegresar.setBounds(80, 580, 100, 30);
        botonRegresar.addActionListener(this);
        botonRegresar.setBackground(Color.white);
        panelCreatePlayer.add(botonRegresar);
        
        botonCrearPlayer.setText("Crear Player");
        botonCrearPlayer.setBounds(280, 580, 120, 30);
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
            if(userfield.getText().isEmpty()|| passwordfield.getText().isEmpty() || Nombrefield.getText().isEmpty() || confirmarpasswordfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "LLene todos los campos");
            }else{
                String username=userfield.getText();
                String password=passwordfield.getText();
                //guardar usuario
                if(Player.buscarUser(username) == null){
                   Player.addUser(username, password);
                   Player.UsuarioLogeado = username;
                   JOptionPane.showMessageDialog(null, "Se ha registrado el usuario");

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
