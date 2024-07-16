package infrastructure.database;

import domain.models.Articulo;
import infrastructure.IPersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLPersistenciaImpl implements IPersistencia {
    private Connection conexion;

    public MySQLPersistenciaImpl() {
        this.conexion = DatabaseConnection.getConnection();
    }

    @Override
    public void guardarArticulo(Articulo articulo) {
        String query = "INSERT INTO articulo (nombre, precio) VALUES (?,?,?)";

        try{
            PreparedStatement preparador = this.conexion.prepareStatement(query);
            preparador.setString(1, articulo.getNombre());
            preparador.setDouble(2, articulo.getPrecio());
            preparador.executeUpdate();
            preparador.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
