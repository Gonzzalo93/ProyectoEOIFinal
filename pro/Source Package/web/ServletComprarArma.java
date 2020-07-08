/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import ConexionSQL.ConexionSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author migue
 */
@WebServlet("/ServletComprarArma")
public class ServletComprarArma extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            HttpSession sesion = request.getSession();
            ConexionSQL gestion = new ConexionSQL();
            String arma = request.getParameter("boton");
            String login = (String)sesion.getAttribute("Nick");
            System.out.println(login);
            Integer coste = 0;
            Integer dinero = (Integer) sesion.getAttribute("Dinero");
            System.out.println(arma);
            switch(arma){
                case "Espada de madera":
                    coste = 1000;
                    break;
                case "Espada de plata":
                    coste = 3000;
                    break;
            }
            System.out.println(coste);
             if(login == null && dinero == null){
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");
             }else if (login != null && dinero >= coste){
                 int id = gestion.checkId(login);
                 String personaje = gestion.checkPersonaje(id);
                 gestion.gastarDinero(personaje, dinero-coste);
                 gestion.cambioArma(personaje, arma);
                 sesion.setAttribute("Dinero", dinero-coste);
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");

                 
             }
            
        }
}