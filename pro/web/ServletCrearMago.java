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

@WebServlet("/ServletCrearMago")
public class ServletCrearMago extends HttpServlet{
      @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
             HttpSession sesion = request.getSession();
            String nombre = request.getParameter("nombre");
            String nick = (String)sesion.getAttribute("Nick");
            ConexionSQL gestion = new ConexionSQL();
            PrintWriter out = response.getWriter();
            int id = gestion.checkId(nick);
              if(gestion.createMago(id,nick,nombre)){
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/index/index.jsp");
                   
                    
                }else{
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/crearpersonaje/crearpersonaje.jsp");
                }
                
                
      
        }
}