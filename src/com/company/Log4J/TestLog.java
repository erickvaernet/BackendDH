package com.company.Log4J;

import org.apache.log4j.Logger;

public class TestLog {
    //private static final Logger logger = Logger.getLogger(TestLog.class);
    public static void main(String[] args) {
        /*
        logger.info("Empezamos nuestro metodo MAIN");
        try {
            String variable = "Hola";
            int division = 1 / 0;
        } catch (Exception e) {
            logger.error("Error por dividir por cero ", e);
        }
        logger.warn("Advertencia el metodo MAIN esta por finalizar");
        logger.debug("Esto va a mostrarse solo si el infoLogger esta en DEBUG");
        logger.info("Finalizamos el thread MAIN");
        */
        Leon leon =new Leon("leon1",9,false);
        leon.correr();
        leon.esMayorA10();

        Animal tigre= new Tigre("tigre1",20);
        tigre.correr();

        try {
            Animal tigre2= new Tigre("tigre1",-1);
            tigre2.correr();
        }catch(Exception e){
            StaticLogger.logger.error("Error al crear tigre 2:",e);
        }

        leon.correr();



    }
}
