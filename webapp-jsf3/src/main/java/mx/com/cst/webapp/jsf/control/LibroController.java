package mx.com.cst.webapp.jsf.control;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.com.cst.webapp.jsf.model.Libro;
import mx.com.cst.webapp.jsf.service.LibroService;

import java.util.List;

@Model
public class LibroController {

    // Este atributo va hasta generar la vista de editar
    private int id;

    private Libro libro;

    // Estos getter y setter son hasta generar la vista editar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Inject
    private LibroService libroService;

    @Produces
    @Model
    public String titulo(){
        return "Hola a todos desde Jakarta Server Faces 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Libro> listarLibros(){
        // Hacer primero este ejemplo con libros:
        /*return Arrays.asList(
               new Libro("Cien años de soledad", "Gabriel García Márquez", 15.99),
                new Libro("El gran Gatsby", "F. Scott Fitzgerald", 10.99),
                new Libro("Orgullo y prejuicio", "Jane Austen", 9.99),
                new Libro("1984", "George Orwell", 14.99),
                new Libro("Moby Dick", "Herman Melville", 12.99),
                new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 13.50),
                new Libro("El extranjero", "Albert Camus", 11.99)
        );*/
        return libroService.listar();
    }

    @Produces
    @Model
    public Libro libro(){
        this.libro = new Libro();
        if(id>0){
            // Obtiene el producto o lanza una exception
            libroService.porId(id).ifPresent(
                    l -> this.libro = l
            );
        }
        return libro;
    }

    public String guardarLibro(){
        System.out.println("\n\t Libro: "+libro);
        libroService.guardar(libro);
        return "index.xhtml?faces-redirect=true";
    } // Método de navegación en jsf (con el nuevo libro)

    // Método para editar:
    public String editarLibro(int id){
        this.id = id;
        return "formulario.xhtml";
    }

    // Hasta agregar eliminar:
    public String eliminarLibro(int id){
        libroService.eliminar(id);
        return "index.xhtml?faces-redirect=true";
    }

}
