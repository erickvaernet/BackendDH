package clase6;

public class Main {
    public static void main(String[] args) {
        Perro p1= new Perro("hola",2000,5.7,true,false,"Kira");

        System.out.println("p1 = " + p1);
        System.out.println("edad:"+p1.obtenerEdadEnAnios());
        System.out.println("Puede perderse:"+p1.puedePerderse());
        System.out.println(p1.enAdopcion);
        Abstracta a1;

    }
}
