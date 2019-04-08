package presentacion;

import com.google.gson.Gson;
import persistencia.TurnosDao;
import entidades.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Turnos", urlPatterns={"/Turnos"})
public class Turnos extends HttpServlet {
Gson convertir = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Pidiendo GET");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList<Turno> listado;
            listado = TurnosDao.getInstance().obtener();
            String resultado = convertir.toJson(listado);
            out.println("" + resultado);
        } catch (ClassNotFoundException ex) {
            System.out.println("Exeption ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Exeption SQLException: " + ex.getMessage());
        }
    }
   
 

}
