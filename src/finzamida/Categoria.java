package finzamida;

public class Categoria {

    private int idCategoria, idUsuario;
    private String nombre;

    public Categoria(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{"
                + "idCategoria=" + idCategoria
                + ", idUsuario=" + idUsuario
                + ", nombre='" + nombre + '\''
                + '}';
    }
}
