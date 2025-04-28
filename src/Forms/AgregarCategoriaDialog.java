package Forms;

import finzamida.Conexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class AgregarCategoriaDialog extends JDialog {

    private Categorias categoriasForm;
    private int idUsuario;
    private JTextField nombreTextField;
    private JButton guardarButton;
    private JButton cancelarButton;
    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();

    public AgregarCategoriaDialog(JFrame owner, Categorias categoriasForm, int idUsuario) {
        super(owner, "Agregar Nueva Categoría", true);
        this.categoriasForm = categoriasForm;
        this.idUsuario = idUsuario;
        initComponents();
        setPreferredSize(new Dimension(400, 180));
        pack();
        setLocationRelativeTo(owner);
    }

    private void initComponents() {
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

        nombreTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombreTextField, gbc);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevaCategoria();
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

    private void guardarNuevaCategoria() {
        String nombre = nombreTextField.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        insertarNuevaCategoria(nombre);
    }

    private void insertarNuevaCategoria(String nombre) {
        String sql = "INSERT INTO `categorias` (`idUsuario`, `Nombre`) VALUES (?, ?)";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idUsuario);
            pst.setString(2, nombre);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Categoría agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                categoriasForm.cargarCategorias();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la categoría: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al guardar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
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
        Categorias categoriasForm = new Categorias(1);
        frame.setVisible(true);
        AgregarCategoriaDialog dialog = new AgregarCategoriaDialog(frame, categoriasForm, 1);
        dialog.setVisible(true);
    }
}
