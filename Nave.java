public class Nave {
    private String nombre;
    private int fila;
    private String columna;
    private boolean estado;
    private int puntos;

    // Constructor
    public Nave(String nombre, int fila, String columna, boolean estado, int puntos) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.puntos = puntos;
    }

    // Métodos mutadores (setters)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Métodos accesores (getters)
    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getPuntos() {
        return puntos;
    }

    // Método para cambiar el estado de la nave de operativa a inactiva o viceversa
    public void cambiarEstado() {
        this.estado = !this.estado;
    }

    // Método para verificar si la nave está operativa
    public boolean estaOperativa() {
        return this.estado;
    }

    // Método para actualizar los puntos de la nave
    public void actualizarPuntos(int puntosExtra) {
        this.puntos += puntosExtra;
    }

    // Método para mover la nave a una nueva posición
    public void moverNave(int nuevaFila, String nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    // Método para comparar si esta nave tiene más puntos que otra nave
    public boolean tieneMasPuntosQue(Nave otraNave) {
        return this.puntos > otraNave.getPuntos();
    }

    // Sobrescribir el método toString() para mostrar la información de la nave
    @Override
    public String toString() {
        return "Nave [Nombre: " + nombre +
            ", Fila: " + fila +
            ", Columna: " + columna +
            ", Estado: " + (estado ? "Operativa" : "Inactiva") +
            ", Puntos: " + puntos + "]";
    }
}
