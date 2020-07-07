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
    </head>
    <body>
        <h1>Ranking de los niveles mas altos</h1>   
         <%       
         String tipo =request.getParameter("tipos");
            %>
        <br>
        <h2><%= "Ranking de " + tipo %></h2>
        <%   
        String url = "jdbc:mysql://localhost:3306/shadowlands?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="asd123!\"·";
        String insertQuery ="SELECT Nombre, Nivel from personajes order by Nivel desc";
        
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(url,user,pass);
        System.out.println("Conectando a "+url);

            
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery(insertQuery);
        
        int cont = 0;
        
        
        
        while(rs.next()|| cont==10){
            System.out.print("Nick " + rs.getString("Nombre")+ "   Nivel: " +rs.getInt("Nivel"));
            
            cont++;
        }
                
	} catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de MySQL: " + ex);
                }
           
        
        %>
 </body>
</html>
