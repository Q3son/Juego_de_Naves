import java.util.*;

/* Autor: Subia Huaicane Edson Fabricio
 * Colaborador: Mi persona
 * Tiempo: 40 minutos
 */

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[3];
        int totalNaves = misNaves.length;
        Scanner scanPro = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = scanPro.next();
            System.out.println("Fila: ");
            fil = scanPro.nextInt();
            System.out.print("Columna: ");
            col = scanPro.next();
            System.out.print("Estado (true para operativa, false para inactiva): ");
            est = scanPro.nextBoolean();
            System.out.print("Puntos: ");
            punt = scanPro.nextInt();

            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);

        // Solicitar y mostrar naves por nombre
        mostrarPorNombre(misNaves, scanPro);

        // Mostrar naves según los puntos ingresados
        mostrarPorPuntos(misNaves, scanPro);

        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));

        // Mostrar naves desordenadas aleatoriamente
        Nave[] navesDesordenadas = desordenarNaves(misNaves);
        System.out.println("\nNaves desordenadas aleatoriamente:");
        mostrarNaves(navesDesordenadas);
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave lasNaves : flota)
            System.out.println(lasNaves);
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota, Scanner scanPro) {
        System.out.println("Ingrese el nombre de la nave a mostrar: ");
        String nombreBuscado = scanPro.next();  // Cambiar a next() para evitar problemas con espacios

        boolean naveEncontrada = false;

        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombreBuscado)) {  // Comparación insensible a mayúsculas
                System.out.println(nave);
                naveEncontrada = true;
            }
        }

        if (!naveEncontrada) {
            System.out.println("No se encontraron naves con el nombre: " + nombreBuscado);
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota, Scanner scanPro) {
        System.out.print("Ingrese el límite de puntos: ");
        int puntosMax = scanPro.nextInt();

        boolean naveEncontrada = false;

        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMax) {
                System.out.println(nave);
                naveEncontrada = true;
            }
        }

        if (!naveEncontrada) {
            System.out.println("No se encontraron naves con puntos menores o iguales a: " + puntosMax);
        }
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];

        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }

        return naveMayorPuntos;
    }

    // Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos
    // previamente ingresados pero aleatoriamente desordenados
    public static Nave[] desordenarNaves(Nave[] flota) {
        Nave[] flotaDesordenada = Arrays.copyOf(flota, flota.length);
        Random locoRand = new Random();
        
        for (int i = 0; i < flotaDesordenada.length; i++) {
            int randomIndex = locoRand.nextInt(flotaDesordenada.length);
            Nave temp = flotaDesordenada[i];
            flotaDesordenada[i] = flotaDesordenada[randomIndex];
            flotaDesordenada[randomIndex] = temp;
        }

        return flotaDesordenada;
    }
}
