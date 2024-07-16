package infrastructure;

import domain.models.Articulo;


public interface IPersistencia {

    void guardarArticulo(Articulo articulo);
}
