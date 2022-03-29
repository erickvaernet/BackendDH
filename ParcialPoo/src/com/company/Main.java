package com.company;

public class Main {

    public static void main(String[] args) {
        Consulta c1= new Consulta("10/11/2021","Bromatología",10,30);

        PacienteObraSocial po1= new PacienteObraSocial("10/01/1995","Erick","Vaernet",c1,
                true,"Osde",12411);

        Consulta c2= new Consulta("10/12/2021","Bromatología",11,50);

        PacienteObraSocial po2= new PacienteObraSocial("10/02/1999","Rock","Vaernet",c2,
                false,"Osde",19921);

        System.out.println("Paciente con obra social 1: "+po1);
        System.out.println("Paciente con obra social 2: "+po2);

        System.out.println("Paciente po1 debe realizar evaluacion inicial ? " +
                (po1.debeRealizarseEvaluacionInicial()?"SI":"NO"));
        System.out.println("Paciente po2 debe realizar evaluacion inicial ? " +
                (po2.debeRealizarseEvaluacionInicial()?"SI":"NO"));

        System.out.println("Paciente con O.Social 1 tiene mayor numero de asociado que el paciente 2:"+
                (po1.compareTo(po2)>1?"SI":"NO") );

        Consulta c3= new Consulta("03/01/2022","Micología",9,00);

        PacienteParticular pp1= new PacienteParticular("10/09/1994","Rick","Sanchez",c3,
                true,3000d,3265812);
        System.out.println("Paciente Particular 1: "+pp1);
    }
}
