package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLGrillasTest {
    public static void main(String[] args) {
        System.out.println("            [...] DB SQL Test Grillas System");
        Connection conexion = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int idSql = 0;
        
        System.out.println("=====================");
        
        System.out.println("    [...] DB SQL INSERT in Grillas table. FK error Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("INSERT INTO grillas (grilla_os, grilla_medic, grilla_lugar) VALUES(1,5,8)", pstm.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs.next()){
                idSql = rs.getInt(1);
                System.out.println("    ID insertado: " + rs.getInt(1));
            }
            System.out.println("    [ERROR] DB SQL INSERT in Grillas table.FK error  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [OK] DB SQL INSERT in Grillas table. FK error  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [OK] DB SQL INSERT in Grillas table. FK error  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [OK] DB SQL INSERT in Grillas table. FK error  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [OK] DB SQL INSERT in Grillas table. FK error  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL INSERT in Grillas table. FK error Test " + ex.getMessage());
                }
            }
        }
        
        System.out.println("=====================");
        
        System.out.println("    [...] DB SQL INSERT in Grillas table Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("INSERT INTO grillas (grilla_os, grilla_medic, grilla_lugar) VALUES(3,5,8)", pstm.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs.next()){
                idSql = rs.getInt(1);
                System.out.println("    ID insertado: " + rs.getInt(1));
            }
            System.out.println("    [OK] DB SQL INSERT in Grillas table  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in Grillas table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in Grillas table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in Grillas table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL INSERT in Grillas table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL INSERT in Grillas table Test " + ex.getMessage());
                }
            }
        }
        System.out.println("=====================");
        System.out.println("    [...] DB SQL UPDATE in Grillas table Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("UPDATE grillas SET grilla_os = 6 WHERE grilla_id = ?");
            pstm.setInt(1, idSql);
            pstm.execute();
            
            System.out.println("    [OK] DB SQL UPDATE in Grillas table  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in Grillas table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in Grillas table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in Grillas table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL UPDATE in Grillas table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL UPDATE in Grillas table Test " + ex.getMessage());
                }
            }
        }
        System.out.println("=====================");
        System.out.println("    [...] DB SQL DELETE in Grillas table Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            pstm = conexion.prepareStatement("DELETE FROM grillas WHERE grilla_id = ?");
            pstm.setInt(1, idSql);
            pstm.execute();
            
            System.out.println("    [OK] DB SQL DELETE in Grillas table  Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in Grillas table  Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in Grillas table  Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in Grillas table  Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB SQL DELETE in Grillas table  Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB SQL DELETE in Grillas table Test " + ex.getMessage());
                }
            }
        }
        
        System.out.println("=====================");
        System.out.println("            [OK] DB SQL Test Grillas System");
    }
    
}
