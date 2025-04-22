package Forms;

import finzamida.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditarCategoriaDialog extends JDialog {

    private int idCategoria;
    private Categorias categoriasForm;
    private JTextField nombreTextField;
    private JButton guardarButton;
    private JButton cancelarButton;
    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();

    public EditarCategoriaDialog(JFrame owner, Categorias categoriasForm, int idCategoria, String nombre) {
        super(owner, "Editar Categoría", true);
        this.categoriasForm = categoriasForm;
        this.idCategoria = idCategoria;
        initComponents(nombre);
        setPreferredSize(new Dimension(400, 180));
        pack();
        setLocationRelativeTo(owner);
    }

    private void initComponents(String nombreInicial) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0x251939));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
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

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCategoria();
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
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        add(panel);
    }

    private void actualizarCategoria() {
        String nuevoNombre = nombreTextField.getText();

        if (nuevoNombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        guardarCambiosCategoria(nuevoNombre);
        dispose();
    }

    private void guardarCambiosCategoria(String nombre) {
        String sql = "UPDATE `categorias` SET `Nombre` = ? WHERE `idCategoria` = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setInt(2, idCategoria);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Categoría actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                categoriasForm.cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.desconectar();
        }
    }
}