package persistencia;

import entidades.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class LoginDao {

    private LoginDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static LoginDao INSTANCE = null;

    public static LoginDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new LoginDao();
        }
        return INSTANCE;
    }

    private final static String SQL_ACCES_LOGIN = "SELECT * FROM public.usuarios WHERE username = ? AND password = ?";

    public String verificar(String puser, String ppass) throws ClassNotFoundException, IOException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String miUsuario = null;

        try {
            con = DB.getInstance().getConnection();
            pstm = con.prepareStatement(SQL_ACCES_LOGIN);
            pstm.setString(1, puser);
            pstm.setString(2, ppass);
            rs = pstm.executeQuery();
            if (rs.next()) {
                miUsuario = rs.getString("user_id");
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

    private final static String SQL_REGISTER_USER = "INSERT INTO public.usuarios( username, password, email) VALUES (?,?,?)";

    public void registerUser(String email, String pass, String user) throws ClassNotFoundException, IOException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DB.getInstance().getConnection();
            pstm = con.prepareStatement(SQL_REGISTER_USER);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            pstm.setString(3, email);
            pstm.execute();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
