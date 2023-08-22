/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nuestro;

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
public class LOGIN extends JFrame implements ActionListener {

    
    JPanel panellogin = new JPanel();
    JLabel bienvenido = new JLabel("Bienvenido al menu de login!");
    JTextField usernamefield = new JTextField();
    JPasswordField passwordfield = new JPasswordField();
    JButton botonlogin = new JButton();
    
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
        
        usernamefield.setText("Usuario: ");
        usernamefield.setBounds(100, 150,300,50);
        panellogin.add(usernamefield);
        
        passwordfield.setBounds(100,225,300,50);
        passwordfield.setText("Contraseña: ");
        panellogin.add(passwordfield);
        
      
        botonlogin.setText("Iniciar sesion");
        botonlogin.setBounds(200, 320, 100, 50);
        botonlogin.addActionListener(this);
        panellogin.add(botonlogin);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==botonlogin){
            String user,pass;
            user=usernamefield.getText();
            pass=passwordfield.getText().toString();
            
            if(!user.isEmpty() && !pass.isEmpty()){
                if(Player.buscarUser(user)!=null){
                    JOptionPane.showMessageDialog(this, "inicio de sesion terminado exitosamente\nprocedera al menu principal!");
                    usernamefield.setText("");
                    passwordfield.setText("");
                    MENUPRINCIPAL menu = new MENUPRINCIPAL();
                    menu.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontro dicha cuenta");
                }
            } else {
               JOptionPane.showMessageDialog(this,"Debe de llenar los espacios para ingresar");
            }
        }
        
        if(e.getSource()==usernamefield){
            usernamefield.setText("");
        }
         
        if(e.getSource()==passwordfield){
            passwordfield.setText("");
        }
        
        
    }
    
    
}
