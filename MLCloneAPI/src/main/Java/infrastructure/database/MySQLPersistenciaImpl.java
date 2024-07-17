package infrastructure.database;

import domain.models.Articulo;
import infrastructure.IPersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLPersistenciaImpl implements IPersistencia {
    private Connection conexion;

    public MySQLPersistenciaImpl() {
        this.conexion = DatabaseConnection.getConnection();
    }

    @Override
    public void guardarArticulo(Articulo articulo) {
        String query = "INSERT INTO articulo (nombreArticulo, nombreVendedor, descripcion, precio, precioEnvio) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement preparador = this.conexion.prepareStatement(query);
            preparador.setString(1, articulo.getNombreArticulo().toLowerCase());
            preparador.setString(2, articulo.getNombreVendedor().toLowerCase());
            preparador.setString(3, articulo.getDescripcion());
            preparador.setDouble(4, articulo.getPrecio());
            preparador.setDouble(5, articulo.getPrecioEnvio());
            preparador.executeUpdate();
            preparador.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Articulo findByNombre(String nombreArticulo) {
        String query = "SELECT * FROM articulo WHERE articulo.nombreArticulo = ?";

        try {
            PreparedStatement preparador = this.conexion.prepareStatement(query);
            preparador.setString(1, nombreArticulo);
            ResultSet resultados = preparador.executeQuery();

            if(resultados.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(resultados.getInt("id"));
                articulo.setNombreArticulo(resultados.getString("nombreArticulo"));
                articulo.setNombreVendedor(resultados.getString("nombreVendedor"));
                articulo.setDescripcion(resultados.getString("descripcion"));
                articulo.setPrecio(resultados.getDouble("precio"));
                articulo.setPrecioEnvio(resultados.getDouble("precioEnvio"));

                return articulo;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ArrayList<Articulo> getAllArticulos() {
        String query = "SELECT * FROM articulo";

        try{
            ArrayList<Articulo> articulos = new ArrayList<Articulo>();

            PreparedStatement preparador = this.conexion.prepareStatement(query);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()){
                Articulo articulo = new Articulo();

                articulo.setId(resultados.getInt("id"));
                articulo.setNombreArticulo(resultados.getString("nombreArticulo"));
                articulo.setNombreVendedor(resultados.getString("nombreVendedor"));
                articulo.setDescripcion(resultados.getString("descripcion"));
                articulo.setPrecio(resultados.getDouble("precio"));
                articulo.setPrecioEnvio(resultados.getDouble("precioEnvio"));

                articulos.add(articulo);

            }
            return articulos;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteArticulo(int id) {
        String query = "DELETE FROM articulo WHERE id = ?";

        try {
            PreparedStatement preparador = this.conexion.prepareStatement(query);
            preparador.setInt(1, id);

            preparador.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
