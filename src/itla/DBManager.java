package itla;
import java.sql.*;

class DBManager {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pstmnt = null;
    private Statement stmnt = null;
    private String query = "";

    private String url = "jdbc:mysql://localhost/agendaeventos?";
    private String user = "root";
    private String password = "";

    public DBManager() {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado a " + this.url);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    void insertRegistro(Evento e) {
        this.query = "INSERT INTO Eventos (Nombre, Detalle, Fecha, HoraInicio, HoraFin) VALUES (?,?,?,?,?)";

        try {
            this.pstmnt = this.conn.prepareStatement(this.query);

            this.pstmnt.setString(1, e.getNombre());
            this.pstmnt.setString(2, e.getDetalle());
            this.pstmnt.setDate(3, e.getFecha());
            this.pstmnt.setTime(4, e.getHoraInicio());
            this.pstmnt.setTime(5, e.getHoraFin());
            this.pstmnt.executeUpdate();
            
            this.pstmnt.close();
            System.out.println("Registro agregado");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    void updateRegistro(int id, Evento e) {
        //this.query = ("UPDATE Eventos SET Nombre = ?, "
        //                                          + "Detalle = ?, "
        //                                          + "Fecha = ?, "
        //                                          + "HoraInicio = ?, "
        //                                          + "HoraFin = ? "
        //                                          + "WHERE IdEvento = " + id
        this.query = ("UPDATE Eventos SET Nombre = ?, "
                                        + "Detalle = ?, "
                                        + "Fecha = ? "
                                        + "WHERE IdEvento = " + id);
  
        String selectQuery = "SELECT Nombre, Detalle, Fecha, HoraInicio, HoraFin FROM Eventos WHERE IdEvento = " + id;

        try {
            this.stmnt = this.conn.createStatement();
            this.pstmnt = this.conn.prepareStatement(this.query);
            
            this.rs = this.stmnt.executeQuery(selectQuery);
            this.rs.next();
            String n = this.rs.getString("Nombre");
            String d = this.rs.getString("Detalle");
            Date f = this.rs.getDate("Fecha");
            //Time hI = this.rs.getTime("HoraInicio");
            //Time hF = this.rs.getTime("HoraFin");

            n = (e.getNombre() == "") ? n : e.getNombre();
            d = (e.getDetalle() == "") ? d : e.getDetalle();
            f = (String.valueOf(e.getFecha()) == "") ? f : e.getFecha();
            //hI = (e.getHoraInicio() == "") ? hI : e.getHoraInicio();
            //hF = (e.getHoraFin() == "") ? hF : e.getHoraFin();

            this.pstmnt.setString(1, n);
            this.pstmnt.setString(2, d);
            this.pstmnt.setDate(3, f);
            //this.pstmnt.setTime(4, hI);
            //this.pstmnt.setTime(5, hF);
            this.pstmnt.executeUpdate();
            
            this.stmnt.close();
            this.pstmnt.close();
            System.out.println("Registro actualizado");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    void deleteRegistro(int id) {
        this.query = "DELETE FROM Eventos WHERE IdEvento = " + id;

        try {
            this.stmnt = this.conn.createStatement();
            this.stmnt.executeUpdate(this.query);
            this.stmnt.close();
            System.out.println("Registro eliminado");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

}
