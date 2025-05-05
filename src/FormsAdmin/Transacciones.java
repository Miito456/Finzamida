package FormsAdmin;

import Forms.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import finzamida.Conexion;
import finzamida.UIUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import finzamida.UIUtils;

public class Transacciones extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();
    private String nombreUsuarioConsulta;
    private TableRowSorter<DefaultTableModel> sorter;

    public Transacciones() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        applyTableStyle(jTable1);
        cargarDatosTabla();

        sorter = new TableRowSorter<>((DefaultTableModel) jTable1.getModel());
        jTable1.setRowSorter(sorter);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);

        } catch (Exception e) {
            System.out.println("Font unavailable" + e);
        }

    }

    public Transacciones(String nombreUsuario) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        applyTableStyle(jTable1);
        sorter = new TableRowSorter<>((DefaultTableModel) jTable1.getModel());
        jTable1.setRowSorter(sorter);
        txtSearch.setText(nombreUsuario); 
        filterTable(); 
        setupSearchFilter(); 
        applyCustomFont();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRoundFondo = new Items.PanelRound();
        btnCerrar = new javax.swing.JButton();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MenuBotones = new Items.PanelRound();
        Logo = new UIUtils.LogoPanel();
        btnDashboard = new Items.MyButton();
        btnCuentas = new Items.MyButton();
        btnTransacciones = new Items.MyButton();
        btnCategorias = new Items.MyButton();
        btnCerrarSesion = new Items.MyButton();
        btnReporte = new Items.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finzamida");
        setBackground(new java.awt.Color(55, 0, 43));
        setSize(new java.awt.Dimension(1434, 750));

        PanelRoundFondo.setBackground(new java.awt.Color(37, 25, 57));
        PanelRoundFondo.setForeground(new java.awt.Color(255, 255, 255));
        PanelRoundFondo.setMinimumSize(new java.awt.Dimension(1434, 750));
        PanelRoundFondo.setPreferredSize(new java.awt.Dimension(1434, 750));
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
        PanelRoundFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 20, -1, -1));

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));
        crazyPanel2.add(txtSearch);

        cmdAdd.setText("Add New");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdAdd);

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdUpdate);

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdDelete);

        crazyPanel1.add(crazyPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Cuenta", "Cuenta", "Categoría", "Fecha", "Cantidad", "Usuario", "Descripcion", "idUsuario", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        crazyPanel1.add(jScrollPane1);

        PanelRoundFondo.add(crazyPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 1130, 610));

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
        btnReporte.setText("Usuarios");
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
            .addComponent(PanelRoundFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRoundFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        NuevoTransaccionDialogAdmin nuevoDialog = new NuevoTransaccionDialogAdmin(this, this);
        nuevoDialog.setVisible(true);
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed

        int selectedCount = 0;
        int rowToUpdate = -1;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                selectedCount++;
                rowToUpdate = i;
            }
        }

        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una transacción para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selectedCount > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona solo una transacción para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (rowToUpdate != -1) {

            int idTransaccion = -1;
            try {
                idTransaccion = (int) jTable1.getValueAt(rowToUpdate, 1);
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener el ID de la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nombreCuentaCompleto = (String) jTable1.getValueAt(rowToUpdate, 2);
            String nombreCategoria = (String) jTable1.getValueAt(rowToUpdate, 3);
            String fecha = (String) jTable1.getValueAt(rowToUpdate, 4);
            double monto = (double) jTable1.getValueAt(rowToUpdate, 5);
            String tipo = (String) jTable1.getValueAt(rowToUpdate, 6);
            String concepto = "";

            String nombreCuenta = nombreCuentaCompleto.split(" \\(")[0];

            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            int idUsuarioOriginal = -1;

            try {
                String sql = "SELECT Descripcion, t.idUsuario FROM transacciones t WHERE idTransacciones = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, idTransaccion);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    concepto = rs.getString("Descripcion");
                    idUsuarioOriginal = rs.getInt("idUsuario");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener el concepto y el ID del usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            ActualizarTransaccionDialog updateDialog = new ActualizarTransaccionDialog(
                    this,
                    this,
                    idTransaccion,
                    nombreCuenta,
                    nombreCategoria,
                    fecha,
                    monto,
                    tipo,
                    concepto,
                    idUsuarioOriginal 
            );
            updateDialog.setVisible(true);
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        int selectedCount = 0;
        int rowToDelete = -1;
        int idTransaccionToDelete = -1;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                selectedCount++;
                rowToDelete = i;
                try {
                    idTransaccionToDelete = (int) jTable1.getValueAt(i, 1);
                } catch (ClassCastException e) {
                    JOptionPane.showMessageDialog(this, "Error al obtener el ID de la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una transacción para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selectedCount > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona solo una transacción para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (rowToDelete != -1 && idTransaccionToDelete != -1) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar la transacción seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                eliminarTransaccion(idTransaccionToDelete);
            }
        }

    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        new Usuarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        new Categorias().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        new Transacciones().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        new Cuentas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        new DashboardAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Logo;
    private Items.PanelRound MenuBotones;
    private Items.PanelRound PanelRoundFondo;
    private Items.MyButton btnCategorias;
    private javax.swing.JButton btnCerrar;
    private Items.MyButton btnCerrarSesion;
    private Items.MyButton btnCuentas;
    private Items.MyButton btnDashboard;
    private Items.MyButton btnReporte;
    private Items.MyButton btnTransacciones;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdUpdate;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    void cargarDatosTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT "
                    + "    t.idTransacciones, "
                    + "    t.Fecha, "
                    + "    t.Monto, "
                    + "    u.Nombre AS NombreUsuario, "
                    + "    c.Nombre AS NombreCategoria, "
                    + "    cu.Nombre AS NombreCuenta, "
                    + "    SUBSTRING(cu.NumeroCuenta, -4) AS Ultimos4Digitos, "
                    + "    t.Descripcion, "
                    + "    t.idUsuario, "
                    + "    t.Tipo "
                    + "FROM transacciones t "
                    + "JOIN categorias c ON t.idCategoria = c.idCategoria "
                    + "JOIN cuenta cu ON t.idCuenta = cu.idCuenta "
                    + "JOIN usuarios u ON cu.idUsuario = u.idUsuario "
                    + "ORDER BY t.Fecha DESC";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idTransacciones = rs.getInt("idTransacciones");
                java.sql.Date fechaSQL = rs.getDate("Fecha");
                String fecha = (fechaSQL != null) ? fechaSQL.toString() : "";
                double monto = rs.getDouble("Monto");
                String nombreUsuario = rs.getString("NombreUsuario");
                String nombreCategoria = rs.getString("NombreCategoria");
                String nombreCuenta = rs.getString("NombreCuenta");
                String ultimos4Digitos = rs.getString("Ultimos4Digitos");
                String descripcion = rs.getString("Descripcion");
                int idUsuarioTabla = rs.getInt("idUsuario");
                String tipoTransaccion = rs.getString("Tipo"); // Obtenemos el tipo de transacción

                model.addRow(new Object[]{false, idTransacciones, nombreCuenta + " (..." + ultimos4Digitos + ")", nombreCategoria, fecha, monto, nombreUsuario, descripcion, idUsuarioTabla, tipoTransaccion}); // Añadimos el tipo
            }

            if (jTable1.getColumnCount() > 1) {
                jTable1.getColumnModel().getColumn(1).setMinWidth(0);
                jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
            }
            if (jTable1.getColumnCount() > 7) {
                jTable1.getColumnModel().getColumn(7).setMinWidth(0);
                jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            }
            if (jTable1.getColumnCount() > 8) {
                jTable1.getColumnModel().getColumn(8).setMinWidth(0);
                jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            }
            if (jTable1.getColumnCount() > 9) {
                jTable1.getColumnModel().getColumn(9).setMinWidth(0);
                jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Estilos del formualrio
    private void applyTableStyle(JTable table) {

        cmdAdd.setIcon(new FlatSVGIcon("tableview/icon/add.svg", 0.35f));
        cmdUpdate.setIcon(new FlatSVGIcon("tableview/icon/edit.svg", 0.35f));
        cmdDelete.setIcon(new FlatSVGIcon("tableview/icon/delete.svg", 0.35f));
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("tableview/icon/search.svg", 0.35f));
        JScrollPane scroll = (JScrollPane) table.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background;"
                + "track:$Table.background;"
                + "trackArc:999");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        table.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        table.getTableHeader().setDefaultRenderer(getAlignmentCellRender(table.getTableHeader().getDefaultRenderer(), true));
        table.setDefaultRenderer(Object.class, getAlignmentCellRender(table.getDefaultRenderer(Object.class), false));
    }

    private TableCellRenderer getAlignmentCellRender(TableCellRenderer oldRender, boolean header) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = oldRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (com instanceof JLabel) {
                    JLabel label = (JLabel) com;
                    if (column == 0 || column == 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else if (column == 2 || column == 3) {
                        label.setHorizontalAlignment(SwingConstants.TRAILING);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
                    }
                    if (header == false) {
                        if (column == 5) { 
                            String tipo = table.getValueAt(row, 9).toString();
                            double monto = Double.parseDouble(value.toString());
                            DecimalFormat formato = new DecimalFormat("#,##0.00");

                            if (tipo.equalsIgnoreCase("Ingreso")) {
                                label.setForeground(new Color(17, 182, 60));
                                label.setText("+" + formato.format(monto));
                            } else if (tipo.equalsIgnoreCase("Egreso")) {
                                label.setForeground(new Color(202, 48, 48));
                                label.setText("-" + formato.format(monto));
                            } else {
                                label.setForeground(Color.GRAY);
                                label.setText(formato.format(monto));
                            }
                        } else {
                            if (isSelected) {
                                com.setForeground(table.getSelectionForeground());
                            } else {
                                com.setForeground(table.getForeground());
                            }
                        }
                    }

                }
                return com;
            }
        };
    }

    private void eliminarTransaccion(int idTransaccion) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        PreparedStatement pstmt = null;

        try {
            String sql = "DELETE FROM transacciones WHERE idTransacciones = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idTransaccion);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Transacción eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la transacción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Barra de busqueda
    private void setupSearchFilter() {
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
    }

    private void applyCustomFont() {
        try {
            Font customFont = UIUtils.loadCustomFont("Manrope-SemiBold.ttf").deriveFont(Font.PLAIN);
            UIUtils.setFontRecursively(PanelRoundFondo, customFont);
        } catch (Exception e) {
            System.out.println("Font unavailable" + e);
        }
    }

    private void filterTable() {
        String text = txtSearch.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
}
