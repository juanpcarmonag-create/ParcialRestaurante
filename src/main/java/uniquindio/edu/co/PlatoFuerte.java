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

        if (pesoGramos<200 || pesoGramos>900){
            throw new IllegalArgumentException("El peso debe estar entre 200 y 900 gramos");
        }

        if (tiempoPreparacion<10 || tiempoPreparacion>60){
            throw new IllegalArgumentException("El tiempo de preparacion debe ser entre 10 y 60 minutos");
        }

        if (coccionCompleta==false){
            throw new IllegalArgumentException("La coccion del plato no esta aprobada");
        }

        if (precioBase<=0){
            throw new IllegalArgumentException("El precio del plato debe ser positivo y mayor a 0");
        }

        if(codigoProducto<1){
            throw new IllegalArgumentException("el codigo no puede ser menor a 1");
        }
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    public double getPeso() {
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

    public boolean getCoccionSuperada() {
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

    @Override
    public boolean verificarCondicionesCalidad() {
        return this.pesoGramos >= 200 && this.pesoGramos <= 900 &&
                getTiempoPreparacion() >= 10 && getTiempoPreparacion() <= 60 &&
                this.CoccionCompleta;
    }
}
