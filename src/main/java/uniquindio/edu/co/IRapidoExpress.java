package uniquindio.edu.co;

public interface IRapidoExpress {

    static int tarifaBase=5000;
    static int costoKm=1500;
    static int distanciaMax=12;

    default int calcularCosto(int distancia){
        int costo=0;
        if (distancia<=distanciaMax){
            costo=tarifaBase+(costoKm*distancia);
        }
        return costo;
    }
}
