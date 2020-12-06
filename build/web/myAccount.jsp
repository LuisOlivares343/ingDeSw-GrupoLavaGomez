<%-- 
    Document   : myActOp
    Created on : 01-dic-2020, 12:04:55
    Author     : noble
--%>

<%@page import="model.User"%>
<%@page import="java.sql.*"%>
<%@page import="model.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
  request.getSession();
  User usu = (User) session.getAttribute("usuario");

  if (usu == null) {
    request.getRequestDispatcher("login.jsp").forward(request, response);
  } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mi Cuenta - GRUPO LAVAGÓMEZ</title>
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
            <nav class="nav">
                <div>
                    <a href="activitiesOp.jsp">Mis actividades</a>
                </div>
                <div>
                    <a href="myAccount.jsp">Mi cuenta(<% out.print(usu.getMail());%>)</a>
                </div>
            </nav>
        </header>

        <br><br>

        <section class="cuenta" align="left">
            <img src="img/icon_id.png" width="10%" height="auto">
            <div>
                <h1><% out.print(usu.getMail());%></h1>
                <a href="LogOutServlet">Cerrar Sesión</a>
            </div>
        </section> 

        <%
          Connection con = null;
          Connect cn = new Connect();
          Statement st = null;
          ResultSet rs = null;
          try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from usuarios where correo_usr='" + usu.getMail() + "'");

            while (rs.next()) {
        %>
        <div class="twoforms" style="padding-left: 25%;">
            <h2><img src="img/icon_user.png" width="5%" height="auto"> <%=rs.getString("nombre_usr") + " " + rs.getString("apellido_usr")%> </h2>
            <h2><img src="img/icon_add.png" width="5%" height="auto"> <%=rs.getString("domicilio_usr")%> </h2>
            <h2><img src="img/icon_ph2.png" width="5%" height="auto"> <%=rs.getString("tel_usr")%> </h2>
        </div>
        <%  }
            st.close();
            rs.close();
            con.close();
          } catch (SQLException e) {
          }

        %>

        <footer class="footer">
            <hr width=700><br>
            Copyright &copy; 2020 GRUPO LAVAGÓMEZ
        </footer>
    </body>
</html>
<%}%>