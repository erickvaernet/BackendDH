package pizzeria;

public class PizzaSimple extends Pizza{
    private Double precioBase;
    private boolean esGrande;

    public PizzaSimple(String nombre, String descripcion, Double precioBase, boolean esGrande) {
        super(nombre, descripcion);
        this.precioBase = precioBase;
        this.esGrande = esGrande;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isEsGrande() {
        return esGrande;
    }

    public void setEsGrande(boolean esGrande) {
        this.esGrande = esGrande;
    }

    @Override
    Double calcularPrecio() {
        if(esGrande) return precioBase * 2;
        return precioBase;
    }
}
