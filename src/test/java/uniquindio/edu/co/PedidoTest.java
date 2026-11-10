package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    Cliente cliente=new Cliente(12345, "juan", 311503,"juan@gmail","crr 12");
    Pedido pedido=new Pedido(12345,null,cliente,ModalidadEntrega.RESTAURANTE);

    @Test
    void noPermiteCodigoNegativo(){
        assertTrue(pedido.getCodigoPedido()>0);
    }
}
