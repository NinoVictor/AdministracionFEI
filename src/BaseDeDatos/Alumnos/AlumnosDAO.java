/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Esta clase genera las consultas que se utilizaran para
 * agregar, eliminar y editar Alumnos.
 * Modificación: 2019/02/27
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/25
 */
package BaseDeDatos.Alumnos;

import BaseDeDatos.Conectar;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import clases.Alumno;
public class AlumnosDAO implements IAlumnosDAO{

    /**
     * Método que hace una consulta a la base de datos y retorna una lista de
     * objetos
     *
     * @return lista de alumnos que se encuentran en la base de datos.
     * @throws SQLException
     */
    @Override
    public List<Alumno> getAlumnos() throws SQLException {
        List<Alumno> lista = new ArrayList<>();
        Statement s;
        Connection conn = null;
        conn = new Conectar().getConnection();
        ResultSet rs = null;
        String sQuery = "SELECT * from alumnos";
        try {
            s = conn.createStatement();
            rs = s.executeQuery(sQuery);
            System.out.println("Ejecutó la consulta");
            while (rs != null && rs.next()) {
                Alumno al = new Alumno();
                al.setMatricula(rs.getString("matricula"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidoPaterno(rs.getString("paterno"));
                al.setApellidoMaterno(rs.getString("materno"));
                lista.add(al);
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
     * Metodo que guarda en la base de datos un alumno.
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    
    @Override
    public int nuevoAlumno(Alumno alumno) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;
        ResultSet rs = null;
        sentencia = "INSERT INTO alumnos(matricula,nombre,paterno,materno) "
                + "VALUES ('" + alumno.getMatricula() + "','" + alumno.getNombre() + "','"
                + alumno.getApellidoPaterno() + "','" + alumno.getApellidoMaterno() + "');";
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
     * Método que elimina a un alumno de la base de datos
     *
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException
     */
    @Override
    public int EliminarAlumno(Alumno alumno) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;

        ResultSet rs = null;

        sentencia = "DELETE FROM alumnos WHERE matricula ='" + alumno.getMatricula() + "';";
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
     * Método que edita la información de un alumno de la base de datos.
     *
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException
     */
    @Override
    public int EditarAlumno(Alumno alumno) throws SQLException {
        Statement s;
        String sentencia;
        Connection conn = null;

        ResultSet rs = null;

        sentencia = "UPDATE alumnos SET nombre = '" + alumno.getNombre() + "', paterno = '"
                + alumno.getApellidoPaterno() + "', materno = '" 
                + alumno.getApellidoMaterno() + "' WHERE matricula = '" + alumno.getMatricula()
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
