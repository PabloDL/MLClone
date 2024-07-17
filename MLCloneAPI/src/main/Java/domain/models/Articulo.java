package domain.models;

public class Articulo {
    private int id;
    private String nombreArticulo;
    private String nombreVendedor;
    private String descripcion;
    private double precio;
    private double precioEnvio;

    public Articulo(){}

    public Articulo(String nombreArticulo, String nombreVendedor, String descripcion, double precio, double precioEnvio) {
        this.nombreArticulo = nombreArticulo;
        this.nombreVendedor = nombreVendedor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioEnvio = precioEnvio;
    }

    public Articulo(int id, String nombreArticulo, String nombreVendedor, String descripcion, double precio, double precioEnvio) {
        this.id = id;
        this.nombreArticulo = nombreArticulo;
        this.nombreVendedor = nombreVendedor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioEnvio = precioEnvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
}
