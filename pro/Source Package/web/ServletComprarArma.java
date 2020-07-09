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

/**
 *
 * @author migue
 */
@WebServlet("/ServletComprarArma")
public class ServletComprarArma extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            HttpSession sesion = request.getSession();
            ConexionSQL gestion = new ConexionSQL();
            String arma = request.getParameter("boton");
            String login = (String)sesion.getAttribute("Nick");
            int id = gestion.checkId(login);
            String clase = gestion.checkClase(id);
            System.out.println(login);
            Integer coste = 0;
            Integer dinero = (Integer) sesion.getAttribute("Dinero");
            System.out.println(arma);
            if(clase == "Guerrero"){
                switch(arma){
                
                case "Espada de madera":
                    coste = 1000;
                    break;
                case "Espada de plata":
                    coste = 3000;
                    break;
                case "Espada de hierro rojo":
                    coste = 5000;
                    break;
                case "Espada de los antiguos":
                    coste = 8000;
                    break;
                case "Sangre nocturna":
                    coste = 10000;
                    break;
                }
            }
            if(clase == "Arquero"){
                switch(arma){
                    case "Arco de practica":
                        coste = 900;
                        break;
                    case "Arco del bosque":
                        coste = 2900;
                        break;
                    case "Arco de tirador":
                        coste = 5300;
                        break;
                    case "Trazadora":
                        coste = 7000;
                        break;
                    case "Diente de dragon":
                        coste = 12000;
                        break;
                  }
            }
            if(clase == "Mago"){
                 switch(arma){    
                case "Varita del principiante":
                    coste = 1100;
                    break;
                case "Baston de guerra":
                    coste = 3000;
                    break;
                case "Vara del caos":
                    coste = 5400;
                    break;
                case "Baston infernal":
                    coste = 7300;
                    break;
                case "Remenante helado":
                    coste = 13000;
                    break;
                 }
            }
            System.out.println(coste);
             if(login == null && dinero == null){
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");
             }else if (login != null && dinero >= coste){
                 String personaje = gestion.checkPersonaje(id);
                 gestion.gastarDinero(personaje, dinero-coste);
                 gestion.cambioArma(personaje, arma);
                 sesion.setAttribute("Dinero", dinero-coste);
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");

                 
             }
            
        }
}