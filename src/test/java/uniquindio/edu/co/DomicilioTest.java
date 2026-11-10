package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomicilioTest {
    Domicilio domicilio=new Domicilio(123,null,null,11,"entrega Segura");

    @Test
    void noPermiteCodigoNegativo(){
        assertTrue(domicilio.getCodigoPedido()>0);
    }

    @Test
    void noPermiteDistanciaNegativa(){
        assertTrue(domicilio.getDistancia()>0);
    }
}
