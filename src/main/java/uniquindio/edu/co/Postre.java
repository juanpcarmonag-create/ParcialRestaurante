package uniquindio.edu.co;

public class Postre extends Producto{
    private int pesoGramos;
    private int tempAlmacenamiento;
    private boolean refrigeracion;

    public Postre(int codigoProducto, String nombreProducto, String descripcion, double precioBase, int tiempoPreparacion, int pesoGramos, int tempAlmacenamiento, boolean refrigeracion) {
        super(codigoProducto, nombreProducto, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.tempAlmacenamiento = tempAlmacenamiento;
        this.refrigeracion = refrigeracion;
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

    public int getTempAlmacenamiento() {
        return tempAlmacenamiento;
    }

    public void setTempAlmacenamiento(int tempAlmacenamiento) {
        this.tempAlmacenamiento = tempAlmacenamiento;
    }

    public boolean getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(boolean refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    @Override
    public String toString() {
        return "Postre{" +
                "pesoGramos=" + pesoGramos +
                ", tempAlmacenamiento=" + tempAlmacenamiento +
                ", refrigeracion=" + refrigeracion +
                '}';
    }

    @Override
    public double PrecioFinal() {
        Double precioFinal=getPrecioBase()+(getPrecioBase()*0.15);
        if(getRefrigeracion()==true){
            precioFinal+=(getPrecioBase()*0.05);
        }
        return precioFinal;
    }
    @Override
    public boolean verificarCondicionesCalidad() {
        boolean pesoValido = this.pesoGramos >= 80 && this.pesoGramos <= 500;
        boolean tempValida = false;

        if (this.refrigeracion) {
            tempValida = this.tempAlmacenamiento >= 0 && this.tempAlmacenamiento <= 6;
        } else {
            tempValida = this.tempAlmacenamiento >= 15 && this.tempAlmacenamiento <= 30;
        }

        return pesoValido && tempValida;
    }
}
