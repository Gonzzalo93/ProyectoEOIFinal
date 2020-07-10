/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ConexionSQL.ConexionSQL;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author migue
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String email = request.getParameter("correo");
            String fnacimiento = request.getParameter("fnacimiento");
            String direccion = request.getParameter("direccion");
            String pais = request.getParameter("pais");
            ConexionSQL gestion = new ConexionSQL();
            if(gestion.createUsuario(usuario, password, email, pais, fnacimiento, direccion)){
               response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/login/login.html");
            }else{
                response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/registro/registro.html");
            }
        }
        
}
