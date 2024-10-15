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

        // 8. Ordenar naves por nombre
        ordenarPorNombreBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Burbuja):");
        mostrarNaves(misNaves);
        
        // 9. Buscar una nave por nombre
        System.out.print("Ingrese el nombre de la nave a buscar: ");
        String nombreBuscado = scanPro.next();
        int indice = busquedaBinariaNombre(misNaves, nombreBuscado);
        if (indice != -1) {
            System.out.println("Nave encontrada: " + misNaves[indice]);
        } else {
            System.out.println("No se encontró la nave con el nombre: " + nombreBuscado);
        }

        // 10. Ordenar naves por puntos
        ordenarPorPuntosSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (Selección):");
        mostrarNaves(misNaves);
        
        // 11. Ordenar naves por nombre (Selección)
        ordenarPorNombreSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Selección):");
        mostrarNaves(misNaves);
        
        // 12. Ordenar naves por puntos (Inserción)
        ordenarPorPuntosInsercion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (Inserción):");
        mostrarNaves(misNaves);
        
        // 13. Ordenar naves por nombre (Inserción)
        ordenarPorNombreInsercion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Inserción):");
        mostrarNaves(misNaves);
    }

    // 14. Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave lasNaves : flota)
            System.out.println(lasNaves);
    }

    // 15. Método para mostrar todas las naves de un nombre que se pide por teclado
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

    // 16. Método para mostrar naves con puntos inferiores o iguales a los ingresados
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

    // 17. Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];

        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }

        return naveMayorPuntos;
    }

    // 18. Método que desordena aleatoriamente un arreglo de naves
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

    // 19. Método que ordena por nombre de A a Z utilizando el algoritmo de Burbuja
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

    // 20. Método para buscar una nave por su nombre utilizando búsqueda binaria (requiere que esté ordenado por nombre)
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

    // 21. Método que ordena por número de puntos de menor a mayor utilizando el algoritmo de Selección
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getPuntos() < flota[minIndex].getPuntos()) {
                    minIndex = j;
                }
            }
            // Intercambio de naves
            Nave temp = flota[minIndex];
            flota[minIndex] = flota[i];
            flota[i] = temp;
        }
    }

    // 22. Método que ordena por nombre de A a Z utilizando el algoritmo de Selección
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[minIndex].getNombre()) < 0) {
                    minIndex = j;
                }
            }
            // Intercambio de naves
            Nave temp = flota[minIndex];
            flota[minIndex] = flota[i];
            flota[i] = temp;
        }
    }

    // 23. Método que ordena por número de puntos de menor a mayor utilizando el algoritmo de Inserción
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        int n = flota.length;
        for (int i = 1; i < n; i++) {
            Nave key = flota[i];
            int j = i - 1;

            while (j >= 0 && flota[j].getPuntos() > key.getPuntos()) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }

    // 24. Método que ordena por nombre de A a Z utilizando el algoritmo de Inserción
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        int n = flota.length;
        for (int i = 1; i < n; i++) {
            Nave key = flota[i];
            int j = i - 1;

            while (j >= 0 && flota[j].getNombre().compareToIgnoreCase(key.getNombre()) > 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }
}