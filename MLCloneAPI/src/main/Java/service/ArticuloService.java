package service;

import domain.models.Articulo;
import infrastructure.IPersistencia;
import infrastructure.database.MySQLPersistenciaImpl;

public class ArticuloService implements IPersistencia {
    private IPersistencia persistencia = new MySQLPersistenciaImpl();

    @Override
    public void guardarArticulo(Articulo articulo) {
        persistencia.guardarArticulo(articulo);
    }
}
