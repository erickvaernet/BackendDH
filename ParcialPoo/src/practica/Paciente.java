package practica;

import com.company.Consulta;

public class Paciente {

    private String nombre;
    private String apellido;

    public Paciente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public int hashCode() {
        int hash= 31;
        hash = hash * nombre.hashCode();
        hash = hash * apellido.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", apellido='" + apellido ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return nombre.equals(paciente.nombre) && apellido.equals(paciente.apellido);
    }
}
