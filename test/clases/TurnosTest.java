package clases;

import entidades.Grilla;
import entidades.Medico;
import entidades.Turno;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurnosTest {
    public static void main(String[] args) {
        System.out.println("        [...] TurnosTest");
        Turno miTurno = new Turno("1", "3", "2018-11-28 15:00:00", "2018-11-28 15:30:00");
        System.out.println(miTurno);
        System.out.println("        [OK] TurnosTest");
    }
    
}
