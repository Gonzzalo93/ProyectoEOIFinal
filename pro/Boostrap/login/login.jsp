<%-- 
    Document   : login
    Created on : 04-jul-2020, 16:13:50
    Author     : migue
--%>
<%@page import="ConexionSQL.ConexionSQL;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Shadowlands - Login</title>
    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../favicon/favicon-16x16.png">
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link rel="mask-icon" href="../favicon/safari-pinned-tab.svg">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
</head>

<body class="text-center">
    <form class="form-signin" action="../crearpersonaje/crearpersonaje.jsp" method="post" onsubmit="check(this)">
        <img class="mb-4" src="../favicon/chibia2.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesión</h1>
        <label for="inputEmail" class="sr-only" >Nombre de Usuario</label>
        <input type="text" id="inputEmail" class="form-control" name="usuario" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Contraseña</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Contraseña" required>
        <div class="checkbox mb-3">
            <label>
      <input type="checkbox" value="remember-me"> Recordarme
    </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
    </form>
    <script type="text/javascript"></script>
     
             
             <script>
                 
                    var name = "Gautam"; </script> 
                    <% String str = "<script>document.writeln(name)</script>"; 
                          out.println("value: " + str); %>
                    
            
           
              
        
   
</body>

</html>
