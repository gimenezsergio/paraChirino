package persistencia;

import entidades.DB;
import entidades.Reserva;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservasDAO {

    private ReservasDAO() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static ReservasDAO INSTANCE = null;

    public static ReservasDAO getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new ReservasDAO();
        }
        return INSTANCE;
    }

    private final static String SQL_TURNO_INSERT = "INSERT INTO turnos (turnos_fecha,"
            + " turnos_id_session)values(?,?);";

    public static void insertar(String fecha, String id_session) throws ClassNotFoundException, IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_TURNO_INSERT);
            ptsmt.setString(1, fecha);
            ptsmt.setString(2, id_session);
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }

    }
private final static String SQL_TURNOS_SELECT = "SELECT * FROM turnos WHERE turnos_id_session = ?;";
    public ArrayList<Reserva> obtener(String idSession) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<Reserva> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_TURNOS_SELECT);
            ptsmt.setString(1, idSession);
            rs = ptsmt.executeQuery();
            Reserva a = null;
            while (rs.next()) {
                try {
                    a = new Reserva();
                    a.setFecha(rs.getString("turnos_fecha"));
                    a.setId(rs.getString("turnos_id"));
                    a.setSession_id(rs.getString("turnos_id_session"));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                lista.add(a);
            }
        } finally {
            try {
                rs.close();
            } finally {
                try {
                    ptsmt.close();
                } finally {
                    c.close();
                }
            }
        }
        return lista;
    }

}
