package itla;

import java.sql.*;

class DBManager {

    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pstmnt = null;
    private Statement stmnt = null;
    private String sql = "";

    //private String url = "jdbc:mysql://localhost/agendaeventos?"; //Laptop
    private String url = "jdbc:mysql://localhost:3307/agendaeventos?"; //Desktop
    private String user = "root";
    private String password = "";

    void connectDB() {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado a " + this.url);
        } catch (SQLException ex) {
            System.out.println("SQLException, cDB: " + ex.getMessage());
        }
    }

    void disconnectDB() {
        try {
            this.conn.close();
            System.out.println("Desconectado de " + this.url);
        } catch (SQLException ex) {
            System.out.println("SQLException, dDB: " + ex.getMessage());
        }
    }

    void insertRegistro(Evento e) {
        this.sql = "INSERT INTO Eventos (Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin) VALUES (?,?,?,?,?,?)";

        try {
            this.connectDB();
            this.pstmnt = this.conn.prepareStatement(this.sql);

            this.pstmnt.setString(1, e.getNombre());
            this.pstmnt.setString(2, e.getDetalle());
            this.pstmnt.setString(3, e.getLugar());
            this.pstmnt.setDate(4, e.getFecha());
            this.pstmnt.setTime(5, e.getHoraInicio());
            this.pstmnt.setTime(6, e.getHoraFin());
            this.pstmnt.executeUpdate();

            this.pstmnt.close();
            System.out.println("Registro agregado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException, iR: " + ex.getMessage());
        }
    }

    @SuppressWarnings("empty-statement")
    void updateRegistro(int id, Evento e) {
        this.sql = "UPDATE Eventos SET Nombre = ?, Detalle = ?, Lugar = ?, Fecha = ?, HoraInicio = ?, HoraFin = ? WHERE IdEvento = " + id;

        String selectSQL = "SELECT Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin FROM Eventos WHERE IdEvento = " + id;
        
        String n = "";
        String d = "";
        String l = "";
        Date f = null;
        Time hI = null;
        Time hF = null;

        try {
            this.connectDB();
            this.stmnt = this.conn.createStatement();
            this.pstmnt = this.conn.prepareStatement(this.sql);

            this.rs = this.stmnt.executeQuery(selectSQL);
            if (this.rs.next()) {
                n = this.rs.getString("Nombre");
                d = this.rs.getString("Detalle");
                l = this.rs.getString("Lugar");
                f = this.rs.getDate("Fecha");
                hI = this.rs.getTime("HoraInicio");
                hF = this.rs.getTime("HoraFin");
            }

            n = (e.getNombre() == null) ? n : e.getNombre();
            d = (e.getDetalle() == null) ? d : e.getDetalle();
            l = (e.getLugar() == null) ? l : e.getLugar();
            f = (e.getFecha() == null) ? f : e.getFecha();
            hI = (e.getHoraInicio() == null) ? hI : e.getHoraInicio();
            hF = (e.getHoraFin() == null) ? hF : e.getHoraFin();

            this.pstmnt.setString(1, n);
            this.pstmnt.setString(2, d);
            this.pstmnt.setString(3, l);
            this.pstmnt.setDate(4, f);
            this.pstmnt.setTime(5, hI);
            this.pstmnt.setTime(6, hF);
            this.pstmnt.executeUpdate();

            this.stmnt.close();
            this.pstmnt.close();
            System.out.println("Registro actualizado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException, uR: " + ex.getMessage());
        }
    }

    void deleteRegistro(int id) {
        this.sql = "DELETE FROM Eventos WHERE IdEvento = " + id;

        try {
            this.connectDB();
            this.stmnt = this.conn.createStatement();
            this.stmnt.executeUpdate(this.sql);
            this.stmnt.close();
            System.out.println("Registro eliminado");
            this.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException, dR: " + ex.getMessage());
        }
    }

}
