package clase5;

public class Main {
    public static void main(String[] args) {
        UsuarioJuego usuario1= new UsuarioJuego("erick","1234");
        UsuarioJuego usuario2= new UsuarioJuego("","123as4");

        System.out.println(usuario1);
        System.out.println(usuario2);

        System.out.println("----------------------------");
        usuario1.subirNivel();
        usuario1.aumentaPuntaje();
        usuario1.bonus(500);
        System.out.println(usuario1);




    }
}
