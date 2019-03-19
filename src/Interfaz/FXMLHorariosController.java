/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.Horarios.HorarioDAO;
import BaseDeDatos.Materias.MateriasDAO;
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
import javafx.scene.control.ComboBox;
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
public class FXMLHorariosController implements Initializable {
    private RegistroAlumnos20 principal;
    private List<Horario> horarios = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>() ;
    MateriasDAO conMate = new MateriasDAO();
    HorarioDAO controller = new HorarioDAO();
    ObservableList<Horario> horariost;
    ObservableList<Materia> materiast;
    ObservableList<String> horasInicio;
    ObservableList<String> horasFin;
    @FXML private Button btnGuardar;
    @FXML private ComboBox<Materia> cbMateria;
    @FXML private TextField lblAcademico;
    @FXML private TextField lblCupo;
    @FXML private TextField lblSalon;
    @FXML private Button btnGuardarEdicion; 
    @FXML private ComboBox<String> cbjuevesfin;
    @FXML private ComboBox<String> cbjuevesinicio;
    @FXML private ComboBox<String> cblunesfin;
    @FXML private ComboBox<String> cblunesinicio;
    @FXML private ComboBox<String> cbmartesfin;
    @FXML private ComboBox<String> cbmartesinicio;
    @FXML private ComboBox<String> cbmiercolesfin;
    @FXML private ComboBox<String> cbmiercolesinicio;
    @FXML private ComboBox<String> cbsabadofin;
    @FXML private ComboBox<String> cbsabadoinicio;
    @FXML private ComboBox<String> cbviernesfin;
    @FXML private ComboBox<String> cbviernesinicio;
    @FXML private TableColumn<Horario, String> colAcademico;
    @FXML private TableColumn<Horario, String> colCupo;
    @FXML private TableColumn<Horario, String> colJue;
    @FXML private TableColumn<Horario, String> colLun;
    @FXML private TableColumn<Horario, String> colMar;
    @FXML private TableColumn<Horario, String> colMie;
    @FXML private TableColumn<Horario, String> colNrc;
    @FXML private TableColumn<Horario, String> colSab;
    @FXML private TableColumn<Horario, String> colSalon;
    @FXML private TableColumn<Horario, String> colVie;
    @FXML private TableView<Horario> tlbHorario;
    
    @FXML
    private void VentanaMaterias(){
        principal.VentanaMaterias();
    }
    
    public void setProgramaPrincipal(RegistroAlumnos20 principal){
        this.principal = principal;
    }
    
    @FXML
    private void VentanaAlumnos(){
        principal.VentanaPrincipal();
    }
    @FXML
    private void VentanaHorarios(){
        principal.VentanaHorarios();
    }
    
    @FXML
    private void SalirPrograma() {
        JOptionPane.showMessageDialog(null, "Hasta la vista");
        System.exit(0);
    }
    
    public void cargarMaterias(){
        try {
            materias = conMate.getMateria();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        materiast = FXCollections.observableArrayList();
        for(Materia ma : materias){
            materiast.add(ma);  
        }
        cbMateria.setItems(materiast);
        
    }
    
    
    public void cargarHorasInicio(){
        String hor[]={"NULL","07:00","08:00","09:00","10:00","11:00","12:00","13:00",
        "14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        horasInicio =FXCollections.observableArrayList();
        for(int i=0; i<15; i++){
            horasInicio.add(hor[i]);
        }
        cblunesinicio.setItems(horasInicio);
        cbmartesinicio.setItems(horasInicio);
        cbmiercolesinicio.setItems(horasInicio);
        cbjuevesinicio.setItems(horasInicio);
        cbviernesinicio.setItems(horasInicio);
        cbsabadoinicio.setItems(horasInicio);
        
        cblunesinicio.getSelectionModel().selectFirst();
        cbmartesinicio.getSelectionModel().selectFirst();
        cbmiercolesinicio.getSelectionModel().selectFirst();
        cbjuevesinicio.getSelectionModel().selectFirst();
        cbviernesinicio.getSelectionModel().selectFirst();
        cbsabadoinicio.getSelectionModel().selectFirst();
        
    }
    
    public void cargarHorasFin(){
        String hor2[]={"NULL","07:59","08:59","09:59","10:59","11:59","12:59","13:59",
        "14:59","15:59","16:59","17:59","18:59","19:59","20:59"};
        
        horasFin =FXCollections.observableArrayList();
        for(int i=0; i<15; i++){
            horasFin.add(hor2[i]);
        }
        cblunesfin.setItems(horasFin);
        cbmartesfin.setItems(horasFin);
        cbmiercolesfin.setItems(horasFin);
        cbjuevesfin.setItems(horasFin);
        cbviernesfin.setItems(horasFin);
        cbsabadofin.setItems(horasFin);
        
        cblunesfin.getSelectionModel().selectFirst();
        cbmartesfin.getSelectionModel().selectFirst();
        cbmiercolesfin.getSelectionModel().selectFirst();
        cbjuevesfin.getSelectionModel().selectFirst();
        cbviernesfin.getSelectionModel().selectFirst();
        cbsabadofin.getSelectionModel().selectFirst();
        
    }
    
    
    
    
    public void LlenarTabla() throws SQLException {
        colNrc.setCellValueFactory
        (new PropertyValueFactory<>("nrc"));
        colAcademico.setCellValueFactory
        (new PropertyValueFactory<>("academico"));
        colSalon.setCellValueFactory
        (new PropertyValueFactory<>("salon"));
        colCupo.setCellValueFactory
        (new PropertyValueFactory<>("cupo"));
        colLun.setCellValueFactory
        (new PropertyValueFactory<>("lunes"));
        colMar.setCellValueFactory
        (new PropertyValueFactory<>("martes"));
        colMie.setCellValueFactory
        (new PropertyValueFactory<>("miercoles"));
        colJue.setCellValueFactory
        (new PropertyValueFactory<>("jueves"));
        colVie.setCellValueFactory
        (new PropertyValueFactory<>("viernes"));
        colSab.setCellValueFactory
        (new PropertyValueFactory<>("sabado"));
        horarios = controller.getHorario();
        horariost = FXCollections.observableArrayList();
        for (Horario hr : horarios) {
            horariost.add(hr);
        }
        tlbHorario.setItems(horariost);
    }
    
    
    public void IniciarInterfaz(){
        btnGuardar.setVisible(false);
        btnGuardarEdicion.setVisible(false);
        lblAcademico.setDisable(true);
        lblCupo.setDisable(true);
        lblSalon.setDisable(true);
        cbMateria.setDisable(true);
        lblAcademico.setText("");
        lblCupo.setText("");
        lblSalon.setText("");
        cbMateria.getSelectionModel().select(0);
        cblunesinicio.getSelectionModel().selectFirst();
        cbmartesinicio.getSelectionModel().selectFirst();
        cbmiercolesinicio.getSelectionModel().selectFirst();
        cbjuevesinicio.getSelectionModel().selectFirst();
        cbviernesinicio.getSelectionModel().selectFirst();
        cbsabadoinicio.getSelectionModel().selectFirst();
        cblunesfin.getSelectionModel().selectFirst();
        cbmartesfin.getSelectionModel().selectFirst();
        cbmiercolesfin.getSelectionModel().selectFirst();
        cbjuevesfin.getSelectionModel().selectFirst();
        cbviernesfin.getSelectionModel().selectFirst();
        cbsabadofin.getSelectionModel().selectFirst();
    }
    
    public void ActivarFormulario(){
        lblAcademico.setDisable(false);
        lblCupo.setDisable(false);
        lblSalon.setDisable(false);
        cbMateria.setDisable(false);
    }
    
    
    public void AgregarHorario(){
        IniciarInterfaz();
        ActivarFormulario();
        btnGuardar.setVisible(true);
    }
    
    public boolean ValidarCampos() {
        if (cbMateria.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Seleccionar Materia");
            return false;
        }
        if (lblAcademico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregar Academico");
            return false;
        }
        
        if (lblSalon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregar salon");
            return false;
        }
        if (lblCupo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregar cupo");
            return false;
        }
        
        return true;
    }
    
    public Horario HorarioSeleccionado() {
        if (tlbHorario != null) {
            Horario alumno = tlbHorario.getSelectionModel().getSelectedItem();
            return alumno;
        } else {
            return null;
        }
    }

    
    @FXML
    private void GuardarHorario() throws SQLException {
        if (ValidarCampos()) {
            Horario hor = new Horario();
            hor.setNrc(cbMateria.getSelectionModel().getSelectedItem().getNrc());
            hor.setAcademico(lblAcademico.getText());
            hor.setSalon(lblSalon.getText());
            hor.setCupo(Integer.parseInt(lblCupo.getText()));
            if("NULL".equals(cblunesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cblunesfin.getSelectionModel().getSelectedItem())){
                 hor.setLunes("NULL");
            }else{
                hor.setLunes(cblunesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cblunesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbmartesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbmartesfin.getSelectionModel().getSelectedItem())){
                 hor.setMartes("NULL");
            }else{
                hor.setMartes(cbmartesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbmartesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbmiercolesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbmiercolesfin.getSelectionModel().getSelectedItem())){
                 hor.setMiercoles("NULL");
            }else{
                hor.setMiercoles(cbmiercolesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbmiercolesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbjuevesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbjuevesfin.getSelectionModel().getSelectedItem())){
                 hor.setJueves("NULL");
            }else{
                hor.setJueves(cbjuevesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbjuevesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbviernesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbviernesfin.getSelectionModel().getSelectedItem())){
                 hor.setViernes("NULL");
            }else{
                hor.setViernes(cbviernesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbviernesfin.getSelectionModel().getSelectedItem());
            }
            if("NULL".equals(cbsabadoinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbsabadofin.getSelectionModel().getSelectedItem())){
                 hor.setSabado("NULL");
            }else{
                hor.setSabado(cbsabadoinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbsabadofin.getSelectionModel().getSelectedItem());
            } 
            controller.NuevoHorario(hor);
            JOptionPane.showMessageDialog(null, "Horario Guardado");
            LlenarTabla();
            IniciarInterfaz();
        }
        
    }
    
    @FXML
    private void EliminarHorario() throws SQLException {
        Horario hor = HorarioSeleccionado();
        if (hor != null) {
            int respuesta = JOptionPane.showOptionDialog
            (null,"¿Estas seguro que deseas eliminarlo?","Eliminar Horario", 
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controller.EliminarHorario(hor);
                        JOptionPane.showMessageDialog(null, "Horario Eliminado");
                        LlenarTabla();
                    }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Seleccionar una materia de la tabla");
        }
    }
    
    public Materia EncontrarMateria(Horario hor){
        Materia mate = null;
        try {
            materias = conMate.getMateria();
            for(Materia ma : materias){
                if(ma.getNrc() == hor.getNrc()){
                    mate= ma;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mate;
    }
    public String SepararHoras(String hora, int i){
        String hInicio = null;
        if("NULL".equals(hora)){
            return hora;
        }else{
            String[] parts = hora.split("-");
            if(i == 0){
                return hInicio = parts[0];
            }else{
                return hInicio = parts[1];
            }
        }
        
        
    }
    @FXML
    private void EditarHorario(){
        Horario hor = HorarioSeleccionado();
        if (hor != null) {
            IniciarInterfaz();
            ActivarFormulario();
            btnGuardarEdicion.setVisible(true);
            Materia ma = EncontrarMateria(hor);
            cbMateria.getSelectionModel().select(ma);
            lblAcademico.setText(hor.getAcademico());
            lblSalon.setText(hor.getSalon());
            lblCupo.setText(Integer.toString(hor.getCupo()));
            cblunesinicio.getSelectionModel().select(SepararHoras(hor.getLunes(),0));
            cblunesfin.getSelectionModel().select(SepararHoras(hor.getLunes(),1));
            
            cbmartesinicio.getSelectionModel().select(SepararHoras(hor.getMartes(),0));
            cbmartesfin.getSelectionModel().select(SepararHoras(hor.getMartes(),1));
            
            cbmiercolesinicio.getSelectionModel().select(SepararHoras(hor.getMiercoles(),0));
            cbmiercolesfin.getSelectionModel().select(SepararHoras(hor.getMiercoles(),1));
            
            cbjuevesinicio.getSelectionModel().select(SepararHoras(hor.getJueves(),0));
            cbjuevesfin.getSelectionModel().select(SepararHoras(hor.getJueves(),1));
            
            cbviernesinicio.getSelectionModel().select(SepararHoras(hor.getViernes(),0));
            cbviernesfin.getSelectionModel().select(SepararHoras(hor.getViernes(),1));
            
            cbsabadoinicio.getSelectionModel().select(SepararHoras(hor.getSabado(),0));
            cbsabadofin.getSelectionModel().select(SepararHoras(hor.getSabado(),1));
            
            cbMateria.setDisable(true);
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar un alumno de la tabla");
        }
    }
    
    @FXML
    private void GuardarEdicion() throws SQLException{
        Horario hor = HorarioSeleccionado();
        if (hor != null) {
            btnGuardarEdicion.setVisible(true);
            hor.setAcademico(lblAcademico.getText());
            hor.setSalon(lblSalon.getText());
            hor.setCupo(Integer.parseInt(lblCupo.getText()));
            if("NULL".equals(cblunesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cblunesfin.getSelectionModel().getSelectedItem())){
                 hor.setLunes("NULL");
            }else{
                hor.setLunes(cblunesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cblunesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbmartesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbmartesfin.getSelectionModel().getSelectedItem())){
                 hor.setMartes("NULL");
            }else{
                hor.setMartes(cbmartesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbmartesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbmiercolesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbmiercolesfin.getSelectionModel().getSelectedItem())){
                 hor.setMiercoles("NULL");
            }else{
                hor.setMiercoles(cbmiercolesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbmiercolesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbjuevesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbjuevesfin.getSelectionModel().getSelectedItem())){
                 hor.setJueves("NULL");
            }else{
                hor.setJueves(cbjuevesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbjuevesfin.getSelectionModel().getSelectedItem());
            }
            
            if("NULL".equals(cbviernesinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbviernesfin.getSelectionModel().getSelectedItem())){
                 hor.setViernes("NULL");
            }else{
                hor.setViernes(cbviernesinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbviernesfin.getSelectionModel().getSelectedItem());
            }
            if("NULL".equals(cbsabadoinicio.getSelectionModel().getSelectedItem()) 
                    | "NULL".equals(cbsabadofin.getSelectionModel().getSelectedItem())){
                 hor.setSabado("NULL");
            }else{
                hor.setSabado(cbsabadoinicio.getSelectionModel().getSelectedItem() 
                    + "-" +cbsabadofin.getSelectionModel().getSelectedItem());
            } 
            controller.EditarHorario(hor);
            JOptionPane.showMessageDialog(null, "Horario Modificado");
            LlenarTabla();
            IniciarInterfaz();
            
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar un alumno de la tabla");
        }
        
    }
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarMaterias();
        cargarHorasInicio();
        cargarHorasFin();
        IniciarInterfaz();
        try {
            LlenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
