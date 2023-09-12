/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyectooo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AdminColeexz
 */
public class SELECCIONARJUGADORES extends javax.swing.JFrame implements ActionListener {

    private Player player;
    private int c = 1;

    /**
     * Creates new form SELECCIONARJUGADORES
     */
    public SELECCIONARJUGADORES(Player player) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        selecombobox.removeAllItems();

        this.player = player;
        pasarinfo();
        agregarAcciones();
    }

    public void pasarinfo() {
        ArrayList<Player> jugadores = Player.users;

        // Ahora puedes trabajar con la lista de jugadores (jugadores) aquí
        for (Player jugador : jugadores) {
            // Haz algo con cada jugador, por ejemplo, muestra su nombre de usuario
            selecombobox.addItem(jugador.getUser());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        selecombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        selecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Selecciona un jugador!");

        jButton1.setText("SLEECCIONAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(selecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(selecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void agregarAcciones() {
        jButton1.addActionListener(this);
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
            java.util.logging.Logger.getLogger(SELECCIONARJUGADORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SELECCIONARJUGADORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SELECCIONARJUGADORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SELECCIONARJUGADORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Player player = new Player("username", "password", 0, "verde"); // Replace with actual user data
                new SELECCIONARJUGADORES(player).setVisible(true);
                ATABLEROCOLE.players.add(LOGIN.JUGADORACTUAL);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selecombobox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            MENUSWING menus = new MENUSWING();
            int n = menus.numerojugadores;
            if (c < n) {
                String selectedUsername = (String) selecombobox.getSelectedItem(); // Obtén el nombre de usuario seleccionado

                // Llama al método buscarUser con el nombre de usuario seleccionado
                Player usuarioEncontrado = Player.buscarUser(selectedUsername);
                
                if (usuarioEncontrado != null && !ATABLEROCOLE.buscarUsuario(selectedUsername)) {
                    JOptionPane.showMessageDialog(this, "Usuario agregado: " + usuarioEncontrado.getUser());
                    ATABLEROCOLE.players.add(usuarioEncontrado);
                    c++;
                } else if (selectedUsername.equals(LOGIN.JUGADORACTUAL.getUser())){
                    JOptionPane.showMessageDialog(this,"no puede jugar contra usted mismo");
                }else if (ATABLEROCOLE.buscarUsuario(selectedUsername)){
                    JOptionPane.showMessageDialog(this,"no puede volver a escoger un usuario que ya esta escogido");
                }else {
                    JOptionPane.showMessageDialog(this, "Usuario no encontrado");
                }
            }

            if (c >= n) {
                this.dispose();
                ATABLEROCOLE tablero = new ATABLEROCOLE(menus.numerojugadores);
                tablero.setVisible(true);
            }

        }
    }
}
