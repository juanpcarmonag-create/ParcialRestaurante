package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlatoFuerteTest {

    PlatoFuerte platoFuerte=new PlatoFuerte(2,"Bistec","bistec de res en salsa",28000, 40, 300, TipoPreparacion.HORNEADO, true);

    @Test
    void noDebePermitirCodigoMenorDe1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PlatoFuerte(-2, "Bistec", "bistec de res en salsa", 28000, 80, 300, TipoPreparacion.HORNEADO, true);
        });
    }
    @Test
    void pesoDebeEstarEntre200Y900Gramos(){
        assertThrows(IllegalArgumentException.class, ()->{new PlatoFuerte(2,"Bistec","bistec de res en salsa",28000, 40, 100, TipoPreparacion.HORNEADO, true);});
    }

    @Test
    void tiempoDePreparacionEntre10Y60Minutos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PlatoFuerte(2, "Bistec", "bistec de res en salsa", 28000, 80, 300, TipoPreparacion.HORNEADO, true);
        });
    }

    @Test
    void laCoccionDebeEstarAprobada(){
        assertThrows(IllegalArgumentException.class, ()->{new PlatoFuerte(2,"Bistec","bistec de res en salsa",28000, 40, 300, TipoPreparacion.HORNEADO, false);});
    }

    @Test
    void elPrecioNoDebeSerNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{new PlatoFuerte(2,"Bistec","bistec de res en salsa",-28000, 40, 300, TipoPreparacion.HORNEADO, true);});
    }


}
