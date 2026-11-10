package uniquindio.edu.co;

public interface IEntregaSegura {
    static int tarifaBase=7000;
    static int costoKm=1000;
    static int distanciaMax=20;

    default int calcularCostoPedido(int distancia){
        int costo=0;
        if(distancia<=distanciaMax)
            if(distancia>5){
                costo=tarifaBase+3000+(costoKm*distancia);

            }else {
                costo=tarifaBase+(costoKm*distancia);
            }
        return costo;
    }
}