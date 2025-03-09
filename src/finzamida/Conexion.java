package finzamida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection con = null;
    Connection reg;

    public Conexion() {
        conectar();
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/finzamida?user=root&password=");
            System.out.println("Conectado a la base de datos");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (con != null) {
                con.close();

                con = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public Connection getConexion() {
        return con; 
    }

}
