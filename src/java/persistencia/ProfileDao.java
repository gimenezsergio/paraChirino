package persistencia;

import entidades.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class ProfileDao {

    private ProfileDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static ProfileDao INSTANCE = null;

    public static ProfileDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new ProfileDao();
        }
        return INSTANCE;
    }
    
    private final static String SQL_PROFILE_SELECT = "SELECT * FROM public.usuarios WHERE user_id = ?";

    

    public TreeMap obtener(String userId) throws ClassNotFoundException, IOException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        TreeMap<String, String> miUsuario = new TreeMap();

        try {
            con = DB.getInstance().getConnection();
            pstm = con.prepareStatement(SQL_PROFILE_SELECT);
            pstm.setInt(1, Integer.parseInt(userId));
            rs = pstm.executeQuery();
            if (rs.next()) {
                //miUsuario = rs.getString("user_id");
                miUsuario.put("userId", rs.getString("user_id"));
                miUsuario.put("username", rs.getString("username"));
                miUsuario.put("email", rs.getString("email"));
            }

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return miUsuario;
        
    }
    
}
