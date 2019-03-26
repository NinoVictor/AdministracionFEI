/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Controller que permite el manejo de la interface gráfica de
 * la ventana Horarios.
 * Modificación: 2019/03/19
 * FXML Controller Class
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
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

public class FXMLHorariosController implements Initializable {

    private RegistroAlumnos20 principal;
    private List<Horario> horarios = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>();
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
    @FXML private TextField lblsalonjueves;
    @FXML private TextField lblsalonlunes;
    @FXML private TextField lblsalonmartes;
    @FXML private TextField lblsalonmiercoles;
    @FXML private TextField lblsalonsabado;
    @FXML private TextField lblsalonviernes;
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
    @FXML private TableColumn<Horario, String> colVie;
    @FXML private TableColumn<Horario, String> colSaJue;
    @FXML private TableColumn<Horario, String> colSaLun;
    @FXML private TableColumn<Horario, String> colSaMar;
    @FXML private TableColumn<Horario, String> colSaMie;
    @FXML private TableColumn<Horario, String> colSaVie;
    @FXML private TableColumn<Horario, String> colSaSab;
    @FXML private TableView<Horario> tlbHorario;

    /**
     * Permite navegar a la ventana Materias.
     */
    @FXML
    private void VentanaMaterias() {
        principal.VentanaMaterias();
    }
    @FXML
    private void VentanaFormulario(){
        principal.VentanaFormulario(true, null);
    }

    /**
     * obtiene el stage principal para poder navegar entre ventanas
     *
     * @param principal stage principal
     */
    public void setProgramaPrincipal(RegistroAlumnos20 principal) {
        this.principal = principal;
    }

    /**
     * Permite navegar a la ventana Alumnos.
     */
    @FXML
    private void VentanaAlumnos() {
        principal.VentanaPrincipal();
    }

    /**
     * Permite navegar a la ventana Horarios.
     */
    @FXML
    private void VentanaHorarios() {
        principal.VentanaHorarios();
    }
    
    @FXML
    private void VentanaHorarioAlumno(){
        principal.VentanaHorarioAlumno();
    }

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
     * Carga las materias almacenadas en un comboBox
     */
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

    /**
     * Carga los Items de el comboBox Hora inicio
     */
    public void cargarHorasInicio() {
        String hor[] = {"NULL", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
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

    /**
     * Carga los Items de el comboBox Hora Fin
     */
    public void cargarHorasFin() {
        String hor2[] = {"NULL", "07:59", "08:59", "09:59", "10:59", "11:59", "12:59", "13:59",
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

    /**
     * Método que llena la tableView de los objetos detipo materia.
     *
     * @throws SQLException
     */
    public void LlenarTabla() throws SQLException {
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
        horarios = controller.getHorario();
        horariost = FXCollections.observableArrayList();
        for (Horario hr : horarios) {
            
            horariost.add(hr);
        }
        tlbHorario.setItems(horariost);
    }

    /**
     * Método que inicia la interfaz bloqueando los textField, limpiandolos y
     * ocultando el boton de guardar
     */
    public void IniciarInterfaz() {
        btnGuardar.setVisible(false);
        btnGuardarEdicion.setVisible(false);
        lblAcademico.setDisable(true);
        lblCupo.setDisable(true);
        lblSalon.setDisable(true);
        cbMateria.setDisable(true);
        lblAcademico.setText("");
        lblCupo.setText("");
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
        lblsalonlunes.setText("");
        lblsalonmartes.setText("");
        lblsalonmiercoles.setText("");
        lblsalonjueves.setText("");
        lblsalonviernes.setText("");
        lblsalonsabado.setText("");
         lblsalonlunes.setDisable(true);
        lblsalonmartes.setDisable(true);
        lblsalonmiercoles.setDisable(true);
        lblsalonjueves.setDisable(true);
        lblsalonviernes.setDisable(true);
        lblsalonsabado.setDisable(true);
    }

    /**
     * Método que permite editar los textField para que se pueda ingresar
     * infromación.
     */
    public void ActivarFormulario() {
        lblAcademico.setDisable(false);
        lblCupo.setDisable(false);
        cbMateria.setDisable(false);
        lblsalonlunes.setDisable(false);
        lblsalonmartes.setDisable(false);
        lblsalonmiercoles.setDisable(false);
        lblsalonjueves.setDisable(false);
        lblsalonviernes.setDisable(false);
        lblsalonsabado.setDisable(false);
    }

    /**
     * Inicia la interfaz y activa el formulario.
     */
    public void AgregarHorario() {
        //principal.VentanaFormulario(true, null);
        IniciarInterfaz();
        ActivarFormulario();
        btnGuardar.setVisible(true);
    }

    /**
     * Valida que todos los campos hayn sido llenados
     *
     * @return true si todos los campos estan llenos, false si alguno falta por
     * llenarse.
     */
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

    /**
     * Obtiene el elemnto seleccionado en la TableView
     *
     * @return regresa un objeto de tipo Horario
     */
    public Horario HorarioSeleccionado() {
        if (tlbHorario != null) {
            Horario horario = tlbHorario.getSelectionModel().getSelectedItem();
            return horario;
        } else {
            return null;
        }
    }

    /**
     * Método que permite guardar la informacion de los textField en un objeto
     * de Horario para después ser guardados por un metodo de la clase
     * HorariosDAO.
     *
     * @throws SQLException
     */
    @FXML
    private void GuardarHorario() throws SQLException {
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
            LlenarTabla();
            IniciarInterfaz();
        }

    }

    /**
     * Elimina el elemento seleccionado de la tableView
     *
     * @throws SQLException
     */
    @FXML
    private void EliminarHorario() throws SQLException {
        Horario hor = HorarioSeleccionado();
        if (hor != null) {
            int respuesta = JOptionPane.showOptionDialog(null, "¿Estas seguro que deseas eliminarlo?", "Eliminar Horario",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);
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

    /**
     * Encuentra a que materia pertenece cierto NRC.
     *
     * @param hor objeto de tipo Horario.
     * @return objeto de tipo Materia.
     */
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

    /**
     * Metodo que separa a un string en dos.
     *
     * @param hora string que almacena un rango de hora
     * @param tipoHora
     * @return si el parametro tipoHora es cero regresa la primaera parte del
     * string, si es uno regresa la segunda parte del string, si hora es null
     * regresa hora.
     */
    public String SepararHoras(String hora, int tipoHora) {
        String hInicio = null;
        if ("NULL".equals(hora)) {
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

    /**
     * Muestra la infromacion en el formulario de un elemento seleccionado en la
     * tableView
     */
    @FXML
    private void EditarHorario() {
        Horario hor = HorarioSeleccionado();
        //principal.VentanaFormulario(false, hor);
        if (hor != null) {
            IniciarInterfaz();
            ActivarFormulario();
            btnGuardarEdicion.setVisible(true);
            Materia ma = EncontrarMateria(hor);
            cbMateria.getSelectionModel().select(ma);
            lblsalonlunes.setText(hor.getSalonLunes());
            lblsalonmartes.setText(hor.getSalonMartes());
            lblsalonmiercoles.setText(hor.getSalonMiercoles());
            lblsalonjueves.setText(hor.getSalonJueves());
            lblsalonviernes.setText(hor.getSalonViernes());
            lblsalonsabado.setText(hor.getSalonSabado());
            lblAcademico.setText(hor.getAcademico());
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
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un alumno de la tabla");
        }
    }

    /**
     *Modifica un elemento que se selecciono de la tableView 
     * @throws SQLException 
     */
    @FXML
    private void GuardarEdicion() throws SQLException {
        Horario hor = HorarioSeleccionado();
        
        if (hor != null) {
            btnGuardarEdicion.setVisible(true);
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
            LlenarTabla();
            IniciarInterfaz();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un alumno de la tabla");
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
