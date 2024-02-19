import java.util.Date;

public class Tienda {
    private String nombre;
    private String dirección;
    private String teléfono;
    private Producto[] productos;
    
    public Tienda(String nombre, String dirección, String teléfono, Producto[] productos) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.productos = productos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}


enum TipoProducto {
    LACTEO,
    CARNICO,
    FRUTA,
    ENLATADO
}

class Producto {
    private int código;
    private String nombre;
    private TipoProducto tipo;
    private Date fechaExpiración;
    private String fabricante;
    private int cantidadInventario;
    private double precioUnitario;
    
    public Producto(int código, String nombre, TipoProducto tipo, Date fechaExpiración, String fabricante, int cantidadInventario, double precioUnitario) {
        this.código = código;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaExpiración = fechaExpiración;
        this.fabricante = fabricante;
        this.cantidadInventario = cantidadInventario;
        this.precioUnitario = precioUnitario;
    }
    
    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Date getFechaExpiración() {
        return fechaExpiración;
    }

    public void setFechaExpiración(Date fechaExpiración) {
        this.fechaExpiración = fechaExpiración;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

