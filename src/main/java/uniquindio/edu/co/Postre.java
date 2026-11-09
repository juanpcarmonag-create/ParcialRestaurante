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
    public boolean verificarCondiciones() {
        boolean aprobado=false;
        if (refrigeracion==true) {
            if ((pesoGramos <= 500 && pesoGramos >= 80)&&(tempAlmacenamiento<=6&&tempAlmacenamiento>=0)) {
                aprobado=true;
            }
        }else {
            if ((pesoGramos <= 500 && pesoGramos >= 80)&&(tempAlmacenamiento<=30&&tempAlmacenamiento>=15)) {
                aprobado=true;
            }
        }
        return aprobado;
    }
}
