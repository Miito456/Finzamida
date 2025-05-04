package Forms;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import finzamida.Conexion;
import finzamida.UIUtils;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import java.awt.Font;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class Dashboard extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();
    private int idUsuario;

    public Dashboard(int idUsuario) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);

        } catch (Exception e) {
            System.out.println("Font unavailable" + e);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaHaceUnaSemana = fechaActual.minusDays(7);

        String textoFecha = "Del " + formatter.format(fechaHaceUnaSemana) + " al " + formatter.format(fechaActual);
        lblCobrosFecha.setText(textoFecha);
        lblPagosFecha.setText(textoFecha);
        lblSaldoFecha.setText(textoFecha);
        lblCategoriasFecha.setText(textoFecha);
        this.idUsuario = idUsuario;
        cargarTotalIngresos();
        cargarTotalEgresos();
        cargarSaldoTotal();
        cargarGraficoCategorias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRoundFondo = new Items.PanelRound();
        btnCerrar = new javax.swing.JButton();
        MenuBotones = new Items.PanelRound();
        Logo = new UIUtils.LogoPanel();
        btnDashboard = new Items.MyButton();
        btnCuentas = new Items.MyButton();
        btnTransacciones = new Items.MyButton();
        btnCategorias = new Items.MyButton();
        btnCerrarSesion = new Items.MyButton();
        btnReporte = new Items.MyButton();
        PanelCobros = new Items.PanelRound();
        lblCobros = new javax.swing.JLabel();
        lblCobrosFecha = new javax.swing.JLabel();
        lblCobrosProfit = new javax.swing.JLabel();
        PanelPagos = new Items.PanelRound();
        lblPagos = new javax.swing.JLabel();
        lblPagosFecha = new javax.swing.JLabel();
        lblPagosProfit = new javax.swing.JLabel();
        PanelSaldo = new Items.PanelRound();
        lblSaldo = new javax.swing.JLabel();
        lblSaldoFecha = new javax.swing.JLabel();
        lblSaldoProfit = new javax.swing.JLabel();
        PanelIngresos = new Items.PanelRound();
        lblCategorias = new javax.swing.JLabel();
        lblCategoriasFecha = new javax.swing.JLabel();

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

        btnTransacciones.setForeground(new java.awt.Color(55, 0, 43));
        btnTransacciones.setText("Transacciones");
        btnTransacciones.setBorderColor(new java.awt.Color(55, 36, 85));
        btnTransacciones.setColor(new java.awt.Color(226, 232, 247));
        btnTransacciones.setColorOver(new java.awt.Color(176, 179, 185));
        btnTransacciones.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnTransacciones.setRadius(40);
        btnTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionesActionPerformed(evt);
            }
        });
        MenuBotones.add(btnTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 189, 44));

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

        PanelCobros.setBackground(new java.awt.Color(245, 245, 245));
        PanelCobros.setRoundBottomLeft(50);
        PanelCobros.setRoundBottomRight(50);
        PanelCobros.setRoundTopLeft(50);
        PanelCobros.setRoundTopRight(50);

        lblCobros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCobros.setForeground(new java.awt.Color(0, 0, 0));
        lblCobros.setText("Cobros");

        lblCobrosFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCobrosFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblCobrosFecha.setText("[Fecha]");

        lblCobrosProfit.setFont(new java.awt.Font("Segoe UI", 0, 46)); // NOI18N
        lblCobrosProfit.setForeground(new java.awt.Color(70, 155, 74));
        lblCobrosProfit.setText("000000.00 MXN");

        javax.swing.GroupLayout PanelCobrosLayout = new javax.swing.GroupLayout(PanelCobros);
        PanelCobros.setLayout(PanelCobrosLayout);
        PanelCobrosLayout.setHorizontalGroup(
            PanelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCobrosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCobros, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCobrosProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCobrosFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        PanelCobrosLayout.setVerticalGroup(
            PanelCobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCobrosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCobros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCobrosFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCobrosProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        PanelRoundFondo.add(PanelCobros, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 440, 170));

        PanelPagos.setBackground(new java.awt.Color(245, 245, 245));
        PanelPagos.setRoundBottomLeft(50);
        PanelPagos.setRoundBottomRight(50);
        PanelPagos.setRoundTopLeft(50);
        PanelPagos.setRoundTopRight(50);

        lblPagos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPagos.setForeground(new java.awt.Color(0, 0, 0));
        lblPagos.setText("Pagos");

        lblPagosFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPagosFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblPagosFecha.setText("[Fecha]");

        lblPagosProfit.setFont(new java.awt.Font("Segoe UI", 0, 46)); // NOI18N
        lblPagosProfit.setForeground(new java.awt.Color(209, 85, 84));
        lblPagosProfit.setText("000000.00 MXN");

        javax.swing.GroupLayout PanelPagosLayout = new javax.swing.GroupLayout(PanelPagos);
        PanelPagos.setLayout(PanelPagosLayout);
        PanelPagosLayout.setHorizontalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPagosProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPagosFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        PanelPagosLayout.setVerticalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPagos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPagosFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPagosProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        PanelRoundFondo.add(PanelPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 440, 170));

        PanelSaldo.setBackground(new java.awt.Color(245, 245, 245));
        PanelSaldo.setRoundBottomLeft(50);
        PanelSaldo.setRoundBottomRight(50);
        PanelSaldo.setRoundTopLeft(50);
        PanelSaldo.setRoundTopRight(50);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(0, 0, 0));
        lblSaldo.setText("Transacciones");

        lblSaldoFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSaldoFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblSaldoFecha.setText("[Fecha]");

        lblSaldoProfit.setBackground(new java.awt.Color(0, 0, 0));
        lblSaldoProfit.setFont(new java.awt.Font("Segoe UI", 0, 46)); // NOI18N
        lblSaldoProfit.setText("000000.00 MXN");

        javax.swing.GroupLayout PanelSaldoLayout = new javax.swing.GroupLayout(PanelSaldo);
        PanelSaldo.setLayout(PanelSaldoLayout);
        PanelSaldoLayout.setHorizontalGroup(
            PanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaldoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldoProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        PanelSaldoLayout.setVerticalGroup(
            PanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSaldoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldoFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldoProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        PanelRoundFondo.add(PanelSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, -1, -1));

        PanelIngresos.setBackground(new java.awt.Color(245, 245, 245));
        PanelIngresos.setRoundBottomLeft(50);
        PanelIngresos.setRoundBottomRight(50);
        PanelIngresos.setRoundTopLeft(50);
        PanelIngresos.setRoundTopRight(50);

        lblCategorias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCategorias.setForeground(new java.awt.Color(0, 0, 0));
        lblCategorias.setText("Categorías");

        lblCategoriasFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCategoriasFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasFecha.setText("[Fecha]");

        javax.swing.GroupLayout PanelIngresosLayout = new javax.swing.GroupLayout(PanelIngresos);
        PanelIngresos.setLayout(PanelIngresosLayout);
        PanelIngresosLayout.setHorizontalGroup(
            PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoriasFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 178, Short.MAX_VALUE))
        );
        PanelIngresosLayout.setVerticalGroup(
            PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCategoriasFecha)
                .addContainerGap(514, Short.MAX_VALUE))
        );

        PanelRoundFondo.add(PanelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 650, 590));

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

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        new Categorias(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        new Dashboard(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        new Transacciones(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        new Cuentas(idUsuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            String reportPath = getClass().getClassLoader().getResource("Reports/ReporteSemanal.jrxml").getPath();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            java.util.Map<String, Object> parameters = new java.util.HashMap<>();
            parameters.put("idUsuario", this.idUsuario);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, reg);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            int x = this.getX();
            int y = this.getY();
            int width = this.getWidth();
            int height = this.getHeight();
            viewer.setBounds(x, y, width, height);
            viewer.setZoomRatio(0.63f);
            viewer.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Logo;
    private Items.PanelRound MenuBotones;
    private Items.PanelRound PanelCobros;
    private Items.PanelRound PanelIngresos;
    private Items.PanelRound PanelPagos;
    private Items.PanelRound PanelRoundFondo;
    private Items.PanelRound PanelSaldo;
    private Items.MyButton btnCategorias;
    private javax.swing.JButton btnCerrar;
    private Items.MyButton btnCerrarSesion;
    private Items.MyButton btnCuentas;
    private Items.MyButton btnDashboard;
    private Items.MyButton btnReporte;
    private Items.MyButton btnTransacciones;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblCategoriasFecha;
    private javax.swing.JLabel lblCobros;
    private javax.swing.JLabel lblCobrosFecha;
    private javax.swing.JLabel lblCobrosProfit;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblPagosFecha;
    private javax.swing.JLabel lblPagosProfit;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoFecha;
    private javax.swing.JLabel lblSaldoProfit;
    // End of variables declaration//GEN-END:variables

    private void cargarGraficoCategorias() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String consulta = "SELECT c.Nombre, SUM(t.Monto) AS TotalPagado "
                + "FROM categorias c "
                + "INNER JOIN transacciones t ON c.idCategoria = t.idCategoria "
                + "WHERE t.idUsuario = ? AND t.Tipo = 'Egreso' AND t.Fecha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) "
                + "GROUP BY c.Nombre "
                + "HAVING SUM(t.Monto) > 0"; // Solo categorías con pagos

        try (PreparedStatement ps = reg.prepareStatement(consulta)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreCategoria = rs.getString("Nombre");
                double totalPagado = rs.getDouble("TotalPagado");
                dataset.setValue(nombreCategoria, totalPagado);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos para el gráfico de categorías: " + e.getMessage());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "", // Título del gráfico
                dataset, // Datos
                true, // Incluir leyenda
                true, // Tooltips
                false // URLs
        );

     
        // Cambiar la fuente del título
        Font tituloFont = new Font("Manrope-SemiBold", Font.BOLD, 18);
        chart.getTitle().setFont(tituloFont);
        chart.getTitle().setPaint(new Color(37, 25, 57));

        // Obtener el plot del gráfico de pastel
        PiePlot plot = (PiePlot) chart.getPlot();

        // Cambiar la fuente de las etiquetas de las secciones
        Font etiquetaFont = new Font("Manrope-SemiBold", Font.PLAIN, 14);
        plot.setLabelFont(etiquetaFont);
        plot.setLabelBackgroundPaint(new Color(245, 245, 245));
        plot.setLabelOutlinePaint(null);
        plot.setShadowPaint(null);

        // Cambiar los colores de las secciones del pastel
        Color[] coloresPersonalizados = {
            new Color(123, 104, 238), // Morado
            new Color(255, 165, 0), // Naranja
            new Color(46, 139, 87), // Verde
            new Color(255, 99, 71), // Rojo
            new Color(70, 130, 180), // Azul
            new Color(255, 215, 0), // Dorado
        };
        int i = 0;
        for (Object key : dataset.getKeys()) {
            plot.setSectionPaint((Comparable) key, coloresPersonalizados[i % coloresPersonalizados.length]);
            i++;
        }

        chart.setBackgroundPaint(new Color(245, 245, 245)); 
        plot.setBackgroundPaint(new Color(245, 245, 245));
        plot.setOutlineVisible(false);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("###,###.##"), new DecimalFormat("0.0%"));
        plot.setLabelGenerator(labelGenerator);

        ChartPanel chartPanel = new ChartPanel(chart);

        int x = 20; 
        int y = 20 + lblCategorias.getHeight() + 5 + lblCategoriasFecha.getHeight() + 5; 
        int ancho = PanelIngresos.getWidth() - 40; 
        int alto = PanelIngresos.getHeight() - 100; 
        chartPanel.setBounds(x, y, ancho, alto);

        PanelIngresos.removeAll();
        PanelIngresos.add(lblCategorias);
        PanelIngresos.add(lblCategoriasFecha);
        PanelIngresos.add(chartPanel);

        PanelIngresos.revalidate();
        PanelIngresos.repaint();
    }

    private void cargarSaldoTotal() {
        double totalIngresosSemana = 0.0;
        double totalEgresosSemana = 0.0;

        String consultaIngresos = "SELECT SUM(Monto) AS totalIngresos FROM transacciones WHERE idUsuario = ? AND Tipo = 'Ingreso' AND Fecha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";
        String consultaEgresos = "SELECT SUM(Monto) AS totalEgresos FROM transacciones WHERE idUsuario = ? AND Tipo = 'Egreso' AND Fecha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";

        try (PreparedStatement psIngresos = reg.prepareStatement(consultaIngresos); PreparedStatement psEgresos = reg.prepareStatement(consultaEgresos)) {

            psIngresos.setInt(1, idUsuario);
            ResultSet rsIngresos = psIngresos.executeQuery();
            if (rsIngresos.next()) {
                totalIngresosSemana = rsIngresos.getDouble("totalIngresos");
            }

            psEgresos.setInt(1, idUsuario);
            ResultSet rsEgresos = psEgresos.executeQuery();
            if (rsEgresos.next()) {
                totalEgresosSemana = rsEgresos.getDouble("totalEgresos");
            }

            double saldoSemanal = totalIngresosSemana - totalEgresosSemana;
            lblSaldoProfit.setText(String.format("%.2f MXN", saldoSemanal));
            lblSaldoProfit.setForeground(new java.awt.Color(0, 0, 0)); 

        } catch (SQLException e) {
            System.out.println("Error al calcular el saldo semanal: " + e.getMessage());
            lblSaldoProfit.setText("Error"); 
        }
    }

    private void cargarTotalIngresos() {
        String consulta = "SELECT SUM(Monto) AS totalIngresos FROM transacciones WHERE idUsuario = ? AND Tipo = 'Ingreso' AND Fecha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";
        try (PreparedStatement ps = reg.prepareStatement(consulta)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double totalIngresos = rs.getDouble("totalIngresos");
                lblCobrosProfit.setText(String.format("%.2f MXN", totalIngresos));
            } else {
                lblCobrosProfit.setText("0.00 MXN"); 
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ingresos de la semana: " + e.getMessage());
            lblCobrosProfit.setText("Error"); 
        }
    }

    private void cargarTotalEgresos() {
        String consulta = "SELECT SUM(Monto) AS totalEgresos FROM transacciones WHERE idUsuario = ? AND Tipo = 'Egreso' AND Fecha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";
        try (PreparedStatement ps = reg.prepareStatement(consulta)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double totalEgresos = rs.getDouble("totalEgresos");
                lblPagosProfit.setText(String.format("%.2f MXN", totalEgresos));
            } else {
                lblPagosProfit.setText("0.00 MXN"); 
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener egresos de la semana: " + e.getMessage());
            lblPagosProfit.setText("Error"); 
        }
    }

}
