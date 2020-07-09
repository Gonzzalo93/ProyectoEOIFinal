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
@WebServlet("/AdminEstadisticas")
public class AdminEstadisticas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
       
        String cuenta = request.getParameter("ncuenta");
        String personaje = request.getParameter("npersonaje");
        String clase = request.getParameter("clase");
        String oro = request.getParameter("oro");
        String nivel = request.getParameter("nivel");
        String progreso = request.getParameter("torre");
        String hp = request.getParameter("hp");
        String mp = request.getParameter("mp");
        String atq = request.getParameter("atq");
        String def = request.getParameter("def");
        String eva = request.getParameter("eva");
        
        
     
         ConexionSQL gestion = new ConexionSQL();
         if (gestion.adminEstadisticas(cuenta,personaje,clase,oro,nivel,progreso,hp,mp,atq,def,eva)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
            response.sendRedirect("/ProyectoWebFinal/Boostrap/vistaadmin/vistaAdmin.html?Hecho.");
        }
    
}

