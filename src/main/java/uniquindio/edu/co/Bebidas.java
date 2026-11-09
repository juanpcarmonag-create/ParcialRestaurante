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
    public boolean verificarCondiciones() {
        boolean aprobado=false;
        if (tipoBebida==TipoBebida.CALIENTE) {
            if ((volumenML <= 1500 && volumenML >= 150)&&(temperatura<=85&&temperatura>=55)) {
                aprobado=true;
            }
        }else {
            if ((volumenML <= 1500 && volumenML >= 150)&&(temperatura<=10&&temperatura>=0)) {
                aprobado=true;
            }
        }
        return aprobado;
    }
}
