import java.util.*;
/* Autor: Subia Huaicane Edson Fabricio
 * Colaborador: Mi persona
 * Tiempo: 40 minutos
 */
public class DemoBatalla {
    public static void main(String[] args) {
        // 1. Crear un arreglo de naves
        Nave[] misNaves = new Nave[3];  
        Scanner scanPro = new Scanner(System.in);  
        String nomb, col;
        int fil, punt;
        boolean est;

        // 2. Recolección de datos y creación de cada nave
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

        // 3. Mostrar las naves creadas
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        
        // 4. Solicitar y mostrar naves por nombre
        mostrarPorNombre(misNaves, scanPro);

        // 5. Mostrar naves según los puntos ingresados
        mostrarPorPuntos(misNaves, scanPro);

        // 6. Mostrar nave con mayor número de puntos
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));

        // 7. Mostrar naves desordenadas aleatoriamente
        Nave[] navesDesordenadas = desordenarNaves(misNaves);
        System.out.println("\nNaves desordenadas aleatoriamente:");
        mostrarNaves(navesDesordenadas);
    }

    // 8. Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave lasNaves : flota)
            System.out.println(lasNaves);
    }

    // 9. Método para mostrar todas las naves de un nombre que se pide por teclado
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

    // 10. Método para mostrar naves con puntos inferiores o iguales a los ingresados
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

    // 11. Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];

        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }

        return naveMayorPuntos;
    }

    // 12. Método que desordena aleatoriamente un arreglo de naves
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
    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equalsIgnoreCase(s)) {
                return i; // Retorna la posición si encuentra la nave
            }
        }
        return -1; // Retorna -1 si no encuentra la nave
    }

    // Método que ordena por número de puntos de menor a mayor (Burbuja)
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    // Intercambia las naves
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    // Método que ordena por nombre de A a Z utilizando el algoritmo de Burbuja
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) > 0) {
                    // Intercambio de naves
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    // Método para buscar una nave por su nombre utilizando búsqueda binaria (requiere que esté ordenado por nombre)
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int inicio = 0;
        int fin = flota.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = flota[medio].getNombre().compareToIgnoreCase(s);

            if (comparacion == 0) {
                return medio;  // Retorna la posición si encuentra el nombre
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;  // Retorna -1 si no encuentra ninguna nave con ese nombre
    }        
}