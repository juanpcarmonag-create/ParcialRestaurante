package uniquindio.edu.co;

public class EntregaSegura implements IServicioDomicilio {
    private static final double TARIFA_BASE = 7000.0;
    private static final double VALOR_KM = 1000.0;
    private static final double RECARGO_LARGA_DISTANCIA = 3000.0;
    private static final double UMBRAL_RECARGO = 5.0;
    private static final double DISTANCIA_MAXIMA = 20.0;

    @Override
    public boolean aceptaEntrega(double distanciaKm) {
        return distanciaKm > 0 && distanciaKm <= DISTANCIA_MAXIMA;
    }

    @Override
    public double calcularCostoDomicilio(double distanciaKm) {
        if (!aceptaEntrega(distanciaKm)) {
            throw new IllegalArgumentException("Distancia no permitida para EntregaSegura.");
        }
        double costo = TARIFA_BASE + (distanciaKm * VALOR_KM);
        if (distanciaKm > UMBRAL_RECARGO) {
            costo += RECARGO_LARGA_DISTANCIA;
        }
        return costo;
    }
}
