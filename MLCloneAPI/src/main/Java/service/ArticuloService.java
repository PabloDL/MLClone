package service;

import domain.models.Articulo;
import infrastructure.IPersistencia;
import infrastructure.database.MySQLPersistenciaImpl;

import java.util.ArrayList;

public class ArticuloService implements IPersistencia {
    private IPersistencia persistencia = new MySQLPersistenciaImpl();

    @Override
    public void guardarArticulo(Articulo articulo) {
        persistencia.guardarArticulo(articulo);
    }

    @Override
    public Articulo findByNombre(String nombreArticulo) {
        return persistencia.findByNombre(nombreArticulo);
    }

    @Override
    public ArrayList<Articulo> getAllArticulos() {
        return persistencia.getAllArticulos();
    }

    public void deleteArticulo (int id){
        persistencia.deleteArticulo(id);
    }

}
