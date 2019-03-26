/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Clase que contiene el controlador de la interfaz Horario 
 * Alumno
 * Modificación: 2019/03/21
 * FXML Controller class
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/21
 */
package Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class FXMLHorarioAlumnoController implements Initializable {
    private RegistroAlumnos20 principal;
    public void setProgramaPrincipal(RegistroAlumnos20 principal){
        this.principal = principal;
    }
    @FXML
    private void VentanaHorarios(){
        principal.VentanaHorarios();
    }
    @FXML
    private void VentanaAlumnos(){
        principal.VentanaPrincipal();
    }
    @FXML
    private void VentanaMaterias(){
        principal.VentanaMaterias();
    }
    @FXML
    private void VentanaHorarioAlumno(){
        principal.VentanaHorarioAlumno();
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
