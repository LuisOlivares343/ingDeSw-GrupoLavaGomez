<%-- 
    Document   : activitiesOp
    Created on : 01-dic-2020, 11:12:47
    Author     : noble
--%>

<%@page import="controllers.Login"%>
<%@page import="model.Connect"%>
<%@page import="java.sql.*"%>
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
        <header>
            <div>
                <a href="index.jsp">
                    <img src="img/logolavagomez2020.png" class=logo>
                </a>
            </div>
            <nav class="nav">
                <div>
                    <a href="reportes.jsp">Reportes</a>
                </div>
                <div>
                    <a href="activitiesOp.jsp">Mis actividades</a>
                </div>
                <div>
                    <a href="#.jsp">Mi cuenta</a>
                </div>
            </nav>
        </header>

        <section align=center>
            <h1>Actividades</h1>
        </section>

        <table border="1" align="center" >
            <tr bgcolor="#ccc">
                <th>Id Actividad</th>
                <th>Actividad</th>
                <th>&Aacute;rea</th>
                <th>Encargado</th>
                <th>Inicio de actividad</th>
                <th>T&eacute;rmino de actividad</th>
            </tr>

            <%
              String cod = request.getParameter("user_mail");
              Connection con = null;
              Connect cn = new Connect();
              Statement st = null;
              ResultSet rs = null;
              try {
                con = cn.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("select * from actividades where lider_act = (select rfc_usr from usuarios where correo_usr='"+cod+"')");

                while (rs.next()) {
            %>
            <tr>
                <th> <%=rs.getString("id_act")%> </th>
                <th> <%=rs.getString("nombre_act")%>  </th>
                <th> <%=rs.getString("area_act")%>    </th>
                <th> <%=rs.getString("lider_act")%>   </th>
                <th> <%=rs.getString("ini_act")%>     </th>
                <th> <%=rs.getString("fin_act")%>     </th>
                <th> 
                    <a>
                        <img src="img/icon_details.png" width="18px" height="auto">
                    </a>
                    |
                    <a href="delete.jsp?cod=<%=rs.getString("id_act")%>">
                        <img src="img/icon_finish.png" width="18px" height="auto">
                    </a>
                </th>
            </tr>        
            <%  }
                st.close();
                rs.close();
                con.close();
              } catch (SQLException e) {
              }

            %>
        </table>

        <footer class="footer">
            <hr width=700><br>
            Copyright &copy; 2020 GRUPO LAVAGÓMEZ
        </footer>
    </body>
</html>
