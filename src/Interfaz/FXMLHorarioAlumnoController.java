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

import BaseDeDatos.Alumnos.AlumnosDAO;
import BaseDeDatos.Horarios.HorarioDAO;
import BaseDeDatos.Materias.MateriasDAO;
import clases.Alumno;
import clases.Horario;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;


public class FXMLHorarioAlumnoController implements Initializable {
    private RegistroAlumnos20 principal;
    private List<Alumno> alumnos = new ArrayList<>();
    AlumnosDAO alumnosDao = new AlumnosDAO();
    HorarioDAO horarioDao = new HorarioDAO();
    ObservableList<Horario> horariost;
    ObservableList<Horario> horariostAlum = FXCollections.observableArrayList();
    private List<Horario> horarios = new ArrayList<>();
    @FXML private Button btnAgregarHorario;
    @FXML private Button btnAgregarMateria;
    @FXML private Button btnBuscar;
    @FXML private Button btnQuitarMateria;
    @FXML private Button btnGuardarHorario;
    
    @FXML private Label lblMateriasDisponibles;
    @FXML private Label lblMateriasSele;
    
    @FXML private TableColumn<Horario, String> colNrc;
    @FXML private TableColumn<Horario, String>colAcademico;
    @FXML private TableColumn<Horario, String> colCupo;
    @FXML private TableColumn<Horario, String> colLun;
    @FXML private TableColumn<Horario, String> colMar;
    @FXML private TableColumn<Horario, String> colMie;
    @FXML private TableColumn<Horario, String> colJue;
    @FXML private TableColumn<Horario, String> colVie;
    @FXML private TableColumn<Horario, String> colSab;
    @FXML private TableColumn<Horario, String> colSaLun;
    @FXML private TableColumn<Horario, String> colSaMar;
    @FXML private TableColumn<Horario, String> colSaMie;
    @FXML private TableColumn<Horario, String> colSaJue;
    @FXML private TableColumn<Horario, String> colSaVie;
    @FXML private TableColumn<Horario, String> colSaSab;
    
    @FXML private TableColumn<Horario, String> colNrcAlum;
    @FXML private TableColumn<Horario, String> colAcademicoAlum;
    @FXML private TableColumn<Horario, String> colCupoAlum;
    @FXML private TableColumn<Horario, String> colLunAlum;
    @FXML private TableColumn<Horario, String> colMarAlum;
    @FXML private TableColumn<Horario, String> colMieAlum;
    @FXML private TableColumn<Horario, String> colJueAlum;
    @FXML private TableColumn<Horario, String> colVieAlum;
    @FXML private TableColumn<Horario, String> colSabAlum;
        
    @FXML private TableColumn<Horario, String> colSaLunAlum;
    @FXML private TableColumn<Horario, String> colSaMarAlum;
    @FXML private TableColumn<Horario, String> colSaMieAlum;
    @FXML private TableColumn<Horario, String> colSaJueAlum;
    @FXML private TableColumn<Horario, String> colSaVieAlum;
    @FXML private TableColumn<Horario, String> colSaSabAlum;
    
    @FXML private TextField lblBuscarMatricula;
    @FXML private TextField lblMatricula;
    @FXML private TextField lblNombreAlumno;
    
    @FXML private TableView<Horario> tblHorario;
    @FXML private TableView<Horario> tblHorarioAlumno;
    
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
    @FXML
    private void SalirPrograma() {
        JOptionPane.showMessageDialog(null, "Hasta la vista");
        System.exit(0);
    }
    
    public Alumno EncontrarAlumno(String matricula) {
            Alumno alumno = null;
            System.out.println(matricula);
        try {
            alumnos = alumnosDao.getAlumnos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            for(Alumno al : alumnos){
                if(al.getMatricula().equals(matricula)){
                    alumno = al;
                    System.out.println("Alumno encontrado");
                }
            }
            return alumno;
        
    }
    public Materia BuscarMateria(int nrc){
        MateriasDAO maDAO = new MateriasDAO();
        Materia materia = null;
        List<Materia> listaMaterias = new ArrayList();
        try {
            listaMaterias = maDAO.getMateria();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorarioAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Materia ma : listaMaterias){
            if(ma.getNrc() == nrc){
                materia = ma;
            }
        }
        return materia;
    }
    
    @FXML
    private void BuscarAlumno(){
        Alumno al = null;
        al = EncontrarAlumno(lblBuscarMatricula.getText());
        if(al != null){
            lblNombreAlumno.setText(al.toString());
            lblMatricula.setText(al.getMatricula());
            lblBuscarMatricula.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Alumno no encontrado");
        }
      
    }
        
    
    public void IniciarInterfaz(){
        lblNombreAlumno.setEditable(false);
        lblMatricula.setEditable(false);
        tblHorarioAlumno.setVisible(false);
        tblHorario.setVisible(false);
        lblMateriasSele.setVisible(false);
        lblMateriasDisponibles.setVisible(false);
        btnAgregarMateria.setVisible(false);
        btnQuitarMateria.setVisible(false);
        btnGuardarHorario.setVisible(false);
    }
    
    @FXML
    private void AgregarHorario(){
        if(!lblNombreAlumno.getText().isEmpty()){
            LlenarTablaHorario();
            tblHorarioAlumno.setVisible(true);
            tblHorario.setVisible(true);
            lblMateriasSele.setVisible(true);
            lblMateriasDisponibles.setVisible(true);
            btnAgregarMateria.setVisible(true);
            btnQuitarMateria.setVisible(true);
            btnGuardarHorario.setVisible(true);
        }
        
    }

    public void LlenarTablaHorario() {
        colNrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
        colAcademico.setCellValueFactory(new PropertyValueFactory<>("academico"));
        colCupo.setCellValueFactory(new PropertyValueFactory<>("cupo"));
        colLun.setCellValueFactory(new PropertyValueFactory<>("lunes"));
        colSaLun.setCellValueFactory(new PropertyValueFactory<>("salonLunes"));
        colMar.setCellValueFactory(new PropertyValueFactory<>("martes"));
        colSaMar.setCellValueFactory(new PropertyValueFactory<>("salonMartes"));
        colMie.setCellValueFactory(new PropertyValueFactory<>("miercoles"));
        colSaMie.setCellValueFactory(new PropertyValueFactory<>("salonMiercoles"));
        colJue.setCellValueFactory(new PropertyValueFactory<>("jueves"));
        colSaJue.setCellValueFactory(new PropertyValueFactory<>("salonJueves"));
        colVie.setCellValueFactory(new PropertyValueFactory<>("viernes"));
        colSaVie.setCellValueFactory(new PropertyValueFactory<>("salonViernes"));
        colSab.setCellValueFactory(new PropertyValueFactory<>("sabado"));
        colSaSab.setCellValueFactory(new PropertyValueFactory<>("salonSabado"));
        try {
            horarios = horarioDao.getHorario();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorarioAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        horariost = FXCollections.observableArrayList();
        for (Horario hr : horarios) {
            horariost.add(hr);
        }
        tblHorario.setItems(horariost);
    }
    
    public void LlenarTablaHorarioAlumno() {
        colNrcAlum.setCellValueFactory(new PropertyValueFactory<>("nrc"));
        colAcademicoAlum.setCellValueFactory(new PropertyValueFactory<>("academico"));
        colCupoAlum.setCellValueFactory(new PropertyValueFactory<>("cupo"));
        colLunAlum.setCellValueFactory(new PropertyValueFactory<>("lunes"));
        colSaLunAlum.setCellValueFactory(new PropertyValueFactory<>("salonLunes"));
        colMarAlum.setCellValueFactory(new PropertyValueFactory<>("martes"));
        colSaMarAlum.setCellValueFactory(new PropertyValueFactory<>("salonMartes"));
        colMieAlum.setCellValueFactory(new PropertyValueFactory<>("miercoles"));
        colSaMieAlum.setCellValueFactory(new PropertyValueFactory<>("salonMiercoles"));
        colJueAlum.setCellValueFactory(new PropertyValueFactory<>("jueves"));
        colSaJueAlum.setCellValueFactory(new PropertyValueFactory<>("salonJueves"));
        colVieAlum.setCellValueFactory(new PropertyValueFactory<>("viernes"));
        colSaVieAlum.setCellValueFactory(new PropertyValueFactory<>("salonViernes"));
        colSabAlum.setCellValueFactory(new PropertyValueFactory<>("sabado"));
        colSaSabAlum.setCellValueFactory(new PropertyValueFactory<>("salonSabado"));
        
        tblHorarioAlumno.setItems(horariostAlum);
    }
    
     public Horario HorarioSeleccionado(Integer tabla) {
        if(tabla.equals(1)){
            if (tblHorario != null) {                
                Horario horario = tblHorario.getSelectionModel().getSelectedItem();
                return horario;
            } else {
                return null;
            }
        }else{
            if (tblHorarioAlumno != null) {                
                Horario horario = tblHorarioAlumno.getSelectionModel().getSelectedItem();
                return horario;
            } else {
                return null;
            }
        }
        
    }
    @FXML
    private void AgregarMateria() {
        Horario hor = HorarioSeleccionado(1);
        if (hor != null) {
            if(validarHorarioAlumno(hor)){
                horariostAlum.add(hor);
                LlenarTablaHorarioAlumno();
            }            
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar una materia de la tabla");
        }
    }
    
    @FXML
    private void QuitarMateria() {
        Horario hor = HorarioSeleccionado(2);
        if (hor != null) {
            horariostAlum.remove(hor);
            LlenarTablaHorarioAlumno();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar una materia de la tabla para quitarla");
        }
    }
    
    public boolean materiaRepetida(Horario hor){
        for(Horario hr: horariostAlum){
            if(hor.equals(hr)){
                return true;
            }
        }
        return false;
    }
    public int numeroCreditosHorarioAlum(Horario hr){
        int totalCreditos = 0;
        Materia ma;
        for(Horario hor : horariostAlum){
            ma = BuscarMateria(hor.getNrc());
            totalCreditos += ma.getCreditos();
        }
        ma = BuscarMateria(hr.getNrc());
        return totalCreditos + ma.getCreditos();
    }
    
    public boolean validarHorarioAlumno(Horario hor){
        if(!horariostAlum.isEmpty()){
            if(materiaRepetida(hor)){
                JOptionPane.showMessageDialog(null, 
                        "La materia ya ha sido seleccionada");
                return false;
            }
            if(numeroCreditosHorarioAlum(hor) > 35){
                JOptionPane.showMessageDialog(null, 
                        "Solo puede tener 35 créditos en esta inscripcion");
                return false;
            }
        }
        return true;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IniciarInterfaz();
    }    
    
}
