<%-- 
    Document   : myActOp
    Created on : 01-dic-2020, 12:04:55
    Author     : noble
--%>

<%@page import="java.sql.*"%>
<%@page import="model.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <%
              HttpSession sesion = request.getSession();
              String usr = sesion.getAttribute("user").toString();
            %>
            <nav class="nav">
                <div>
                    <a href="activitiesOp.jsp">Mis actividades</a>
                </div>
                <div>
                    <a href="myAccount.jsp">Mi cuenta</a>
                </div>
            </nav>
        </header>
            
        <br><br>
        <section class="account" style="background-color: #06a4dc">
            <div>
                <h1> <% out.print(usr);%> </h1>
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
                rs = st.executeQuery("select * from usuarios where correo_usr='"+usr+"'");
                
                System.out.println(usr+" "+rs.toString());

                while (rs.next()) {
            %>
            <h1> <%=rs.getString("nombre_usr")+" "+rs.getString("apellido_usr")%> </h1>
            <h1> <%=rs.getString("domicilio_usr")%> </h1>
            <h1> <%=rs.getString("tel_usr")%> </h1>
            <%  }
                st.close();
                rs.close();
                con.close();
              } catch (SQLException e) {
              }

            %>
    </body>
</html>
