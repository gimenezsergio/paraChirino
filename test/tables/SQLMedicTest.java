package tables;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.StampedLock;


public class SQLMedicTest {

    public static void main(String[] args) {
        System.out.println("            [...] DB SQL Test Medic System");
        Connection conexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int idSql = 0;
        
        System.out.println("=====================");
        System.out.println("    [...] DB SQL INSERT in medic table Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("INSERT INTO medicos (medic_nombre) VALUES('RAMON CARRILLO')", pstm.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs.next()){
                idSql = rs.getInt(1);
                System.out.println("    ID insertado: " + rs.getInt(1));
            }
            System.out.println("    [OK] DB SQL INSERT in medic table  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in medic table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in medic table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in medic table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in medic table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL INSERT in medic table Test " + ex.getMessage());
                }
            }
        }
        
        
        System.out.println("=====================");
        System.out.println("    [...] DB SQL UPDATE Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("UPDATE medicos SET medic_nombre = 'ALEJANDRO' WHERE medic_id = ?");
            pstm.setInt(1, idSql);
            pstm.execute();

            System.out.println("    [OK] DB SQL UPDATE in medic table Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in medic table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in medic table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in medic table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in medic table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL UPDATE in medic table  Test " + ex.getMessage());
                }
            }
        }
        
        
        System.out.println("=====================");
        System.out.println("    [...] DB SQL DELETE in medic table  Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("DELETE FROM medicos WHERE medic_id = ?");
            pstm.setInt(1, idSql);
            pstm.execute();

            System.out.println("    [OK] DB SQL DELETE in medic table  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL DELETE  in medic table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL DELETE  in medic table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in medic table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in medic table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL DELETE in medic table  Test " + ex.getMessage());
                }
            }
        }
        
        System.out.println("=====================");
        System.out.println("            [OK] DB SQL Test Medic System");
    }

}
