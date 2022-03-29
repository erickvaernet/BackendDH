package practica;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Paciente p1= new Paciente("Erick","Vaernet");
        Paciente p2= new Paciente("Erick","Vaernet");

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        Set s= new TreeSet();
        s.add("a");
        s.add("b");
        s.add("bc");

        s.remove("a");

        Iterator it= s.iterator();

        while (it.hasNext()){
          String str= (String) it.next();
          if(str.equals("b")) System.out.println("encontrado");
        }
    }
}
