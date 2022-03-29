package clase5;

public class UsuarioJuego {
    private String nombre;
    private String clave;
    private double puntaje;
    private int nivel;

    public UsuarioJuego(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }


    @Override
    public String toString() {
        return "UsuarioJuego{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", puntaje=" + puntaje +
                ", nivel=" + nivel +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public int getNivel() {
        return nivel;
    }

    public void aumentaPuntaje(){
        this.puntaje+=1;
    }
    public void subirNivel(){
        this.nivel+=1;
    }

    public void bonus(int valor){
        this.puntaje+=valor;
    }
}
