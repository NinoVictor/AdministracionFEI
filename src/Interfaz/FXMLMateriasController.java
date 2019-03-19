/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
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
    
    
    @FXML
    private void SalirPrograma(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Hasta la vista");
        System.exit(0);
    }
    
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
    @FXML
    private void ActivarFormulario(){
        lblNrc.setEditable(true);
        lblNombre.setEditable(true);
        lblCreditos.setEditable(true);
        lblHorasPracticas.setEditable(true);
        lblHorasTeoricas.setEditable(true);
    }
    
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
    
    
    @FXML
    private Materia AlumnoSeleccionado() {
        if (tblMaterias != null) {
            Materia materia = tblMaterias.getSelectionModel().getSelectedItem();
            return materia;
        } else {
            return null;
        }
    }
    
    @FXML
    private void AgregarMateria(){
        IniciarInterfaz();
        ActivarFormulario();
        btnGuardar.setVisible(true);
    }
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
