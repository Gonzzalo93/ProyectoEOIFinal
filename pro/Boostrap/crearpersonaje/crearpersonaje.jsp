<%-- 
    Document   : crearpersonaje
    Created on : 03-jul-2020, 11:55:45
    Author     : migue
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*;" %>
<%@page import="javax.servlet.http.*;" %>
<% HttpSession sesion = request.getSession();%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Freelancer - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">

        <!-- Masthead-->
        <header class="masthead bg-dark text-white text-center fondo">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase-gray mb-0">SHADOWLANDS</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                <p class="masthead-subheading font-weight-light mb-0">Creación de personaje</p>
            </div>
        </header>
        <!-- Portfolio Section-->
        
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Elige tu clase, <%= sesion.getAttribute("Nick") %> </h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                </div>
                <!-- Portfolio Grid Items-->
                <div class="row">
                    <!-- Portfolio Item 1-->
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal1">
                            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                            </div>
                            <img class="img-fluid" src="imagenes/warrior.png" alt="" />
                        </div>
                         
                    </div>
                    <!-- Portfolio Item 2-->
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal2">
                            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                            </div>
                            <img class="img-fluid" src="imagenes/mago.png" alt="" />
                            
                        </div>
                    </div>
                    <!-- Portfolio Item 3-->
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal3">
                            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                            </div>
                            <img class="img-fluid" src="imagenes/archer.png" alt="" />
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Portfolio Modals-->
        <!-- Portfolio Modal 1-->
        <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="fas fa-times"></i></span>
                    </button>
                    <div class="modal-body text-center">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <!-- Portfolio Modal - Title-->
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0 colorWarr" id="portfolioModal1Label">Guerrero</h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                        <div class="divider-custom-line"></div>
                                        <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                                        <div class="divider-custom-line"></div>
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    <img class="img-fluid rounded mb-5" src="imagenes/warrior.png" alt="" />
                                    <!-- Portfolio Modal - Text-->
                                    <p class="mb-5 estilo">Valeroso guerrero, sientes el fervor de la batalla, cuentas con gran salud y defensa, tendrás una ofensiva pobre, sin embargo cuenta con daño critico. El mejor arma es la defensa.</p>
                                    <p class="mb-5 estilo">Parámetros iniciales:</p>
                                    <p class="mb-5 colorWarr estilo"><strong>Salud: 140 Ataque: 8 Defensa: 14 Evasión: 3% Daño Critico:150%</strong></p>
                                    <form method="post" action="/ProyectoWebFinal/ServletCrearWarrior" onsubmit="return checkCharacter()">
                                        <input type="text" placeholder="Escriba el nombre de su personaje" name="nombre" id="guerrero">
                                        <button class="btn btn-primary" data-dismiss="modal" onsubmit="return checkCharacter()">
                                           Crear
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Portfolio Modal 2-->
        <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-labelledby="portfolioModal2Label" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="fas fa-times"></i></span>
                    </button>
                    <div class="modal-body text-center">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <!-- Portfolio Modal - Title-->
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0 colorMago" id="portfolioModal2Label">Mago</h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                        <div class="divider-custom-line"></div>
                                        <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                                        <div class="divider-custom-line"></div>
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    <img class="img-fluid rounded mb-5" src="imagenes/mago.png" alt="" />
                                    <!-- Portfolio Modal - Text-->
                                    <p class="mb-5 estilo">El poder de la sabiduria. Elige bien tus cartas, heroe, este camino lleva a la puerta de un gran poder, sin embargo, no tendrás mucha resistencia. Todo poder conlleva una gran responsabilidad.</p>
                                    <p class="mb-5 estilo">Parámetros iniciales:</p>
                                    <p class="mb-5 estilo colorMago"><strong>Salud: 70 Ataque: 22 Defensa: 6 Evasion: 5%</strong></p>
                                    <form method="post" action="/ProyectoWebFinal/ServletCrearMago" onsubmit="return checkCharacter()">
                                        <input type="text" placeholder="Escriba el nombre de su personaje" name="nombre" id="mago">
                                        <button class="btn btn-primary" data-dismiss="modal" onsubmit="return checkCharacter()">
                                           Crear
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Portfolio Modal 3-->
        <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-labelledby="portfolioModal3Label" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="fas fa-times"></i></span>
                    </button>
                    <div class="modal-body text-center">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <!-- Portfolio Modal - Title-->
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0 colorArcher" id="portfolioModal3Label">Arquero</h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                        <div class="divider-custom-line"></div>
                                        <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                                        <div class="divider-custom-line"></div>
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    <img class="img-fluid rounded mb-5" src="imagenes/archer.png" alt="" />
                                    <!-- Portfolio Modal - Text-->
                                    <p class="mb-5 estilo">Heroe, te moveras con destreza, y los enemigos no podran tan si quiera alcanzarte con sus golpes, agil y audaz en el combate. Si ese es tu estilo, este es tu camino.</p>
                                    <p class="mb-5 estilo">Parámetros iniciales:</p>
                                    <p class="mb-5 estilo colorArcher"><strong>Salud: 100 Ataque: 15 Defensa: 9 Evasión: 10% Daño Critico: 200%</strong></p>
                                    <form method="post" action="/ProyectoWebFinal/ServletCrearPersonaje" onsubmit="return checkCharacter()">
                                    <input type="text" placeholder="Escriba el nombre de su personaje" name="nombre" id="arquero">
                                        <button type="submit" class="btn btn-primary">
                                           Crear
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
         <script type="text/javascript">
             function checkCharacter(){
                 var arquero = document.getElementById("arquero").value;
                 var guerrero = document.getElementById("guerrero").value;
                 var mago = document.getElementById("mago").value;
                 
                 if (arquero === "" || arquero.length <== 4){
                     alert("Escriba un nombre de personaje con más de 4 caracteres");
                     return false;
                 }
                  if (mago === "" || mago.length <= 4){
                     alert("Escriba un nombre de personaje con más de 4 caracteres");
                     return false;
                 }
                  if (guerrero === "" || guerrero.length <= 4){
                     alert("Escriba un nombre de personaje con más de 4 caracteres");
                     return false;
                 }
             }
         </script>
    </body>
</html>
