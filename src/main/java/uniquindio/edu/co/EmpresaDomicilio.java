package uniquindio.edu.co;

public enum EmpresaDomicilio {
    RAPIDO_EXPRESS(new RapidoExpress()),
    ENTREGA_SEGURA(new EntregaSegura());

    private final IServicioDomicilio servicio;

    EmpresaDomicilio(IServicioDomicilio servicio) {
        this.servicio = servicio;
    }

    public IServicioDomicilio getServicio() {
        return servicio;
    }

    public boolean aceptaPedido(double distanciaKm) {
        return servicio.aceptaEntrega(distanciaKm);
    }

    public double calcularCostoDistancia(double distanciaKm) {
        return servicio.calcularCostoDomicilio(distanciaKm);
    }
}
