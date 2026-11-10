package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomicilioTest {
    Domicilio domicilio=new Domicilio(123,null,null,11,"rapido express");

    @Test
    void noPermiteCodigoNegativo(){
        assertTrue(domicilio.getCodigoPedido()>0);
    }

    @Test
    void noPermiteDistanciaNegativa(){
        assertTrue(domicilio.getDistancia()>0);
    }

    @Test
    void distanciaMaximaDeEntregaSegura(){
        if(domicilio.getEmpresa().equalsIgnoreCase("entrega segura")){
            assertTrue(domicilio.getDistancia()<=20);
        }
    }

    @Test
    void distanciaMaximaDeRapidoExpress(){
        if(domicilio.getEmpresa().equalsIgnoreCase("rapido express")){
            assertTrue(domicilio.getDistancia()<=12);
        }
    }
}
