package Forms;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import finzamida.Conexion;
import finzamida.UIUtils;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class Cuentas extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();
    private int idUsuario;

    public Cuentas(int idUsuario) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);
        } catch (Exception e) {
            System.out.println("Font unavailable: " + e);
        }

        this.idUsuario = idUsuario;
        cargarCuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRoundFondo = new Items.PanelRound();
        btnCerrar = new javax.swing.JButton();
        PanelCuenta0 = new Items.PanelRound();
        lblNombreCuenta = new javax.swing.JLabel();
        lblTipoCuenta = new javax.swing.JLabel();
        lblSaldoTotal = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        lblUltimos4 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnEditar = new Items.MyButton();
        btnEliminar = new Items.MyButton();
        btnTransacciones = new Items.MyButton();
        btnAgregarCuenta = new Items.MyButton();
        MenuBotones = new Items.PanelRound();
        Logo = new UIUtils.LogoPanel();
        btnDashboard = new Items.MyButton();
        btnCuentas = new Items.MyButton();
        btnTransacciones1 = new Items.MyButton();
        btnCategorias = new Items.MyButton();
        btnCerrarSesion = new Items.MyButton();
        btnReporte = new Items.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finzamida");
        setBackground(new java.awt.Color(55, 0, 43));

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

        PanelCuenta0.setBackground(new java.awt.Color(245, 245, 245));
        PanelCuenta0.setRoundBottomLeft(50);
        PanelCuenta0.setRoundBottomRight(50);
        PanelCuenta0.setRoundTopLeft(50);
        PanelCuenta0.setRoundTopRight(50);
        PanelCuenta0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombreCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreCuenta.setText("[Nombre de cuenta]");
        PanelCuenta0.add(lblNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 362, -1));

        lblTipoCuenta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTipoCuenta.setForeground(new java.awt.Color(102, 102, 102));
        lblTipoCuenta.setText("Tipo de cuenta");
        PanelCuenta0.add(lblTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 386, -1));

        lblSaldoTotal.setFont(new java.awt.Font("Segoe UI", 0, 46)); // NOI18N
        lblSaldoTotal.setForeground(new java.awt.Color(70, 155, 74));
        lblSaldoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoTotal.setText("000000.00 MXN");
        PanelCuenta0.add(lblSaldoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 350, 74));

        lblBanco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblBanco.setForeground(new java.awt.Color(102, 102, 102));
        lblBanco.setText("[Banco]");
        PanelCuenta0.add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 79, 386, -1));

        lblUltimos4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblUltimos4.setForeground(new java.awt.Color(102, 102, 102));
        lblUltimos4.setText("[Ultimos 4 digitos de la tarjeta]");
        PanelCuenta0.add(lblUltimos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 107, 386, -1));

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(102, 102, 102));
        lblSaldo.setText("Saldo");
        PanelCuenta0.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 50, -1));

        btnEditar.setForeground(new java.awt.Color(55, 0, 43));
        btnEditar.setText("Editar");
        btnEditar.setBorderColor(new java.awt.Color(245, 245, 245));
        btnEditar.setColor(new java.awt.Color(226, 232, 247));
        btnEditar.setColorOver(new java.awt.Color(176, 179, 185));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnEditar.setRadius(40);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        PanelCuenta0.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 120, 44));

        btnEliminar.setForeground(new java.awt.Color(55, 0, 43));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorderColor(new java.awt.Color(245, 245, 245));
        btnEliminar.setColor(new java.awt.Color(226, 232, 247));
        btnEliminar.setColorOver(new java.awt.Color(176, 179, 185));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnEliminar.setRadius(40);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PanelCuenta0.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 160, 120, 44));

        btnTransacciones.setForeground(new java.awt.Color(55, 0, 43));
        btnTransacciones.setText("Ver transacciones");
        btnTransacciones.setBorderColor(new java.awt.Color(245, 245, 245));
        btnTransacciones.setColor(new java.awt.Color(226, 232, 247));
        btnTransacciones.setColorOver(new java.awt.Color(176, 179, 185));
        btnTransacciones.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnTransacciones.setRadius(40);
        btnTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionesActionPerformed(evt);
            }
        });
        PanelCuenta0.add(btnTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 180, 44));

        PanelRoundFondo.add(PanelCuenta0, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 1130, 220));

        btnAgregarCuenta.setForeground(new java.awt.Color(55, 0, 43));
        btnAgregarCuenta.setText("Agregar cuenta");
        btnAgregarCuenta.setBorderColor(new java.awt.Color(55, 36, 85));
        btnAgregarCuenta.setColor(new java.awt.Color(226, 232, 247));
        btnAgregarCuenta.setColorOver(new java.awt.Color(176, 179, 185));
        btnAgregarCuenta.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAgregarCuenta.setRadius(40);
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        PanelRoundFondo.add(btnAgregarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 189, 44));

        MenuBotones.setBackground(new java.awt.Color(55, 36, 85));
        MenuBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        MenuBotones.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 180));

        btnDashboard.setForeground(new java.awt.Color(55, 0, 43));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorderColor(new java.awt.Color(55, 36, 85));
        btnDashboard.setColor(new java.awt.Color(226, 232, 247));
        btnDashboard.setColorOver(new java.awt.Color(176, 179, 185));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnDashboard.setRadius(40);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        MenuBotones.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 189, 44));

        btnCuentas.setForeground(new java.awt.Color(55, 0, 43));
        btnCuentas.setText("Cuentas");
        btnCuentas.setBorderColor(new java.awt.Color(55, 36, 85));
        btnCuentas.setColor(new java.awt.Color(226, 232, 247));
        btnCuentas.setColorOver(new java.awt.Color(176, 179, 185));
        btnCuentas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCuentas.setRadius(40);
        btnCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasActionPerformed(evt);
            }
        });
        MenuBotones.add(btnCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 189, 44));

        btnTransacciones1.setForeground(new java.awt.Color(55, 0, 43));
        btnTransacciones1.setText("Transacciones");
        btnTransacciones1.setBorderColor(new java.awt.Color(55, 36, 85));
        btnTransacciones1.setColor(new java.awt.Color(226, 232, 247));
        btnTransacciones1.setColorOver(new java.awt.Color(176, 179, 185));
        btnTransacciones1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnTransacciones1.setRadius(40);
        btnTransacciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransacciones1ActionPerformed(evt);
            }
        });
        MenuBotones.add(btnTransacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 189, 44));

        btnCategorias.setForeground(new java.awt.Color(55, 0, 43));
        btnCategorias.setText("Categorías");
        btnCategorias.setBorderColor(new java.awt.Color(55, 36, 85));
        btnCategorias.setColor(new java.awt.Color(226, 232, 247));
        btnCategorias.setColorOver(new java.awt.Color(176, 179, 185));
        btnCategorias.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCategorias.setRadius(40);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        MenuBotones.add(btnCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 189, 44));

        btnCerrarSesion.setForeground(new java.awt.Color(55, 0, 43));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorderColor(new java.awt.Color(55, 36, 85));
        btnCerrarSesion.setColor(new java.awt.Color(226, 232, 247));
        btnCerrarSesion.setColorOver(new java.awt.Color(176, 179, 185));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCerrarSesion.setRadius(40);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        MenuBotones.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 189, 44));

        btnReporte.setForeground(new java.awt.Color(55, 0, 43));
        btnReporte.setText("Reporte semanal");
        btnReporte.setBorderColor(new java.awt.Color(55, 36, 85));
        btnReporte.setColor(new java.awt.Color(226, 232, 247));
        btnReporte.setColorOver(new java.awt.Color(176, 179, 185));
        btnReporte.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnReporte.setRadius(40);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        MenuBotones.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 189, 44));

        PanelRoundFondo.add(MenuBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRoundFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRoundFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private int idCuentaPanel0;

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombre = lblNombreCuenta.getText();
        String tipo = lblTipoCuenta.getText();
        String banco = lblBanco.getText();
        String saldoStr = lblSaldoTotal.getText().replace(" MXN", "").trim();
        double saldo = 0.0;
        try {
            saldo = Double.parseDouble(saldoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el saldo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idCuentaPanel0 != -1) {
            EditarCuentaDialog editarDialog = new EditarCuentaDialog(this, this, idCuentaPanel0, nombre, tipo, banco, numeroCuentaCompletoPanel0, saldo);
            editarDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el ID de la cuenta para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String nombre = lblNombreCuenta.getText();
        int opcion = JOptionPane.showConfirmDialog(Cuentas.this, "¿Estás seguro de eliminar la cuenta '" + nombre + "'?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            if (idCuentaPanel0 != -1) {
                eliminarCuenta(idCuentaPanel0);
            } else {
                JOptionPane.showMessageDialog(Cuentas.this, "No se pudo obtener el ID de la cuenta para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        String nombreCuenta = lblNombreCuenta.getText();
        Transacciones transaccionesForm = new Transacciones(idUsuario, nombreCuenta);
        transaccionesForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        AgregarCuentaDialog agregarDialog = new AgregarCuentaDialog(this, true, this, idUsuario);
        agregarDialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        new Dashboard(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        new Cuentas(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnTransacciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransacciones1ActionPerformed
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        new Transacciones(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransacciones1ActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        new Categorias(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            String reportPath = getClass().getClassLoader().getResource("Reports/Reporte_.jrxml").getPath();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            java.util.Map<String, Object> parameters = new java.util.HashMap<>();
            parameters.put("idUsuario", this.idUsuario);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, reg);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnReporteActionPerformed

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
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Logo;
    private Items.PanelRound MenuBotones;
    private Items.PanelRound PanelCuenta0;
    private Items.PanelRound PanelRoundFondo;
    private Items.MyButton btnAgregarCuenta;
    private Items.MyButton btnCategorias;
    private javax.swing.JButton btnCerrar;
    private Items.MyButton btnCerrarSesion;
    private Items.MyButton btnCuentas;
    private Items.MyButton btnDashboard;
    private Items.MyButton btnEditar;
    private Items.MyButton btnEliminar;
    private Items.MyButton btnReporte;
    private Items.MyButton btnTransacciones;
    private Items.MyButton btnTransacciones1;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblNombreCuenta;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoTotal;
    private javax.swing.JLabel lblTipoCuenta;
    private javax.swing.JLabel lblUltimos4;
    // End of variables declaration//GEN-END:variables

    private String numeroCuentaCompletoPanel0;

    void cargarCuentas() {
        String sql = "SELECT idCuenta, Nombre, Tipo, Banco, NumeroCuenta, SUBSTR(NumeroCuenta, -4) AS ultimos4, Saldo FROM cuenta WHERE idUsuario = ?";

        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();

            java.util.List<java.awt.Component> componentesToRemove = new java.util.ArrayList<>();
            for (java.awt.Component comp : PanelRoundFondo.getComponents()) {
                if (comp instanceof Items.PanelRound && comp != MenuBotones) {
                    componentesToRemove.add(comp);
                }
            }
            for (java.awt.Component comp : componentesToRemove) {
                PanelRoundFondo.remove(comp);
            }
            int y = 100; 
            if (rs.next()) {
                Items.PanelRound primerPanelCuenta = crearPanelCuenta(
                        rs.getInt("idCuenta"),
                        rs.getString("Nombre"),
                        rs.getString("Tipo"),
                        rs.getString("Banco"),
                        rs.getString("NumeroCuenta"),
                        rs.getString("ultimos4"),
                        rs.getDouble("Saldo"),
                        y
                );
                PanelRoundFondo.add(primerPanelCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, y, 1130, 220));
                y += 240;

                while (rs.next()) {
                    Items.PanelRound nuevoPanelCuenta = crearPanelCuenta(
                            rs.getInt("idCuenta"),
                            rs.getString("Nombre"),
                            rs.getString("Tipo"),
                            rs.getString("Banco"),
                            rs.getString("NumeroCuenta"),
                            rs.getString("ultimos4"),
                            rs.getDouble("Saldo"),
                            y
                    );
                    PanelRoundFondo.add(nuevoPanelCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, y, 1130, 220));
                    y += 240;
                }
            }

            PanelRoundFondo.repaint();
            PanelRoundFondo.revalidate();
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);

        } catch (SQLException e) {
            System.out.println("Error al cargar cuentas: " + e.getMessage());
        }
    }

    private Items.PanelRound crearPanelCuenta(int idCuenta, String nombre, String tipo, String banco, String numeroCuentaCompleto, String ultimos4, double saldo, int y) {
        Items.PanelRound panelCuenta = new Items.PanelRound();
        panelCuenta.setBackground(new java.awt.Color(245, 245, 245));
        panelCuenta.setRoundTopLeft(50);
        panelCuenta.setRoundTopRight(50);
        panelCuenta.setRoundBottomLeft(50);
        panelCuenta.setRoundBottomRight(50);
        panelCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.JLabel lblNombre = new javax.swing.JLabel(nombre);
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18));
        panelCuenta.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, -1));

        javax.swing.JLabel lblTipo = new javax.swing.JLabel(tipo);
        lblTipo.setForeground(new java.awt.Color(102, 102, 102));
        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 16));
        panelCuenta.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, -1));

        javax.swing.JLabel lblBanco = new javax.swing.JLabel(banco);
        lblBanco.setForeground(new java.awt.Color(102, 102, 102));
        lblBanco.setFont(new java.awt.Font("Segoe UI", 0, 16));
        panelCuenta.add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 300, -1));

        javax.swing.JLabel lblUltimos = new javax.swing.JLabel("**** " + ultimos4);
        lblUltimos.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblUltimos.setForeground(new java.awt.Color(102, 102, 102));
        panelCuenta.add(lblUltimos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, -1));

        javax.swing.JLabel lblSaldoNueva = new javax.swing.JLabel("Saldo");
        lblSaldoNueva.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblSaldoNueva.setForeground(new java.awt.Color(102, 102, 102));
        panelCuenta.add(lblSaldoNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 50, -1));

        javax.swing.JLabel lblSaldoCuenta = new javax.swing.JLabel(saldo + " MXN");
        lblSaldoCuenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoCuenta.setFont(new java.awt.Font("Segoe UI", 0, 46));
        lblSaldoCuenta.setForeground(new java.awt.Color(70, 155, 74));
        panelCuenta.add(lblSaldoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 350, -1));

        Items.MyButton btnEditarNuevo = new Items.MyButton();
        btnEditarNuevo.setText("Editar");
        btnEditarNuevo.setColor(new java.awt.Color(226, 232, 247));
        btnEditarNuevo.setBorderColor(new java.awt.Color(245, 245, 245));
        btnEditarNuevo.setColorOver(new java.awt.Color(176, 179, 185));
        btnEditarNuevo.setFont(new java.awt.Font("Segoe UI", 0, 15));
        btnEditarNuevo.setRadius(40);
        btnEditarNuevo.setForeground(new java.awt.Color(55, 0, 43));
        panelCuenta.add(btnEditarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 120, 44));
        btnEditarNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditarCuentaDialog editarDialog = new EditarCuentaDialog(Cuentas.this, Cuentas.this, idCuenta, nombre, tipo, banco, numeroCuentaCompleto, saldo);
                editarDialog.setVisible(true);
            }
        });

        Items.MyButton btnEliminarNuevo = new Items.MyButton();
        btnEliminarNuevo.setText("Eliminar");
        btnEliminarNuevo.setColor(new java.awt.Color(226, 232, 247));
        btnEliminarNuevo.setBorderColor(new java.awt.Color(245, 245, 245));
        btnEliminarNuevo.setColorOver(new java.awt.Color(176, 179, 185));
        btnEliminarNuevo.setFont(new java.awt.Font("Segoe UI", 0, 15));
        btnEliminarNuevo.setRadius(40);
        btnEliminarNuevo.setForeground(new java.awt.Color(55, 0, 43));
        panelCuenta.add(btnEliminarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 160, 120, 44));
        btnEliminarNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreCuentaAEliminar = nombre;
                int opcion = JOptionPane.showConfirmDialog(Cuentas.this, "¿Estás seguro de eliminar la cuenta '" + nombreCuentaAEliminar + "'?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    eliminarCuenta(idCuenta);
                }
            }
        });

        Items.MyButton btnTransaccionesNuevo = new Items.MyButton();
        btnTransaccionesNuevo.setText("Ver transacciones");
        btnTransaccionesNuevo.setColor(new java.awt.Color(226, 232, 247));
        btnTransaccionesNuevo.setBorderColor(new java.awt.Color(245, 245, 245));
        btnTransaccionesNuevo.setColorOver(new java.awt.Color(176, 179, 185));
        btnTransaccionesNuevo.setFont(new java.awt.Font("Segoe UI", 0, 15));
        btnTransaccionesNuevo.setRadius(40);
        btnTransaccionesNuevo.setForeground(new java.awt.Color(55, 0, 43));
        panelCuenta.add(btnTransaccionesNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 180, 44));
        btnTransaccionesNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FlatRobotoFont.install();
                FlatLaf.registerCustomDefaultsSource("tableview");
                UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
                FlatMacDarkLaf.setup();
                Transacciones transaccionesForm = new Transacciones(idUsuario, nombre);
                transaccionesForm.setVisible(true);
                dispose();
            }
        });

        return panelCuenta;
    }

    private void eliminarCuenta(int idCuentaAEliminar) {
        String sql = "DELETE FROM cuenta WHERE idCuenta = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idCuentaAEliminar);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarCuentas();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cuenta: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al eliminar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
