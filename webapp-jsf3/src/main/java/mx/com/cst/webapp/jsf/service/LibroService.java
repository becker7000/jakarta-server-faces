package mx.com.cst.webapp.jsf.service;

import jakarta.ejb.Local;
import mx.com.cst.webapp.jsf.model.Libro;

import java.util.List;
import java.util.Optional;

@Local // Un EJB que maneja transacciones
public interface LibroService {

    List<Libro> listar();
    Optional<Libro> porId(int id);

    void guardar(Libro libro);
    void eliminar(int id);

}
