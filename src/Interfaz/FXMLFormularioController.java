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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class FXMLFormularioController implements Initializable {

    private List<Materia> materias = new ArrayList<>();
    ObservableList<Materia> materiast;
    MateriasDAO conMate = new MateriasDAO();
    HorarioDAO controller = new HorarioDAO();
    ObservableList<String> horasInicio;
    ObservableList<String> horasFin;
    @FXML private Button btnGuardar;
    @FXML private ComboBox<Materia> cbMateria;
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
    @FXML private TextField lblAcademico;
    @FXML private TextField lblCupo;
    @FXML private TextField lblsalonjueves;
    @FXML private TextField lblsalonlunes;
    @FXML private TextField lblsalonmartes;
    @FXML private TextField lblsalonmiercoles;
    @FXML private TextField lblsalonsabado;
    @FXML private TextField lblsalonviernes;
    private Stage stagePrincipal;
    private RegistroAlumnos20 principal;
    private boolean nuevo;
    private Horario horario;


    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public void setStagePrincipal(Stage principal){
        this.stagePrincipal = principal;
        
    }
    public void setProgramaPrincipal(RegistroAlumnos20 principal){
        this.principal = principal;
    }
    @FXML
    private void VentanaHorarios(){
        this.stagePrincipal.close();
        //principal.VentanaHorarios();
    }
    
    public void cargarMaterias() {
        try {
            materias = conMate.getMateria();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        materiast = FXCollections.observableArrayList();
        for (Materia ma : materias) {
            materiast.add(ma);
        }
        cbMateria.setItems(materiast);

    }
    public void cargarHorasInicio() {
        String hor[] = {"-", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
            "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
        horasInicio = FXCollections.observableArrayList();
        for (int i = 0; i < 15; i++) {
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
    
    public void cargarHorasFin() {
        String hor2[] = {"-", "07:59", "08:59", "09:59", "10:59", "11:59", "12:59", "13:59",
            "14:59", "15:59", "16:59", "17:59", "18:59", "19:59", "20:59"};

        horasFin = FXCollections.observableArrayList();
        for (int i = 0; i < 15; i++) {
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
    public boolean ValidarCampos() {
        if (cbMateria.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Seleccionar Materia");
            return false;
        }
        if (lblAcademico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregar Academico");
            return false;
        }

        if (lblCupo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregar cupo");
            return false;
        }

        return true;
    }
    
    @FXML
    private void Guardar() throws SQLException{
        if(this.nuevo){
            GuardarHorario();
        }else{
            GuardarEdicion();
        }
    }
    
    public void GuardarHorario() throws SQLException {
        if (ValidarCampos()) {
            Horario hor = new Horario();
            hor.setNrc(cbMateria.getSelectionModel().getSelectedItem().getNrc());
            hor.setAcademico(lblAcademico.getText());
            hor.setSalonLunes(lblsalonlunes.getText());
            hor.setSalonMartes(lblsalonmartes.getText());
            hor.setSalonMiercoles(lblsalonmiercoles.getText());
            hor.setSalonJueves(lblsalonjueves.getText());
            hor.setSalonViernes(lblsalonviernes.getText());
            hor.setSalonSabado(lblsalonsabado.getText());
            hor.setCupo(Integer.parseInt(lblCupo.getText()));
            if ("NULL".equals(cblunesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cblunesfin.getSelectionModel().getSelectedItem())) {
                hor.setLunes("NULL");
            } else {
                hor.setLunes(cblunesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cblunesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbmartesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbmartesfin.getSelectionModel().getSelectedItem())) {
                hor.setMartes("NULL");
            } else {
                hor.setMartes(cbmartesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbmartesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbmiercolesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbmiercolesfin.getSelectionModel().getSelectedItem())) {
                hor.setMiercoles("NULL");
            } else {
                hor.setMiercoles(cbmiercolesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbmiercolesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbjuevesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbjuevesfin.getSelectionModel().getSelectedItem())) {
                hor.setJueves("NULL");
            } else {
                hor.setJueves(cbjuevesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbjuevesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbviernesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbviernesfin.getSelectionModel().getSelectedItem())) {
                hor.setViernes("NULL");
            } else {
                hor.setViernes(cbviernesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbviernesfin.getSelectionModel().getSelectedItem());
            }
            if ("NULL".equals(cbsabadoinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbsabadofin.getSelectionModel().getSelectedItem())) {
                hor.setSabado("NULL");
            } else {
                hor.setSabado(cbsabadoinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbsabadofin.getSelectionModel().getSelectedItem());
            }
            controller.NuevoHorario(hor);
            JOptionPane.showMessageDialog(null, "Horario Guardado");
            
        }
    }
    
    public void GuardarEdicion() throws SQLException {
        Horario hor = this.horario;
        if (hor != null) {
            hor.setAcademico(lblAcademico.getText());
            hor.setSalonLunes(lblsalonlunes.getText());
            hor.setSalonMartes(lblsalonmartes.getText());
            hor.setSalonMiercoles(lblsalonmiercoles.getText());
            hor.setSalonJueves(lblsalonjueves.getText());
            hor.setSalonViernes(lblsalonviernes.getText());
            hor.setSalonSabado(lblsalonsabado.getText());
            hor.setCupo(Integer.parseInt(lblCupo.getText()));
            if ("NULL".equals(cblunesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cblunesfin.getSelectionModel().getSelectedItem())) {
                hor.setLunes("NULL");
            } else {
                hor.setLunes(cblunesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cblunesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbmartesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbmartesfin.getSelectionModel().getSelectedItem())) {
                hor.setMartes("NULL");
            } else {
                hor.setMartes(cbmartesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbmartesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbmiercolesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbmiercolesfin.getSelectionModel().getSelectedItem())) {
                hor.setMiercoles("NULL");
            } else {
                hor.setMiercoles(cbmiercolesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbmiercolesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbjuevesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbjuevesfin.getSelectionModel().getSelectedItem())) {
                hor.setJueves("NULL");
            } else {
                hor.setJueves(cbjuevesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbjuevesfin.getSelectionModel().getSelectedItem());
            }

            if ("NULL".equals(cbviernesinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbviernesfin.getSelectionModel().getSelectedItem())) {
                hor.setViernes("NULL");
            } else {
                hor.setViernes(cbviernesinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbviernesfin.getSelectionModel().getSelectedItem());
            }
            if ("NULL".equals(cbsabadoinicio.getSelectionModel().getSelectedItem())
                    | "NULL".equals(cbsabadofin.getSelectionModel().getSelectedItem())) {
                hor.setSabado("NULL");
            } else {
                hor.setSabado(cbsabadoinicio.getSelectionModel().getSelectedItem()
                        + "-" + cbsabadofin.getSelectionModel().getSelectedItem());
            }
            controller.EditarHorario(hor);
            JOptionPane.showMessageDialog(null, "Horario Modificado");

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un alumno de la tabla");
        }

    }
    
    
     public String SepararHoras(String hora, int tipoHora) {
        String hInicio = null;
        if ("---".equals(hora)) {
            return hora;
        } else {
            String[] parts = hora.split("-");
            if (tipoHora == 0) {
                return hInicio = parts[0];
            } else {
                return hInicio = parts[1];
            }
        }

    }
     
     public Materia EncontrarMateria(Horario hor) {
        Materia mate = null;
        try {
            materias = conMate.getMateria();
            for (Materia ma : materias) {
                if (ma.getNrc() == hor.getNrc()) {
                    mate = ma;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mate;
    }
     
    
    public void EditarHorario() {
        Horario hor = this.horario;
        
            Materia ma = EncontrarMateria(hor);
            cbMateria.getSelectionModel().select(ma);
            lblAcademico.setText(hor.getAcademico());
            lblsalonlunes.setText(hor.getSalonLunes());
            lblsalonmartes.setText(hor.getSalonMartes());
            lblsalonmiercoles.setText(hor.getSalonMiercoles());
            lblsalonjueves.setText(hor.getSalonJueves());
            lblsalonviernes.setText(hor.getSalonViernes());
            lblsalonsabado.setText(hor.getSalonSabado());
            lblCupo.setText(Integer.toString(hor.getCupo()));
            cblunesinicio.getSelectionModel().select(SepararHoras(hor.getLunes(), 0));
            cblunesfin.getSelectionModel().select(SepararHoras(hor.getLunes(), 1));

            cbmartesinicio.getSelectionModel().select(SepararHoras(hor.getMartes(), 0));
            cbmartesfin.getSelectionModel().select(SepararHoras(hor.getMartes(), 1));

            cbmiercolesinicio.getSelectionModel().select(SepararHoras(hor.getMiercoles(), 0));
            cbmiercolesfin.getSelectionModel().select(SepararHoras(hor.getMiercoles(), 1));

            cbjuevesinicio.getSelectionModel().select(SepararHoras(hor.getJueves(), 0));
            cbjuevesfin.getSelectionModel().select(SepararHoras(hor.getJueves(), 1));

            cbviernesinicio.getSelectionModel().select(SepararHoras(hor.getViernes(), 0));
            cbviernesfin.getSelectionModel().select(SepararHoras(hor.getViernes(), 1));

            cbsabadoinicio.getSelectionModel().select(SepararHoras(hor.getSabado(), 0));
            cbsabadofin.getSelectionModel().select(SepararHoras(hor.getSabado(), 1));

            cbMateria.setDisable(true);
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarMaterias();
        cargarHorasInicio();
        cargarHorasFin();
        
        
    }    
    
}
