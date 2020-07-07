<%-- 
    Document   : index
    Created on : 7 jul. 2020, 16:06:40
    Author     : Propietario
--%>
<% 
    HttpSession sesion = request.getSession();
             String login = (String)sesion.getAttribute("Nick");
             
             if (login == null) {
                 login = "Login";
             }else{
                 login = login;
             } 
             



%>

 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shadowland, una nueva era ha comenzado</title>
    
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link rel="apple-touch-icon" sizes="180x180" href="../favicon/">
    <link rel="icon" type="image/png" sizes="32x32" href="../favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../favicon/favicon-16x16.png">
    <link rel="manifest" href="../favicon/site.webmanifest">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Piedra&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alex+Brush&family=Bahianita&display=swap" rel="stylesheet">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="#about">¿De qué va el juego?</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../login/login.html"><%=login%></a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../registro/registro.html">Crear cuenta</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../tienda/tienda.jsp">Tienda de objetos</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#signup">Sobre nosotros</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Masthead-->
    <header class="masthead">
        <div class="container d-flex h-100 align-items-center">
            <div class="mx-auto text-center">
                <h1 class="mx-auto my-0 text-uppercase">Shadowland</h1>
                <h2 class="text-white-50 mx-auto mt-2 mb-5">Luchad, y puede que muráis. Huid y viviréis… un tiempo al menos. Y cuando estéis en vuestro lecho de muerte dentro de muchos años, ¿no cambiaréis todos los días desde aquí hasta entonces por una oportunidad, sólo una oportunidad, de volver
                    aquí y decir a nuestros enemigos: Pueden quitarnos la vida, pero jamás nos quitarán… ¡La libertad!”</h2>
                <a class="btn btn-primary js-scroll-trigger" href="#about">Página de descarga</a>
            </div>
        </div>
    </header>
    <!-- About-->
    <div class="paPonerNegro" id="negrako">
        <section class="about-section text-center" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-8 mx-auto">
                        <h2 class="text-white mb-4">¿De qué va el juego?</h2>
                        <p class="text-white-50">
                            Deberás de crear un personaje, que dependiendo de su clase, su estilo de combate y sus armas variarán. Tendrás que subir la torre de 100 plantas, cada planta es diferente, y cuando más alto estés mas dificil será el reto de continuar. Gestiona tu economia
                            desde la web, comprando objetos mejores, para poder seguir avanzando.
                        </p>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- Projects-->
    <section class="projects-section bg-light" id="projects">
        <div class="container">
            <!-- Featured Project Row-->
            <div class="row align-items-center no-gutters mb-4 mb-lg-5">
                <div class="col-xl-8 col-lg-7"><img class="img-fluid mb-3 mb-lg-0" src="assets/img/bg-masthead.jpg" alt="" /></div>
                <div class="col-xl-4 col-lg-5">
                    <div class="featured-text text-center text-lg-left">
                        <h4>Imagenes de muestra del juego</h4>
                    </div>
                </div>
            </div>
            <!-- Project One Row-->
            <div class="row justify-content-center no-gutters mb-5 mb-lg-0">
                <div class="col-lg-6"><img class="img-fluid" src="../index/imagenes/Armeria.png" alt="" /></div>
                <div class="col-lg-6">
                    <div class="bg-black text-center h-100 project">
                        <div class="d-flex h-100">
                            <div class="project-text w-100 my-auto text-center text-lg-left">
                                <a href="../tienda/tienda.html">
                                    <h4 class="text-white">Acceso a la tienda</h4>
                                </a>
                                <p class="mb-0 text-white-50">En la tienda podrás comprar objetos como arcos, varas, arcos y armaduras que te ayudarán a superar los siguiente niveles.</p>
                                <hr class="d-none d-lg-block mb-0 ml-0" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Project Two Row-->
            <div class="row justify-content-center no-gutters">
                <div class="col-lg-6"><img class="img-fluid" src="../index/imagenes/Pergamino.png" alt="" /></div>
                <div class="col-lg-6 order-lg-first">
                    <div class="bg-black text-center h-100 project">
                        <div class="d-flex h-100">
                            <div class="project-text w-100 my-auto text-center text-lg-right">
                                <a href="../servicios/servicios.html">
                                    <h4 class="text-white">Servicios de cuenta y<br> soporte técnico</h4>
                                </a>
                                <p class="mb-0 text-white-50">Cambia datos de tu cuenta o contacta con nosotros para comunicarnos posibles fallos o cambios</p>
                                <hr class="d-none d-lg-block mb-0 mr-0" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Signup-->
    <section class="signup-section" id="signup">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto text-center">
                    <div class="creadores">Creadores del juego</div>
                    <table>
                        <tr>
                            <td class="eddy">
                                <a href=""><img src="../index/imagenes/eddy.png" width="200px" height="260px" alt=""></a>
                            </td>
                            <td class="edd">
                                <a href=""><img src="../index/imagenes/lupitas3.png" width="200px" height="300px" alt=""></a>
                            </td>
                            <td class="edd">
                                <a href=""><img src="../index/imagenes/eddo.png" width="200px" height="300px" alt=""></a>
                            </td>
                        </tr>
                        <tr>
                            <td class="nombres">Miguel</td>
                            <td class="nombres">Santi</td>
                            <td class="nombres">Gonzalo</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact-->
    <section class="contact-section bg-black">
        <div class="container">
            <div class="ajuste">
                <div class="col-md-4 mb-3 mb-md-0">
                    <div class="card py-4 h-100">
                        <div class="card-body text-center">
                            <div class="eoi"><img src="imagenes/eoi.jpg" width="60" alt=""> </div>
                            <h4 class="text-uppercase m-0">EOI Escuela de Organización Industrial</h4>
                            <hr class="my-4" />
                            <div class="small text-black-50"><a href="#!">eoi@gmail.com</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="social d-flex justify-content-center">
            <a class="mx-2" href="https://twitter.com/Santymmr"><i class="fab fa-twitter"></i></a>
            <a class="mx-2" href="https://www.facebook.com/groups/201129633726211"><i class="fab fa-facebook-f"></i></a>
            <a class="mx-2" href="https://github.com/Gonzzalo93/ProyectoEOIFinal"><i class="fab fa-github"></i></a>
        </div>
        </div>
    </section>
    <!-- Footer-->
    <footer class="footer bg-black small text-center text-white-50">
        <div class="container2">Copyright © Coffee team 2020</div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>

</html>
