<%-- 
    Document   : login
    Created on : 19-nov-2020, 15:56:35
    Author     : Luis Olivares
--%>

<%@page import="controllers.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Iniciar Sesión - GRUPO LAVAGÓMEZ</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel=stylesheet type="text/css" href="css/style.css">
    <link rel=stylesheet type="text/css" href="css/normalize.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
  </head>
  <body>
    <header>
      <div>
        <a href="index.jsp">
          <img src="img/logolavagomez2020.png" class=logo>
        </a>
      </div>
      <nav class=nav>
        <div>
          <a href="login.jsp">Inicio</a>
        </div>
      </nav>
    </header>
    <section align=center>
      <h1>Iniciar Sesión</h1>
    </section>

    <section align=center>
      <form class="forms" method="post" action="login">
        <div align=left>
          Correo electrónico  <br>
        </div>
        <div align=left>
          <input type="text" class=txtfield name="user_mail" required=true/><br>
        </div>
        <div align=left>
          Contraseña<br>
        </div>
        <div align=left>
          <input type="password" class=txtfield name="pass" required=true/><br>
        </div>
          <br>
        <button name="log" class=btns type="submit" value="login">Iniciar Sesión</button>
      </form>
    </section>

    <footer class=footer>
      <hr width=700><br>
      Copyright &copy; 2020 GRUPO LAVAGÓMEZ
    </footer>
  </body>
</html>