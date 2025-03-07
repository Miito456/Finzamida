package finamida;

public class Usuarios {

    int idUsuario;
    String CURP, RFC, Nombre, ApellidoPat, ApellidoMat, CorreoElectronico, Contrasena, FechaAlta;

    public Usuarios(int idUsuario, String CURP, String RFC, String Nombre, String ApellidoPat, String ApellidoMat, String CorreoElectronico, String Contrasena, String FechaAlta) {
        this.idUsuario = idUsuario;
        this.CURP = CURP;
        this.RFC = RFC;
        this.Nombre = Nombre;
        this.ApellidoPat = ApellidoPat;
        this.ApellidoMat = ApellidoMat;
        this.CorreoElectronico = CorreoElectronico;
        this.Contrasena = Contrasena;
        this.FechaAlta = FechaAlta;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", CURP=" + CURP + ", RFC=" + RFC + ", Nombre=" + Nombre + ", ApellidoPat=" + ApellidoPat + ", ApellidoMat=" + ApellidoMat + ", CorreoElectronico=" + CorreoElectronico + ", Contrasena=" + Contrasena + ", FechaAlta=" + FechaAlta + '}';
    }

    public Usuarios() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPat() {
        return ApellidoPat;
    }

    public void setApellidoPat(String ApellidoPat) {
        this.ApellidoPat = ApellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }

    public void setApellidoMat(String ApellidoMat) {
        this.ApellidoMat = ApellidoMat;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

}
