package finzamida;

import java.sql.*;

public class CRUD {

    private Conexion con;
    private Connection reg;

    public CRUD() {
        con = new Conexion();
        reg = con.getConexion();

    }

    //
    //Modulo de altas
    //
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

    //
    //Modulo de bajas
    //
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
<<<<<<< HEAD
    
    
=======

>>>>>>> a6cb742944ce5698bbd4c43c8f4537609ee41401
}
