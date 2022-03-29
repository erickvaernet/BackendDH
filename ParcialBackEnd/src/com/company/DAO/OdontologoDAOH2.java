package com.company.DAO;
import com.company.Models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDAO<Odontologo>{
    private static final Logger logger = Logger.getLogger(Odontologo.class);
    private Connection connection;

    public OdontologoDAOH2() {
        this.connection=DBH2Singleton.getConnection();
    }

    public OdontologoDAOH2(Connection c) {
        this.connection=c;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        PreparedStatement ps;
        int id;
        try {
            ps= connection.prepareStatement(
                    "INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1,odontologo.getNumeroMatricula());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getApellido());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id=generatedKeys.getInt(1);
                odontologo.setId(id);
                logger.info("Se guardo "+ odontologo + " en la tabla ODONTOLOGOS" );
            }
            ps.close();
        } catch (Exception e) {
            logger.error("Error al guardar odontologo en la Base de Datos:"+e.getMessage());
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        PreparedStatement ps=null;
        try {
            ps= connection.prepareStatement("DELETE FROM odontologos WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            logger.info("Se elimino el odontologo de id:"+id+" de la tabla ODONTOLOGOS" );
            ps.close();

        } catch (Exception e) {
            logger.error("No se pudo eliminar el odontologo de las Base de Datos");
            e.printStackTrace();
        }

    }

    @Override
    public Odontologo buscar(int id) {
        PreparedStatement ps=null;
        Odontologo odontologo=null;

        try {
            ps= connection.prepareStatement("SELECT * FROM odontologos WHERE id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int matriculaOdontologo= rs.getInt("matricula");
                String nombreOdontologo= rs.getString("nombre");
                String apellidoOdontologo= rs.getString("apellido");
                odontologo= new Odontologo(id,matriculaOdontologo,nombreOdontologo,apellidoOdontologo);
            }
            if(odontologo!=null) logger.info("Tras la busqueda se encontro "+odontologo+" en la tabla ODONTOLOGOS" );
            logger.info("Tras la busqueda NO se encontro el odontologo de id="+id+" en la tabla ODONTOLOGOS" );
            ps.close();
        } catch (Exception e) {
            logger.error("No se pudo encontrar el odontologo en la Base de Datos");
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        PreparedStatement ps=null;
        ArrayList<Odontologo> listaOdontologos= new ArrayList<>();
        String info="";
        try {
            ps= connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int idOdontologo= rs.getInt("id");
                int matriculaOdontologo= rs.getInt("matricula");
                String nombreOdontologo= rs.getString("nombre");
                String apellidoOdontologo= rs.getString("apellido");
                Odontologo odontologo= new Odontologo(idOdontologo,matriculaOdontologo,nombreOdontologo,apellidoOdontologo);
                listaOdontologos.add(odontologo);
                info+=("-> "+odontologo+"\n");
            }
            if (info != "") {
                logger.info("Se obtuvo ListaOdontoogos:\n"+info);
            }
            ps.close();
        } catch (Exception e) {
            logger.error("No se pudo encontrar el odontologo en la Base de Datos");
            e.printStackTrace();
        }
        return listaOdontologos;
    }
}
