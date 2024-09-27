package co.edu.uniquindio.notas.modelo;
import java.time.LocalDate;
import java.util.Random;
public class Nota {
    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private LocalDate fechaCreacion;

    //public Nota(String titulo, String descripcion, String categoria) {

    //}


    public Nota(int id, String titulo, String descripcion, String categoria, LocalDate fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion != null ? fechaCreacion : LocalDate.now();
    }

    public static NotaBuilder builder (){
       return new NotaBuilder();
   }
   public int getId(){
        return id;
   }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
