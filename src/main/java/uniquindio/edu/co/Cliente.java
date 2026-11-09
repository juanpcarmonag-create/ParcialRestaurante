package uniquindio.edu.co;

public class Cliente {
    private int documento;
    private String nombreCliente;
    private int telefono;
    private String correo;
    private String direccionCliente;

    public Cliente(int documento, String nombreCliente, int telefono, String correo, String direccionCliente) {
        this.documento = documento;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.correo = correo;
        this.direccionCliente = direccionCliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }




    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + documento +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", direccionCliente='" + direccionCliente + '\'' +
                '}';
    }
}
