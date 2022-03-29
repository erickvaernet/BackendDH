package pizzeria;

public class Test {
    public static void main(String[] args) {
        Pizzeria pizzaLoca = new Pizzeria("Pizza Loca");

        pizzaLoca.agregarPizza(PizzaFactory.MUZZA_CHICA);
        pizzaLoca.agregarPizza(PizzaFactory.ESPECIAL_CHICA);
        pizzaLoca.agregarPizza(PizzaFactory.ANANA_CHICA);
        pizzaLoca.agregarPizza(PizzaFactory.COMBINADA_LOCA);

        pizzaLoca.mostrarPizzas();



    }
}
