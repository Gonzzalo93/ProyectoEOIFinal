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

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            ConexionSQL gestion = new ConexionSQL();
<<<<<<< HEAD:pro/web/ServletLogin.java
                if(gestion.checkLogin(usuario, password)){
                    System.out.println("Login correcto");
=======
            PrintWriter out = response.getWriter();
                if(gestion.checkLogin(usuario, password)){
                    System.out.println("Login correcto");
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("Nick", usuario);
                    if(gestion.checkPersonaje(usuario) == 1){
                        response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/index/index.html");

                    }else{
                        response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/crearpersonaje/crearpersonaje.jsp");

                    }
                   
                    
>>>>>>> master:pro/Source Package/web/ServletLogin.java
                }else{
                    System.out.println("login incorrecto");
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/login/login.html");
                }
        }
    
}
