<%-- 
    Document   : endact
    Created on : 03-dic-2020, 19:09:20
    Author     : noble
--%>

<%@page import="model.User"%>
<%@page import="java.sql.*"%>
<%@page import="model.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actividades - GRUPO LAVAGÓMEZ</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel=stylesheet type="text/css" href="css/style.css">
        <link rel=stylesheet type="text/css" href="css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
    </head>
    <body>
        <%
              request.getSession();
              User usu = (User) session.getAttribute("usuario");
              
              if(usu == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
              }
            %>
        <header>
            <div>
                <a href="index.jsp">
                    <img src="img/logolavagomez2020.png" class=logo>
                </a>
            </div>
            <nav class="nav">
                <div>
                    <a href="activitiesOp.jsp">Mis actividades</a>
                </div>
                <div>
                    <a href="myAccount.jsp">Mi cuenta (<% out.print(usu.getMail());%>)</a>
                </div>
            </nav>
        </header>
                
        <%String cod=request.getParameter("cod");%>
        
        <section align=center>
            <h1>Terminar Actividad <%out.print(cod);%></h1>
        </section>

        <section align=center>
            <form class="forms" method="post" action="End">
                <div align=left>
                    Fecha y hora de fin
                </div>
                <select name="cod" hidden="true">
                    <option><%out.print(cod);%></option>
                </select>
                <input type="date" class=txtfield name="act_end_date" required=true/><br>
                <input type="time" class=txtfield name="act_end_time" required=true/><br><br>
                
                <button name="end" class=btns type="submit" value="End">Terminar actividad</button>
            </form>
        </section>
</html>
