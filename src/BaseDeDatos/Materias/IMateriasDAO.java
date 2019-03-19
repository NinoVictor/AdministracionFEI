/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Materias;

import clases.Materia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vik-t
 */
public interface IMateriasDAO {
    public List<Materia> getMateria() throws SQLException;
    public int NuevaMateria(Materia materia) throws SQLException;
    public int EliminarMateria(Materia materia) throws SQLException;
    public int EditarMateria(Materia materia) throws SQLException;
}
