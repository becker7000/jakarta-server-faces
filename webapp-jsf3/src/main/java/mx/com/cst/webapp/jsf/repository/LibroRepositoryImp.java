package mx.com.cst.webapp.jsf.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import mx.com.cst.webapp.jsf.model.Libro;

import java.util.List;

@RequestScoped // Componente CDI
public class LibroRepositoryImp implements CrudRepository<Libro> {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Libro> listar() {
        return entityManager.
                createQuery("SELECT l FROM Libro l").
                getResultList();
    }

    @Override
    public Libro porId(int id) {
        return entityManager.find(Libro.class,id);
    }

    @Override
    public void guardar(Libro libro) {
        if(libro.getId()>0){
            entityManager.merge(libro);
        }else {
            entityManager.persist(libro);
        }
    }

    @Override
    public void eliminar(int id) {
        Libro libro = porId(id);
        entityManager.remove(libro);
    }
}
