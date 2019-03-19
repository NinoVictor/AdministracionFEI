/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Alumnos;

import clases.Alumno;
import clases.Materia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vik-t
 */
public interface IAlumnosDAO {
    public List<Alumno> getAlumnos() throws SQLException ;
    public int nuevoAlumno(Alumno alumno) throws SQLException;
    public int EliminarAlumno(Alumno alumno) throws SQLException;
    public int EditarAlumno(Alumno alumno) throws SQLException;
    
    
}
