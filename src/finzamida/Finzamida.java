package finzamida;

public class Finzamida {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        CRUD cr = new CRUD();

        //Altas
//        //Agregar un nuevo usuario
        Usuarios usu = new Usuarios("ABCX010101HDFLNS02", // CURP 
                "XAXX010101001", // RFC 
                "Miguel", // Nombre
                "Hernández", // Apellido Paterno
                "López", // Apellido Materno
                "miguel@example.com", // Correo Electrónico
                "Contraseña123!", // Contraseña
                "2025-03-07" // Fecha de Alta (Formato YYYY-MM-DD)
        );
    //    cr.altaUsuario(usu);
//        //Insertar nueva cuenta
        Cuenta cuenta = new Cuenta(1, "Cuenta Ahorros", "Ahorro", "BBVA", "1234567891", 5000.0, "2025-03-07");
//        cr.altaCuenta(cuenta);
//        // Insertar una transacción (asumiendo que idUsuario=1, idCuenta=1, idCategoria=2)
        Transacciones transaccion = new Transacciones(1, 1, 2, 1500.0, "Ingreso", "Depósito mensual", "2025-03-07");
//         cr.altaTransaccion(transaccion);
//        //Agregar nueva categoria
        Categoria nuevaCategoria = new Categoria(1, "Comida"); 
//        cr.altaCategoria(nuevaCategoria);
//
//
        //Bajas
        //   cr.bajaUsuario("ABCX010101HDFLNS01");
          //  cr.bajaCuenta(14);
        //    cr.bajaTransaccion(21);
        //   cr.bajaCategoria(15);
    }

}
