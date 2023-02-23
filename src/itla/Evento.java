package itla;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    private int idEvento;
    private String nombre;
    private String detalle;
    private String lugar;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    Evento(int idEvento, String nombre, String detalle, String lugar, Date fecha, Time horaInicio, Time horaFin) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.detalle = detalle;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    Evento(String nombre, String detalle, String lugar, Date fecha, Time horaInicio, Time horaFin) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdEvento() {
        return idEvento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }
}
