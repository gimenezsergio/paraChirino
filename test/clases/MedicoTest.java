package clases;


import entidades.Medico;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoTest {

    public static void main(String[] args) {
        System.out.println("            [...] MedicoTest");

        System.out.println("=============================");
        System.out.println("Instanciar medico");
        Medico pedro;
        try {
            pedro = new Medico("Pedro");
            System.out.println(pedro);
            System.out.println("    [OK] Instanciar medico");
        } catch (Exception ex) {
            System.out.println("Exeption: " + ex.getMessage());
            System.out.println("    [ERROR] Instanciar medico");
        }
        
        System.out.println("=============================");
        System.out.println("Nombre vacio");
        
        try {
            Medico laura = new Medico("");
            System.out.println("    [ERROR] Nombre vacio");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("    [OK] Nombre vacio");
        }
        
        System.out.println("=============================");
        System.out.println("            [OK] MedicoTest");
    }

}
