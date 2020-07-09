<%@page import="ConexionSQL.ConexionSQL"%>
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
        <title>EstadoTickets</title>
        <link rel="stylesheet" href="TicketsCss/cssTickets.css">
     <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="css/servicios.css" rel="stylesheet" />
    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../favicon/favicon-16x16.png">
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link rel="mask-icon" href="../favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    </head>
    <body>
            <div class="p-3 mb-2 bg-primary text-white">Servicios
        <h1>Soporte y Ticket</h1>
    </div>
        <br>
        <h2>Estado de los Tickets</h2>   
        <br>

        <%   
        String url = "jdbc:mysql://localhost:3306/shadowlands?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="asd123!\"·";
        String insertQuery ="SELECT* FROM consultas WHERE cuentas_idCuentas = ?";
        
        
        HttpSession sesion = request.getSession();
        String Nick="Drizzt";
        //String Nick = (String)sesion.getAttribute("Nick");
        ConexionSQL gestion = new ConexionSQL(); 
        int idCuenta= gestion.checkId(Nick);
        
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(url,user,pass);
        System.out.println("Conectando a "+url);

        int idConsultas = 1;
        PreparedStatement pst = conexion.prepareStatement(insertQuery);
        pst.setInt(1, idCuenta);

        ResultSet rs = pst.executeQuery();
        
%>
    <table class="Tabla">
        <tr class=Titulos>
            <th class=" Oro">
                <strong>Nº de consulta</strong>
            </th>
            <th class="Oro">
                <strong>Titulo</strong>
            </th>
            <th class="Oro">
                <strong>Estado</strong>
            </th>
            <th class="Nombre">
                <strong>Tu Comentario</strong>
            </th>
            <th class="Resolucion">
                <strong>Resolución</strong>
            </th>
        </tr>
        <% while(rs.next()){
           
            %>
            <tr>
            <td><%= rs.getInt("idConsultas")  %></td>
            <td><%= rs.getString("Titulo")  %></td>

            <td><strong><% if(rs.getString("Estado").equals("En revision")){
                %>
           
                <p id="Rojo"> <%out.print(rs.getString("Estado"));%></p>
                <%
            }else{
                 %>
                 
                 <p id="Verde"><% out.print(rs.getString("Estado"));%></p>
                 <%
                        }

%></strong></td>            
                        <td><%= rs.getString("Comentarios")  %></td>
            
            <td><%= rs.getString("Resolucion")  %></td>
            </tr>

            <%
        }
        %>
            
            </table> 
        <%
            rs.close();
            pst.close();
            conexion.close();
            }catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de MySQL: " + ex);
                }
        
        %>
 </body>
</html>
