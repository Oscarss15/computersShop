package dev.oscar;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Informatica Pepin", "Pepin Alvarez", "123123123");
        

        Computador computer1 = new Computador("HP", 8, "Intel i3", "Windows 10", 150.00);
        Computador computer2 = new Computador("Lenovo", 16, "Intel i5", "Windows 11", 250.00);
        Computador computer3 = new Computador("Samsung", 8, "Intel i7", "Windows 11", 700.00);
        Computador computer4 = new Computador("MSI", 8, "Intel i7", "Windows 11", 750.00);

        tienda.agregarComputador(computer1);
        tienda.agregarComputador(computer2);
        tienda.agregarComputador(computer3);
        tienda.agregarComputador(computer4);

        tienda.listarComputadores();

        System.out.println("Buscando computador de la marca Lenovo:");
        Computador encontrado = tienda.buscarComputador("Lenovo");
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Computador no encontrado.");
        }

        System.out.println("\nEliminando computador marca Lenovo:");
        tienda.eliminarComputador("Lenovo");

        tienda.listarComputadores();
    }
    }

