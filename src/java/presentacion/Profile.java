package presentacion;

import com.google.gson.Gson;
import persistencia.ProfileDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Profile", urlPatterns={"/Profile"})
public class Profile extends HttpServlet {
    Gson convertir = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String userId = (String) req.getSession().getAttribute("usuario");
        try {
            TreeMap miUsuario = ProfileDao.getInstance().obtener(userId);
            out.println(convertir.toJson(miUsuario));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Exepction: " + ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exepction: " + ex.getMessage());
        }
    }

 

}
