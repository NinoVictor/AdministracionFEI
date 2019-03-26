/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Esta es la definición de la clase alumno
 * Modificación: 2019/02/27
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/25
 */
package clases;

public class Alumno {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;

    public Alumno() {
    }

    /**
     * Constructor con variables inicializadas.
     *
     * @param nombre nombre del alumno.
     * @param apellidoPaterno apellido paterno del alumno.
     * @param apellidoMaterno apellido materno del alumno.
     * @param matricula matricula del alumno.
     */
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String matricula) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public String toString(){
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }

}
