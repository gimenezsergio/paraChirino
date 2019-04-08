/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

@WebFilter(filterName = "login", urlPatterns = {"/privado/*"})
public class Filterlogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
        HttpServletRequest pedido = (HttpServletRequest) request;
        HttpServletResponse respuesta = (HttpServletResponse) response;
        HttpSession session = pedido.getSession(false);// don't create if it doesn't exist
        if (session != null && !session.isNew()) {
            System.out.println("Ingresado");
            chain.doFilter(request, response);            
        } else {
            System.out.println("Sin ingreso");
            respuesta.sendRedirect( 
                        pedido.getScheme() +"://" +
                        pedido.getServerName() + ":" +
                        pedido.getServerPort() + 
                        pedido.getContextPath() +
                        "/index.html" );
        }
        }catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

}
