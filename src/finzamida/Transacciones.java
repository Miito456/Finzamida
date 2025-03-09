package finzamida;

public class Transacciones {

    private int idTransaccion, idUsuario, idCuenta, idCategoria;

    double monto;
    String tipo, descripcion, fecha;

    public Transacciones(int idUsuario, int idCuenta, int idCategoria, double monto, String tipo, String descripcion, String fecha) {
        this.idUsuario = idUsuario;
        this.idCuenta = idCuenta;
        this.idCategoria = idCategoria;
        this.monto = monto;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaccion{"
                + "idTransaccion=" + idTransaccion
                + ", idUsuario=" + idUsuario
                + ", idCuenta=" + idCuenta
                + ", idCategoria=" + idCategoria
                + ", monto=" + monto
                + ", tipo='" + tipo + '\''
                + ", descripcion='" + descripcion + '\''
                + ", fecha='" + fecha + '\''
                + '}';
    }
}
