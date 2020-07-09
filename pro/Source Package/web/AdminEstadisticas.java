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
       
        
        
        int cuenta = Integer.parseInt(request.getParameter("ncuenta"));
        String personaje = request.getParameter("npersonaje");
        String clase = request.getParameter("clase");
        int oro = Integer.parseInt(request.getParameter("oro"));
        int nivel = Integer.parseInt(request.getParameter("nivel"));
        int progreso = Integer.parseInt(request.getParameter("torre"));
        int hp = Integer.parseInt(request.getParameter("hp"));
        int mp = Integer.parseInt(request.getParameter("mp"));
        int atq = Integer.parseInt(request.getParameter("atq"));
        int def = Integer.parseInt(request.getParameter("def"));
        int eva = Integer.parseInt(request.getParameter("eva"));
        
        System.out.println("cuenta: " + cuenta);
        System.out.println("oro: " + oro);
          System.out.println("lv: " + nivel);
        
         ConexionSQL gestion = new ConexionSQL();
         if (gestion.adminEstadisticas(cuenta,personaje,clase,oro,nivel,progreso,hp,mp,atq,def,eva)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
            response.sendRedirect("/ProyectoWebFinal/Boostrap/vistaadmin/vistaAdmin.html?Hecho.");
        }
    
}

