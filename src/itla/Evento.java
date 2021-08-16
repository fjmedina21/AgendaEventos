package itla;
import java.sql.Date;
import java.sql.Time;

public class Evento {
    private String nombre;
    private String detalle;
    private String lugar;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    Evento(String nombre, String detalle, String lugar, Date fecha, Time horaInicio, Time horaFin) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    String getNombre() {
        return nombre;
    }

    String getDetalle() {
        return detalle;
    }
    
    String getLugar() {
        return lugar;
    }
    
    Date getFecha() {
        
        return fecha;
    }

    Time getHoraInicio() {
        return horaInicio;
    }

    Time getHoraFin() {
        return horaFin;
    }
}
