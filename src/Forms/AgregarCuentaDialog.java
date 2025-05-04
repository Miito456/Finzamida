package Forms;

import finzamida.Conexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class AgregarCuentaDialog extends JDialog {

    private Cuentas cuentasForm;
    private int idUsuario;
    private JTextField nombreTextField;
    private JComboBox<String> tipoComboBox;
    private JTextField bancoTextField;
    private JTextField numeroCuentaTextField;
    private JTextField saldoTextField;
    private JButton guardarButton;
    private JButton cancelarButton;
    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();

    public AgregarCuentaDialog(JFrame owner, boolean modal, Cuentas cuentasForm, int idUsuario) {
        super(owner, "Agregar Nueva Cuenta", modal);
        this.cuentasForm = cuentasForm;
        this.idUsuario = idUsuario;
        initComponents();
        setPreferredSize(new Dimension(500, 300));
        pack();
        setLocationRelativeTo(owner);
    }

    private void initComponents() {
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

        nombreTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombreTextField, gbc);

        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(tipoLabel, gbc);

        tipoComboBox = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Débito", "Tarjeta de Crédito", "Cuenta de Inversión", "Otro"});
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tipoComboBox, gbc);

        JLabel bancoLabel = new JLabel("Banco:");
        bancoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(bancoLabel, gbc);

        bancoTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(bancoTextField, gbc);

        JLabel numeroCuentaLabel = new JLabel("Número de Cuenta:");
        numeroCuentaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(numeroCuentaLabel, gbc);

        numeroCuentaTextField = new JTextField();
        ((AbstractDocument) numeroCuentaTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + string.length()) <= 50 && string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if ((fb.getDocument().getLength() - length + text.length()) <= 50 && text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(numeroCuentaTextField, gbc);

        JLabel saldoLabel = new JLabel("Saldo Inicial:");
        saldoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(saldoLabel, gbc);

        saldoTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(saldoTextField, gbc);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevaCuenta();
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
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        add(panel);
    }

    private void guardarNuevaCuenta() {
        String nombre = nombreTextField.getText();
        String tipo = (String) tipoComboBox.getSelectedItem();
        String banco = bancoTextField.getText();
        String numeroCuenta = numeroCuentaTextField.getText();
        String saldoStr = saldoTextField.getText();

        if (nombre.isEmpty() || tipo.isEmpty() || banco.isEmpty() || numeroCuenta.isEmpty() || saldoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (numeroCuenta.length() < 8) {
            JOptionPane.showMessageDialog(this, "El número de cuenta debe tener al menos 8 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double saldo = Double.parseDouble(saldoStr);
            insertarNuevaCuenta(nombre, tipo, banco, numeroCuenta, saldo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El saldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertarNuevaCuenta(String nombre, String tipo, String banco, String numeroCuenta, double saldo) {
        String sql = "INSERT INTO cuenta (idUsuario, Nombre, Tipo, Banco, NumeroCuenta, Saldo, FechaCreacion) VALUES (?, ?, ?, ?, ?, ?, NOW())";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idUsuario);
            pst.setString(2, nombre);
            pst.setString(3, tipo);
            pst.setString(4, banco);
            pst.setString(5, numeroCuenta);
            pst.setDouble(6, saldo);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Cuenta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cuentasForm.cargarCuentas();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la cuenta: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al guardar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.desconectar();
        }
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
        Cuentas cuentasForm = new Cuentas(1);
        frame.setVisible(true);
        AgregarCuentaDialog dialog = new AgregarCuentaDialog(frame, true, cuentasForm, 1);
        dialog.setVisible(true);
    }
}