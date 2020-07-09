<%-- 
    Document   : tienda2
    Created on : 7 jul. 2020, 10:35:59
    Author     : Propietario
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
    <link href="css/tienda.css" rel="stylesheet"/>
    <script src="particles/particles.js"></script>
    <script src="particles/app.js"></script>
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
                <img class="ajustar" src="imagenes/security.png"></a>
            <a href="#arcos">
                <img class="ajustar" src="imagenes/shoes.png"></a>
            <a href="#varitas">
                <img class="ajustar" src="imagenes/sgorros.png"></a>

        </div>
        
            </div>
         <a href="tienda.jsp">
                <img class="ajustar" src="imagenes/agre.png"></a>

        <div class="container">


            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <!-- <th scope=" col ">#</th> -->
                        <th scope="col ">Armadura</th>
                        <th scope="col ">Descripción</th>
                        <th scope="col ">Comprar</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="espada">


                        <td><img src="imagenes/escudo1.png "></td>
                        <td class="tier1 ">Escudo básico: +100 HP +14 Defensa +2 Evasion </td>
                        <td><button type="button " class="btn btn-warning txt " value="Escudo basico">Comprar (900g)</button></td>
                    </tr>
                    <tr>

                        <td><img src="imagenes/escudo2.png "></td>
                        <td class="tier2 ">Escudo robusto: +470 HP +33 Defensa +3 Evasion </td>
                        <td><button type="button " class="btn btn-warning txt " value="Escudo robusto">Comprar (1.700g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo3.png "></td>
                        <td class="tier3 ">Escudo de Plata: +810 HP +33 Defensa +4 Evasion </td>
                        <td><button type="button " class="btn btn-warning txt " value="Escudo de plata">Comprar (3.500g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo4.png "></td>
                        <td class="tier4 ">Gran Escudo: +1300 HP +68 Defensa +4 Evasion </td>
                        <td><button type="button " class="btn btn-warning txt " value="Gran escudo">Comprar (5.100g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo5.png "></td>
                        <td class="tier5 ">Coraza Inmortal: +2520 HP +140 Defensa +5 Evasion </td>
                        <td><button type="submit" class="btn btn-warning txt " value="Coraza inmortal">Comprar (9.000g)</button></td>
                    </tr>
                    <tr id="arcos">

                        <td><img src="imagenes/botas1.png "></td>
                        <td class="tier1 ">Zapatillas básicas: +50 HP +8 Defensa +3 Evasion </td>
                        <td><button type="submit" class="btn btn-warning txt " value="Zapatillas basicas">Comprar (800g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas2.png "></td>
                        <td class="tier2 ">Zapatillas prácticas: +140 HP +18 Defensa +6 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Zapatillas practicas">Comprar (1.600g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas3.png "></td>
                        <td class="tier3 ">Chanclas del Viento: +210 HP +31 Defensa +9 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Chanclas del viento">Comprar (5.300g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas4.png "></td>
                        <td class="tier4 ">Viento aúreo: +370 HP +68 Defensa +12 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Viento aureo">Comprar (7.200g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas5.png "></td>
                        <td class="tier5 ">Paso Ligero: +560 HP +92 Defensa +15 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Paso ligero">Comprar (9.900g)</button></td>
                    </tr>

                    <tr id="varitas">

                        <td><img src="imagenes/gorro1.png "></td>
                        <td class="tier1 ">Gorro de Principiante: +20 HP +5 Defensa +2 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Gorro de principiante">Comprar (1.100g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro2.png "></td>
                        <td class="tier2 ">Gorro de Mago: +60 HP +15 Defensa +5 Evasion/td>
                        <td><button type="submit" class="btn btn-warning txt " value="Gorro de mago">Comprar (3.000g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro3.png "></td>
                        <td class="tier3 ">Gorro Maldito: +120 HP +28 Defensa +6 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Gorro maldito">Comprar (5.400g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro4.png "></td>
                        <td class="tier4 ">Tiara Infernal: +200 HP +49 Defensa +7 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Tiara infernal">Comprar (8.300g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro5.png "></td>
                        <td class="tier5 ">Corona del Fin: +400 HP +65 Defensa +10 Evasion</td>
                        <td><button type="submit" class="btn btn-warning txt " value="Corona del fin">Comprar (16.000g)</button></td>
                    </tr>
                </tbody>
            </table>

        </div>

        <button onclick="topFunction()" id="myBtn">  &#129045 </button>
    </div>
</body>

</html>