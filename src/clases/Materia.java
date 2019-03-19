/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Clase correspondiente a la definición de Materia
 * 
 * Modificación: 2019/03/14
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/14
 */
package clases;


public class Materia {
    private int nrc;
    private String nombre;
    private int creditos;
    private String horasTeoricas;
    private String horasPracticas;

    public Materia(){
        
    }
    public Materia(int nrc, String nombre, int creditos, String horasTeoricas, String horasPracticas) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasTeoricas = horasTeoricas;
        this.horasPracticas = horasPracticas;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(String horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public String getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(String horasPracticas) {
        this.horasPracticas = horasPracticas;
    }
    
    @Override
    public String toString() {
        return this.nrc + " - " + this.nombre;
    }
}
