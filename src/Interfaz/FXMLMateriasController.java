/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Controller que permite el manejo de la interface gráfica de
 * la ventana Materias.
 * Modificación: 2019/03/19
 * FXML Controller Class
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package Interfaz;

import BaseDeDatos.Materias.MateriasDAO;
import clases.Materia;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;


public class FXMLMateriasController implements Initializable {

    private List<Materia> mate = new ArrayList<>();
    MateriasDAO controller = new MateriasDAO();
    ObservableList<Materia> materiaOb;
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btnAgregar;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Button btnGuardar;
    @FXML private Button btnGuardarEdicion;
    @FXML private Button btnSalir;
    @FXML private Button btnVentanaAlumnos;
    @FXML private TableColumn<Materia, String> colCreditos;
    @FXML private TableColumn<Materia, String> colHorasPracticas;
    @FXML private TableColumn<Materia, String> colHorasTeoricas;
    @FXML private TableColumn<Materia, String> colNombre;
    @FXML private TableColumn<Materia, String> colNrc;
    @FXML private TextField lblCreditos;
    @FXML private TextField lblHorasPracticas;
    @FXML private TextField lblHorasTeoricas;
    @FXML private TextField lblNombre;
    @FXML private TextField lblNrc;
    @FXML private TableView<Materia> tblMaterias;
    @FXML private Menu menuAlumnos;
    @FXML private Menu menuMaterias;
    
    /**
     * Método que muestra y mensaje de despedida y cierra el programa.
     *
     * @param event
     */
    @FXML
    private void SalirPrograma(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Hasta la vista");
        System.exit(0);
    }
    
    /**
     * Método que llena la tableView de los objetos detipo materia.
     *
     * @throws SQLException
     */
    @FXML
    private void LlenarTabla() throws SQLException {
        colNrc.setCellValueFactory
        (new PropertyValueFactory<>("nrc"));
        colNombre.setCellValueFactory
        (new PropertyValueFactory<>("nombre"));
        colCreditos.setCellValueFactory
        (new PropertyValueFactory<>("creditos"));
        colHorasTeoricas.setCellValueFactory
        (new PropertyValueFactory<>("horasTeoricas"));
        colHorasPracticas.setCellValueFactory
        (new PropertyValueFactory<>("horasPracticas"));
        
        mate = controller.getMateria();
        materiaOb = FXCollections.observableArrayList();
        for (Materia materia : mate) {
            materiaOb.add(materia);
        }
        tblMaterias.setItems(materiaOb);
    }
    
    /**
     * Método que inicia la interfaz bloqueando los textField, limpiandolos y
     * ocultando el boton de guardar
     */
    @FXML
    private void IniciarInterfaz(){
        btnGuardar.setVisible(false);
        btnGuardarEdicion.setVisible(false);
        lblNrc.setText("");
        lblNombre.setText("");
        lblCreditos.setText("");
        lblHorasPracticas.setText("");
        lblHorasTeoricas.setText("");
        lblNrc.setEditable(false);
        lblNombre.setEditable(false);
        lblCreditos.setEditable(false);
        lblHorasPracticas.setEditable(false);
        lblHorasTeoricas.setEditable(false);
    }
    
    /**
     * Método que permite editar los textField para que se pueda ingresar 
     * infromación.
     */
    @FXML
    private void ActivarFormulario(){
        lblNrc.setEditable(true);
        lblNombre.setEditable(true);
        lblCreditos.setEditable(true);
        lblHorasPracticas.setEditable(true);
        lblHorasTeoricas.setEditable(true);
    }
    
    /**
     * Método que permite guardar la informacion de los textField en un
     * objeto de materia para después ser guardados por un metodo de la 
     * clase MateriasDAO.
     * @throws SQLException 
     */
    @FXML
    private void GuardarMateria() throws SQLException {
        if(ValidarCampos()){
            Materia ma = new Materia();
            ma.setNrc(Integer.parseInt(lblNrc.getText()));
            ma.setNombre(lblNombre.getText());
            ma.setCreditos(Integer.parseInt(lblCreditos.getText()));
            ma.setHorasPracticas(lblHorasPracticas.getText());
            ma.setHorasTeoricas(lblHorasTeoricas.getText());
            controller.NuevaMateria(ma);
            JOptionPane.showMessageDialog(null, "Materia Guardada");
            IniciarInterfaz();
            LlenarTabla();
        }
    }
    
    /**
     * Valida que todos los campos hayn sido llenados
     * @return true si todos los campos estan llenos, false si alguno 
     * falta por llenarse.
     */
    public boolean ValidarCampos() {
        if (lblNrc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar NRC");
            return false;
        }
        if (lblNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar Nombre");
            return false;
        }
        if (lblCreditos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar Creditos");
            return false;
        }
        if (lblHorasPracticas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar horas practivas");
            return false;
        }
        if (lblHorasTeoricas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar horas teoricas");
            return false;
        }
        return true;
    }
    
    /**
     * Obtiene el elemnto seleccionado en la TableView
     * @return regresa un objeto de tipo Materia 
     */
    @FXML
    private Materia AlumnoSeleccionado() {
        if (tblMaterias != null) {
            Materia materia = tblMaterias.getSelectionModel().getSelectedItem();
            return materia;
        } else {
            return null;
        }
    }
    
    /**
     * Inicia la interfaz y activa el formulario.
     */
    @FXML
    private void AgregarMateria(){
        IniciarInterfaz();
        ActivarFormulario();
        btnGuardar.setVisible(true);
    }
    /**
     * Elimina el elemento seleccionado de la tableView
     * @throws SQLException 
     */
    @FXML
    private void Eliminar() throws SQLException {
        Materia mat = AlumnoSeleccionado();
        if (mat != null) {
            int respuesta = JOptionPane.showOptionDialog
            (null,"¿Estas seguro que deseas eliminar el alumno?","Cerrar sesion", 
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controller.EliminarMateria(mat);
                        JOptionPane.showMessageDialog(null, "Alumno Eliminada");
                        LlenarTabla();
                    }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar una materia de la tabla");
        }
    }
    
    /**
     * Muestra la infromacion en el formulario de un elemento seleccionado en
     * la tableView
     */
    @FXML
    private void Editar() {
        Materia materia = AlumnoSeleccionado();
        if (materia != null) {
            IniciarInterfaz();
            ActivarFormulario();
            btnGuardarEdicion.setVisible(true);
            lblNrc.setText(Integer.toString(materia.getNrc()));
            lblNombre.setText(materia.getNombre());
            lblCreditos.setText(Integer.toString(materia.getCreditos()));
            lblHorasPracticas.setText(materia.getHorasPracticas());
            lblHorasTeoricas.setText(materia.getHorasTeoricas());
            lblNrc.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar un alumno de la tabla");
        }

    }
    
    /**
     *Modifica un elemento que se selecciono de la tableView 
     * @throws SQLException 
     */
    @FXML
    private void GuardarEditar() throws SQLException {
        if (ValidarCampos()) {
            Materia ma = new Materia();
            ma.setNrc(Integer.parseInt(lblNrc.getText()));
            ma.setNombre(lblNombre.getText());
            ma.setCreditos(Integer.parseInt(lblCreditos.getText()));
            ma.setHorasPracticas(lblHorasPracticas.getText());
            ma.setHorasTeoricas(lblHorasTeoricas.getText());
            controller.EditarMateria(ma);
            JOptionPane.showMessageDialog(null, "Materia Editada");
            IniciarInterfaz();
            LlenarTabla();
        }
        
        
    }
    
    private RegistroAlumnos20 principal;
    /**
     * obtiene el stage principal para poder navegar entre ventanas
     * @param principal stage principal
     */
    public void setProgramaPrincipal(RegistroAlumnos20 principal){
        this.principal = principal;
    }
    
    /**
     * Permite navegar a la ventana Alumnos.
     */
    @FXML
    private void VentanaAlumnos(){
        principal.VentanaPrincipal();
    }
    /**
     * Permite navegar a la ventana Materias.
     */
    @FXML
    private void VentanaMaterias(){
        principal.VentanaMaterias();
    }
    /**
     * Permite navegar a la ventana Horarios.
     */
    @FXML
    private void VentanaHorarios(){
        principal.VentanaHorarios();
    }
    @FXML
    private void VentanaHorarioAlumno(){
        principal.VentanaHorarioAlumno();
    }
    
    

    /**
     * Inicializa la interfaz de javaFX
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IniciarInterfaz();
        try {
            LlenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMateriasController.class.getName()).log
        (Level.SEVERE, null, ex);
        }
    }
    
    
      
    
}
