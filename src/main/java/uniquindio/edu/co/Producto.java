package uniquindio.edu.co;

public abstract class Producto{
    private int codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioBase;
    private int tiempoPreparacion;

    public Producto(int codigoProducto, String nombreProducto, String descripcion, double precioBase, int tiempoPreparacion) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto=" + codigoProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
    public double PrecioFinal(){
        return getPrecioBase();
    }

    public abstract boolean verificarCondicionesCalidad();
}
