package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(platoFuerte.getPesoGramos() >= 200);
        assertTrue(platoFuerte.getPesoGramos() <= 900);
    }

    @Test
    void tiempoDePreparacionEntre10Y60Minutos() {
        assertTrue(platoFuerte.getTiempoPreparacion() >= 10);
        assertTrue(platoFuerte.getTiempoPreparacion() <= 60);
    }

    @Test
    void laCoccionDebeEstarAprobada(){
        assertTrue(platoFuerte.isCoccionCompleta()==true);
    }

    @Test
    void elPrecioNoDebeSerNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{new PlatoFuerte(2,"Bistec","bistec de res en salsa",-28000, 40, 300, TipoPreparacion.HORNEADO, true);});
    }


}
