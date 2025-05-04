package Forms;

import finzamida.UIUtils;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

public class Main extends javax.swing.JFrame {

    public Main() {

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        try {

            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);
            txtTitulo.setFont(loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN, 50));
            texto.setFont(loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN, 20));
            text.setBorder(null);
            //text1.setBorder(null);
            //text1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            //text1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        } catch (Exception e) {
            System.out.println("Font unvaliable" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRoundFondo = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        Logo = new LogoPanel();
        jButton4 = new javax.swing.JButton();
        txtEslogan1 = new javax.swing.JLabel();
        text = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnIniciarSesion = new Items.MyButton();
        btnAdmin = new Items.MyButton();
        ImagePanel1 = new StatsPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelRoundFondo.setBackground(new java.awt.Color(37, 25, 57));
        PanelRoundFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Finzamida");
        PanelRoundFondo.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 620, 70));

        Logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelRoundFondo.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 180, 180));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("X");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PanelRoundFondo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1412, 6, -1, -1));

        txtEslogan1.setBackground(new java.awt.Color(255, 255, 255));
        txtEslogan1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        txtEslogan1.setForeground(new java.awt.Color(255, 255, 255));
        txtEslogan1.setText("Toma control de tus finanzas");
        PanelRoundFondo.add(txtEslogan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 761, 90));

        texto.setEditable(false);
        texto.setBackground(new java.awt.Color(37, 25, 57));
        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setRows(5);
        texto.setText("Finzamida es una aplicación de finanzas personales \nque facilita la gestión del dinero. \nEstá diseñada para optimizar el seguimiento de gastos y ayudarte \na ahorrar dinero.");
        texto.setBorder(null);
        texto.setCaretColor(new java.awt.Color(37, 25, 57));
        text.setViewportView(texto);

        PanelRoundFondo.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 700, 180));

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

        btnIniciarSesion.setForeground(new java.awt.Color(55, 0, 43));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setBorderColor(new java.awt.Color(55, 36, 85));
        btnIniciarSesion.setColor(new java.awt.Color(226, 232, 247));
        btnIniciarSesion.setColorOver(new java.awt.Color(176, 179, 185));
        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnIniciarSesion.setRadius(40);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        PanelRoundFondo.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 189, 44));

        btnAdmin.setForeground(new java.awt.Color(55, 0, 43));
        btnAdmin.setText("Administrador");
        btnAdmin.setBorderColor(new java.awt.Color(55, 36, 85));
        btnAdmin.setColor(new java.awt.Color(226, 232, 247));
        btnAdmin.setColorOver(new java.awt.Color(176, 179, 185));
        btnAdmin.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAdmin.setRadius(40);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        PanelRoundFondo.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, 189, 44));

        ImagePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelRoundFondo.add(ImagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 530, 620));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRoundFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelRoundFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        new Login().setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagePanel1;
    private javax.swing.JPanel Logo;
    private javax.swing.JPanel PanelRoundFondo;
    private Items.MyButton btnAdmin;
    private Items.MyButton btnIniciarSesion;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane text;
    private javax.swing.JTextArea texto;
    private javax.swing.JLabel txtEslogan1;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    class LogoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/logo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    private Font loadCustomFont(String fontName) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
            return customFont.deriveFont(Font.PLAIN, 16);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 16);
        }
    }

    class StatsPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/Imagen.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
