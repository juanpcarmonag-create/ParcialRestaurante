package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PedidoTest {
    Cliente cliente=new Cliente(12345, "juan", 311503,"juan@gmail","crr 12");
    Pedido pedido=new Pedido(12345,null,cliente,ModalidadEntrega.RESTAURANTE);
    Pedido pedido2=new Pedido(12345,null,cliente,ModalidadEntrega.DOMICILIO);

    @Test
    void noPermitirCodigoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new Pedido(-12345,null,cliente,ModalidadEntrega.RESTAURANTE);});
    }

    
}
