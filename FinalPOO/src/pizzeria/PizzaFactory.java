package pizzeria;

public class PizzaFactory {
    private static PizzaFactory instance;
    public static final String MUZZA_CHICA = "MUZZA_CHICA";
    public static final String ESPECIAL_CHICA = "ESPECIAL_CHICA";
    public static final String ANANA_CHICA = "ANANA_CHICA";
    public static final String COMBINADA_LOCA = "COMBINADA_LOCA";


    private PizzaFactory(){}

    public static PizzaFactory getInstance(){
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza crearPizza(String codigoPizza) throws RuntimeException {
        switch (codigoPizza) {
            case MUZZA_CHICA: return new PizzaSimple("Muzzarella chica","Solo queso",700d,false);
            case ESPECIAL_CHICA: return new PizzaSimple("Especial chica","Con queso y jamon",850d,false);
            case ANANA_CHICA: return new PizzaSimple("Anana chica","Con queso y anana",950d,false);
            case COMBINADA_LOCA:
                PizzaCombinada pizzaCombinadaLoca = new PizzaCombinada("Combinada Loca", "Mitad especial y mitad anana");
                pizzaCombinadaLoca.agregarPizza(crearPizza(ESPECIAL_CHICA));
                pizzaCombinadaLoca.agregarPizza(crearPizza(ANANA_CHICA));
                return pizzaCombinadaLoca;
            default: throw new RuntimeException("Código de pizza inválido");
        }
    }


}
