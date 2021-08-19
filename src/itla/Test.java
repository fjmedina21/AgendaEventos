package itla;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        EventosManagement em = new EventosManagement();

        //em.createEvento("Test 30","probando el finally","My room","2021-08-18","22:08","22:10");
        //em.deleteEvento(id);
        //em.updateEvento(11,"Test 50","testing","desktop","2021-08-19","22:44","22:45");
        //List<Evento> eventos = em.searchEventoByNombre("Partido de baseball");
        //List<Evento> eventos = em.searchEventoByFecha("2021-08-16");
        //List<Evento> eventos = em.searchEventoByDetalle("it");
        List<Evento> eventos = em.searchEvento();

        for (Evento e : eventos) {
            System.out.println(
                    "IdEvento: " + e.getIdEvento() + " "
                    + "Nombre: " + e.getNombre() + " "
                    + "Detalle: " + e.getDetalle() + " "
                    + "Lugar: " + e.getLugar() + " "
                    + "Fecha: " + e.getFecha() + " "
                    + "Hora Inicio: " + e.getHoraInicio() + " "
                    + "Hora Fin: " + e.getHoraFin()
            );
        }

    }
}
