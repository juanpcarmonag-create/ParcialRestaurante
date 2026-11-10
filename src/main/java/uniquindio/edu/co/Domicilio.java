package uniquindio.edu.co;

import java.time.LocalDate;

public class Domicilio extends Pedido implements IRapidoExpress, IEntregaSegura {

    private int distancia;
    private String empresa;

    public Domicilio(int codigoPedido, LocalDate fecha, Cliente cliente, int distancia, String empresa) {
        super(codigoPedido, fecha, cliente, ModalidadEntrega.DOMICILIO);
        this.distancia = distancia;
        this.empresa = empresa;
    }

    public boolean aceptarPedido() {
        if (distancia <= 0) {
            return false;
        }
        if ("Rápido Express".equalsIgnoreCase(empresa)) {
            return distancia <= IRapidoExpress.distanciaMax;
        } else if ("EntregaSegura".equalsIgnoreCase(empresa)) {
            return distancia <= IEntregaSegura.distanciaMax;
        }
        return false;
    }

    public double calcularCostoDistancia() {
        if (!aceptarPedido()) {
            return 0.0;
        }
        if ("Rápido Express".equalsIgnoreCase(empresa)) {
            return IRapidoExpress.super.calcularCosto(distancia);
        } else if ("EntregaSegura".equalsIgnoreCase(empresa)) {
            return IEntregaSegura.super.calcularCostoPedido(distancia);
        }
        return 0.0;
    }

    @Override
    public double calcularTotalPedido() {
        return calcularTotalProductos() + calcularCostoDistancia();
    }

    @Override
    public double calcularTotal() {
        return calcularTotalPedido();
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}