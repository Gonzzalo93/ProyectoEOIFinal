<%-- 
    Document   : tienda2
    Created on : 7 jul. 2020, 10:35:59
    Author     : Propietario
--%>

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
                        <td class="tier1 ">Escudo básico: +10 HP +5 Defensa </td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (900g)</button></td>
                    </tr>
                    <tr>

                        <td><img src="imagenes/escudo2.png "></td>
                        <td class="tier2 ">Escudo robusto: +20 HP +9 Defensa</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (1.700g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo3.png "></td>
                        <td class="tier3 ">Escudo de Plata: +50 HP +13 Defensa </td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (3.500g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo4.png "></td>
                        <td class="tier4 ">Gran Escudo: +80 HP +18 Defensa</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (5.100g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/escudo5.png "></td>
                        <td class="tier5 ">Coraza Inmortal: +170 HP +28 Defensa</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (9.000g)</button></td>
                    </tr>
                    <tr id="arcos">

                        <td><img src="imagenes/botas1.png "></td>
                        <td class="tier1 ">Zapatillas básicas: +3 HP +5 Evasión</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (800g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas2.png "></td>
                        <td class="tier2 ">Zapatillas prácticas: +8 HP +9 Evasión</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (1.600g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas3.png "></td>
                        <td class="tier3 ">Chanclas Corredor del Viento: +13 HP +13 Evasión</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (5.300g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas4.png "></td>
                        <td class="tier4 ">Viento aúreo: +20 HP + 17 Evasión</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (7.200g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/botas5.png "></td>
                        <td class="tier5 ">Paso Ligero: +25 HP + 25 Evasión</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (9.900g)</button></td>
                    </tr>

                    <tr id="varitas">

                        <td><img src="imagenes/gorro1.png "></td>
                        <td class="tier1 ">Gorro de Principiante: +3 HP + 3 Daño</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (1.100g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro2.png "></td>
                        <td class="tier2 ">Gorro de Mago Experto: +5 HP + 5 Daño</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (3.000g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro3.png "></td>
                        <td class="tier3 ">Gorro Maldito: +8 HP + 8 Daño</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (5.400g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro4.png "></td>
                        <td class="tier4 ">Tiara Infernal: +11 HP + 10 Daño</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (8.300g)</button></td>
                    </tr>
                    <tr>
                        <!-- <th scope="row ">3</th> -->
                        <td><img src="imagenes/gorro5.png "></td>
                        <td class="tier5 ">Corona de Destrucción: +15 HP + 14 Daño</td>
                        <td><button type="button " class="btn btn-warning txt ">Comprar (16.000g)</button></td>
                    </tr>
                </tbody>
            </table>

        </div>

        <button onclick="topFunction()" id="myBtn">  &#129045 </button>
    </div>
</body>

</html>