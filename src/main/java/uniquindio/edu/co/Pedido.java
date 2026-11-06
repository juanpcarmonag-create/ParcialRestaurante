package uniquindio.edu.co;

import java.time.LocalDate;

public class Pedido {
    private int codigoPedido;
    private LocalDate fecha;
    private Entrega entrega;
    private EstadoPedido estadoPedido;

    public Pedido(int codigoPedido, LocalDate fecha, Entrega entrega, EstadoPedido estadoPedido) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.entrega = entrega;
        this.estadoPedido = estadoPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", fecha='" + fecha + '\'' +
                ", entrega=" + entrega +
                ", estadoPedido=" + estadoPedido +
                '}';
    }
}
