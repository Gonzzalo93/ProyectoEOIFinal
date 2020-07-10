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
@WebServlet("/ServletComprarArmadura")
public class ServletComprarArmadura extends HttpServlet{
     @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            HttpSession sesion = request.getSession();
            ConexionSQL gestion = new ConexionSQL();
            String armadura = request.getParameter("boton");
            String login = (String)sesion.getAttribute("Nick");
            int id = gestion.checkId(login);
            String clase = gestion.checkClase(id);
            String armaduraComprada = "Nada";
            System.out.println(login);
            Integer coste = 0;
            Integer dinero = (Integer) sesion.getAttribute("Dinero");
            System.out.println(armadura);
            if(clase == "Guerrero"){
                switch(armadura){
                    case "Escudo basico":
                        armaduraComprada = "Escudo basico";
                        coste = 900;
                        break;
                    case "Espada robusto":
                        armaduraComprada = "Escudo robusto";
                        coste = 1700;
                        break;
                    case "Espada de plata":
                        armaduraComprada = "Escudo de plata";
                        coste = 3500;
                        break;
                    case "Gran escudo":
                        armaduraComprada = "Gran escudo";
                        coste = 5100;
                        break;
                    case "Coraza inmortal":
                        armaduraComprada = "Coraza inmortal";
                        coste = 9000;
                        break;
                }
            }
            if(clase == "Guerrero"){
                switch(armadura){
                 case "Zapatillas basicas":
                     armaduraComprada = "Zapatillas basicas";
                    coste = 800;
                    break;
                case "Zapatillas practicas":
                    armaduraComprada = "Zapatillas practicas";
                    coste = 1600;
                    break;
                case "Chanclas del viento":
                    armaduraComprada = "Chanclas del viento";
                    coste = 5300;
                    break;
                case "Viento aureo":
                    armaduraComprada = "Viento aureo";
                    coste = 7200;
                    break;
                case "Paso ligero":
                    armaduraComprada = "Paso ligero";
                    coste = 9900;
                    break;
                }
            }
            if(clase == "Guerrero"){
                switch(armadura){
                case "Gorro de principiante":
                    armaduraComprada = "Gorro de principiante";
                    coste = 1100;
                    break;
                case "Gorro de mago":
                    armaduraComprada = "Gorro de mago";
                    coste = 3000;
                    break;
                case "Gorro maldito":
                    armaduraComprada = "Gorro maldito";
                    coste = 5400;
                    break;
                case "Tiara infernal":
                    armaduraComprada = "Tiara infernal";
                    coste = 8300;
                    break;
                case "Corona del fin":
                    armaduraComprada = "Corona del fin";
                    coste = 16000;
                    break;
                }
            }
            System.out.println(coste);
             if(login == null && dinero == null){
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");
             }else if (login != null && dinero >= coste){
                 String personaje = gestion.checkPersonaje(id);
                 gestion.gastarDinero(personaje, dinero-coste);
                 gestion.cambioArmadura(personaje, armadura);
                 sesion.setAttribute("Dinero", dinero-coste);
                 response.sendRedirect("http://localhost:8080/ProyectoWebFinal/Boostrap/tienda/tienda.jsp");

                 
             }
            
        }
}
