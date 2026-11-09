package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int codigoPedido;
    private LocalDate fecha;
    private Cliente cliente;
    private ModalidadEntrega modalidadEntrega;
    private IServicioDomicilio iservicioDomicilio;
    private double distanciaKm;
    private EstadoPedido estadoPedido;
    private List<DetallePedido> detalles;

    public Pedido(int codigoPedido, LocalDate fecha, Cliente cliente, ModalidadEntrega modalidadEntrega) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modalidadEntrega = modalidadEntrega;
        this.estadoPedido = EstadoPedido.PENDIENTE;
        this.detalles = new ArrayList<>();
        this.distanciaKm = 0.0;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        this.detalles.add(new DetallePedido(producto, cantidad));
    }

    public double calcularTotalProductos() {
        double total = 0;
        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    public double calcularTotalPedido() {
        double total = calcularTotalProductos();
        if (this.modalidadEntrega == ModalidadEntrega.DOMICILIO && this.iservicioDomicilio != null) {
            total += this.iservicioDomicilio.calcularCostoDomicilio(this.distanciaKm);
        }
        return total;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", fecha=" + fecha +
                ", cliente=" + (cliente != null ? cliente.getNombreCliente() : "Sin cliente") +
                ", modalidadEntrega=" + modalidadEntrega +
                ", servicioDomicilio=" + iservicioDomicilio +
                ", estadoPedido=" + estadoPedido +
                ", totalPedido=" + calcularTotalPedido() +
                '}';
    }
}