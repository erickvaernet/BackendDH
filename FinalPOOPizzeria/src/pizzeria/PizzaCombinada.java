package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class PizzaCombinada extends Pizza{
    private List<Pizza> pizzas;

    public PizzaCombinada(String nombre, String descripcion) {
        super(nombre, descripcion);
        this.pizzas=new ArrayList<>();
    }

    public void agregarPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    @Override
    Double calcularPrecio() {
        double precioTotal=0;
        for (Pizza pizza:this.pizzas) {
            precioTotal+=pizza.calcularPrecio();
        }
        precioTotal = precioTotal/pizzas.size();
        return precioTotal;
    }
}
