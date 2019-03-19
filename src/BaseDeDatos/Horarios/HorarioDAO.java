/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Horarios;

import BaseDeDatos.Conectar;
import clases.Horario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vik-t
 */
public class HorarioDAO implements IHorarioDAO{

    @Override
    public List<Horario> getHorario() throws SQLException {
        List<Horario> lista = new ArrayList<>();
        Statement s;
        Connection conn = null;
        conn = new Conectar().getConnection();
        ResultSet rs = null;
        String sQuery = "SELECT * from horarios";
        try {
            s = conn.createStatement();
            rs = s.executeQuery(sQuery);
            System.out.println("Ejecutó la consulta");
            while (rs != null && rs.next()) {
                Horario hr = new Horario();
                hr.setIdHorario(rs.getInt("idhorario"));
                hr.setNrc(rs.getInt("nrc"));
                hr.setAcademico(rs.getString("academico"));
                hr.setSalon(rs.getString("salon"));
                hr.setCupo(rs.getInt("cupo"));
                hr.setLunes(rs.getString("lunes"));
                hr.setMartes(rs.getString("martes"));
                hr.setMiercoles(rs.getString("miercoles"));
                hr.setJueves(rs.getString("jueves"));
                hr.setViernes(rs.getString("viernes"));
                hr.setSabado(rs.getString("sabado"));
                lista.add(hr);
            }
        } catch (SQLException e) {
            System.err.println("Error: "
                    + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            conn.close();
        }
        if (lista != null) {
            System.out.println("Lista llena");
        } else {
            System.out.println("Lista vacia");
        }
        return lista;
    }

    @Override
    public int NuevoHorario(Horario horario) throws SQLException {
       Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "INSERT INTO horarios(academico,salon,cupo,nrc,lunes,martes,miercoles,jueves,viernes,sabado)"
                + "VALUES ('" + horario.getAcademico() + "','" + horario.getSalon() + "','"
                + horario.getCupo() + "','" + horario.getNrc() + "','" + horario.getLunes() + "','" 
                + horario.getMartes()+ "','" + horario.getMiercoles() + "','" + horario.getJueves()
                + "','" + horario.getViernes() + "','" + horario.getSabado() + "');";
        System.out.println(sentencia);
        try {
            conn = new Conectar().getConnection();
            s = conn.createStatement();
            return s.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            conn.close();
        }
        return -1;
    }

    @Override
    public int EliminarHorario(Horario horario) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "DELETE FROM horarios WHERE idhorario ='" + horario.getIdHorario() + "';";
        System.out.println(sentencia);
        try {
            conn = new Conectar().getConnection();
            s = conn.createStatement();
            return s.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.err.println("Error: "
                    + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            conn.close();
        }
        return -1;
    }

    @Override
    public int EditarHorario(Horario horario) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;

        sentencia = "UPDATE horarios SET academico = '" + horario.getAcademico()
                + "', salon = '" + horario.getSalon()
                +"', cupo = '" + horario.getCupo()
                + "', lunes = '" + horario.getLunes()
                + "', martes = '" + horario.getMartes()
                + "', miercoles = '" + horario.getMiercoles()
                + "', jueves = '" + horario.getJueves()
                + "', viernes = '" + horario.getViernes()
                + "', sabado = '" + horario.getSabado()
                + "', nrc = '" + horario.getNrc()
                + "' WHERE idhorario = '" + horario.getIdHorario()
                + "';";
        System.out.println(sentencia);
        try {
            conn = new Conectar().getConnection();
            s = conn.createStatement();
            return s.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            conn.close();
        }
        return -1;
    }
    
    
    
    
}
