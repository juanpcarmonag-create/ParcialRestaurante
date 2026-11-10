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

        if(nombreCliente.contains("1")||nombreCliente.contains("2")||nombreCliente.contains("3")||nombreCliente.contains("4")||nombreCliente.contains("5")||nombreCliente.contains("6")||
                nombreCliente.contains("7")||nombreCliente.contains("8")||nombreCliente.contains("9")||nombreCliente.contains("0")){
            throw new IllegalArgumentException("El nombre del cliente no permite numeros");
        }

        if(!correo.contains("@")){
            throw new IllegalArgumentException("El correo debe tener un arroba");
        }

        if(documento<=0){
            throw new IllegalArgumentException("El documento no puede ser negativo");
        }

        if(telefono<=0){
            throw new IllegalArgumentException("El telefono no puede ser negativo");
        }
    }

    public int getDocumento() {
        return documento;
    }

    public int getIdentificacion() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setIdentificacion(int documento) {
        this.documento = documento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombre() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNombre(String nombreCliente) {
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

    public String getDireccion() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setDireccion(String direccionCliente) {
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
