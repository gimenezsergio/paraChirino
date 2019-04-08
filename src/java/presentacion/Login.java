/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import com.google.gson.Gson;
import persistencia.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    Gson convertir = new Gson();
    static String laclave = "usuario";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        TreeMap paramRegister = convertir.fromJson(req.getReader(), TreeMap.class);
        String email = (String) paramRegister.get("email");
        String pass = (String) paramRegister.get("pass");
        String user = (String) paramRegister.get("user");
        String mensaje = "";
        if (email.equals("")) {
            mensaje += "Email no puede estar vacio. ";

        } else {
            if (pass.equals("")) {
                mensaje += "Clave no puede estar vacia. ";

            } else {
                if (user.equals("")) {
                    mensaje += "Usuario no puede estar vacio. ";
                }
            }

        }
        
        if(mensaje.equals("")){
            try {
                LoginDao.getInstance().registerUser(email, pass, user);
                mensaje = "Se inserto usuario";
            } catch (ClassNotFoundException ex) {
                mensaje = ex.getMessage();
                System.out.println("Exeption: " + ex.getMessage());
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
                System.out.println("Exeption: " + ex.getMessage());
            }
            
        }
        
        out.println(convertir.toJson(mensaje));
        System.out.println("Register user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LOGIN servlet");
        String loginCheck = null;
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        System.out.println("usuario " + user + " pass: " + pass);
        try {
            //loginCheck = LoginDao.verificar(user, pass);
            loginCheck = LoginDao.getInstance().verificar(user, pass);
            if (loginCheck != null) {
                System.out.println("loginCheck: " + loginCheck);
                if (req.getSession().getAttribute(laclave) == null) {
                    req.getSession().setAttribute(laclave, loginCheck);
                    System.out.println("EPA!!: Primera vez del Login de Usuario:: Nueva  Session ::" + req.getSession().getId());
                    System.out.println("Usuario ID: " + req.getSession().getAttribute(laclave));
                } else {
                    System.out.println("OK!!!: Logueado, dale para adelante    :: MISMA  Session ::" + req.getSession().getId());

                }
                resp.sendRedirect("privado/index.html");
            } else {
                resp.sendRedirect("index.html");
            }

        } catch (Exception ex) {
            System.out.println("Exeption de login: " + ex.getMessage());
        }

    }

}
