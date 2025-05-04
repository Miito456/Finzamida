package finzamida;

import java.sql.*;

public class CRUD {

    private Conexion con;
    private Connection reg;

    public CRUD() {
        con = new Conexion();
        reg = con.getConexion();

    }

    //Alta de cada uno de las tablas
    public void altaUsuario(Usuarios usuario) {
        String sentenciaSQL = "INSERT INTO Usuarios (CURP, RFC, Nombre, ApellidoPat, ApellidoMat, CorreoElectronico, Contrasena, FechaAlta) "
                + "VALUES ('"
                + usuario.getCURP() + "','"
                + usuario.getRFC() + "','"
                + usuario.getNombre() + "','"
                + usuario.getApellidoPat() + "','"
                + usuario.getApellidoMat() + "','"
                + usuario.getCorreoElectronico() + "','"
                + usuario.getContrasena() + "','"
                + usuario.getFechaAlta() + "')";

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Usuario registrado correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al registrar usuario: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void altaCuenta(Cuenta cuenta) {
        String sentenciaSQL = "INSERT INTO Cuenta (idUsuario, Nombre, Tipo, Banco, NumeroCuenta, Saldo, FechaCreacion) "
                + "VALUES ('"
                + cuenta.getIdUsuario() + "','"
                + cuenta.getNombre() + "','"
                + cuenta.getTipo() + "','"
                + cuenta.getBanco() + "','"
                + cuenta.getNumeroCuenta() + "',"
                + cuenta.getSaldo() + ",'"
                + cuenta.getFechaCreacion() + "')";

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Cuenta registrada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al registrar cuenta: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void altaTransaccion(Transacciones transaccion) {
        String sentenciaSQL = "INSERT INTO Transacciones (idUsuario, idCuenta, idCategoria, Monto, Tipo, Descripcion, Fecha) "
                + "VALUES ("
                + transaccion.getIdUsuario() + ","
                + transaccion.getIdCuenta() + ","
                + transaccion.getIdCategoria() + ","
                + transaccion.getMonto() + ",'"
                + transaccion.getTipo() + "','"
                + transaccion.getDescripcion() + "','"
                + transaccion.getFecha() + "')";

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Transaccion registrada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al registrar transacción: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void altaCategoria(Categoria categoria) {
        String sentenciaSQL = "INSERT INTO Categorias (idUsuario, Nombre) "
                + "VALUES ("
                + categoria.getIdUsuario() + ",'"
                + categoria.getNombre() + "')";

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Categoría registrada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al registrar categoría: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    //Delete de cada uno de las tablas
    public void bajaUsuario(String curp) {
        String sentenciaSQL = "DELETE FROM Usuarios WHERE CURP = '" + curp + "'";
        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Usuario eliminado correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al eliminar usuario: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void bajaCuenta(int idCuenta) {
        String sentenciaSQL = "DELETE FROM Cuenta WHERE idCuenta = " + idCuenta;
        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Cuenta eliminada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al eliminar cuenta: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void bajaTransaccion(int idTransaccion) {
        String sentenciaSQL = "DELETE FROM Transacciones WHERE idTransacciones = " + idTransaccion;
        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Transacción eliminada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al eliminar transacción: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void bajaCategoria(int idCategoria) {
        String sentenciaSQL = "DELETE FROM Categorias WHERE idCategoria = " + idCategoria;
        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Categoría eliminada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al eliminar categoría: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    // Actualizar un usuario
    public void actualizarUsuario(Usuarios usuario) {
        String sentenciaSQL = "UPDATE Usuarios SET "
                + "RFC = '" + usuario.getRFC() + "', "
                + "Nombre = '" + usuario.getNombre() + "', "
                + "ApellidoPat = '" + usuario.getApellidoPat() + "', "
                + "ApellidoMat = '" + usuario.getApellidoMat() + "', "
                + "CorreoElectronico = '" + usuario.getCorreoElectronico() + "', "
                + "Contrasena = '" + usuario.getContrasena() + "' "
                + "WHERE CURP = '" + usuario.getCURP() + "'";

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Usuario actualizado correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al actualizar usuario: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    // Actualizar una cuenta
    public void actualizarCuenta(Cuenta cuenta) {
        String sentenciaSQL = "UPDATE Cuenta SET "
                + "Nombre = '" + cuenta.getNombre() + "', "
                + "Tipo = '" + cuenta.getTipo() + "', "
                + "Banco = '" + cuenta.getBanco() + "', "
                + "NumeroCuenta = '" + cuenta.getNumeroCuenta() + "', "
                + "Saldo = " + cuenta.getSaldo() + " "
                + "WHERE idUsuario = " + cuenta.getIdUsuario();

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Cuenta actualizada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al actualizar cuenta: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    // Actualizar transacción
    public void actualizarTransaccion(Transacciones transaccion) {
        String sentenciaSQL = "UPDATE Transacciones SET "
                + "Monto = " + transaccion.getMonto() + ", "
                + "Tipo = '" + transaccion.getTipo() + "', "
                + "Descripcion = '" + transaccion.getDescripcion() + "', "
                + "Fecha = '" + transaccion.getFecha() + "' "
                + "WHERE idUsuario = " + transaccion.getIdUsuario() + " "
                + "AND idCuenta = " + transaccion.getIdCuenta() + " "
                + "AND idCategoria = " + transaccion.getIdCategoria();

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Transacción actualizada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al actualizar transacción: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    // Actualizar categoría
    public void actualizarCategoria(Categoria categoria) {
        String sentenciaSQL = "UPDATE Categorias SET "
                + "Nombre = '" + categoria.getNombre() + "' "
                + "WHERE idUsuario = " + categoria.getIdUsuario();

        try {
            Statement stm = reg.createStatement();
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            System.out.println("Categoría actualizada correctamente.");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException sqle) {
            System.out.println("Error al actualizar categoría: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public void altaUsuarioConCategorias(Usuarios usuario) {
        PreparedStatement psUsuario = null;
        PreparedStatement psCategoria = null;
        ResultSet rs = null;

        String insertarUsuario = "INSERT INTO Usuarios (CURP, RFC, Nombre, ApellidoPat, ApellidoMat, CorreoElectronico, Contrasena, FechaAlta) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String insertarCategoria = "INSERT INTO Categorias (idUsuario, Nombre) VALUES (?, ?)";

        try {
            reg.setAutoCommit(false);
            
            psUsuario = reg.prepareStatement(insertarUsuario, Statement.RETURN_GENERATED_KEYS);
            psUsuario.setString(1, usuario.getCURP());
            psUsuario.setString(2, usuario.getRFC());
            psUsuario.setString(3, usuario.getNombre());
            psUsuario.setString(4, usuario.getApellidoPat());
            psUsuario.setString(5, usuario.getApellidoMat());
            psUsuario.setString(6, usuario.getCorreoElectronico());
            psUsuario.setString(7, usuario.getContrasena());
            psUsuario.setString(8, usuario.getFechaAlta());

            int filasUsuario = psUsuario.executeUpdate();

            if (filasUsuario == 0) {
                throw new SQLException("No se pudo crear el usuario.");
            }
            
            rs = psUsuario.getGeneratedKeys();
            int idUsuario = -1;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID del nuevo usuario.");
            }

            psCategoria = reg.prepareStatement(insertarCategoria);
            psCategoria.setInt(1, idUsuario);
            psCategoria.setString(2, "Categoría 1");
            psCategoria.executeUpdate();
            psCategoria.setInt(1, idUsuario);
            psCategoria.setString(2, "Categoría 2");
            psCategoria.executeUpdate();

            reg.commit(); 
            System.out.println("Usuario y categorías creados exitosamente.");

        } catch (SQLException sqle) {
            try {
                reg.rollback(); 
                System.out.println("Se hizo rollback por un error: " + sqle.getMessage());
            } catch (SQLException e) {
                System.out.println("Error haciendo rollback: " + e.getMessage());
            }
            sqle.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psUsuario != null) {
                    psUsuario.close();
                }
                if (psCategoria != null) {
                    psCategoria.close();
                }
                reg.setAutoCommit(true); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
