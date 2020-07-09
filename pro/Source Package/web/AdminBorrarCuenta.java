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
@WebServlet("/AdminBorrarCuenta")
public class AdminBorrarCuenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
       
        String aborrar = request.getParameter("borrar");
         ConexionSQL gestion = new ConexionSQL();
         int id = gestion.checkId(aborrar);
         if(gestion.checkIdPersonaje(id) >= 1){
             gestion.borrarPersonaje(id);
             gestion.adminBorrarCuenta(aborrar);
             
         }else{
             gestion.adminBorrarCuenta(aborrar);
         }
            response.sendRedirect("/ProyectoWebFinal/Boostrap/vistaadmin/vistaAdmin.html");
        }
    
}
