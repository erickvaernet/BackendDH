package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private String nombre;
    private List<Pizza> pizzas;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.pizzas = new ArrayList<>();
    }

    public void agregarPizza(String codigoPizza){
        this.pizzas.add(PizzaFactory.getInstance().crearPizza(codigoPizza));
    }
    public void mostrarPizzas(){
        System.out.println("Pizzas en '" + this.toString() + "' :");
        for (Pizza pizza : pizzas) {
            System.out.println(" -"+pizza);
        }
    }

    @Override
    public String toString() {
        return "Pizzeria " + this.nombre;
    }
}
