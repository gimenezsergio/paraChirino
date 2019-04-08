package persistencia;

import entidades.DB;
import entidades.Turno;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurnosDao {

    private TurnosDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static TurnosDao INSTANCE = null;

    public static TurnosDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new TurnosDao();
        }
        return INSTANCE;
    }

    private final static String TURNOS_SELECT_ALL = "SELECT turnos_id, turnos_id_paciente, turnos_id_grilla, turnos_desde, turnos_hasta, pacientes.paci_nombre FROM public.turnos INNER JOIN pacientes ON turnos_id_paciente = pacientes.paci_id ;";

    public ArrayList<Turno> obtener() throws ClassNotFoundException, IOException, SQLException {
        ArrayList<Turno> listaTurnos = new ArrayList();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DB.getInstance().getConnection();
            pstm = con.prepareStatement(TURNOS_SELECT_ALL);
            rs = pstm.executeQuery();
            while (rs.next()){
                Turno miTurno = new Turno(
                        rs.getString("paci_nombre"), 
                        rs.getString("turnos_id_grilla"), 
                        rs.getString("turnos_desde"), 
                        rs.getString("turnos_hasta"));
                listaTurnos.add(miTurno);
            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Exeption: " + ex.getMessage());
//            throw ex;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return listaTurnos;
    }

}
