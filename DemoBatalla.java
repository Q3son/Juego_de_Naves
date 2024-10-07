import java.util.*;
/* Autor: Subia Huaicane Edson Fabricio
 * Colaborador: Mi persona
 * Tiempo: 40 minutos
 */
public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[3];  // Crear un arreglo de naves
        Scanner scanPro = new Scanner(System.in);  // Lector de entradas
        String nomb, col;
        int fil, punt;
        boolean est;

        // Recolección de datos y creación de cada nave
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = scanPro.next();  // Capturar nombre
            System.out.print("Fila: ");
            fil = scanPro.nextInt();  // Capturar fila
            System.out.print("Columna: ");
            col = scanPro.next();  // Capturar columna
            System.out.print("Estado (true para operativa, false para inactiva): ");
            est = scanPro.nextBoolean();  // Capturar estado
            System.out.print("Puntos: ");
            punt = scanPro.nextInt();  // Capturar puntos

            // Crear cada nave usando el constructor con parámetros
            misNaves[i] = new Nave(nomb, fil, col, est, punt);
        }

        // Mostrar las naves creadas
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
