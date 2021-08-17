package itla;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class EventosManagement {

    DBManager dbm = null;

    EventosManagement() {
        this.dbm = new DBManager();
    }

    void createEvento(String nombre, String detalle, String lugar, String fecha, String horaInicio, String horaFin) {
        try {
            String n = nombre;
            String d = detalle;
            String l = lugar;

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Time hI = new Time(timeFormat.parse(horaInicio).getTime());
            Time hF = new Time(timeFormat.parse(horaFin).getTime());
            Date f = Date.valueOf(fecha);

            Evento e = new Evento(n, d, l, f, hI, hF);
            this.dbm.insertRegistro(e);
        } catch (ParseException pe) {
            System.out.println("ParseException: " + pe.getMessage());
        }
    }

    void deleteEvento(int id) {
        this.dbm.deleteRegistro(id);
    }

    void updateEvento(int id, String nombre, String detalle, String lugar, String fecha, String horaInicio, String horaFin) {
        try {
            String n = (nombre.isEmpty()) ? null : nombre;
            String d =  (detalle.isEmpty()) ? null : detalle;
            String l = (lugar.isEmpty()) ? null : lugar;
           
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            
            Time hI = (horaInicio == null) ? null : new Time(timeFormat.parse(horaInicio).getTime());
            Time hF = (horaFin == null) ? null : new Time(timeFormat.parse(horaFin).getTime());
            Date f = (fecha == null) ? null : Date.valueOf(fecha);

            Evento e = new Evento(n, d, l, f, hI, hF);
            this.dbm.updateRegistro(id,e);
        } catch (ParseException pe) {
            System.out.println("ParseException: " + pe.getMessage());
        }  
    }

}
