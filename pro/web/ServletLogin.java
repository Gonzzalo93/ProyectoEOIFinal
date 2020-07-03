package web;


import ConexionSQL.ConexionSQL;
import com.mysql.cj.x.protobuf.MysqlxConnection;
import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
            PrintWriter out = response.getWriter();
            Cookie[] cookies = request.getCookies();
              //Declaramos la variable contador
              int contador = 0;
                if(gestion.checkLogin(usuario, password)){
                    System.out.println("Login correcto");
                    Cookie c = new Cookie("Nick",usuario);
                    response.addCookie(c);
                    
                   
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/crearpersonaje/crearpersonaje.jsp");
                    
                }else{
                    System.out.println("login incorrecto");

                }
                
      
        }
}
