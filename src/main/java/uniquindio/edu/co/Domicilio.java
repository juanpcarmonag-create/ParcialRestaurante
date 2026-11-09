package uniquindio.edu.co;

import java.time.LocalDate;

public class Domicilio extends Pedido implements IEntregaSegura, IRapidoExpress{

    private int distancia;

    public Domicilio(int codigoPedido, LocalDate fecha, ModalidadEntrega modalidadEntrega, EstadoPedido estadoPedido, int distancia) {
        super(codigoPedido, fecha, modalidadEntrega, estadoPedido);
        this.distancia = distancia;
    }

    @Override
    public int calcularCostoPedido(int distancia) {
        return IEntregaSegura.super.calcularCostoPedido(distancia);
    }

    @Override
    public int calcularCosto(int distancia) {
        return IRapidoExpress.super.calcularCosto(distancia);
    }
}
