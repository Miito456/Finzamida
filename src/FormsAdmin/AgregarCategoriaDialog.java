package FormsAdmin;

import Forms.*;
import finzamida.Conexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AgregarCategoriaDialog extends JDialog {

    private Categorias categoriasForm;
    private JTextField nombreTextField;
    private JComboBox<UsuarioItem> usuarioComboBox;
    private JButton guardarButton;
    private JButton cancelarButton;
    Conexion conexion = new Conexion();
    Connection reg = conexion.getConexion();
    private List<UsuarioItem> listaUsuarios;

    public AgregarCategoriaDialog(JFrame owner, Categorias categoriasForm) {
        super(owner, "Agregar Nueva Categoría", true);
        this.categoriasForm = categoriasForm;
        listaUsuarios = cargarUsuarios();
        initComponents();
        setPreferredSize(new Dimension(400, 220)); 
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

        // Nombre de la categoría
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nombreLabel, gbc);

        nombreTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombreTextField, gbc);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(usuarioLabel, gbc);

        DefaultComboBoxModel<UsuarioItem> usuarioModel = new DefaultComboBoxModel<>();
        for (UsuarioItem usuario : listaUsuarios) {
            usuarioModel.addElement(usuario);
        }
        usuarioComboBox = new JComboBox<>(usuarioModel);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usuarioComboBox, gbc);

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
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        add(panel);
    }

    private List<UsuarioItem> cargarUsuarios() {
        List<UsuarioItem> usuarios = new ArrayList<>();
        String sql = "SELECT `idUsuario`, `Nombre` FROM `usuarios`";
        try (PreparedStatement pst = reg.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("Nombre");
                usuarios.add(new UsuarioItem(id, nombre));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return usuarios;
    }

    private void guardarNuevaCategoria() {
        String nombre = nombreTextField.getText();
        UsuarioItem usuarioSeleccionado = (UsuarioItem) usuarioComboBox.getSelectedItem();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        insertarNuevaCategoria(nombre, usuarioSeleccionado.getIdUsuario());
    }

    private void insertarNuevaCategoria(String nombre, int idUsuarioAsignado) {
        String sql = "INSERT INTO `categorias` (`idUsuario`, `Nombre`) VALUES (?, ?)";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idUsuarioAsignado);
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

    private static class UsuarioItem {
        private int idUsuario;
        private String nombreUsuario;

        public UsuarioItem(int idUsuario, String nombreUsuario) {
            this.idUsuario = idUsuario;
            this.nombreUsuario = nombreUsuario;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        @Override
        public String toString() {
            return nombreUsuario;
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
        frame.setSize(300, 250); // Aumentamos el tamaño para el ComboBox
        Categorias categoriasForm = new Categorias();
        frame.setVisible(true);
        AgregarCategoriaDialog dialog = new AgregarCategoriaDialog(frame, categoriasForm);
        dialog.setVisible(true);
    }
}