package clases;


import entidades.Grilla;
import entidades.Medico;
import entidades.ObraSocial;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GrillaTest {

    public static void main(String[] args) {
        System.out.println("            [...] GrilaTest");
        System.out.println("=============================");
        
        Medico miMedico;
        Medico miMedico2;
        ObraSocial miOs = new ObraSocial("PAMI");
        miOs.setId("3");
        System.out.println("Instanciar grilla");
        try {
            miMedico = new Medico("Luis");
            miMedico.setId("2");
            miMedico2 = new Medico("Hernan");
            miMedico2.setId("7");
            Grilla miGrilla = new Grilla(miMedico.getId(), miOs.getId(),"12/08/2018 10:00","12/08/2018 10:00");
            Grilla miGrilla2 = new Grilla(miMedico2.getId(), miOs.getId(),"12/08/2018 10:00","12/08/2018 14:00");
            System.out.println(miGrilla);
            System.out.println(miGrilla2);
            System.out.println("[OK] Instanciar grilla");
        } catch (Exception ex) {
            System.out.println("[ERROR] Instanciar grilla " + ex.getMessage());
        }
        
        System.out.println("=============================");
        System.out.println("Instanciar grilla fecha desde vacia");
        try {
            miMedico = new Medico("Luis");
            miMedico.setId("2");
            miMedico2 = new Medico("Hernan");
            miMedico2.setId("7");
            Grilla miGrilla = new Grilla(miMedico.getId(), miOs.getId(),"","12/08/2018 10:00");
            System.out.println(miGrilla);
            System.out.println("[ERROR] Instanciar grilla fecha desde vacia");
        } catch (Exception ex) {
            System.out.println("[OK] Instanciar grilla fecha desde vacia" + ex.getMessage());
        }
        
        System.out.println("=============================");
        System.out.println("Instanciar grilla fecha hasta vacia");
        try {
            miMedico = new Medico("Luis");
            miMedico.setId("2");
            miMedico2 = new Medico("Hernan");
            miMedico2.setId("7");
            Grilla miGrilla = new Grilla(miMedico.getId(), miOs.getId(),"12/08/2018 10:00","");
            System.out.println(miGrilla);
            System.out.println("[ERROR] Instanciar grilla fecha hasta vacia.");
        } catch (Exception ex) {
            System.out.println("[OK] Instanciar grilla fecha hasta vacia: " + ex.getMessage());
        }
        System.out.println("=============================");
        Date desde = new Date();
        Date hasta = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("E yyyy.MM.dd '-' hh:mm:ss");
        
        
        System.out.println("Fecha desde: " + df.format(desde));
        System.out.println("Fecha hasta: " + hasta);
        
        System.out.println("=============================");
        System.out.println("            [OK] GrilaTest");
    }

}
