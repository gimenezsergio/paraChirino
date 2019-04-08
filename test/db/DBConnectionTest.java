package db;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionTest {

    public static void main(String[] args) {
        System.out.println("            [...] DB Connection Test Medic System");
        System.out.println("=====================");
        Connection conexion = null;
        System.out.println("    [...] DB Connection Test");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgres");
            System.out.println("    [OK] DB Connection Test");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [ERROR] DB Connection Test " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [ERROR] DB Connection Test " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [ERROR] DB Connection Test " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [ERROR] DB Connection Test " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB Connection Test " + ex.getMessage());
                }
            }
        }
        System.out.println("=====================");
        
        System.out.println("    [...] DB Connection Test, DBname incorect");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turno",
                    "postgres", "postgres");
            System.out.println("    [ERROR] DB Connection Test, , DBname incorect");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [OK] DB Connection Test, DBname incorect " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [OK] DB Connection Test, DBname incorect " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [OK] DB Connection Test, DBname incorect " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [OK] DB Connection Test, DBname incorect " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB Connection Test, DBname incorect " + ex.getMessage());
                }
            }
        }
        
        System.out.println("=====================");
        
        System.out.println("    [...] DB Connection Test, password incorect");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgres", "postgresWW");
            System.out.println("    [ERROR] DB Connection Test, , password incorect");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [OK] DB Connection Test, password incorect " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [OK] DB Connection Test, password incorect " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [OK] DB Connection Test, password incorect " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [OK] DB Connection Test, password incorect " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB Connection Test, password incorect " + ex.getMessage());
                }
            }
        }
        
        
        System.out.println("=====================");
        
        System.out.println("    [...] DB Connection Test, user incorect");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/turnos",
                    "postgresPPP", "postgres");
            System.out.println("    [ERROR] DB Connection Test, , user incorect");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [OK] DB Connection Test, user incorect " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [OK] DB Connection Test, user incorect " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [OK] DB Connection Test, user incorect " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [OK] DB Connection Test, user incorect " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB Connection Test, user incorect " + ex.getMessage());
                }
            }
        }
        
        System.out.println("=====================");
        
        System.out.println("    [...] DB Connection Test, host incorect");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localho8888/turnos",
                    "postgresPPP", "postgres");
            System.out.println("    [ERROR] DB Connection Test, host incorect");
        } catch (ClassNotFoundException ex) {
            System.out.println("    [OK] DB Connection Test, host incorect " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("    [OK] DB Connection Test, host incorect " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("    [OK] DB Connection Test, host incorect " + ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("    [OK] DB Connection Test, host incorect " + ex.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("    [ERROR] DB Connection Test, host incorect " + ex.getMessage());
                }
            }
        }
        
        
        
        System.out.println("=====================");
        System.out.println("            [OK] DB Connection Test Medic System");
    }

}
