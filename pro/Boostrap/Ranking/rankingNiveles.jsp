<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking niveles</title>
        <link rel="stylesheet" href="CssRanking/estiloRanking.css">
    <link href="https://fonts.googleapis.com/css2?family=Fondamento&family=Yellowtail&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1>Shadowlands</h1>
        <h2>Ranking de los niveles más altos</h2>   
         <%       
        String tipo =request.getParameter("tipos");

             %>
        <br>
        <h2> <h2><%= "Ranking de " + tipo %></h2></div></h2>
        <%   
        String url = "jdbc:mysql://localhost:3306/shadowlands?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="asd123!\"·";
        String insertQueryTodos ="SELECT Nombre,Clase, Nivel,Progreso, Dinero,Hp,Dmg,ArmaEquipada FROM personajes order by Nivel desc";
        
        String insertQueryClases ="SELECT Nombre,Clase, Nivel,Progreso,Dinero,Hp,Dmg,ArmaEquipada  FROM personajes WHERE Clase = ? order by Nivel desc";
        
       
        if(tipo.equals("")){
        %>
    <h3 margin-top = 20px >Selecciona una opción para ver el ranking</h3>
    <br>
    <h3>Pulsa <a href="../Ranking/index.html">Aquí</a> para volver atrás</h3>
    <%    
        }else if(tipo.equals("Todos")){   
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(url,user,pass);
        System.out.println("Conectando a "+url);

        
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery(insertQueryTodos);
        
        int cont = 0;
        %>
    <table class="Tabla">
        <tr class=Titulos>
            <th class=" Nombre">
                <strong>Nombre</strong>
            </th>
            <th class="Clase">
                <strong>Clase</strong>
            </th>
            <th class="Nivel">
                <strong>Nivel</strong>
            </th>
            <th class="Piso">
                <strong>Piso</strong>
            </th>
            <th class="Oro">
                <strong>Oro</strong>
            </th>
            <th class="Oro">
                <strong>Daño</strong>
            </th>
            <th class="Oro">
                <strong>Vida</strong>
            </th>
            <th class="Oro">
                <strong>Arma Equipada</strong>
            </th>
        </tr>
        <%
            rs.next();
            %>
        <tr class="primero">
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
        </tr>
                <%
            rs.next();
            %>
        <tr class="segundo">
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
        </tr>
                <%
            rs.next();
            %>
        <div class="imagen">
            <tr class="tercero">
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
            </tr>
            <%
        while(rs.next()){
            System.out.print("Nick " + rs.getString("Nombre")+ "   Nivel: " +rs.getInt("Nivel"));
            %>
            <tr>
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
            </tr>

            <%
            cont++;
        }
        %>
            
            </table> 
        <%
            rs.close();
            st.close();
            conexion.close();
            }catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de MySQL: " + ex);
                }
        }else if(tipo.equals("Guerrero")||tipo.equals("Arquero")||tipo.equals("Mago")){
        PreparedStatement stmt = null;
        ResultSet rs =null;
            try{
               Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(url,user,pass);
        System.out.println("Conectando a "+url);

        stmt = conexion.prepareStatement(insertQueryClases);
        stmt.setString(1,tipo);
        rs = stmt.executeQuery();
        %>
    <table class="Tabla">
        <tr class=Titulos>
            <th class=" Nombre">
                <strong>Nombre</strong>
            </th>
            <th class="Clase">
                <strong>Clase</strong>
            </th>
            <th class="Nivel">
                <strong>Nivel</strong>
            </th>
            <th class="Piso">
                <strong>Piso</strong>
            </th>
            <th class="Oro">
                <strong>Oro</strong>
            </th>
            <th class="Oro">
                <strong>Daño</strong>
            </th>
            <th class="Oro">
                <strong>Vida</strong>
            </th>
            <th class="Oro">
                <strong>Arma Equipada</strong>
            </th>
        </tr>
        <%
            rs.next();
            %>
        <tr class="primero">
            <td> <%= rs.getString("Nombre")   %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
        </tr>
                <%
            rs.next();
            %>
        <tr class="segundo">
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
        </tr>
                <%
            rs.next();
            %>
        <div class="imagen">
            <tr class="tercero">
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
            </tr>
            <%
        while(rs.next()){
            System.out.print("Nick " + rs.getString("Nombre")+ "   Nivel: " +rs.getInt("Nivel"));
            %>
            <tr>
            <td><%= rs.getString("Nombre")  %></td>
            <td><%= rs.getString("Clase")  %></td>
            <td><%= rs.getInt("Nivel")  %></td>
            <td><%= rs.getInt("Progreso")  %></td>
            <td><%= rs.getInt("Dinero")  %></td>
            <td><%= rs.getInt("Hp")  %></td>
            <td><%= rs.getInt("Dmg")  %></td>
            <td><%= rs.getString("ArmaEquipada")  %></td>
            </tr>

            <%
        }
        %>
            
            </table> 
        <%
            rs.close();
            stmt.close();
            conexion.close();

            }catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de MySQL: " + ex);
                }

            }   
        
        %>
 </body>
</html>
