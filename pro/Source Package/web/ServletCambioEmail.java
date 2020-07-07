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

@WebServlet("/ServletCambioEmail")
public class ServletCambioEmail extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         HttpSession sesion = request.getSession();
         String sesioncorreo = (String)sesion.getAttribute("Nick");
         String email = request.getParameter("nnemail");
            ConexionSQL gestion = new ConexionSQL();
            if (gestion.cambioEmail(email,sesioncorreo)){
                System.out.println("bien");
            }else{
                System.out.println("mal");
            }
            
            response.sendRedirect("/ProyectoWebFinal/Boostrap/servicios/servicios.html");
        }
        
        
        
    }