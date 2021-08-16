package itla;
import java.sql.Date;
import java.sql.Time;

public class Evento {
    private String nombre;
    private String detalle;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    public Evento(String nombre, String detalle, Date fecha, Time horaInicio, Time horaFin) {
        this.nombre = nombre;
        this.detalle = detalle;
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

    Date getFecha() {
        
        return fecha;
    }

    Time getHoraInicio() {
        return horaInicio;
    }

    Time getHoraFin() {
        return horaFin;
    }
    
    //    public String getHoraInicio() {
    //        String strHI = String.(this.getHoraInicio());
    //        
    //        return strHI;
    //    }

    //    public Time getHoraFin() {
    //        return horaFin;
    //    }
   
}
