/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Interface para guardar y recuperar información de
 * esudiantes
 * Modificación: 2019/03/19
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package BaseDeDatos.Alumnos;

import clases.Alumno;
import clases.Materia;
import java.sql.SQLException;
import java.util.List;

public interface IAlumnosDAO {

    /**
     * Metodo para obtener una lista de alumnos registrados
     *
     * @return lista de Alumnos
     * @throws SQLException
     */
    public List<Alumno> getAlumnos() throws SQLException;

    /**
     * Metodo que permite registrar un alumno nuevo
     *
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException
     */
    public int nuevoAlumno(Alumno alumno) throws SQLException;

    /**
     * Metodo que elimina a un alumno de registrado
     *
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException
     */
    public int EliminarAlumno(Alumno alumno) throws SQLException;

    /**
     * Metodo que permite editar la información de un alumno
     *
     * @param alumno objeto de tipo alumno
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException
     */
    public int EditarAlumno(Alumno alumno) throws SQLException;

}
