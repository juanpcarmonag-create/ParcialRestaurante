package uniquindio.edu.co;

import java.time.LocalDate;

public class Domicilio extends Pedido {

    private int distancia;
    private EmpresaDomicilio empresa;

    public Domicilio(int codigoPedido, LocalDate fecha, Cliente cliente, int distancia, EmpresaDomicilio empresa) {
        super(codigoPedido, fecha, cliente, ModalidadEntrega.DOMICILIO);
        this.distancia = distancia;
        this.empresa = empresa;
        setDistanciaKm(distancia);
        setServicioDomicilio(empresa.getServicio());
    }

    public boolean aceptarPedido() {
        return empresa.aceptaPedido(distancia);
    }

    public EmpresaDomicilio getEmpresa() {
        return empresa;
    }

    public double calcularCostoDistancia() {
        return empresa.calcularCostoDistancia(distancia);
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
        setDistanciaKm(distancia);
    }
}
