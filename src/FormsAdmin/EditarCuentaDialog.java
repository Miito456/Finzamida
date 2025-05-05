package FormsAdmin;

import Forms.*;
import finzamida.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EditarCuentaDialog extends JDialog {

    private int idCuenta;
    private Cuentas cuentasForm;
    private JTextField nombreTextField;
    private JComboBox<String> tipoComboBox;
    private JTextField bancoTextField;
    private JTextField numeroCuentaTextField;
    private JTextField saldoTextField;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox<String> usuarioComboBox; 
    private Map<String, Integer> usuarioMap = new HashMap<>();
    private int idUsuarioActual; 
    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();

    public EditarCuentaDialog(JFrame owner, Cuentas cuentasForm, int idCuenta, String nombre, String tipo, String banco, String numeroCuenta, double saldo, int idUsuarioActual) {
        super(owner, "Editar Cuenta", true);
        this.cuentasForm = cuentasForm;
        this.idCuenta = idCuenta;
        this.idUsuarioActual = idUsuarioActual;
        initComponents(nombre, tipo, banco, numeroCuenta, saldo);
        cargarUsuarios(); 
        seleccionarUsuarioActual(); 
        setPreferredSize(new Dimension(500, 350)); 
        pack();
        setLocationRelativeTo(owner);
    }

    private void initComponents(String nombreInicial, String tipoInicial, String bancoInicial, String numeroCuentaInicial, double saldoInicial) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0x251939));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nombreLabel, gbc);

        nombreTextField = new JTextField(nombreInicial);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombreTextField, gbc);

        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(tipoLabel, gbc);

        tipoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Débito", "Tarjeta de Crédito", "Cuenta de Inversión", "Otro"});
        tipoComboBox.setSelectedItem(tipoInicial);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tipoComboBox, gbc);

        JLabel bancoLabel = new JLabel("Banco:");
        bancoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(bancoLabel, gbc);

        bancoTextField = new JTextField(bancoInicial);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(bancoTextField, gbc);

        JLabel numeroCuentaLabel = new JLabel("Número de Cuenta:");
        numeroCuentaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(numeroCuentaLabel, gbc);

        numeroCuentaTextField = new JTextField(numeroCuentaInicial);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(numeroCuentaTextField, gbc);

        JLabel saldoLabel = new JLabel("Saldo:");
        saldoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(saldoLabel, gbc);

        saldoTextField = new JTextField(String.valueOf(saldoInicial));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(saldoTextField, gbc);

        JLabel usuarioLabel = new JLabel("Asignar a Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(usuarioLabel, gbc);

        usuarioComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(usuarioComboBox, gbc);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCuenta();
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
    }

    private void cargarUsuarios() {
        String sql = "SELECT idUsuario, Nombre FROM usuarios";
        try (PreparedStatement pst = reg.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("Nombre");
                usuarioMap.put(nombre, id);
                usuarioComboBox.addItem(nombre);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionarUsuarioActual() {
        for (Map.Entry<String, Integer> entry : usuarioMap.entrySet()) {
            if (entry.getValue() == idUsuarioActual) {
                usuarioComboBox.setSelectedItem(entry.getKey());
                break;
            }
        }
    }

    private void actualizarCuenta() {
        String nuevoNombre = nombreTextField.getText();
        String nuevoTipo = (String) tipoComboBox.getSelectedItem();
        String nuevoBanco = bancoTextField.getText();
        String nuevoNumeroCuenta = numeroCuentaTextField.getText();
        String nuevoSaldoStr = saldoTextField.getText();
        String usuarioSeleccionado = (String) usuarioComboBox.getSelectedItem();

        if (nuevoNombre.isEmpty() || nuevoTipo.isEmpty() || nuevoBanco.isEmpty() || nuevoNumeroCuenta.isEmpty() || nuevoSaldoStr.isEmpty() || usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double nuevoSaldo = Double.parseDouble(nuevoSaldoStr);
            int idUsuarioSeleccionado = usuarioMap.get(usuarioSeleccionado);
            guardarCambiosCuenta(nuevoNombre, nuevoTipo, nuevoBanco, nuevoNumeroCuenta, nuevoSaldo, idUsuarioSeleccionado);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El saldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarCambiosCuenta(String nombre, String tipo, String banco, String numeroCuenta, double saldo, int idUsuario) {
        String sql = "UPDATE cuenta SET Nombre = ?, Tipo = ?, Banco = ?, NumeroCuenta = ?, Saldo = ?, idUsuario = ? WHERE idCuenta = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, tipo);
            pst.setString(3, banco);
            pst.setString(4, numeroCuenta);
            pst.setDouble(5, saldo);
            pst.setInt(6, idUsuario);
            pst.setInt(7, idCuenta);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Cuenta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cuentasForm.cargarCuentas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la cuenta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.desconectar();
        }
    }
}