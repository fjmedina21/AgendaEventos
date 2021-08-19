package itla;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

class EventosManagement {

    DBManager dbm = new DBManager();

    void createEvento(String nombre, String detalle, String lugar, String fecha, String horaInicio, String horaFin) {
        try {
            String n = nombre;
            String d = detalle;
            String l = lugar;
            Date f = Date.valueOf(fecha);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Time hI = new Time(timeFormat.parse(horaInicio).getTime());
            Time hF = new Time(timeFormat.parse(horaFin).getTime());

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
            String d = (detalle.isEmpty()) ? null : detalle;
            String l = (lugar.isEmpty()) ? null : lugar;
            Date f = (fecha == null) ? null : Date.valueOf(fecha);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Time hI = (horaInicio == null) ? null : new Time(timeFormat.parse(horaInicio).getTime());
            Time hF = (horaFin == null) ? null : new Time(timeFormat.parse(horaFin).getTime());

            Evento e = new Evento(n, d, l, f, hI, hF);
            this.dbm.updateRegistro(id, e);
        } catch (ParseException pe) {
            System.out.println("ParseException: " + pe.getMessage());
        }
    }

    List<Evento> searchEvento() {
        List<Evento> resultado = dbm.readRegistro();
        return resultado;
    }

    List<Evento> searchEventoByNombre(String nombre) {
        List<Evento> resultado = dbm.readRegistroByNombre(nombre);
        return resultado;
    }

    List<Evento> searchEventoByDetalle(String detalle) {
        List<Evento> resultado = dbm.readRegistroByDetalle(detalle);
        return resultado;
    }

    List<Evento> searchEventoByFecha(String fecha) {
        List<Evento> resultado = dbm.readRegistroByFecha(Date.valueOf(fecha));
        return resultado;
    }
}
