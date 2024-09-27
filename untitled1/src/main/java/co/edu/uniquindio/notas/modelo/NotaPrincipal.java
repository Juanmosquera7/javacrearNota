package co.edu.uniquindio.notas.modelo;

import java.util.ArrayList;
import java.util.Random;
public class NotaPrincipal {

    private ArrayList<Nota> notas;
    private Random random;

    public NotaPrincipal(){
        this.notas = new ArrayList<>();
        this.random = new Random();
    }
    public void agregarNota (String titulo, String descripcion, String categoria){
        int id = generarIdAleatorio();
        Nota nuevaNota = Nota.builder()
                .id(id)
                .titulo(titulo)
                .descripcion(descripcion)
                .categoria(categoria)
                .build();
        notas.add(nuevaNota);
    }
    public void eliminarNota(int id) throws Exception {
        if (notas.isEmpty()) {
            throw new Exception("No hay notas disponibles para eliminar.");
        }
        boolean eliminado = notas.removeIf(nota -> nota.getId() == id);
        if (!eliminado) {
            throw new Exception("No se encontró una nota con el ID proporcionado.");
        }
    }

    public ArrayList<Nota> listarNotas(){
        return notas;
    }
    private int generarIdAleatorio() {
        return 10 + random.nextInt(90); // Genera un número entre 10 y 99
    }
}
