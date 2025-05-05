package FormsAdmin;

import Forms.*;
import finzamida.Conexion;
import finzamida.UIUtils;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EditarUsuario extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();
    private Usuarios ventanaPadre;
    private int idUsuarioActual;
    private String nombreUsuarioActual;

    public EditarUsuario(int idUsuario, String nombre, Usuarios padre) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        lblCobros1.setText("Editar usuario"); 
        btnRegistrarse.setText("Guardar cambios"); 
        idUsuarioActual = idUsuario;
        cargarDatosUsuario(idUsuario);

        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf");
            UIUtils.setFontRecursively(PanelPrincipal, customFont);
        } catch (Exception e) {
            System.out.println("Font unavailable" + e);
        }
    }

    public EditarUsuario() { 
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

    private void cargarDatosUsuario(int idUsuario) {
        String sql = "SELECT `CURP`, `RFC`, `Nombre`, `ApellidoPat`, `ApellidoMat`, `CorreoElectronico`, `Contrasena` FROM `usuarios` WHERE `idUsuario` = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtCurp.setText(rs.getString("CURP"));
                txtRFC.setText(rs.getString("RFC"));
                txtNombre.setText(rs.getString("Nombre"));
                txtAPaterno.setText(rs.getString("ApellidoPat"));

                // Verificar si ApellidoMat es null antes de establecer el texto
                String apellidoMaterno = rs.getString("ApellidoMat");
                txtAMaterno.setText(apellidoMaterno == null ? "" : apellidoMaterno);

                txtCorreo.setText(rs.getString("CorreoElectronico"));
                txtContra.setText(rs.getString("Contrasena"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron datos para el usuario con ID: " + idUsuario, "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose(); 
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos del usuario: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar datos del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose(); 
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
        btnVolver = new Items.MyButton();
        btnRegistrarse = new Items.MyButton();
        txtCurp = new Items.TextField();
        txtRFC = new Items.TextField();
        txtNombre = new Items.TextField();
        txtAPaterno = new Items.TextField();
        txtAMaterno = new Items.TextField();
        txtCorreo = new Items.TextField();
        txtContra = new Items.PasswordField();

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
        lblCobros1.setText("Dar de alta a un usuario");
        PanelIngresos.add(lblCobros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 595, -1));

        lblCobrosFecha1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCobrosFecha1.setForeground(new java.awt.Color(102, 102, 102));
        lblCobrosFecha1.setText("Estas a unos cuantos click de tener control de tus finanzas");
        PanelIngresos.add(lblCobrosFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 495, -1));

        btnVolver.setForeground(new java.awt.Color(55, 0, 43));
        btnVolver.setText("Volver");
        btnVolver.setBorderColor(new java.awt.Color(245, 245, 245));
        btnVolver.setColor(new java.awt.Color(226, 232, 247));
        btnVolver.setColorOver(new java.awt.Color(176, 179, 185));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnVolver.setRadius(40);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        PanelIngresos.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 189, 44));

        btnRegistrarse.setForeground(new java.awt.Color(55, 0, 43));
        btnRegistrarse.setText("Guardar cambios");
        btnRegistrarse.setBorderColor(new java.awt.Color(245, 245, 245));
        btnRegistrarse.setColor(new java.awt.Color(226, 232, 247));
        btnRegistrarse.setColorOver(new java.awt.Color(176, 179, 185));
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnRegistrarse.setRadius(40);
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        PanelIngresos.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 500, 189, 44));

        txtCurp.setBackground(new java.awt.Color(245, 245, 245));
        txtCurp.setForeground(new java.awt.Color(0, 0, 0));
        txtCurp.setCaretColor(new java.awt.Color(36, 25, 56));
        txtCurp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCurp.setLabelText("CURP");
        txtCurp.setLineColor(new java.awt.Color(125, 84, 75));
        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 390, -1));

        txtRFC.setBackground(new java.awt.Color(245, 245, 245));
        txtRFC.setForeground(new java.awt.Color(0, 0, 0));
        txtRFC.setCaretColor(new java.awt.Color(36, 25, 56));
        txtRFC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtRFC.setLabelText("RFC");
        txtRFC.setLineColor(new java.awt.Color(125, 84, 75));
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 390, -1));

        txtNombre.setBackground(new java.awt.Color(245, 245, 245));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setCaretColor(new java.awt.Color(36, 25, 56));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setLabelText("Nombre");
        txtNombre.setLineColor(new java.awt.Color(125, 84, 75));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 390, -1));

        txtAPaterno.setBackground(new java.awt.Color(245, 245, 245));
        txtAPaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtAPaterno.setCaretColor(new java.awt.Color(36, 25, 56));
        txtAPaterno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAPaterno.setLabelText("Apellido paterno");
        txtAPaterno.setLineColor(new java.awt.Color(125, 84, 75));
        txtAPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPaternoActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 390, -1));

        txtAMaterno.setBackground(new java.awt.Color(245, 245, 245));
        txtAMaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtAMaterno.setCaretColor(new java.awt.Color(36, 25, 56));
        txtAMaterno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAMaterno.setLabelText("Apellido materno");
        txtAMaterno.setLineColor(new java.awt.Color(125, 84, 75));
        txtAMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAMaternoActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 390, -1));

        txtCorreo.setBackground(new java.awt.Color(245, 245, 245));
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setCaretColor(new java.awt.Color(36, 25, 56));
        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCorreo.setLabelText("Correo electrónico ");
        txtCorreo.setLineColor(new java.awt.Color(125, 84, 75));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        PanelIngresos.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 390, -1));

        txtContra.setBackground(new java.awt.Color(245, 245, 245));
        txtContra.setForeground(new java.awt.Color(0, 0, 0));
        txtContra.setCaretColor(new java.awt.Color(36, 25, 56));
        txtContra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContra.setLabelText("Contraseña");
        txtContra.setLineColor(new java.awt.Color(116, 76, 68));
        PanelIngresos.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 390, -1));

        PanelRoundFondo.add(PanelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1340, 590));

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

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        PreparedStatement ps = null;
        Connection conexionTransaccion = null;

        String curp = txtCurp.getText().trim();
        String rfc = txtRFC.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellidoPat = txtAPaterno.getText().trim();
        String apellidoMat = txtAMaterno.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contrasena = new String(txtContra.getPassword()).trim();

        if (curp.isEmpty() || rfc.isEmpty() || nombre.isEmpty() || apellidoPat.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            conexionTransaccion = conexion.getConexion();
            conexionTransaccion.setAutoCommit(false);

            String sql = "UPDATE usuarios SET CURP=?, RFC=?, Nombre=?, ApellidoPat=?, ApellidoMat=?, CorreoElectronico=?, Contrasena=? WHERE idUsuario=?";
            ps = conexionTransaccion.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, rfc);
            ps.setString(3, nombre);
            ps.setString(4, apellidoPat);
            ps.setString(5, apellidoMat.isEmpty() ? null : apellidoMat);
            ps.setString(6, correo);
            ps.setString(7, contrasena.isEmpty() ? null : contrasena);
            ps.setInt(8, idUsuarioActual);
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                conexionTransaccion.commit();
                JOptionPane.showMessageDialog(this, "Datos del usuario actualizados exitosamente.");
                new Usuarios().setVisible(true);
                this.dispose();

            } else {
                conexionTransaccion.rollback();
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            if (conexionTransaccion != null) {
                try {
                    conexionTransaccion.rollback();
                } catch (SQLException rollbackEx) {
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback de la transacción: " + rollbackEx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos del usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexionTransaccion != null) {
                    conexionTransaccion.setAutoCommit(true);
                }
            } catch (SQLException closeEx) {
                JOptionPane.showMessageDialog(this, "Error al cerrar recursos de la base de datos: " + closeEx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new Usuarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtAPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPaternoActionPerformed

    private void txtAMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAMaternoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Items.PanelRound PanelIngresos;
    private javax.swing.JPanel PanelPrincipal;
    private Items.PanelRound PanelRoundFondo;
    private javax.swing.JButton btnCerrar;
    private Items.MyButton btnRegistrarse;
    private Items.MyButton btnVolver;
    private javax.swing.JLabel lblCobros1;
    private javax.swing.JLabel lblCobrosFecha1;
    private Items.TextField txtAMaterno;
    private Items.TextField txtAPaterno;
    private Items.PasswordField txtContra;
    private Items.TextField txtCorreo;
    private Items.TextField txtCurp;
    private Items.TextField txtNombre;
    private Items.TextField txtRFC;
    // End of variables declaration//GEN-END:variables

}
