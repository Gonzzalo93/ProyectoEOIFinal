/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import ConexionSQL.ConexionSQL;
import java.io.IOException;
import java.io.PrintWriter;
import web.*;
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
@WebServlet("/ServletBorrarCuenta")
    public class ServletBorrarCuenta extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         HttpSession sesion = request.getSession();
         String borrarnick = (String)sesion.getAttribute("Nick");
         String confirmar = request.getParameter("confirmar");
         
                 
         if (confirmar.equals("CONFIRMAR")) {
             ConexionSQL gestion = new ConexionSQL();
             
             gestion.borrarCuenta(borrarnick);
             
             System.out.println("Chaoo");
                     
                     
         }else{
             System.out.println("No has escrito CONFIRMAR");
                     
         }
           
        
        response.sendRedirect("/ProyectoWebFinal/Boostrap/servicios/servicios.html");
        
    }
}    

