package mx.com.cst.appear.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.cst.appear.model.Libro;
import mx.com.cst.appear.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Stateless // EJB
public class LibroServiceImp implements LibroService{

    @Inject
    private CrudRepository<Libro> libroCrudRepository;

    @Override
    public List<Libro> listar() {
        return libroCrudRepository.listar();
    }

    @Override
    public Optional<Libro> porId(int id) {
        return Optional.ofNullable(libroCrudRepository.porId(id));
    }

    @Override
    public void guardar(Libro libro) {
        libroCrudRepository.guardar(libro);
    }

    @Override
    public void eliminar(int id) {
        libroCrudRepository.eliminar(id);
    }

}
