package presentacion;

import com.google.gson.Gson;
import entidades.Reserva;
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
import persistencia.ReservasDAO;

@WebServlet(name = "Reservas", urlPatterns = {"/privado/Reservas"})
public class Reservas extends HttpServlet {

    Gson convertir = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reserva miReserva = (Reserva) req.getSession().getAttribute("reserva");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        try {
            ArrayList<Reserva> listado = ReservasDAO.getInstance().obtener(req.getSession().getId());
            resp.getWriter().println(convertir.toJson(listado));
        } catch (ClassNotFoundException ex) {
            System.out.println("Alerta: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Alerta: " + ex.getMessage());
        }
        
        
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("reserva", convertir.fromJson(req.getReader(), Reserva.class));
        Reserva miReserva = (Reserva) req.getSession().getAttribute("reserva");
        System.out.println(" reserva: " + miReserva);
        try {
            ReservasDAO.insertar(miReserva.getFecha(), req.getSession().getId());
            resp.getWriter().println(convertir.toJson(req.getSession().getAttribute("reserva")));
        } catch (ClassNotFoundException ex) {
            System.out.println("Alerta: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Alerta: " + ex.getMessage());
        }
        
    }

}
