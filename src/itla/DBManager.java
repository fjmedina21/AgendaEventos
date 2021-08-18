package itla;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DBManager {

    //private final String url = "jdbc:mysql://localhost/agendaeventos?"; //Laptop
    private final String url = "jdbc:mysql://localhost:3307/agendaeventos?"; //Desktop
    private final String user = "root";
    private final String password = "";
    private Connection conn;

    void connectDB() {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado a " + this.url);
        } catch (SQLException ex) {
            System.out.println("SQLException from connectDB: " + ex.getMessage());
        }
    }

    void disconnectDB() {
        try {
            this.conn.close();
            System.out.println("Desconectado de " + this.url);
        } catch (SQLException ex) {
            System.out.println("SQLException from disconnectDB: " + ex.getMessage());
        }
    }

    void insertRegistro(Evento e) {
        PreparedStatement pstmnt;
        String insertSQL = "INSERT INTO Eventos (Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin) VALUES (?,?,?,?,?,?)";

        try {
            this.connectDB();
            pstmnt = this.conn.prepareStatement(insertSQL);

            pstmnt.setString(1, e.getNombre());
            pstmnt.setString(2, e.getDetalle());
            pstmnt.setString(3, e.getLugar());
            pstmnt.setDate(4, e.getFecha());
            pstmnt.setTime(5, e.getHoraInicio());
            pstmnt.setTime(6, e.getHoraFin());
            pstmnt.executeUpdate();

            pstmnt.close();
            System.out.println("Registro agregado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException from insertRegistro: " + ex.getMessage());
        }
    }

    void updateRegistro(int id, Evento e) {
        PreparedStatement pstmnt;
        Statement stmnt;
        ResultSet rs;

        String updateSQL = "UPDATE Eventos SET Nombre = ?, Detalle = ?, Lugar = ?, Fecha = ?, HoraInicio = ?, HoraFin = ? WHERE IdEvento = " + id;
        String selectSQL = "SELECT Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin FROM Eventos WHERE IdEvento = " + id;

        String n = "";
        String d = "";
        String l = "";
        Date f = null;
        Time hI = null;
        Time hF = null;

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();
            pstmnt = this.conn.prepareStatement(updateSQL);

            rs = stmnt.executeQuery(selectSQL);
            if (rs.next()) {
                n = rs.getString("Nombre");
                d = rs.getString("Detalle");
                l = rs.getString("Lugar");
                f = rs.getDate("Fecha");
                hI = rs.getTime("HoraInicio");
                hF = rs.getTime("HoraFin");
            }

            n = (e.getNombre() == null) ? n : e.getNombre();
            d = (e.getDetalle() == null) ? d : e.getDetalle();
            l = (e.getLugar() == null) ? l : e.getLugar();
            f = (e.getFecha() == null) ? f : e.getFecha();
            hI = (e.getHoraInicio() == null) ? hI : e.getHoraInicio();
            hF = (e.getHoraFin() == null) ? hF : e.getHoraFin();

            pstmnt.setString(1, n);
            pstmnt.setString(2, d);
            pstmnt.setString(3, l);
            pstmnt.setDate(4, f);
            pstmnt.setTime(5, hI);
            pstmnt.setTime(6, hF);
            pstmnt.executeUpdate();

            stmnt.close();
            pstmnt.close();
            System.out.println("Registro actualizado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException from updateRegistro: " + ex.getMessage());
        }
    }

    void deleteRegistro(int id) {
        Statement stmnt;
        String deleteSQL = "DELETE FROM Eventos WHERE IdEvento = " + id;

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();

            stmnt.executeUpdate(deleteSQL);

            stmnt.close();
            System.out.println("Registro eliminado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException from deleteRegistro: " + ex.getMessage());
        }
    }

    List<Evento> readRegistro() {
        Statement stmnt;
        ResultSet rs;
        List<Evento> eventos = new ArrayList<>();

        String selectSQL = "SELECT IdEvento, Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin from Eventos";

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();
            rs = stmnt.executeQuery(selectSQL);

            while (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("IdEvento"),
                        rs.getString("Nombre"),
                        rs.getString("Detalle"),
                        rs.getString("Lugar"),
                        rs.getDate("Fecha"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"))
                );
            }

            stmnt.close();
            rs.close();
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }

        return eventos;
    }

    List<Evento> readRegistroByFecha(Date fecha) {
        Statement stmnt;
        ResultSet rs;
        List<Evento> eventos = new ArrayList<>();

        String selectSQL = "SELECT IdEvento, Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin from Eventos where Fecha = '" + fecha + "'";

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();
            rs = stmnt.executeQuery(selectSQL);

            if (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("IdEvento"),
                        rs.getString("Nombre"),
                        rs.getString("Detalle"),
                        rs.getString("Lugar"),
                        rs.getDate("Fecha"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"))
                );
            } else {
                System.out.println("No se encontraron eventos en esta fecha");
            }

            stmnt.close();
            rs.close();
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }

        return eventos;
    }

    List<Evento> readRegistroByNombre(String nombre) {
        Statement stmnt;
        ResultSet rs;
        List<Evento> eventos = new ArrayList<>();

        String selectSQL = "SELECT IdEvento, Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin from Eventos WHERE Nombre = '" + nombre + "'";

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();
            rs = stmnt.executeQuery(selectSQL);

            if (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("IdEvento"),
                        rs.getString("Nombre"),
                        rs.getString("Detalle"),
                        rs.getString("Lugar"),
                        rs.getDate("Fecha"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"))
                );
            } else {
                System.out.println("No se encontraron eventos con este nombre");
            }

            stmnt.close();
            rs.close();
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }

        return eventos;
    }

    List<Evento> readRegistroByDetalle(String detalle) {
        Statement stmnt;
        ResultSet rs;
        List<Evento> eventos = new ArrayList<>();

        String selectSQL = "SELECT IdEvento, Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin from Eventos where Detalle like '%" + detalle + "%'";

        try {
            this.connectDB();
            stmnt = this.conn.createStatement();
            rs = stmnt.executeQuery(selectSQL);

            if (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("IdEvento"),
                        rs.getString("Nombre"),
                        rs.getString("Detalle"),
                        rs.getString("Lugar"),
                        rs.getDate("Fecha"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"))
                );
            } else {
                System.out.println("No se encontraron eventos con coincidencias");
            }

            stmnt.close();
            rs.close();
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }

        return eventos;
    }
}
