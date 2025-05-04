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

public class NuevoTransaccionDialog extends JDialog {

    private int idUsuario;
    private JComboBox<String> cuentaComboBox;
    private JTextField conceptoTextField;
    private JComboBox<String> tipoComboBox;
    private JTextField cantidadTextField;
    private JDateChooser fechaChooser;
    private JComboBox<String> etiquetaComboBox;
    private JButton guardarButton;
    private JButton cancelarButton;
    private Transacciones transaccionesForm;

    public NuevoTransaccionDialog(JFrame owner, int idUsuario, Transacciones transaccionesForm) {
        super(owner, "Nueva Transacción", true);
        this.idUsuario = idUsuario;
        this.transaccionesForm = transaccionesForm;
        initComponents();
        llenarComboBoxes();

        setPreferredSize(new Dimension(500, 350));
        pack();

        setLocationRelativeTo(owner);
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
        panel.add(cuentaLabel, gbc);

        cuentaComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        panel.add(cuentaComboBox, gbc);
        gbc.weightx = 0;

        JLabel conceptoLabel = new JLabel("Concepto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(conceptoLabel, gbc);

        conceptoTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(conceptoTextField, gbc);

        JLabel tipoLabel = new JLabel("Tipo:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(tipoLabel, gbc);

        tipoComboBox = new JComboBox<>(new String[]{"Ingreso", "Egreso"});
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(tipoComboBox, gbc);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cantidadLabel, gbc);

        cantidadTextField = new JTextField();
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
        panel.add(etiquetaLabel, gbc);

        etiquetaComboBox = new JComboBox<>();
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
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

            // Modifica la consulta para obtener solo las categorías del usuario
            String sqlEtiquetas = "SELECT Nombre FROM categorias WHERE idUsuario = ?";
            pstmt = con.prepareStatement(sqlEtiquetas);
            pstmt.setInt(1, idUsuario); // Establece el idUsuario para la consulta de categorías
            rs = pstmt.executeQuery();
            while (rs.next()) {
                etiquetaComboBox.addItem(rs.getString("Nombre"));
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cuentas o etiquetas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.desconectar();
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
            double cantidad = Double.parseDouble(cantidadStr);

            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            PreparedStatement pstmtInsert = null;
            PreparedStatement pstmtUpdate = null;

            int idCuenta = obtenerIdCuenta(con, cuenta);
            int idCategoria = obtenerIdCategoria(con, etiqueta);

            if (idCuenta != -1 && idCategoria != -1) {
                String sqlInsert = "INSERT INTO transacciones (idUsuario, idCuenta, idCategoria, Monto, Tipo, Descripcion, Fecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
                pstmtInsert = con.prepareStatement(sqlInsert);
                pstmtInsert.setInt(1, idUsuario);
                pstmtInsert.setInt(2, idCuenta);
                pstmtInsert.setInt(3, idCategoria);
                pstmtInsert.setDouble(4, cantidad);
                pstmtInsert.setString(5, tipo);
                pstmtInsert.setString(6, concepto);
                pstmtInsert.setDate(7, new java.sql.Date(fecha.getTime()));

                int filasAfectadasInsert = pstmtInsert.executeUpdate();
                if (filasAfectadasInsert > 0) {
                    // Actualizar el saldo de la cuenta
                    String sqlUpdateSaldo;
                    if (tipo.equalsIgnoreCase("Ingreso")) {
                        sqlUpdateSaldo = "UPDATE cuenta SET Saldo = Saldo + ? WHERE idCuenta = ?";
                    } else if (tipo.equalsIgnoreCase("Egreso")) {
                        sqlUpdateSaldo = "UPDATE cuenta SET Saldo = Saldo - ? WHERE idCuenta = ?";
                    } else {
                        JOptionPane.showMessageDialog(this, "Tipo de transacción no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    pstmtUpdate = con.prepareStatement(sqlUpdateSaldo);
                    pstmtUpdate.setDouble(1, cantidad);
                    pstmtUpdate.setInt(2, idCuenta);
                    int filasAfectadasUpdate = pstmtUpdate.executeUpdate();

                    if (filasAfectadasUpdate > 0) {
                        JOptionPane.showMessageDialog(this, "Transacción guardada y saldo de cuenta actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        transaccionesForm.cargarDatosTabla(idUsuario); // Actualizar la tabla en el formulario principal
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el saldo de la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                        // Considerar deshacer la inserción de la transacción si falla la actualización del saldo
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener ID de cuenta o etiqueta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (pstmtInsert != null) {
                pstmtInsert.close();
            }
            if (pstmtUpdate != null) {
                pstmtUpdate.close();
            }
            conexion.desconectar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la transacción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        Transacciones transaccionesForm = new Transacciones(1);
        frame.setVisible(true);
        NuevoTransaccionDialog dialog = new NuevoTransaccionDialog(frame, 1, transaccionesForm);
        dialog.setVisible(true);
    }
}
