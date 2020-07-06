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

@WebServlet("/ServletCambioPassword") 
public class ServletCambioPassword extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         HttpSession sesion = request.getSession();
         String nuevapass = (String)sesion.getAttribute("Nick");
         String pass = request.getParameter("nnpassword");
            ConexionSQL gestion = new ConexionSQL();
            if (gestion.cambioPassword(pass,nuevapass)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
        }
        
        
        
    }
    

