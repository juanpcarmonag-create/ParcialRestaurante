package uniquindio.edu.co;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostreTest {
    Postre postre=new Postre(3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,150, 23,false);

    @Test
    void pesoDebeEstarEntre80Y500Gramos(){
        assertThrows(IllegalArgumentException.class, ()->{new Postre(3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,700, 23,false);});
    }

    @Test
    void siRequiereRefrigeracionDebenEstarEntre0Y6Grados(){
        assertThrows(IllegalArgumentException.class, ()->{new Postre(3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,700, 23,true);});
    }

    @Test
    void siNoRequiereRefrigeracionDebenEstarEntre15Y30Grados(){
        assertThrows(IllegalArgumentException.class, ()->{new Postre(3,"Torta", "torta de chocolate con centro cremoso", 15000, 5,700, 11,false);});
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
