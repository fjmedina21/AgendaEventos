package itla;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class EventosManagement {

    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        Evento e = null;

        String n = "test 1.1.1";
        String d = "zxcvbnm";
        Time hI = null;
        Time hF = null;
        Date f = null;

        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            hI = new Time(timeFormat.parse("18:00").getTime());
            hF = new Time(timeFormat.parse("21:00").getTime());
            f = Date.valueOf("2021-08-14");
        } catch (ParseException pe) {
            System.out.println("ParseException: " + pe.getMessage());
        }
        
        e = new Evento (n);
        
        //dbm.insertRegistro(e);
        //dbm.deleteRegistro(1);
        dbm.updateRegistro(2, e);
    }
}
