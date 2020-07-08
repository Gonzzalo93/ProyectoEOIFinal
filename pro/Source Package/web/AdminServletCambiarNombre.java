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
@WebServlet("/AdminServletCambiarNombre")
public class AdminServletCambiarNombre extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String antiguo = request.getParameter("nombre_antiguo");
        String nuevo = request.getParameter("nombre_nuevo");
         ConexionSQL gestion = new ConexionSQL();
         
           
            if (gestion.adminNuevoNombre(antiguo,nuevo)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
            response.sendRedirect("/ProyectoWebFinal/Boostrap/vistaadmin/vistaAdmin.html");
        
    }
}
