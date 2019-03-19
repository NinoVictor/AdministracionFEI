/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Esta clase genera una conexión a la base de datos
 * Modificación: 2019/02/27
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/25
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {

    /**
     * Variables que se ocuparan para realizar la conexión
     */
    private Connection conn;
    private String host = "localhost";
    private String db = "pruebajavafx";
    private String username = "root";
    private String password = "#codigo99;";
    private String url = "jdbc:mysql://" + host + "/" + db;
    String error;

    private static Conectar conexion;

    /**
     * Método que conectará ala base de datos MySQL
     */
    public Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Conecando a la base de datos...");
            try {
                conn = DriverManager.getConnection(url, username, password);
                if (conn != null) {
                    System.out.println("Conexión a la base de datos establecida.");
                }
            } catch (SQLException ex) {
                System.out.println("Error de mysql");
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, getMensajeError());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado " + e.getMessage());
        }

        conexion = this;

    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public String getMensajeError() {

        return error;

    }
}
