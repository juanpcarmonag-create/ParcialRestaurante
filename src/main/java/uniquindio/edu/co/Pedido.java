package uniquindio.edu.co;

import java.time.LocalDate;

public class Pedido {
    private int codigoPedido;
    private LocalDate fecha;
    private ModalidadEntrega modalidadEntrega;
    private IServicioDomicilio iservicioDomicilio;
    private EstadoPedido estadoPedido;

    public Pedido(int codigoPedido, LocalDate fecha, ModalidadEntrega modalidadEntrega, EstadoPedido estadoPedido) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.modalidadEntrega = modalidadEntrega;
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

    public ModalidadEntrega getModalidadEntrega() {
        return modalidadEntrega;
    }

    public void setModalidadEntrega(ModalidadEntrega modalidadEntrega) {
        this.modalidadEntrega = modalidadEntrega;
    }

    public IServicioDomicilio getIServicioDomicilio() {
        return iservicioDomicilio;
    }

    public void setServicioDomicilio(IServicioDomicilio servicioDomicilio) {
        this.iservicioDomicilio = servicioDomicilio;
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
                ", fecha=" + fecha +
                ", modalidadEntrega=" + modalidadEntrega +
                ", servicioDomicilio=" + iservicioDomicilio +
                ", estadoPedido=" + estadoPedido +
                '}';
    }
}