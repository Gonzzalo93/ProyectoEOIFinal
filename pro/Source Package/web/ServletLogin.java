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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            ConexionSQL gestion = new ConexionSQL();
            PrintWriter out = response.getWriter();
                if(gestion.checkLogin(usuario, password)){
                    System.out.println("Login correcto");
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("Nick", usuario);
                    int id = gestion.checkId(usuario);
                    int dinero = gestion.checkCash(id);
                    
                    
                    String admin = gestion.checkRol(usuario);
                    sesion.setAttribute("Dinero", dinero);
                    System.out.println("oro:" + dinero);
                    System.out.println("rol: " + admin);
                    
                    System.out.println("Admin: " + admin);
                    
                    if(gestion.checkIdPersonaje(id) >= 1){
                       
                        
                        if(gestion.checkRol(usuario).equals("Admin")) {
                            System.out.println("ESTOY DENTRO" + usuario);
                        response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/vistaadmin/vistaAdmin.html");
                        
                    }else{
                        response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/index/index.jsp");    
                        

                    }
                   
                    
                }else{
                    
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/crearpersonaje/crearpersonaje.jsp");
                    
                }
               
      
        }else{
                    System.out.println("login incorrecto");
                    response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/login/login.html");
                }
    }
}
