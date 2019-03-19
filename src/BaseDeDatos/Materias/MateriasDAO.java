/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Implementacion de la interface IMateriasDAO.
 * Modificación: 2019/03/19
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package BaseDeDatos.Materias;

import BaseDeDatos.Conectar;
import BaseDeDatos.Conectar;
import BaseDeDatos.Materias.IMateriasDAO;
import clases.Materia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MateriasDAO implements IMateriasDAO{
    /**
     * Implemantación de la interface IMateriasDAO. Método que obtiene una 
     * lista de las materias registradas.
     * @return lista de objetos de materias registradas
     * @throws SQLException 
     */
    @Override
    public List<Materia> getMateria() throws SQLException{
        List<Materia> lista = new ArrayList<Materia>();
        Statement s;
        Connection conn = null;
        conn = new Conectar().getConnection();
        ResultSet rs = null;
        String sQuery = "SELECT * from materias";
        try {
            s = conn.createStatement();
            rs = s.executeQuery(sQuery);
            System.out.println("Ejecutó la consulta");
            while (rs != null && rs.next()) {
                Materia ma = new Materia();
                ma.setNrc(rs.getInt("nrc"));
                ma.setNombre(rs.getString("nombre"));
                ma.setCreditos(rs.getInt("creditos"));
                ma.setHorasPracticas(rs.getString("horasPracticas"));
                ma.setHorasTeoricas(rs.getString("horasTeoricas"));
                lista.add(ma);
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
     * Implemantación de la interface IMateriasDAO. Método que permite 
     * registrar una materia nueva.
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    @Override
    public int NuevaMateria(Materia materia) throws SQLException{
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "INSERT INTO materias(nrc,nombre,creditos,horasPracticas, "
                + "horasTeoricas) VALUES ('" + materia.getNrc() + "','" 
                + materia.getNombre() + "','"+ materia.getCreditos() 
                + "','" + materia.getHorasPracticas() +"','" 
                + materia.getHorasTeoricas() + "');";
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

    /**
     * Implemantación de la interface IMateriasDAO. Método que permite 
     * eliminar una materia registrada
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    @Override
    public int EliminarMateria(Materia materia) throws SQLException{
        Statement s;
        String sentencia;
        Connection conn = null;

        ResultSet rs = null;

        sentencia = "DELETE FROM materias WHERE nrc ='" + materia.getNrc() + "';";
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
     * Implemantación de la interface IMateriasDAO. Método que modifica 
     * una materia registrada.
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    @Override
    public int EditarMateria(Materia materia) throws SQLException{
        Statement s;
        String sentencia;
        Connection conn = null;

        ResultSet rs = null;

        sentencia = "UPDATE materias SET nombre = '" + materia.getNombre() 
                + "', creditos = '" + materia.getCreditos() 
                + "', horasPracticas = '" + materia.getHorasPracticas()
                + "', horasTeoricas = '" +materia.getHorasTeoricas()
                + "' WHERE nrc = '" + materia.getNrc() + "';";
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
