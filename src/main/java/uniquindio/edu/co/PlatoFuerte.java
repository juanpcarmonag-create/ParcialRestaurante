package uniquindio.edu.co;

public class PlatoFuerte extends Producto{
    private int pesoGramos;
    private TipoPreparacion tipoPreparacion;
    private boolean CoccionCompleta;

    public PlatoFuerte(int codigoProducto, String nombreProducto, String descripcion, double precioBase, int tiempoPreparacion, int pesoGramos, TipoPreparacion tipoPreparacion, boolean coccionCompleta) {
        super(codigoProducto, nombreProducto, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.tipoPreparacion = tipoPreparacion;
        CoccionCompleta = coccionCompleta;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }

    public boolean isCoccionCompleta() {
        return CoccionCompleta;
    }

    public void setCoccionCompleta(boolean coccionCompleta) {
        CoccionCompleta = coccionCompleta;
    }

    @Override
    public String toString() {
        return "PlatoFuerte{" +
                "pesoGramos=" + pesoGramos +
                ", tipoPreparacion=" + tipoPreparacion +
                ", CoccionCompleta=" + CoccionCompleta +
                '}';
    }

    @Override
    public double PrecioFinal() {
        double precioFinal=getPrecioBase()+(getPrecioBase()*0.20);
        return precioFinal;
    }
}
