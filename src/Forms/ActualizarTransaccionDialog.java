package Forms;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import finzamida.Conexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;

public class ActualizarTransaccionDialog extends JDialog {

    private int idUsuario;
    private int idTransaccionParaActualizar;
    private JComboBox<String> cuentaComboBox;
    private JTextField conceptoTextField;
    private JComboBox<String> tipoComboBox;
    private JTextField cantidadTextField;
    private JDateChooser fechaChooser;
    private JComboBox<String> etiquetaComboBox;
    private JButton guardarButton;
    private JButton cancelarButton;
    private Transacciones transaccionesForm;
    private double montoOriginal;
    private String tipoOriginal;
    private int idCuentaOriginal;

    public ActualizarTransaccionDialog(JFrame owner, int idUsuario, Transacciones transaccionesForm,
                                        int idTransaccion, String cuenta, String etiqueta,
                                        String fecha, double monto, String tipo, String concepto) {
        super(owner, "Actualizar Transacción", true);
        this.idUsuario = idUsuario;
        this.transaccionesForm = transaccionesForm;
        this.idTransaccionParaActualizar = idTransaccion;
        this.montoOriginal = monto;
        this.tipoOriginal = tipo;
        initComponents();
        pack();
        setSize(new Dimension(500, 350));
        llenarComboBoxes();
        precargarDatos(cuenta, etiqueta, fecha, monto, tipo, concepto);
        setLocationRelativeTo(owner);
        obtenerIdCuentaOriginal(cuenta);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0x251939));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel cuentaLabel = new JLabel("Cuenta:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        cuentaLabel.setForeground(Color.WHITE);
        panel.add(cuentaLabel, gbc);

        cuentaComboBox = new JComboBox<>();
        cuentaComboBox.setForeground(Color.WHITE);
        cuentaComboBox.setBackground(new Color(0x251939));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        panel.add(cuentaComboBox, gbc);
        gbc.weightx = 0;

        JLabel conceptoLabel = new JLabel("Concepto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        conceptoLabel.setForeground(Color.WHITE);
        panel.add(conceptoLabel, gbc);

        conceptoTextField = new JTextField();
        conceptoTextField.setForeground(Color.WHITE);
        conceptoTextField.setBackground(new Color(0x251939));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(conceptoTextField, gbc);

        JLabel tipoLabel = new JLabel("Tipo:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        tipoLabel.setForeground(Color.WHITE);
        panel.add(tipoLabel, gbc);

        tipoComboBox = new JComboBox<>(new String[]{"Ingreso", "Egreso"});
        tipoComboBox.setForeground(Color.WHITE);
        tipoComboBox.setBackground(new Color(0x251939));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(tipoComboBox, gbc);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        cantidadLabel.setForeground(Color.WHITE);
        panel.add(cantidadLabel, gbc);

        cantidadTextField = new JTextField();
        cantidadTextField.setForeground(Color.WHITE);
        cantidadTextField.setBackground(new Color(0x251939));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cantidadTextField, gbc);

        JLabel fechaLabel = new JLabel("Fecha:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        fechaLabel.setForeground(Color.WHITE);
        panel.add(fechaLabel, gbc);

        fechaChooser = new JDateChooser();
        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextFieldDateEditor dateEditor = (JTextFieldDateEditor) fechaChooser.getDateEditor();
        dateEditor.setBackground(Color.decode("#B9BFC9")); 
        panel.add(fechaChooser, gbc);

        JLabel etiquetaLabel = new JLabel("Etiqueta:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        etiquetaLabel.setForeground(Color.WHITE);
        panel.add(etiquetaLabel, gbc);

        etiquetaComboBox = new JComboBox<>();
        etiquetaComboBox.setForeground(Color.WHITE);
        etiquetaComboBox.setBackground(new Color(0x251939));
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(etiquetaComboBox, gbc);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTransaccion();
            }
        });

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(0x251939));
        buttonPanel.add(guardarButton);
        buttonPanel.add(cancelarButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        add(panel);
        pack();
    }

    private void llenarComboBoxes() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlCuentas = "SELECT Nombre FROM cuenta WHERE idUsuario = ?";
            pstmt = con.prepareStatement(sqlCuentas);
            pstmt.setInt(1, idUsuario);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cuentaComboBox.addItem(rs.getString("Nombre"));
            }
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();

            String sqlEtiquetas = "SELECT Nombre FROM categorias WHERE idUsuario = ?";
            pstmt = con.prepareStatement(sqlEtiquetas);
            pstmt.setInt(1, idUsuario); 
            rs = pstmt.executeQuery();
            while (rs.next()) {
                etiquetaComboBox.addItem(rs.getString("Nombre"));
            }
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cuentas o etiquetas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.desconectar();
        }
    }

    private void precargarDatos(String cuenta, String etiqueta, String fecha, double monto, String tipo, String concepto) {
        cuentaComboBox.setSelectedItem(cuenta);
        etiquetaComboBox.setSelectedItem(etiqueta);
        tipoComboBox.setSelectedItem(tipo);
        cantidadTextField.setText(String.valueOf(monto));
        conceptoTextField.setText(concepto);
        try {
            java.util.Date date = java.sql.Date.valueOf(fecha);
            fechaChooser.setDate(date);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void obtenerIdCuentaOriginal(String nombreCuenta) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT idCuenta FROM cuenta WHERE Nombre = ? AND idUsuario = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nombreCuenta);
            pstmt.setInt(2, idUsuario);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                this.idCuentaOriginal = rs.getInt("idCuenta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener ID de la cuenta original: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void guardarTransaccion() {
        String cuenta = (String) cuentaComboBox.getSelectedItem();
        String concepto = conceptoTextField.getText();
        String tipo = (String) tipoComboBox.getSelectedItem();
        String cantidadStr = cantidadTextField.getText();
        Date fecha = fechaChooser.getDate();
        String etiqueta = (String) etiquetaComboBox.getSelectedItem();

        if (cuenta.isEmpty() || concepto.isEmpty() || tipo == null || cantidadStr.isEmpty() || fecha == null || etiqueta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double cantidadNueva = Double.parseDouble(cantidadStr);
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            PreparedStatement pstmtUpdateTransaccion = null;
            PreparedStatement pstmtUpdateSaldo = null;

            int idCuentaNueva = obtenerIdCuenta(con, cuenta);
            int idCategoria = obtenerIdCategoria(con, etiqueta);

            if (idCuentaNueva != -1 && idCategoria != -1) {
                String sqlUpdateTransaccion = "UPDATE transacciones SET idCuenta = ?, idCategoria = ?, Monto = ?, Tipo = ?, Descripcion = ?, Fecha = ? WHERE idTransacciones = ?";
                pstmtUpdateTransaccion = con.prepareStatement(sqlUpdateTransaccion);
                pstmtUpdateTransaccion.setInt(1, idCuentaNueva);
                pstmtUpdateTransaccion.setInt(2, idCategoria);
                pstmtUpdateTransaccion.setDouble(3, cantidadNueva);
                pstmtUpdateTransaccion.setString(4, tipo);
                pstmtUpdateTransaccion.setString(5, concepto);
                pstmtUpdateTransaccion.setDate(6, new java.sql.Date(fecha.getTime()));
                pstmtUpdateTransaccion.setInt(7, idTransaccionParaActualizar);

                int filasAfectadasTransaccion = pstmtUpdateTransaccion.executeUpdate();

                if (filasAfectadasTransaccion > 0) {
                    // Ajustar el saldo de la cuenta original
                    String sqlAdjustSaldoOriginal = "UPDATE cuenta SET Saldo = Saldo " + (tipoOriginal.equalsIgnoreCase("Ingreso") ? "-" : "+") + " ? WHERE idCuenta = ?";
                    pstmtUpdateSaldo = con.prepareStatement(sqlAdjustSaldoOriginal);
                    pstmtUpdateSaldo.setDouble(1, montoOriginal);
                    pstmtUpdateSaldo.setInt(2, idCuentaOriginal);
                    pstmtUpdateSaldo.executeUpdate();

                    // Actualizar el saldo de la nueva cuenta
                    String sqlAdjustSaldoNueva = "UPDATE cuenta SET Saldo = Saldo " + (tipo.equalsIgnoreCase("Ingreso") ? "+" : "-") + " ? WHERE idCuenta = ?";
                    pstmtUpdateSaldo = con.prepareStatement(sqlAdjustSaldoNueva);
                    pstmtUpdateSaldo.setDouble(1, cantidadNueva);
                    pstmtUpdateSaldo.setInt(2, idCuentaNueva);
                    pstmtUpdateSaldo.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Transacción actualizada y saldo de cuenta ajustado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    transaccionesForm.cargarDatosTabla(idUsuario);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener ID de cuenta o etiqueta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (pstmtUpdateTransaccion != null) pstmtUpdateTransaccion.close();
            if (pstmtUpdateSaldo != null) pstmtUpdateSaldo.close();
            conexion.desconectar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la transacción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerIdCuenta(Connection con, String nombreCuenta) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("SELECT idCuenta FROM cuenta WHERE Nombre = ? AND idUsuario = ?");
        pstmt.setString(1, nombreCuenta);
        pstmt.setInt(2, idUsuario);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("idCuenta");
        }
        return -1;
    }

    private int obtenerIdCategoria(Connection con, String nombreCategoria) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("SELECT idCategoria FROM categorias WHERE Nombre = ? AND idUsuario = ?");
        pstmt.setString(1, nombreCategoria);
        pstmt.setInt(2, idUsuario); 
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("idCategoria");
        }
        return -1;
    }
}