package dev.oscar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiendaTest {

      private Tienda tienda;
    private Computador computador1;
    private Computador computador2;
    private Computador computador3;

    @BeforeEach
    public void setUp() {
        tienda = new Tienda("Tienda de Computadoras", "Oscar", "12345678");
        computador1 = new Computador("HP", 8, "Intel i5", "Windows 10", 700.00);
        computador2 = new Computador("Dell", 16, "Intel i7", "Windows 11", 1200.00);
        computador3 = new Computador("Apple", 8, "M1", "macOS", 1400.00);
    }

    @Test
    public void testAgregarComputador() {
        tienda.agregarComputador(computador1);
        Computador encontrado = tienda.buscarComputador("HP");
        assertNotNull(encontrado);
        assertEquals("HP", encontrado.getMarca());
    }

    @Test
    public void testEliminarComputadorExistente() {
        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);
        
        tienda.eliminarComputador("Dell");
        
        Computador encontrado = tienda.buscarComputador("Dell");
        assertNull(encontrado); 
    }

    @Test
    public void testEliminarComputadorInexistente() {
        tienda.agregarComputador(computador1);
        
        tienda.eliminarComputador("Apple");
        
        Computador encontrado = tienda.buscarComputador("HP");
        assertNotNull(encontrado); 
    }

    @Test
    public void testBuscarComputadorExistente() {
        tienda.agregarComputador(computador2);
        Computador encontrado = tienda.buscarComputador("Dell");
        assertNotNull(encontrado);
        assertEquals("Dell", encontrado.getMarca());
    }

    @Test
    public void testBuscarComputadorInexistente() {
        Computador encontrado = tienda.buscarComputador("Asus");
        assertNull(encontrado);
    }

    @Test
    public void testListarComputadores() {
        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);
        tienda.agregarComputador(computador3);

        ArrayList<Computador> esperado = new ArrayList<>();
        esperado.add(computador1);
        esperado.add(computador2);
        esperado.add(computador3);

        tienda.listarComputadores();

        for (Computador comp : esperado) {
            Computador encontrado = tienda.buscarComputador(comp.getMarca());
            assertNotNull(encontrado);
            assertEquals(comp.getMarca(), encontrado.getMarca());
        }
    }

    @Test
    public void testListarComputadoresVacio() {
        tienda.listarComputadores();
        assertTrue(tienda.buscarComputador("HP") == null && tienda.buscarComputador("Dell") == null);
    }
    
}
