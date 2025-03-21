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

}
