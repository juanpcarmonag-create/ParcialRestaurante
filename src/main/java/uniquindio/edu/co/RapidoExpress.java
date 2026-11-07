package uniquindio.edu.co;

public class RapidoExpress implements IServicioDomicilio {
    private static final double TARIFA_BASE = 5000.0;
    private static final double VALOR_KM = 1500.0;
    private static final double DISTANCIA_MAXIMA = 12.0;

    @Override
    public boolean aceptaEntrega(double distanciaKm) {
        return distanciaKm > 0 && distanciaKm <= DISTANCIA_MAXIMA;
    }

    @Override
    public double calcularCostoDomicilio(double distanciaKm) {
        if (!aceptaEntrega(distanciaKm)) {
            throw new IllegalArgumentException("Distancia no permitida para Rápido Express.");
        }
        return TARIFA_BASE + (distanciaKm * VALOR_KM);
    }
}