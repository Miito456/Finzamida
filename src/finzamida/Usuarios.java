package finzamida;

public class Usuarios {

    String CURP, RFC, Nombre, ApellidoPat, ApellidoMat, CorreoElectronico, Contrasena, FechaAlta;

    public Usuarios(String CURP, String RFC, String Nombre, String ApellidoPat, String ApellidoMat, String CorreoElectronico, String Contrasena, String FechaAlta) {
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
        return "Usuarios{CURP=" + CURP + ", RFC=" + RFC + ", Nombre=" + Nombre + ", ApellidoPat=" + ApellidoPat + ", ApellidoMat=" + ApellidoMat + ", CorreoElectronico=" + CorreoElectronico + ", Contrasena=" + Contrasena + ", FechaAlta=" + FechaAlta + '}';
    }

    public String getCURP() {
        return CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidoPat() {
        return ApellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidoPat(String ApellidoPat) {
        this.ApellidoPat = ApellidoPat;
    }

    public void setApellidoMat(String ApellidoMat) {
        this.ApellidoMat = ApellidoMat;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

}
