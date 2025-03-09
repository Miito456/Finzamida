package finzamida;

public class Cuenta {

    private int idUsuario;
    private String Nombre, Tipo, Banco, NumeroCuenta, FechaCreacion;
    private double Saldo;

    public Cuenta(int idUsuario, String Nombre, String Tipo, String Banco, String NumeroCuenta, double Saldo, String FechaCreacion) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Banco = Banco;
        this.NumeroCuenta = NumeroCuenta;
        this.Saldo = Saldo;
        this.FechaCreacion = FechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getBanco() {
        return Banco;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }
}
