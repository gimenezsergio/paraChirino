package entidades;

import java.io.IOException;
import java.sql.*;

public class DB {

    private static DB INSTANCE = null;
    private static String LABASE = "jdbc:postgresql://localhost/turnos";
    private static String LABASEUSUARIO = "postgres";  // "root";
    private static String LABASECLAVE = "postgres";    //"root";
    public static DB getInstance() throws ClassNotFoundException, IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new DB();
        }
        return INSTANCE;
    }
    private DB() throws ClassNotFoundException,
            IOException, SQLException {
    }

    public Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(LABASE, LABASEUSUARIO, LABASECLAVE);
    }

}
