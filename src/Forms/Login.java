package Forms;

import finzamida.Conexion;
import finzamida.UIUtils;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();

    public Login() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf");
            UIUtils.setFontRecursively(PanelPrincipal, customFont);

        } catch (Exception e) {
            System.out.println("Font unavailable" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelRoundFondo = new Items.PanelRound();
        btnCerrar = new javax.swing.JButton();
        PanelIngresos = new Items.PanelRound();
        lblCobros1 = new javax.swing.JLabel();
        lblCobrosFecha1 = new javax.swing.JLabel();
        txtUsuario = new Items.TextField();
        txtPassword = new Items.PasswordField();
        btnDashboard1 = new Items.MyButton();
        btnCuentas = new Items.MyButton();
        lblCobrosFecha2 = new javax.swing.JLabel();
        btnCuentas1 = new Items.MyButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelRoundFondo.setBackground(new java.awt.Color(37, 25, 57));
        PanelRoundFondo.setForeground(new java.awt.Color(255, 255, 255));
        PanelRoundFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        PanelRoundFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, -1, -1));

        PanelIngresos.setBackground(new java.awt.Color(245, 245, 245));
        PanelIngresos.setRoundBottomLeft(50);
        PanelIngresos.setRoundBottomRight(50);
        PanelIngresos.setRoundTopLeft(50);
        PanelIngresos.setRoundTopRight(50);
        PanelIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCobros1.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        lblCobros1.setForeground(new java.awt.Color(0, 0, 0));
        lblCobros1.setText("Bienvenido de nuevo a Finzamida ");
        PanelIngresos.add(lblCobros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 58, 595, -1));

        lblCobrosFecha1.setBackground(new java.awt.Color(245, 245, 245));
        lblCobrosFecha1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCobrosFecha1.setForeground(new java.awt.Color(102, 102, 102));
        lblCobrosFecha1.setText("¿No tienes cuenta? ");
        PanelIngresos.add(lblCobrosFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 180, -1));

        txtUsuario.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setCaretColor(new java.awt.Color(36, 25, 56));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(125, 84, 75));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 186, 528, -1));

        txtPassword.setBackground(new java.awt.Color(245, 245, 245));
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setCaretColor(new java.awt.Color(36, 25, 56));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setLineColor(new java.awt.Color(116, 76, 68));
        PanelIngresos.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 272, 528, -1));

        btnDashboard1.setForeground(new java.awt.Color(55, 0, 43));
        btnDashboard1.setText("Regresar");
        btnDashboard1.setBorderColor(new java.awt.Color(245, 245, 245));
        btnDashboard1.setColor(new java.awt.Color(226, 232, 247));
        btnDashboard1.setColorOver(new java.awt.Color(176, 179, 185));
        btnDashboard1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnDashboard1.setRadius(40);
        btnDashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboard1ActionPerformed(evt);
            }
        });
        PanelIngresos.add(btnDashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 440, 189, 44));

        btnCuentas.setForeground(new java.awt.Color(55, 0, 43));
        btnCuentas.setText("Iniciar sesión");
        btnCuentas.setBorderColor(new java.awt.Color(245, 245, 245));
        btnCuentas.setColor(new java.awt.Color(226, 232, 247));
        btnCuentas.setColorOver(new java.awt.Color(176, 179, 185));
        btnCuentas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCuentas.setRadius(40);
        btnCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasActionPerformed(evt);
            }
        });
        PanelIngresos.add(btnCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 440, 189, 44));

        lblCobrosFecha2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCobrosFecha2.setForeground(new java.awt.Color(102, 102, 102));
        lblCobrosFecha2.setText("Gestiona todo mucho mejor");
        PanelIngresos.add(lblCobrosFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 120, 495, -1));

        btnCuentas1.setBackground(new java.awt.Color(245, 245, 245));
        btnCuentas1.setForeground(new java.awt.Color(51, 51, 255));
        btnCuentas1.setText("Registrarse");
        btnCuentas1.setBorderColor(new java.awt.Color(245, 245, 245));
        btnCuentas1.setColor(new java.awt.Color(245, 245, 245));
        btnCuentas1.setColorClick(new java.awt.Color(245, 245, 245));
        btnCuentas1.setColorOver(new java.awt.Color(245, 245, 245));
        btnCuentas1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCuentas1.setRadius(40);
        btnCuentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentas1ActionPerformed(evt);
            }
        });
        PanelIngresos.add(btnCuentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 189, 44));

        PanelRoundFondo.add(PanelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 650, 590));

        jPanel2.setBackground(new java.awt.Color(74, 60, 99));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        PanelRoundFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 910, 40));

        jPanel1.setBackground(new java.awt.Color(74, 60, 99));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        PanelRoundFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 910, 40));

        PanelPrincipal.add(PanelRoundFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1422, 762));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtPassword.getPassword());

        String consulta = "SELECT idUsuario FROM usuarios WHERE CorreoElectronico = ? AND Contrasena = ?";

        try {
            PreparedStatement ps = reg.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                Dashboard dashboard = new Dashboard(idUsuario);
                dashboard.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnDashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboard1ActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboard1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCuentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentas1ActionPerformed
        new AltaUsuario().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentas1ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Items.PanelRound PanelIngresos;
    private javax.swing.JPanel PanelPrincipal;
    private Items.PanelRound PanelRoundFondo;
    private javax.swing.JButton btnCerrar;
    private Items.MyButton btnCuentas;
    private Items.MyButton btnCuentas1;
    private Items.MyButton btnDashboard1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCobros1;
    private javax.swing.JLabel lblCobrosFecha1;
    private javax.swing.JLabel lblCobrosFecha2;
    private Items.PasswordField txtPassword;
    private Items.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
