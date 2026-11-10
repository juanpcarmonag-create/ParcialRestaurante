package uniquindio.edu.co;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.Bebidas;
import uniquindio.edu.co.TipoBebida;

import static org.junit.jupiter.api.Assertions.*;

public class BebidaTest {
    Bebidas bebida = new Bebidas(0001, "Jugo de fresa", "jugo de fresa en agua o leche", 5000, 15, 400, 5, TipoBebida.FRIA, true);

    @Test
    void productosTenganLosDatosCorrectos() {
        assertEquals("jugo de fresa", bebida.getNombreProducto());
        assertEquals(8500.0, bebida.getPrecioBase());
        assertEquals(500, bebida.getVolumenML());
        assertEquals(false, bebida.getPreparacionEspecial());
    }

    @Test
    void NoDebePermitirVolumenMLMenorDe80() {
        assertTrue(bebida.getVolumenML() >= 80);
    }

    @Test
    void noDebePermitirPrecioNegativo() {
        assertTrue(bebida.getPrecioBase() > 0);
    }

    @Test
    void noDebePermitirTiempoDePreparacionMenorDe10() {
        assertTrue(bebida.getTiempoPreparacion() >= 10);
    }

    @Test
    void noDebePermitirCodigoMenorDe1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Bebidas(0001, "Jugo de fresa", "jugo de fresa en agua o leche", 5000, 15, 400, 5, TipoBebida.FRIA, true);
        });

    }
}
