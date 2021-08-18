package itla;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        EventosManagement em = new EventosManagement();

        //em.createEvento("Test 2","probando nuevos metodos","My room","2021-08-16","23:35","23:45");
        //em.deleteEvento(id);
        //em.updateEvento(3,"Test 25","it's working!","",null,null,null);
        
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
