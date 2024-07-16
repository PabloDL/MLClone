package infrastructure;

import domain.models.Articulo;

import java.util.ArrayList;


public interface IPersistencia {

    void guardarArticulo(Articulo articulo);

    Articulo findByNombre(String nombreArticulo);

    ArrayList<Articulo> getAllArticulos();

    void deleteArticulo (int id);
}
