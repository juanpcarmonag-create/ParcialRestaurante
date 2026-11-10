package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostreTest {
    Postre postre=new Postre(3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,150, 23,false);

    @Test
    void pesoDebeEstarEntre80Y500Gramos(){
        assertTrue(postre.getPesoGramos()>=80);
        assertTrue(postre.getPesoGramos()<=500);
    }

    @Test
    void siRequiereRefrigeracionDebenEstarEntre0Y6Grados(){
        if(postre.getRefrigeracion()){
            assertTrue(postre.getTempAlmacenamiento()>=0);
            assertTrue(postre.getTempAlmacenamiento()<=6);
        }
    }

    @Test
    void siNoRequiereRefrigeracionDebenEstarEntre15Y30Grados() {
        if(postre.getRefrigeracion()==false) {
            assertTrue(postre.getTempAlmacenamiento() >= 15);
            assertTrue(postre.getTempAlmacenamiento() <= 30);
        }
    }

    @Test
    void elPrecioNoDebeSerNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{new Postre(3,"Torta", "torta de chocolate con centro cremoso", -15000, 5,700, 23,false);});
    }

    @Test
    void elCodigoDelProductoNoDebeSerNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{new Postre(-3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,700, 23,false);});
    }
}
