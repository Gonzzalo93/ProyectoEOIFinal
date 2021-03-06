<%-- 
    Document   : tienda
    Created on : 7 jul. 2020, 10:32:36
    Author     : santi
--%>


<% 
    HttpSession sesion = request.getSession();
         
           String login = (String)sesion.getAttribute("Nick");
          Integer dinero = (Integer) sesion.getAttribute("Dinero");
       if( login == null){
           login = "invitado";
           
       }
          if (dinero == null){
              dinero = 0;
          }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <link href="css/tienda.css" rel="stylesheet" />

    <script src="js/tienda.js"></script>



    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../favicon/favicon-16x16.png">
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link rel="mask-icon" href="../favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <title>Shadowlands - Tienda</title>
</head>

<body id="bck">
    <div>

        <!-- <div class="p-3 mb-2 bg-primary text-white div1">Tienda -->

        <div class="col-md-center div2">
            <a href="#espada">
                <img class="ajustar" src="imagenes/sword.png"></a>
            <a href="#arcos">
                <img class="ajustar" src="imagenes/bow.png"></a>
            <a href="#varitas">
                <img class="ajustar" src="imagenes/witch.png"></a>

        </div>
         <a href="tienda2.jsp">
                <img class="ajustar" src="imagenes/armor.png"></a>
        
        
        <div class="container">
           
            <h2>Tienda de <%= login%>  y cuentas con <%= dinero %>  oro</h2>   
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <!-- <th scope=" col ">#</th> -->
                        <th scope="col ">Arma</th>
                        <th scope="col ">Descripción</th>
                        <th scope="col ">Comprar</th>
                    </tr>
                </thead>
                <form action="/ProyectoWebFinal/ServletComprarArma" method="post">
                    <tbody>
                        <tr id="espada">


                            <td><img src="imagenes/espada1.png "></td>
                            <td class="tier1 ">Espada de Madera: +20 daño +4% Probabilidad de Crítico </td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Espada de madera">Comprar (1.000g)</button></td>
                        </tr>
                        <tr>

                            <td><img src="imagenes/espada2.png "></td>
                            <td class="tier2 ">Espada de Plata: +44 daño +8% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Espada de plata">Comprar (3.000g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/espada3.png "></td>
                            <td class="tier3 ">Espada de Hierro Rojo: +67 daño 15% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Espada de hierro rojo">Comprar (5.500g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/espada4.png "></td>
                            <td class="tier4 ">Espada de los Antiguos: +100 daño +25% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Espada de los antiguos">Comprar (7.100g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/espada5.png "></td>
                            <td class="tier5 ">Sangre Nocturna: +140 daño +40% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Sangre nocturna">Comprar (10.000g)</button></td>
                        </tr>
                        <tr id="arcos">

                            <td><img src="imagenes/arco1.png "></td>
                            <td class="tier1 ">Arco de práctica: +30 daño +6% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Arco de practica">Comprar (900g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/arco2.png "></td>
                            <td class="tier2 ">Arco del Bosque: +58 daño +12% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Arco del bosque">Comprar (2.900g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/arco3.png "></td>
                            <td class="tier3 ">Arco de Tirador: +92 daño +20% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " Arco de tirador>Comprar (5.300g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/arco4.png "></td>
                            <td class="tier4 ">Trazadora: +150 daño +32% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Trazadora">Comprar (7.000g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/arco5.png "></td>
                            <td class="tier5 ">Diente de Dragón: +190 daño +60% Probabilidad de Crítico</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Diente de dragon">Comprar (12.000g)</button></td>
                        </tr>

                        <tr id="varitas">

                            <td><img src="imagenes/vara1.png "></td>
                            <td class="tier1 ">Varita de Principiante: +40 daño</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Varita de principiante">Comprar (1.100g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/vara2.png "></td>
                            <td class="tier2 ">Bastón de Guerra: +76 daño</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Baston de guerra">Comprar (3.000g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/vara3.png "></td>
                            <td class="tier3 ">Vara del Caos: +112 daño</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Vara del caos">Comprar (5.400g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/vara4.png "></td>
                            <td class="tier4 ">Bastón Infernal: +179 daño</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Baston infernal">Comprar (7.300g)</button></td>
                        </tr>
                        <tr>
                            <!-- <th scope="row ">3</th> -->
                            <td><img src="imagenes/vara5.png "></td>
                            <td class="tier5 ">Remanente Helado: +230 daño</td>
                            <td><button type="submit" name="boton" class="btn btn-warning txt " value="Remanente helado">Comprar (13.000g)</button></td>
                        </tr>
                         
                    </tbody>
               </form>
            </table>

        </div>

        <button onclick="topFunction()" id="myBtn">  &#129045 </button>
    </div>
</body>

</html>
