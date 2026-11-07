package uniquindio.edu.co;

    public interface IServicioDomicilio {
        boolean aceptaEntrega(double distanciaKm);
        double calcularCostoDomicilio(double distanciaKm);
    }

