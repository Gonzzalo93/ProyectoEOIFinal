package web;


import ConexionSQL.ConexionSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            ConexionSQL gestion = new ConexionSQL();
                if(gestion.checkLogin(usuario, password)){
                    System.out.println("Login correcto");
                }else{
                    System.out.println("login incorrecto");

                }
        }
    
}
