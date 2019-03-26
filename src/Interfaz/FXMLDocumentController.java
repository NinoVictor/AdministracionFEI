/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Definicion de los metodos que se usaran en la interfaz así
 * como los metodos para los eventos de los botones y bajas, altas de
 * alumnos
 * Modificación: 2019/02/27
 * FXML Controller Class
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/25
 */
package Interfaz;

import clases.Alumno;
import BaseDeDatos.Alumnos.AlumnosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable{

    /**
     * Declaración de las variables y componentes de la interfaz
     */
    private List<Alumno> al = new ArrayList<>();// Lista de objetos alum
    AlumnosDAO controller = new AlumnosDAO();
    ObservableList<Alumno> alumnost;
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btnAgregar;
    @FXML private Rectangle formulario;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Button btnGuardar;
    @FXML private Button btnGuardarEditar;
    @FXML private Button btnSalir;
    @FXML private Button btnVentanaNueva;
    @FXML private TableColumn<Alumno, String> colApellidoMaterno;
    @FXML private TableColumn<Alumno, String> colApellidoPaterno;
    @FXML private TableColumn<Alumno, String> colMatricula;
    @FXML private TableColumn<Alumno, String> colNombre;
    @FXML private Label label;
    @FXML private TextField lblApellidoMaterno;
    @FXML private TextField lblApellidoPaterno;
    @FXML private TextField lblMatricula;
    @FXML private TextField lblNombre;
    @FXML private TableView<Alumno> tabla;
    @FXML private Menu menuAlumnos;
    @FXML private Menu menuMaterias;

    /**
     * Método que muestra y mensaje de despedida y cierra el programa.
     *
     */
    @FXML
    private void SalirPrograma() {
        JOptionPane.showMessageDialog(null, "Hasta la vista");
        System.exit(0);
    }

    /**
     * Método que llena la tableView de los objetos alumnos.
     *
     * @throws SQLException
     */
    @FXML
    private void LlenarTabla() throws SQLException {
        colMatricula.setCellValueFactory
        (new PropertyValueFactory<>("matricula"));
        colNombre.setCellValueFactory
        (new PropertyValueFactory<>("nombre"));
        colApellidoPaterno.setCellValueFactory
        (new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory
        (new PropertyValueFactory<>("apellidoMaterno"));
        al = controller.getAlumnos();
        alumnost = FXCollections.observableArrayList();
        for (Alumno alumno : al) {
            alumnost.add(alumno);
        }
        tabla.setItems(alumnost);
    }

    /**
     * Método que inicia la interfaz bloqueando los textField, limpiandolos y
     * ocultando el boton de guardar
     */
    @FXML
    private void IniciarInterfaz() {
        lblMatricula.setEditable(false);
        lblNombre.setEditable(false);
        lblApellidoPaterno.setEditable(false);
        lblApellidoMaterno.setEditable(false);
        btnGuardar.setVisible(false);
        btnGuardarEditar.setVisible(false);
        lblMatricula.setText("");
        lblNombre.setText("");
        lblApellidoPaterno.setText("");
        lblApellidoMaterno.setText("");

    }

    /**
     * Método que habilita los textField y muestra el botón de guardar
     */
    @FXML
    private void AgregarAlumno() {
        IniciarInterfaz();
        lblMatricula.setEditable(true);
        lblNombre.setEditable(true);
        lblApellidoPaterno.setEditable(true);
        lblApellidoMaterno.setEditable(true);
        btnGuardar.setVisible(true);
    }

    /**
     * Método que obtiene el texto de los textField y los envía al a la clase
     * conexiónSQL para guardar los datos del alumno en la BD
     *
     * @throws SQLException
     */
    @FXML
    private void GuardarAlumno() throws SQLException {
        if (ValidarCampos()) {
            Alumno alm = new Alumno();
            alm.setNombre(lblNombre.getText());
            alm.setMatricula(lblMatricula.getText());
            alm.setApellidoPaterno(lblApellidoPaterno.getText());
            alm.setApellidoMaterno(lblApellidoMaterno.getText());
            controller.nuevoAlumno(alm);
            JOptionPane.showMessageDialog(null, "Alumno Guardado");
            LlenarTabla();
            IniciarInterfaz();
        }
    }

    /**
     * Valida que los TextField no estén vacíos
     *
     * @return regresa un false si alguno está vació y true si todos están
     * llenos
     */
    @FXML
    private boolean ValidarCampos() {
        if (lblMatricula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar Matricula");
            return false;
        }
        if (lblNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar Nombre");
            return false;
        }
        if (lblApellidoPaterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar apellido paterno");
            return false;
        }
        if (lblApellidoMaterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llenar apellido materno");
            return false;
        }
        return true;
    }

    /**
     * Método que obtiene el objeto que está siendo seleccionado en la tabla
     *
     * @return regresa un objeto alumno si la tabla no está vacía y un null si
     * lo está.
     */
    @FXML
    private Alumno AlumnoSeleccionado() {
        if (tabla != null) {
            Alumno alumno = tabla.getSelectionModel().getSelectedItem();
            return alumno;
        } else {
            return null;
        }
    }

    /**
     * Método que muestra el alumno seleccionado en los TextField para que
     * después puedan ser editados.
     */
    @FXML
    private void Editar() {
        Alumno alumno = AlumnoSeleccionado();
        if (alumno != null) {
            lblMatricula.setEditable(true);
            lblNombre.setEditable(true);
            lblApellidoPaterno.setEditable(true);
            lblApellidoMaterno.setEditable(true);
            btnGuardar.setVisible(false);
            btnGuardarEditar.setVisible(true);
            for (Alumno alu : al) {
                if (alumno.getMatricula() == alu.getMatricula()) {
                    lblMatricula.setText(alu.getMatricula());
                    lblNombre.setText(alu.getNombre());
                    lblApellidoPaterno.setText(alu.getApellidoPaterno());
                    lblApellidoMaterno.setText(alu.getApellidoMaterno());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar un alumno de la tabla");
        }

    }

    /**
     * Método que obtiene el texto de los textField y los envía al a la clase
     * conexiónSQL para editar los datos del alumno en la BD
     *
     * @throws SQLException
     */
    @FXML
    private void GuardarEditar() throws SQLException {
        if (ValidarCampos()) { 
            Alumno alum = new Alumno();
            alum.setNombre(lblNombre.getText());
            alum.setMatricula(lblMatricula.getText());
            alum.setApellidoPaterno(lblApellidoPaterno.getText());
            alum.setApellidoMaterno(lblApellidoMaterno.getText());
            controller.EditarAlumno(alum);
            JOptionPane.showMessageDialog(null, "Alumno Modificado");
        }
        LlenarTabla();
        IniciarInterfaz();
    }

    /**
     * Método que obtiene el texto de los textField y envía la matrícula a la
     * clase conexiónSQL para eliminar los datos del alumno en la BD.
     *
     * @throws SQLException
     */
    @FXML
    private void Eliminar() throws SQLException {
        Alumno alumno = AlumnoSeleccionado();
        if (alumno != null) {
            for (Alumno alu : al) {
                if (alumno.getMatricula() == alu.getMatricula()) {
                    int respuesta = JOptionPane.showOptionDialog(null,
                            "¿Estas seguro que deseas eliminar el alumno?",
                            "Cerrar sesion", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controller.EliminarAlumno(alu);
                        JOptionPane.showMessageDialog(null, "Alumno Eliminado");
                        LlenarTabla();
                    }
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar un alumno de la tabla");
        }
    }
    
    
    private RegistroAlumnos20 principal;
    
    public void setProgramaPrincipal(RegistroAlumnos20 principal){
        this.principal = principal;
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
    private void VentanaHorarios(){
        principal.VentanaHorarios();
    }
    @FXML
    private void VentanaHorarioAlumno(){
        principal.VentanaHorarioAlumno();
    }
    

    /**
     * Método que inicializa los metodos en la interfaz.
     *
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Llenando tabla...");
        IniciarInterfaz();
        try {
            LlenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
