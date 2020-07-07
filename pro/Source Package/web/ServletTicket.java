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
import javax.swing.JOptionPane;

/**
 *
 * @author Propietario
 */
@WebServlet("/ServletTicket") 
public class ServletTicket extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         HttpSession sesion = request.getSession();
         String nuevapass = (String)sesion.getAttribute("Nick");
        
         
          String opcion = request.getParameter("opcion");
          String titulo = request.getParameter("titulo");
           String descripcion = request.getParameter("descripcion");
            ConexionSQL gestion = new ConexionSQL();
            int id = gestion.checkId(nuevapass);
            
            if (gestion.enviarTicket(id, opcion, titulo, descripcion)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
            
            response.sendRedirect("/ProyectoWebFinal/Boostrap/servicios/servicios.html");
        }
    
}
