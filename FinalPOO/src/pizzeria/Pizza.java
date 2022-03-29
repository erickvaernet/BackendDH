package pizzeria;

public abstract class Pizza {
    private String nombre;
    private String descripcion;

    public Pizza(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    abstract Double calcularPrecio();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Pizza '" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio= $" + calcularPrecio() +
                '}';
    }
}
