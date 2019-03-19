/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Interface para guardar y recuperar la informacion de
 * los horarios registrados.
 * Modificación: 2019/03/19
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package BaseDeDatos.Horarios;

import clases.Horario;
import java.sql.SQLException;
import java.util.List;


public interface IHorarioDAO {
    /**
     * Método que obtiene un alista de los horarios registrados
     * @return lista de objetos de horario
     * @throws SQLException 
     */
    public List<Horario> getHorario() throws SQLException;
    
    /**
     * Método que registra un nuevo horario
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    public int NuevoHorario(Horario horario) throws SQLException;
    
    /**
     * Método que elimina un horario registrado
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    public int EliminarHorario(Horario horario) throws SQLException;
    
    /**
     * Método que modifica la informacion de un horario registrado
     * @param horario objeto de tipo horario
     * @return regresa el resultado de la operacón de la sentencia MySQL si es
     * que fue exitosa, si no regresa -1
     * @throws SQLException 
     */
    public int EditarHorario(Horario horario) throws SQLException;
}
