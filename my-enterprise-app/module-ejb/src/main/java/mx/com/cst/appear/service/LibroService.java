package mx.com.cst.appear.service;

import jakarta.ejb.Local;
import mx.com.cst.appear.model.Libro;

import java.util.List;
import java.util.Optional;

@Local // Un EJB que maneja transacciones
public interface LibroService {

    List<Libro> listar();
    Optional<Libro> porId(int id);

    void guardar(Libro libro);
    void eliminar(int id);

}
