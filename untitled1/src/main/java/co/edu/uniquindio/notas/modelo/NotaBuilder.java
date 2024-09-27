package co.edu.uniquindio.notas.modelo;
import java.time.LocalDate;

public class NotaBuilder {
    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private LocalDate fechaCreacion;

    public NotaBuilder(){}

    public NotaBuilder titulo (String titulo){
        this.titulo = titulo;
        return this;
    }
    public NotaBuilder descripcion (String descripcion){
        this.descripcion = descripcion;
        return this;
    }
     public  NotaBuilder categoria (String categoria){
        this.categoria = categoria;
        return this;
     }

    public  NotaBuilder fechaCreacion (LocalDate fechaCreacion){
        this.fechaCreacion = fechaCreacion;
        return this;
    }
    public NotaBuilder id (int id) {
        this.id = id;
        return this;
    }
     public Nota build(){
        return new Nota(id,titulo, descripcion, categoria, fechaCreacion);
     }


}
