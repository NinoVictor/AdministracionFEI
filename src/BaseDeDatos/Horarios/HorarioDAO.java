/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Implementación de la Interface IHorarioDAO.
 * Modificación: 2019/03/19
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
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
public class HorarioDAO implements IHorarioDAO {

    /**
     * Implementación de la clase IHorarioDAO, método que obtiene una lista 
     * de los horarios registrados.
     * @return lista de objetos de horario
     * @throws SQLException 
     */
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
                hr.setCupo(rs.getInt("cupo"));
                hr.setLunes(rs.getString("lunes"));
                hr.setMartes(rs.getString("martes"));
                hr.setMiercoles(rs.getString("miercoles"));
                hr.setJueves(rs.getString("jueves"));
                hr.setViernes(rs.getString("viernes"));
                hr.setSabado(rs.getString("sabado"));
                hr.setSalonLunes(rs.getString("salonlunes"));
                hr.setSalonMartes(rs.getString("salonmartes"));
                hr.setSalonMiercoles(rs.getString("salonmiercoles"));
                hr.setSalonJueves(rs.getString("salonjueves"));
                hr.setSalonViernes(rs.getString("salonviernes"));
                hr.setSalonSabado(rs.getString("salonsabado"));
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

    /**
     * Implementación de la clase IHorarioDAO, método que registra un nuevo 
     * horario
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    @Override
    public int NuevoHorario(Horario horario) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "INSERT INTO horarios(academico,salonsabado,cupo,nrc,lunes,"
                + "martes,miercoles,jueves,viernes,sabado,salonlunes,"
                + "salonmartes,salonmiercoles,salonjueves,salonviernes)"
                + " VALUES ('" + horario.getAcademico() + "','" + horario.getSalonSabado()
                + "','" + horario.getCupo() + "','" 
                + horario.getNrc() + "','" + horario.getLunes() + "','"
                + horario.getMartes() + "','" + horario.getMiercoles() 
                + "','" + horario.getJueves() + "','" + horario.getViernes() 
                + "','" + horario.getSabado() + "','" + horario.getSalonLunes()
                + "','" + horario.getSalonMartes() + "','" + horario.getSalonMiercoles()
                + "','" + horario.getSalonJueves() + "','" + horario.getSalonViernes()
                + "');";
        System.out.println(sentencia);
        try {
            conn = new Conectar().getConnection();
            s = conn.createStatement();
            return s.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" 
                    + e.getErrorCode());
        } finally {
            conn.close();
        }
        return -1;
    }

     /**
     * Implementación de la clase IHorarioDAO, método que elimina un horario 
     * registrado
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    @Override
    public int EliminarHorario(Horario horario) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "DELETE FROM horarios WHERE idhorario ='" 
                + horario.getIdHorario() + "';";
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

    /**
     * Implementación de la clase IHorarioDAO, método que modifica la 
     * informacion de un horario registrado
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    @Override
    public int EditarHorario(Horario horario) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;

        sentencia = "UPDATE horarios SET academico = '" + horario.getAcademico()
                
                + "', cupo = '" + horario.getCupo()
                + "', lunes = '" + horario.getLunes()
                + "', martes = '" + horario.getMartes()
                + "', miercoles = '" + horario.getMiercoles()
                + "', jueves = '" + horario.getJueves()
                + "', viernes = '" + horario.getViernes()
                + "', sabado = '" + horario.getSabado()
                + "', nrc = '" + horario.getNrc()
                + "', salonlunes = '" + horario.getSalonLunes()
                + "', salonmartes = '" + horario.getSalonMartes()
                + "', salonmiercoles = '" + horario.getSalonMiercoles()
                + "', salonjueves = '" + horario.getSalonJueves()
                + "', salonviernes = '" + horario.getSalonViernes()
                + "', salonsabado = '" + horario.getSalonSabado()
                + "' WHERE idhorario = '" + horario.getIdHorario()
                + "';";
        System.out.println(sentencia);
        try {
            conn = new Conectar().getConnection();
            s = conn.createStatement();
            return s.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" 
                    + e.getErrorCode());
        } finally {
            conn.close();
        }
        return -1;
    }

}
