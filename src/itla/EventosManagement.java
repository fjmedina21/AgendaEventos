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

    void updateEvento() {
        //TODO: 
    }

}
