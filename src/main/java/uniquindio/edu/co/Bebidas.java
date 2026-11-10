package uniquindio.edu.co;

public class Bebidas extends Producto{
    private int volumenML;
    private int temperatura;
    private TipoBebida tipoBebida;
    private boolean PreparacionEspecial;

    public Bebidas(int codigoProducto, String nombreProducto, String descripcion, double precioBase, int tiempoPreparacion, int volumenML, int temperatura, TipoBebida tipoBebida, boolean preparacionEspecial) {
        super(codigoProducto, nombreProducto, descripcion, precioBase, tiempoPreparacion);
        this.volumenML = volumenML;
        this.temperatura = temperatura;
        this.tipoBebida = tipoBebida;
        PreparacionEspecial = preparacionEspecial;
    }

    public boolean getPreparacionEspecial() {
        return PreparacionEspecial;
    }

    public void setPreparacionEspecial(boolean preparacionEspecial) {
        PreparacionEspecial = preparacionEspecial;
    }

    public int getVolumenML() {
        return volumenML;
    }

    public double getVolumen() {
        return volumenML;
    }

    public void setVolumenML(int volumenML) {
        this.volumenML = volumenML;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    @Override
    public String toString() {
        return "Bebidas{" +
                "volumenML=" + volumenML +
                ", temperatura=" + temperatura +
                ", tipoBebida=" + tipoBebida +
                '}';
    }

    @Override
    public double PrecioFinal() {
        Double precioFinal=getPrecioBase()+(getPrecioBase()*0.1);
        if(getPreparacionEspecial()==true){
            precioFinal+=3000;
        }
        return precioFinal;
    }
    @Override
    public boolean verificarCondicionesCalidad() {
        boolean volumenValido = this.volumenML >= 150 && this.volumenML <= 1500;
        boolean tempValida = false;

        if (this.tipoBebida == TipoBebida.FRIA) {
            tempValida = this.temperatura >= 0 && this.temperatura <= 10;
        } else if (this.tipoBebida == TipoBebida.CALIENTE) {
            tempValida = this.temperatura >= 55 && this.temperatura <= 85;
        }

        return volumenValido && tempValida;
    }
}
