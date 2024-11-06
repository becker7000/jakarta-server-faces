package mx.com.cst.appear.repository;

import java.util.List;

public interface CrudRepository <T>{

    List<T> listar();
    T porId(int id);
    void guardar(T t);
    void eliminar(int id);

}
