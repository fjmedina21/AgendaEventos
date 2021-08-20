package itla;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        EventosManagement em = new EventosManagement();

        //em.createEvento("nombre","detalle del evento","lugar","año-mes-dia","HH:mm","HH:mm");        
        //em.deleteEvento(id);
        //em.updateEvento(id,"","","",null,null,null);
        
        List<Evento> eventos = em.searchEvento();
        //List<Evento> eventos = em.searchEventoByNombre("Proyecto de programacion I");
        //List<Evento> eventos = em.searchEventoByDetalle("el");
        //List<Evento> eventos = em.searchEventoByFecha("2021-09-01");

        eventos.forEach(e -> {
            System.out.println("IdEvento: " + e.getIdEvento() + " "
                            + "Nombre: " + e.getNombre() + " "
                            + "Detalle: " + e.getDetalle() + " "
                            + "Lugar: " + e.getLugar() + " "
                            + "Fecha: " + e.getFecha() + " "
                            + "Hora Inicio: " + e.getHoraInicio() + " "
                            + "Hora Fin: " + e.getHoraFin());
        });

    }
}
