/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Definicion de la clase Horario
 * Modificación: 2019/03/19
 * @author Victor Niño
 * @version 1.0
 * @since 2019/03/16
 */
package clases;


public class Horario {
    private int idHorario;
    private String academico;
    private int cupo;
    private int nrc;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private String salonLunes;
    private String salonMartes;
    private String salonMiercoles;
    private String salonJueves;
    private String salonViernes;
    private String salonSabado;
    
    public Horario(){
        
    }

    /**
     * 
     * @param idHorario identificador del horario
     * @param academico nombre del academico que impartira la clase 
     * @param salon 
     * @param cupo
     * @param nrc identificador de la materia 
     * @param lunes
     * @param martes
     * @param miercoles
     * @param jueves
     * @param viernes
     * @param sabado 
     */
    

    

    public Horario(int idHorario, String academico, int cupo, int nrc, 
            String lunes, String martes, String miercoles, String jueves, 
            String viernes, String sabado, String salonLunes, 
            String salonMartes, String salonMiercoles, String salonJueves, 
            String salonViernes, String salonSabado) {
        this.idHorario = idHorario;
        this.academico = academico;
        this.cupo = cupo;
        this.nrc = nrc;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.salonLunes = salonLunes;
        this.salonMartes = salonMartes;
        this.salonMiercoles = salonMiercoles;
        this.salonJueves = salonJueves;
        this.salonViernes = salonViernes;
        this.salonSabado = salonSabado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getAcademico() {
        return academico;
    }

    public void setAcademico(String academico) {
        this.academico = academico;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getSalonLunes() {
        return salonLunes;
    }

    public void setSalonLunes(String salonLunes) {
        this.salonLunes = salonLunes;
    }

    public String getSalonMartes() {
        return salonMartes;
    }

    public void setSalonMartes(String salonMartes) {
        this.salonMartes = salonMartes;
    }

    public String getSalonMiercoles() {
        return salonMiercoles;
    }

    public void setSalonMiercoles(String salonMiercoles) {
        this.salonMiercoles = salonMiercoles;
    }

    public String getSalonJueves() {
        return salonJueves;
    }

    public void setSalonJueves(String salonJueves) {
        this.salonJueves = salonJueves;
    }

    public String getSalonViernes() {
        return salonViernes;
    }

    public void setSalonViernes(String salonViernes) {
        this.salonViernes = salonViernes;
    }

    public String getSalonSabado() {
        return salonSabado;
    }

    public void setSalonSabado(String salonSabado) {
        this.salonSabado = salonSabado;
    }

    
    
    
}
