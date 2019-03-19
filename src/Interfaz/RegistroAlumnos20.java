/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Definicion de los metodos que se usaran en la interfaz así
 * como los metodos para los eventos de los botones y bajas, altas de
 * alumnos
 * Modificación: 2019/02/27
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/25
 */
package Interfaz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistroAlumnos20 extends Application {

    private Stage stage;
    private AnchorPane rootPane;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
       /* Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();*/
       VentanaPrincipal();
    }
    public void VentanaPrincipal(){
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stage.setScene(scene);
            FXMLDocumentController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegistroAlumnos20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void VentanaMaterias(){
        try {
            FXMLLoader loader= new FXMLLoader(RegistroAlumnos20.class.getResource("FXMLMaterias.fxml"));
           // AnchorPane ventanaDos = (AnchorPane) loader.load();
            //Stage ventana = new Stage();
           // ventana.initOwner(stage);
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stage.setScene(scene);
            FXMLMateriasController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(RegistroAlumnos20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VentanaHorarios(){
        try {
            FXMLLoader loader= new FXMLLoader(RegistroAlumnos20.class.getResource("FXMLHorarios.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stage.setScene(scene);
            FXMLHorariosController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegistroAlumnos20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
