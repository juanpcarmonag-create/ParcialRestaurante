package uniquindio.edu.co;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.Cliente;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    Cliente cliente= new Cliente(12345, "juan", 311503,"juan@gmail","crr 12");

    @Test
    void seDebeProbarDatosCorrectos() {
        assertEquals(12345, cliente.getDocumento());
        assertEquals("juan", cliente.getNombreCliente());
        assertEquals(311503, cliente.getTelefono());
        assertEquals("juan@gmail", cliente.getCorreo());
        assertEquals("crr 12", cliente.getDireccionCliente());
    }


    @Test
    void noPermitirNombreDelClienteConNumeros(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente(12345, "juan12", 311503,"juan@gmail","crr 12");});
    }

    @Test
    void noPermitirCorreosSinArroba(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente(12345, "juan", 311503,"juan.gmail","crr 12");});}

    @Test
    void noDebePermitirDocumentoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente(-12345, "juan", 311503,"juan@gmail","crr 12");});}

    @Test
    void noDebePermitirTelefonoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente(12345, "juan", -311503,"juan@gmail","crr 12");});}
}
