/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Interface para guardar y recuperar la informacion de
 * las materias registradas.
 * Modificación: 2019/03/19
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package BaseDeDatos.Materias;

import clases.Materia;
import java.sql.SQLException;
import java.util.List;


public interface IMateriasDAO {
    /**
     * Método que obtiene una lista de las materias registradas.
     * @return lista de objetos de materias registradas
     * @throws SQLException 
     */
    public List<Materia> getMateria() throws SQLException;
    
    /**
     * Método que permite registrar una materia nueva.
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    public int NuevaMateria(Materia materia) throws SQLException;
    
    /**
     * Método que permite eliminar una materia registrada
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    public int EliminarMateria(Materia materia) throws SQLException;
    
    /**
     * Método que modifica una materia registrada.
     * @param materia objeto de tipo materia.
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1.
     * @throws SQLException 
     */
    public int EditarMateria(Materia materia) throws SQLException;
}
