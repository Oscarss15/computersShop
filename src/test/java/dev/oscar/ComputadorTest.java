package dev.oscar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputadorTest {

    @Test
    public void testConstructor() {
        Computador computador = new Computador("HP", 8, "Intel i5", "Windows 10", 750.00);

        assertEquals("HP", computador.getMarca());
        assertEquals(8, computador.getMemoria());
        assertEquals("Intel i5", computador.getCaracteristicasProcesador());
        assertEquals("Windows 10", computador.getSistemaOperativo());
        assertEquals(750.00, computador.getPrecio());
    }

    @Test
    public void testSettersAndGetters() {
        Computador computador = new Computador("HP", 8, "Intel i5", "Windows 10", 750.00);

        computador.setMarca("Dell");
        assertEquals("Dell", computador.getMarca());

        computador.setMemoria(16);
        assertEquals(16, computador.getMemoria());

        computador.setCaracteristicasProcesador("Intel i7");
        assertEquals("Intel i7", computador.getCaracteristicasProcesador());

        computador.setSistemaOperativo("Windows 11");
        assertEquals("Windows 11", computador.getSistemaOperativo());

        computador.setPrecio(1200.00);
        assertEquals(1200.00, computador.getPrecio());
    }

    @Test
    public void testToString() {
        Computador computador = new Computador("Apple", 8, "M1", "macOS", 1400.00);

        String expected = "Marca: Apple, Memoria: 8 GB, Procesador: M1, Sistema Operativo: macOS, Precio: $1400.0";
        assertEquals(expected, computador.toString());
    }
    
}
