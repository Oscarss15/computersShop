package dev.oscar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;


class AppTest {
  private Tienda tienda;

    @BeforeEach
    public void setUp() {
        tienda = new Tienda("Informatica Pepin", "Pepin Alvarez", "123123123");
    }

    @Test
    public void testAgregarComputadoresYListar() {
        Computador computer1 = new Computador("HP", 8, "Intel i3", "Windows 10", 150.00);
        Computador computer2 = new Computador("Lenovo", 16, "Intel i5", "Windows 11", 250.00);
        Computador computer3 = new Computador("Samsung", 8, "Intel i7", "Windows 11", 700.00);
        Computador computer4 = new Computador("MSI", 8, "Intel i7", "Windows 11", 750.00);

        tienda.agregarComputador(computer1);
        tienda.agregarComputador(computer2);
        tienda.agregarComputador(computer3);
        tienda.agregarComputador(computer4);

        assertEquals(8, tienda.buscarComputador("HP").getMemoria()); 
        assertEquals("Intel i5", tienda.buscarComputador("Lenovo").getCaracteristicasProcesador());
        assertEquals(750.00, tienda.buscarComputador("MSI").getPrecio());
    }

    @Test
    public void testBuscarComputador() {
        Computador computer1 = new Computador("HP", 8, "Intel i3", "Windows 10", 150.00);
        tienda.agregarComputador(computer1);

        Computador encontrado = tienda.buscarComputador("HP");
        assertNotNull(encontrado);
        assertEquals("HP", encontrado.getMarca());

        Computador noEncontrado = tienda.buscarComputador("Lenovo");
        assertNull(noEncontrado);
    }

    @Test
    public void testEliminarComputador() {
        Computador computer1 = new Computador("HP", 8, "Intel i3", "Windows 10", 150.00);
        Computador computer2 = new Computador("Lenovo", 16, "Intel i5", "Windows 11", 250.00);

        tienda.agregarComputador(computer1);
        tienda.agregarComputador(computer2);

        tienda.eliminarComputador("Lenovo");

        Computador encontrado = tienda.buscarComputador("Lenovo");
        assertNull(encontrado);

        Computador hp = tienda.buscarComputador("HP");
        assertNotNull(hp);
        assertEquals("HP", hp.getMarca());
    }

    @Test
    public void testListarComputadores() {
        Computador computer1 = new Computador("HP", 8, "Intel i3", "Windows 10", 150.00);
        Computador computer2 = new Computador("Lenovo", 16, "Intel i5", "Windows 11", 250.00);
        Computador computer3 = new Computador("Samsung", 8, "Intel i7", "Windows 11", 700.00);
        Computador computer4 = new Computador("MSI", 8, "Intel i7", "Windows 11", 750.00);

        tienda.agregarComputador(computer1);
        tienda.agregarComputador(computer2);
        tienda.agregarComputador(computer3);
        tienda.agregarComputador(computer4);

        assertDoesNotThrow(() -> tienda.listarComputadores());
        
        assertEquals("HP", tienda.buscarComputador("HP").getMarca());
        assertEquals("Lenovo", tienda.buscarComputador("Lenovo").getMarca());
        assertEquals("Samsung", tienda.buscarComputador("Samsung").getMarca());
        assertEquals("MSI", tienda.buscarComputador("MSI").getMarca());
    }
}
